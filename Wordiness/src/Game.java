import java.util.Scanner;
public class Game {
    public static void Play(){
        Scanner scan = new Scanner(System.in);
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

}
