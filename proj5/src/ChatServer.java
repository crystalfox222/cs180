import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;

/**
 * [Add your documentation here]
 *
 * @author your name and section
 * @version date
 */
final class ChatServer {
    private static int uniqueId = 0;
    private final List<ClientThread> clients = new ArrayList<>();
    private final int port;
    private ChatFilter chatFilter = new ChatFilter("badwords.txt");

    private void broadcast(String message) {
        String time = SimpleDateFormat.getTimeInstance().format(new Date());
        message = chatFilter.filter(message);
        for (int i = 0; i < clients.size(); i++) {
            clients.get(i).writeMessage(message + "\n" + time + "\n");
        }
        System.out.println(message + "\n" + time + "\n");
    }

    private void directMessage(String message, String recipient) {
        String time = SimpleDateFormat.getTimeInstance().format(new Date());
        message = chatFilter.filter(message);
        for (int i = 0; i < clients.size(); i++) {
            if (clients.get(i).username.equals(recipient)) {
                clients.get(i).writeMessage(message + "\n" + time + "\n");
                break;
            }
        }
    }

    private ChatServer(int port) throws IOException {
        this.port = port;
    }

    private ChatServer(int port, String file) throws IOException {
        this.port = port;
        ChatFilter filter = new ChatFilter(file);
        this.chatFilter = filter;
        chatFilter.printFilter();
    }

    /*
     * This is what starts the ChatServer.
     * Right now it just creates the socketServer and adds a new ClientThread to a list to be handled
     */
    private void start() {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            while (true) {
                Socket socket = serverSocket.accept();
                Runnable r = new ClientThread(socket, uniqueId++);
                Thread t = new Thread(r);
                clients.add((ClientThread) r);
                t.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void remove(int id) {
        for (int i = 0; i < clients.size(); i++) {
            if (clients.get(i).id == id) {
                clients.remove(i);
            }
        }
    }

    public void printList(String name) {
        int location = 0;
        for (int i = 0; i < clients.size(); i++) {
            if (clients.get(i).username.equals(name)) {
                location = i;
                break;
            }
        }
        for (int i = 0; i < clients.size(); i++) {
            if (!clients.get(i).username.equals(clients.get(location).username)) {
                clients.get(location).writeMessage(clients.get(i).username + "\n");
            } else if (clients.size() <= 1) {
                clients.get(location).writeMessage("Empty chat room!" + "\n");
            }
        }
    }

    /*
     *  > java ChatServer
     *  > java ChatServer portNumber
     *  If the port number is not specified 1500 is used
     */
    public static void main(String[] args) throws Exception {
        System.out.println("Waiting to connect...");
        System.out.println("Welcome to the chat room!");
        ChatFilter chatFilter;
        int port = 1500;
        String badWordsFile = "badwords.txt";
        if (args.length == 1) {
            port = Integer.parseInt(args[0]);
        } else if (args.length == 2) {
            port = Integer.parseInt(args[0]);
            badWordsFile = args[1];
        }

        ChatServer server = new ChatServer(port, badWordsFile);
        server.start();
    }


    /**
     * This is a private class inside of the ChatServer
     * A new thread will be created to run this every time a new client connects.
     *
     * @author your name and section
     * @version date
     */
    private final class ClientThread implements Runnable {
        Socket socket;
        ObjectInputStream sInput;
        ObjectOutputStream sOutput;
        int id;
        String username;
        ChatMessage cm;

        private ClientThread(Socket socket, int id) {
            this.id = id;
            this.socket = socket;
            try {
                sOutput = new ObjectOutputStream(socket.getOutputStream());
                sInput = new ObjectInputStream(socket.getInputStream());
                username = (String) sInput.readObject();
                for (int i = 0; i < clients.size(); i++) {
                    if (username.equals(clients.get(i).username)) {
                        username = username + uniqueId;
                        break;
                    }
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        private boolean writeMessage(String message) {
            try {
                if (!socket.isClosed()) {
                    sOutput.writeObject(message);
                    return true;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return false;
        }

        private void close() {
            try {
                sOutput.close();
                sInput.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        /*
         * This is what the client thread actually runs.
         */
        @Override
        public void run() {
            // Read the username sent to you by client
            try {
                while (true) {
                    cm = (ChatMessage) sInput.readObject();
                    if (cm.getType() == 0) {
                        directMessage(username + ": " + cm.getMessage(), cm.getRecipient());
                    }
                    if (cm.getType() == 1) {
                        broadcast(username + ": " + cm.getMessage());
                    } else if (cm.getType() == 2) {
                        broadcast(username + " has logged out!");
                        remove(id);
                        close();
                        break;
                    } else if (cm.getType() == 3) {
                        cm.setRecipient(username);
                        printList(cm.getRecipient());
                    }
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }


            // Send message back to the client

        }
    }
}
