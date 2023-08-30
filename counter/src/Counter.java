/**
 * Counter
 * <p>
 * This class represents threading
 * <p>
 * Used stack overflow occasionally
 *
 * @author Edythe Thompson, L09
 * @version 4-1-2020
 */
public class Counter implements Runnable {

    private static int counter;
    private int start;
    private int end;

    public Counter(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public static int getCounter() {
        return counter;
    }


    @Override
    public void run() {
        for (int i = start; i < end; i++) {
            this.counter = 0;
            counter = counter + i;
        }

    }
}
