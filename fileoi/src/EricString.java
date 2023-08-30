import java.util.Scanner;
public class EricString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String ericB = scan.nextLine();
        String cap1 = ericB.substring(0,1).toUpperCase();
        String low1 = ericB.substring(1, ericB.indexOf(' ')).toLowerCase();

        String sub = ericB.substring(ericB.indexOf(' ') + 1, ericB.length());
        String cap2 = sub.substring(0, 1).toUpperCase();
        String low2 = sub.substring(1, sub.length()).toLowerCase();

        String name = cap1+low1 + " " + cap2 + low2;

        System.out.println(name);
    }
}
