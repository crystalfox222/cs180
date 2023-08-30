import javax.management.remote.JMXServerErrorException;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * [Add your documentation here]
 *
 * @author your name and section
 * @version date
 */
final class ChatClient {
    private ObjectInputStream sInput;
    private ObjectOutputStream sOutput;
    private Socket socket;

    private final String server;
    private final String username;
    private final int port;

    private ArrayList<String> users = new ArrayList<>();

    private ChatClient(String server, int port, String username) {
        this.server = server;
        this.port = port;
        this.username = username;
    }

    /*
     * This starts the Chat Client
     */
    private boolean start() {
        // Create a socket
        try {
            socket = new Socket(server, port);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Create your input and output streams
        try {
            sInput = new ObjectInputStream(socket.getInputStream());
            sOutput = new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // This thread will listen from the server for incoming messages
        Runnable r = new ListenFromServer();
        Thread t = new Thread(r);
        t.start();

        // After starting, send the clients username to the server.
        try {
            sOutput.writeObject(username);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return true;
    }


    /*
     * This method is used to send a ChatMessage Objects to the server
     */
    private void sendMessage(ChatMessage msg) {
        try {
            sOutput.writeObject(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /*
     * To start the Client use one of the following command
     * > java ChatClient
     * > java ChatClient username
     * > java ChatClient username portNumber
     * > java ChatClient username portNumber serverAddress
     *
     * If the portNumber is not specified 1500 should be used
     * If the serverAddress is not specified "localHost" should be used
     * If the username is not specified "Anonymous" should be used
     */
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        // Get proper arguments and override defaults
        String username = "Anonymous";
        int port = 1500;
        String server = "localhost";

        // Create your client and start it
        switch (args.length) {
            case 3:
                server = args[2];
            case 2:
                port = Integer.parseInt(args[1]);
            case 1:
                username = args[0];
            case 0:
                break;
            default:
                throw new Exception("bruh moment");
        }
        ChatClient client = new ChatClient(server, port, username);
        int type;
        client.start();
        while (true) {
            String message = scan.nextLine();
            type = 1;
            String[] directCommand = message.split(" ", 3);
            if (message.equalsIgnoreCase("/logout")) {
                type = 2;
                ChatMessage logout = new ChatMessage(message, type);
                client.sendMessage(logout);
                break;
            }
            else if (message.equals("/list")) {
                String self = username;
                type = 3;
                ChatMessage list = new ChatMessage(message, username, type);
                client.sendMessage(list);
            }
            else if (directCommand[0].equals("/msg")) {
                String recipient = directCommand[1];
                message = directCommand[2];
                if (username.equals(recipient)) {
                    System.out.println("You can't message yourself silly!");
                    continue;
                }
                ChatMessage direct = new ChatMessage(message, recipient);
                client.sendMessage(direct);
            } else {
                ChatMessage newMessage = new ChatMessage(message, type);
                client.sendMessage(newMessage);
            }
        }

        // Send an empty message to the server
    }


    /**
     * This is a private class inside of the ChatClient
     * It will be responsible for listening for messages from the ChatServer.
     * ie: When other clients send messages, the server will relay it to the client.
     *
     * @author your name and section
     * @version date
     */
    private final class ListenFromServer implements Runnable {
        public void run() {
            while (true) {
                try {
                    try {
                        String msg = (String) sInput.readObject();
                        System.out.print(msg);
                    } catch (EOFException e) {
                        socket.close();
                        break;
                    }
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
