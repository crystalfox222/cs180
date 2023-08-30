import java.io.*;
import java.net.*;
public class SimpleServer {

    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(4242);
        System.out.println("waiting for connect");
        Socket socket = serverSocket.accept();
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        writer.flush();
        String message = reader.readLine();
        System.out.printf("Received from client:\n%s\n", message);
        String response = message.replaceAll(",","_");
        writer.write(response);
        writer.newLine();
        writer.flush();
        System.out.printf("Sent to client:\n%s\n", response);
        writer.close();
        reader.close();

    }

}
