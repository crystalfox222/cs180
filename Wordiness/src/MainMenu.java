import java.util.Scanner;
public class MainMenu {

    public static void Menu() {
        System.out.println("Welcome to Wordiness!");
        Scanner scan = new Scanner(System.in);
        int check = 0;
        int chek = 0;
        String input;
        while (check == 0) {
            if (chek == 0) {
                System.out.println("What would you like to do?");
                System.out.println("1. Text Filler Game");
                System.out.println("2. Decryption Puzzle Solver");
                System.out.println("3. Citation Manager");
                System.out.println("4. Subscription Manager");
                input = scan.nextLine();
                if (input.equals("1")) {
                    check = 1;
                    Game.Play();
                    return;
                } else if (input.equals("2")) {
                    check = 1;
                    Decrypt.Crypt();
                } else if (input.equals("3")) {
                    check = 1;
                    Citation.Site();
                    return;
                } else if (input.equals("4")) {
                    check = 1;
                    Subscript.Manager();
                    return;
                } else {
                    System.out.println("invalid input");
                    System.out.println("What would you like to do?");
                    input = scan.nextLine();

                    chek = 1;
                }


            }
            else{

            }
        }
    }
}
