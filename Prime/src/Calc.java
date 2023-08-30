import java.util.Scanner;
public class Calc {
    public int a;
        public int newInt(int a){
            Scanner scan = new Scanner(System.in);
            a = scan.nextInt();
            return a;
        }
        public int validate(int a){
            if (a >= 2 && a <= Math.pow(10,9)){
                System.out.println(a);
                return a;
            } else if (a < 2 && a>=0) {
                System.out.println("N should be bigger than 2");
            } else if (a > Math.pow(10,9)) {
                System.out.println("N should be smaller than 1e9");
            } else if (a < 0) {
                System.out.println("Terminating program...");
            } else {
                System.out.println("Invalid input");
            }
            return 0;
        }
        public int primeCalculation(int a){
            if(a %2 != 0 && a %3 !=0 && a %4 != 0 && a %5 !=0);
            return 0;
//create loop that checks all numbers < N for prime and if they are prime add them to a new total until they are almost > than N
        }
}

