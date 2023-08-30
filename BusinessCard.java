import java.util.Scanner;
import java.text.DecimalFormat; //stackoverflow
public class BusinessCard { 
	public static void main(String[] args){ 
		Scanner scan = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("#.##");//stack overflow
		//name 
		System.out.println("Enter your Name:");
		String name = scan.nextLine();
		//birth
		System.out.println("Enter your Year of Birth:");
		int age = scan.nextInt();
		int birth = 2020 - age;
		scan.nextLine(); //stack overflow
		//gpa
		System.out.println("Enter your GPA:");
		double gpa = scan.nextDouble();
		scan.nextLine(); //stack overflow said to do this
		//major
		System.out.println("Enter your Major:");
		String major = scan.nextLine();
		//email
		System.out.println("Enter your Email:");
		String email = scan.nextLine();
		//output
		System.out.println("Name: " + name);
		System.out.println("Age: " + birth);
		System.out.println("GPA: " + df.format(gpa));
		System.out.println("Major: " + major);
		System.out.println("Email: " + email);
		
		
		
	
	} 
}	