import java.util.Scanner;
public class Citation {
    public static void Site(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to Citation Manager!");
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
}

