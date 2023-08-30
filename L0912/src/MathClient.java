import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class MathClient {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 4242);
        Scanner scan = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        writer.flush();
        System.out.println("Enter the First Value:");
        String one = scan.nextLine();
        System.out.println("Enter the Second Value:");
        String two = scan.nextLine();
        System.out.println("Enter the Mode:");
        String mode = scan.nextLine();

        writer.write(one);
        writer.newLine();
        writer.flush();
        writer.write(two);
        writer.newLine();
        writer.flush();
        writer.write(mode);
        writer.newLine();
        writer.flush();

        String result = reader.readLine();

        System.out.printf("Received from server: \n%s\n", result);
        writer.close();
        reader.close();
    }
}
