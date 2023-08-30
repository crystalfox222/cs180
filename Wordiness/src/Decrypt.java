import java.util.Scanner;
public class Decrypt {
    public static void Crypt() {
        Scanner scan = new Scanner(System.in);
        int check = 0;
        System.out.println("Welcome to the Decryption Puzzle Solver!");
        System.out.println("Please enter a 10=character encrypted String:");
        String input = scan.nextLine();
        while (check == 0) {
            int length = input.length();
            if (length == 11) {
                check = 1;
                break;
            } else {
                System.out.println("Please enter a 10=character encrypted String:");
                input = scan.nextLine();
            }
        }
        if (input.length() == 11) {
            input = input.replace(input.charAt(4), input.charAt(10));
        } else {

        }
        input = input.substring(0, 10);
        if (input.contains("?")) {
            input = input.replace("?", "e");

        } else{

        }
        String half1 = input.substring(0, 5);
        String half2 = input.substring(5, 10);
        input = half2 + half1;

        System.out.println("The unencrypted String is: " + input);
        System.out.println("Thank you for using Wordiness!");
        return;

    }

}

