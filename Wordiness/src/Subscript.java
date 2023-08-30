import java.util.Scanner;
public class Subscript {
    public static void Manager() {
        System.out.println("Welcome to the Subscription Manager!");
        double total = 0.0;
        int check = 0;
        int chek = 0;
        int chek2 = 0;
        Scanner scan = new Scanner(System.in);
        while (check == 0) {
            if (chek == 0) {
                System.out.println("How long do you want to subscribe?");
                System.out.println("1. 1 Month");
                System.out.println("2. 3 Months");
                System.out.println("3. 6 Months");
                System.out.println("4. 12 Months");
            }
            String input = scan.nextLine();
            if (input.equals("1")) {
                total = total + 9.0;
                check = 1;
                System.out.println("You've chosen: 1 Month");
            } else if (input.equals("2")) {
                total = total + 18.0;
                check = 1;
                System.out.println("You've chosen: 3 Months");
            } else if (input.equals("3")) {
                total = total + 30.0;
                check = 1;
                System.out.println("You've chosen: 6 Months");
            } else if (input.equals("4")) {
                total = total + 50.0;
                check = 1;
                System.out.println("You've chosen: 12 Months");
            } else {
                System.out.println("invalid input");
                chek = 1;
            }
        }
        while (check == 1) {
            if (chek2 == 0) {
                System.out.println("Do you have any institutional affiliations?");
                System.out.println("1. Purdue");
                System.out.println("2. Federal Government");
                System.out.println("3. AAA");
                System.out.println("4. Local Library");
                System.out.println("4. None");
            }
            String input = scan.nextLine();
            if (input.equals("1")) {
                check = check + 1;
                System.out.println("You've chosen: Purdue");
                double discount = total * .30;
                total = total - discount;
            } else if (input.equals("2")) {
                check = check + 1;
                System.out.println("You've chosen: Federal Government");
                double discount = total * .25;
                total = total - discount;
            } else if (input.equals("3")) {
                check = check + 1;
                double discount = total * .10;
                total = total - discount;
                System.out.println("You've chosen: AAA");
            } else if (input.equals("4")) {
                check = check + 1;
                System.out.println("You've chosen: Local Library");
                double discount = total * .05;
                total = total - discount;
            } else if (input.equals("5")) {
                check = check + 1;
                System.out.println("You've chosen: None");
            } else {
                System.out.println("invalid input");
                chek = 1;
            }
        }
        while (check == 2) {
            if (chek2 == 0) {
                System.out.println("Do you want to sign up for our live document editing service?");
                System.out.println("1. Yes");
                System.out.println("2. No");

                String input = scan.nextLine();
                if (input.equals("1")) {
                    check = check + 1;
                    total = total + 10.0;
                    System.out.println("You've chosen: Yes. Your total: " +total);
                    System.out.println("Thank you for using Wordiness!");
                } else if (input.equals("2")) {
                    check = check + 1;
                    total = total;
                    System.out.println("You've chosen: No. Your total: "+ total);
                    System.out.println("Thank you for using Wordiness!");
                } else {
                    System.out.println("invalid input");
                    chek = 1;
                }
            }

        }
        return;
    }
}
