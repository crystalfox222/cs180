import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * Purdue CS18000 Midterm 2
 * ComputerBuilderTest.java
 *
 * Tests the fields, methods, and constructors of a computer
 *
 * @author Dylan Martin, mart1243@purdue.edu
 * Some methods adapted from https://github.com/drewsdav/barista
 * @version 1.0, 03/31/2020
 */
public class ComputerBuilderRunner{
    public static void main(String[] args)
    {
        Result result = JUnitCore.runClasses(ComputerBuilderTest.class);
        if (result.wasSuccessful())
        {
            System.out.println("Excellent - all tests ran successfully");
        }
        else
        {
            for (Failure failure : result.getFailures())
            {
                System.out.println(failure.toString());
            }
        }
    }

    public static class ComputerBuilderTest {

        private final static PrintStream ORIGINAL_OUT = System.out;
        private final static InputStream ORIGINAL_IN = System.in;
        private final static String OUTPUT_ERROR = "Verify your output matches that displayed in the handout";
        private static Method studentMainMethod;
        private static Method solutionMainMethod;
        private static ByteArrayOutputStream actualOut;
        private static ByteArrayOutputStream expectedOut;
        private static Class<?> dell;
        private static Class<?> lenovo;
        private static Class<?> computer;

        /**
         * Sets up the ComputerBuilder class for testing
         */
        @BeforeClass
        public static void setup() {
            try {
                Class<?> studentComputerBuilder = Class.forName("ComputerBuilder");
                studentMainMethod = studentComputerBuilder.getDeclaredMethod("main", String[].class);
                studentMainMethod.setAccessible(true);
            } catch (ClassNotFoundException | NoSuchMethodException e) {
                Assert.fail("Make sure the ComputerBuilder class is submitted.");
            }

            try {
                Class<?> studentDell = Class.forName("Dell");
            } catch (ClassNotFoundException e) {
                Assert.fail("Make sure the Dell class is submitted.");
            }

            try {
                Class<?> studentLenovo = Class.forName("Lenovo");
            } catch (ClassNotFoundException e) {
                Assert.fail("Make sure the Lenovo class is submitted.");
            }

            try {
                Class<?> studentComputer = Class.forName("Computer");
            } catch (ClassNotFoundException e) {
                Assert.fail("Make sure the Computer class is submitted.");
            }

            try {
                Class<?> solutionComputerBuilder = Class.forName("ComputerBuilder");
                solutionMainMethod = solutionComputerBuilder.getDeclaredMethod("main", String[].class);
                studentMainMethod.setAccessible(true);
            } catch (ClassNotFoundException | NoSuchMethodException e) {
                Assert.fail("Solution file not found!");
            }

            actualOut = new ByteArrayOutputStream();
            expectedOut = new ByteArrayOutputStream();
        }

        /**
         * Tests if two {@link String}s are equal, ignoring all whitespace and
         * capitalization.
         *
         * @param s1 the first {@link String}
         * @param s2 the second {@link String}
         * @return true if they are "fuzzy equal", false otherwise
         */
        public static boolean fuzzyEquals(String s1, String s2) {
            s1 = removeAllWhitespace(s1).toLowerCase();
            s2 = removeAllWhitespace(s2).toLowerCase();

            return s1.equals(s2);
        }

        /**
         * Normalizes the line endings for a {@link String}.
         *
         * @param s the {@link String} to normalize
         * @return a {@link String} with only the current system's line endings
         */
        public static String normalizeLineEndings(String s) {
            return s.replaceAll("\\n|\\r\\n", System.lineSeparator());
        }

        /**
         * Removes all whitespace from a {@link String}.
         *
         * @param s the {@link String} to remove whitespace from
         * @return a {@link String} with no whitespace
         */
        public static String removeAllWhitespace(String s) {
            return s.replaceAll("[ \\t\\n\\r\\f]", "");
        }

        /**
         * Runs a test to verify that the solutionMainMethod and studentMainMethod have identical output.
         */
        private void testMain(String testInput) {
            try {
                System.setIn(new ByteArrayInputStream(testInput.getBytes()));
                System.setOut(new PrintStream(actualOut));

                studentMainMethod.invoke(null, (Object) null);

                System.setIn(new ByteArrayInputStream(testInput.getBytes()));
                System.setOut(new PrintStream(expectedOut));

                solutionMainMethod.invoke(null, (Object) null);

                System.setOut(ORIGINAL_OUT);
                System.setIn(ORIGINAL_IN);
            } catch (IllegalAccessException | InvocationTargetException e) {
                Assert.fail(e.getMessage());
            }
            String expected = expectedOut.toString();
            String actual = actualOut.toString();
            expectedOut.reset();
            actualOut.reset();
            Assert.assertTrue(fuzzyEquals(expected,actual));
        }

        /**
         * Holistic test against the ComputerBuilder main method
         * Verifies that child classes are correctly instantiated and methods print
         * output as expected.
         *
         */
        @Test(timeout = 1000)
        public void testMainCompletion() {
            String testInput = "";
            testMain(testInput);
        }





    }
}