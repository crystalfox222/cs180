import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MathServer {

    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(4242);
        System.out.println("waiting for connect");
        Socket socket = serverSocket.accept();
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        writer.flush();
        int one = Integer.parseInt(reader.readLine());
        System.out.println(one);
        int two = Integer.parseInt(reader.readLine());
        System.out.println(two);
        int mode = Integer.parseInt(reader.readLine());
        System.out.println(mode);
        int result = 0;
        if (mode == 1) {
            result = one + two;
        } else if (mode == 2){
            result = one - two;
        } else if (mode == 3){
            result = one*two;
        } else if (mode == 4){
            result = one/two;
        }
        String ree = String.valueOf(result);
        writer.write(ree);
        writer.newLine();
        writer.flush();
        writer.close();
        reader.close();

    }

}
