import java.util.Scanner;
public class Wordiness {
   private static Scanner scan = new Scanner(System.in);
    public static void Menu() {
        System.out.println("Welcome to Wordiness!");
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
                    Wordiness.Play();
                    return;
                } else if (input.equals("2")) {
                    check = 1;
                    Wordiness.Crypt();
                } else if (input.equals("3")) {
                    check = 1;
                    Citation.Site();
                    return;
                } else if (input.equals("4")) {
                    check = 1;
                    Wordiness.Manager();
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
    public static void Manager() {
        System.out.println("Welcome to the Subscription Manager!");
        double total = 0.0;
        int check = 0;
        double lds = 0.0;
        double discount = 0.0;
                System.out.println("How long do you want to subscribe?");
                System.out.println("1. 1 Month");
                System.out.println("2. 3 Months");
                System.out.println("3. 6 Months");
                System.out.println("4. 12 Months");
            String input = scan.nextLine();
            if (input.equals("1")) {
                total = total + 9.0;
                check = 1;
            } else if (input.equals("2")) {
                total = total + 18.0;
                check = 2;
            } else if (input.equals("3")) {
                total = total + 30.0;
                check = 3;
            } else if (input.equals("4")) {
                total = total + 50.0;
                check = 4;
            } else {
                System.out.println("invalid input");
            }
                System.out.println("Do you have any institutional affiliations?");
                System.out.println("1. Purdue");
                System.out.println("2. Federal Government");
                System.out.println("3. AAA");
                System.out.println("4. Local Library");
                System.out.println("5. None");

            input = scan.nextLine();
            if (input.equals("1")) {
                discount = .30;
            } else if (input.equals("2")) {
                discount = .25;
            } else if (input.equals("3")) {
                discount = .10;
            } else if (input.equals("4")) {
                discount = .05;
            } else if (input.equals("5")) {

            } else {
                System.out.println("invalid input");
            }

                System.out.println("Do you want to sign up for our live document editing service?");
                System.out.println("1. Yes");
                System.out.println("2. No");

                input = scan.nextLine();
                if (input.equals("1")) {
                    if(check == 1){
                     lds = 10;
                    } else if (check == 2){
                        lds = 30;
                    }else if( check == 3){
                        lds = 60;
                    }else if(check == 4){
                        lds = 120;
                    }
                    total = total + lds;
                    discount = total * discount;
                    total = total - discount;
                    System.out.printf("Your total is: $%5.2f%n ", total);
                    System.out.println("Thank you for using Wordiness!");
                } else if (input.equals("2")) {
                    discount = total * discount;
                    total = total - discount;
                    System.out.printf("Your total is: $%5.2f%n ", total);
                    System.out.println("Thank you for using Wordiness!");
                } else {
                    System.out.println("invalid input");
                }
        return;
    }
    public static void Site(){
        System.out.println("Welcome to the Citation Manager!");
        System.out.println("Enter Author First Name:");
        String firstName = scan.nextLine();
        System.out.println("Enter Author Last Name:");
        String lastName = scan.nextLine();
        System.out.println("Enter Book Title: ");
        String bookTitle = scan.nextLine();
        System.out.println("Enter Publisher: ");
        String publisher = scan.nextLine();
        System.out.println("Enter Publishing City:");
        String city = scan.nextLine();
        System.out.println("Enter Publishing Year:");
        String year = scan.nextLine();
        char firstLetter = firstName.charAt(0);
        System.out.println("MLA: "+lastName+", "+firstName+". "+bookTitle+ ". "+publisher+", "+year+".");
        System.out.println("APA: "+lastName+", "+firstLetter+". ("+year+"). "+bookTitle+". "+city+": "+publisher+".");
        System.out.println("Thank you for using Wordiness!");
        return;


    }
    public static void Play(){
        System.out.println("Welcome to the Text Filler Game!");
        System.out.println("Please provide the following:");
        System.out.println("Adjective:");
        String adj1 = scan.nextLine();
        System.out.println("Nationality:");
        String nationality = scan.nextLine();
        System.out.println("Name:");
        String name = scan.nextLine();
        System.out.println("Noun:");
        String noun1 = scan.nextLine();
        System.out.println("Adjective:");
        String adj2 = scan.nextLine();
        System.out.println("Noun:");
        String noun2 = scan.nextLine();
        System.out.println("Adjective:");
        String adj3 = scan.nextLine();
        System.out.println("Adjective:");
        String adj4 = scan.nextLine();
        System.out.println("Plural Noun:");
        String plnoun = scan.nextLine();
        System.out.println("Noun:");
        String noun3 = scan.nextLine();
        System.out.println("Number:");
        String number1 = scan.nextLine();
        System.out.println("Plural Shape:");
        String plshape = scan.nextLine();
        System.out.println("Food:");
        String food1 = scan.nextLine();
        System.out.println("Food:");
        String food2 = scan.nextLine();
        System.out.println("Number:");
        String number2 = scan.nextLine();
        System.out.println("Pizza was invented by a "+adj1+" "+nationality+" chef named "+name+". To make a pizza, you need to take a lump of " +noun1+", and make a thin, round "+adj2+" "+noun2+". Then you cover it with "+adj3+" sauce, "+adj4+" cheese, and fresh chopped "+plnoun+". Next you have to bake it in a very hot "+noun3+". When it is done, cut it into "+number1+" "+plshape+". Some kids like "+food1+" pizza the best, but my favorite is the "+food2+" pizza. If I could, I would eat pizza "+number2+" times a day!");
        System.out.println("Thank you for using Wordiness!");
        return;
    }
    public static void Crypt() {
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
                System.out.println("Please enter a 10-character encrypted String:");
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
    public static void main(String[] args) {
        Wordiness.Menu();

    }
}
