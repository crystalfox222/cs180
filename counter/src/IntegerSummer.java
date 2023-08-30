/**
 * IntegerSummer
 * <p>
 * Runs a thread of addition given param start and end
 * <p>
 * Javadocs for Runable, lecture, and piazza
 *
 * @author Edythe Thompson, L09
 * @version 4-1-2020
 */
public class IntegerSummer implements Runnable {
    private int start;
    private static int counter = 0;
    private int end;

    /**
     * @param start The start of the interval.
     * @param end   The end of the interval.
     */
    public IntegerSummer(int start, int end) {
        this.start = start;
        this.end = end;
    }


    /**
     * @return The counter variable.
     */
    public static int getCounter() {
        return counter;
    }

    @Override
    public void run() {
        for (int i = start; i < end; i++) {
            counter = counter + i;
        }

    }

}
