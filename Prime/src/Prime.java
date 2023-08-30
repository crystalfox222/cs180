import java.util.Scanner;
public class Prime {
    static public boolean primeCheck(long a) {
        long go = 2;
        while (a > go)
            if (a % go != 0) {
                ++go;
            } else {
                return false;
            }
        return true;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long sum = 2;
        long check = 0;
        long total = 0;
        long a = 0;
        long stuck = 0;
        System.out.println("Enter number N:");
        a = scan.nextLong();
        while (stuck == 0) {
            if (check > 0) {
                System.out.println("Enter number N:");
                a = scan.nextLong();
            }
            if (a >= 2 && a <= Math.pow(10, 9)) {
                total = 0;
                sum = 0;
                while (a >= total) {
                    boolean results = Prime.primeCheck(sum);
                    if (results) {
                        if (total + sum + sum >= a) {
                            total = total + sum;
                            System.out.println("The last valid prime number is: " + sum);
                            //System.out.println("The last valid total number is: " + total );
                            total = a + sum;
                            break;
                        } else {
                            total = total + sum;
                            ++sum;
                        }

                    } else {
                        ++sum;
                    }

                     } ++check;
            } else if (a < 2 && a >= 0) {
                System.out.println("N should not be less than 2");
                ++check;
            } else if (a > Math.pow(10, 9)) {
                System.out.println("N should not be bigger than 1e9");
                ++check;
            } else if (a < 0) {
                System.out.println("Terminating program...");
                System.out.println("Bye!");
                stuck = 1;
                return;
            } else {
                System.out.println("Invalid input");
                ++check;
            }
        }
    }


}