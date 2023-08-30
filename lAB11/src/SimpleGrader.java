import java.util.Random;

/**
 * Skeleton Code for task 2
 */
public class SimpleGrader implements Runnable {
    public final static int SEED = 200;
    public static int[] correctAnswers = generateCorrectAnswers();
    public static int[][] studentAnswers = generateStudentAnswers(correctAnswers);
    /* Do not change variables above (you can still import other packages if necessary) */
    /* add or edit necessary variables here*/
    public static int grade = 0;
    public int questionNumber;
    public static Object object = new Object();


    // TODO implement the constructor with necessary parameters
    // hint: When we create threads in main method, each thread only grades its assigned question
    // Therefore, we need a variable to indicate index of the assigned question.

    public SimpleGrader(int questionNumber) {
        this.questionNumber = questionNumber;
    }


    /**
     * run() method will be called when a thread starts.
     * in this case, the grading part should be done here
     */
    @Override
    public void run() {
        synchronized (object) {
            for (int i = 0; i < studentAnswers[9].length; i++) {
                if (studentAnswers[questionNumber][i] == correctAnswers[questionNumber]) {
                    grade = grade + 10;
                } else if (studentAnswers[questionNumber][i] != 0) {
                    grade = grade - 2;
                } 
            }
        }

        // TODO acquire the correct answer from correctAnswers, and grade all students' answer to that question.
    }

    public static void main(String[] args) throws InterruptedException {
        // TODO create ten threads, each responsible for one question (tip: make an array of threads could save you lots of work)
        // As the class implements Runnable instead of extends Thread, here is an example line of create a thread:
        // Thread t = new Thread(new SimpleGrader(...)); //the arguments should be corresponding to your constructor
        int questionNumber = 0;

        Thread[] threads = new Thread[10];

        for (int i = 0; i < threads.length; i++) {
                threads[i] = new Thread(new SimpleGrader(i));
        }

        for (int i = 0; i < threads.length; i++) {
                threads[i].start();
        }

        try {
            for (int i = 0; i < threads.length; i++) {
                threads[i].join();
            }
        } catch (InterruptedException e) {
            System.out.println("Oops!");
        }


        // TODO start all threads created

        // TODO wait for all threads to finish. If there is an InterruptedException, print out "Oops!"


        // to get the average grade
        // you can make changes if necessary
        double average = grade / 500.0;
        System.out.printf("The average score is %.3f\n", average);
    }

    /* Do not change lines below */
    public static int[] generateCorrectAnswers() {
        int[] answers = new int[10];
        Random r = new Random(SEED);
        for (int i = 0; i < answers.length; i++) {
            answers[i] = r.nextInt(4) + 1;
        }
        return answers;
    }

    public static int[][] generateStudentAnswers(int[] answers) {
        int[][] response = new int[10][500];
        Random r = new Random(SEED);
        for (int i = 0; i < response.length; i++) {
            int answer = answers[i];
            for (int j = 0; j < response[i].length; j++) {
                if (r.nextInt(10) < 7) {
                    response[i][j] = answer;
                } else if (r.nextBoolean()) {
                    response[i][j] = 0;
                } else {
                    response[i][j] = r.nextInt(4) + 1;
                }
            }
        }
        return response;
    }
}
