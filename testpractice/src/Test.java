import javax.swing.JFrame;
public class Test {
    public static void main(String[] args) {
        float fle = 3.0;
        Pokemon monkey = new Chimchar("");
        monkey.evolve();
        monkey = monkey.evolve();
        monkey = monkey.evolve();
        System.out.println(monkey.toString());
    }
}
