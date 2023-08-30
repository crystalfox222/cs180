import java.util.Scanner;
/**
 * Homework 3 Walkthrough
 *
 * A program that formats personal info for a business card
 *
 * Stack Overflow - helped format the decimal place
 *
 * @author Eric Bosler, lab sec L-18
 * @version February 07, 2021
 *
 */
public class BusinessCard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name:");
        String name = scanner.nextLine();
        System.out.println("Enter your age:");
        int age = scanner.nextInt();
        System.out.println("Enter your GPA:");
        double GPA = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Enter your major:");
        String major = scanner.nextLine();
        System.out.println("Enter your email:");
        String email = scanner.nextLine();
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.printf("GPA: %.2f", GPA);
        System.out.println("");
        System.out.println("Major: " + major);
        System.out.println("Email: " + email);
    }



}
