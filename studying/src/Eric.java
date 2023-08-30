import java.util.Scanner;
public class Eric {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to 'Business Card'\nPlease enter your name:");
        String name = scan.nextLine();
        System.out.println("What year is your birthday?");
        int birthday = scan.nextInt();
        int age = 0;
        int year = 2021;
        age = year - birthday;
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);

    }
}
