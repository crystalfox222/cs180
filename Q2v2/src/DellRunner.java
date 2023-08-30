import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.*;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * Purdue CS18000 Midterm 2
 * DellTest.java
 *
 * @author Dylan Martin, mart1243@purdue.edu
 * @version 1.0, 03/30/2020
 */


public class DellRunner{
    public static void main(String[] args)
    {
        Result result = JUnitCore.runClasses(DellTest.class);
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
    public static class DellTest {


        private static Class<?> dell;

        /**
         * Sets up class for testing
         */
        @BeforeClass
        public static void setup() {
            try {
                dell = Class.forName("Dell");
            } catch (ClassNotFoundException e) {
                Assert.fail(e.getMessage());
            }
        }

        /**
         * Returns a constructor object of the Dell class
         *
         * @return a constructor object of the Dell class
         */
        private static Constructor<?> getConstructor(boolean isParameterized) {
            Constructor<?> constructor = null;

            if (isParameterized) {
                try {
                    constructor = dell.getDeclaredConstructor(String.class, double.class);
                    constructor.setAccessible(true);
                } catch (NoSuchMethodException e) {
                    Assert.fail("Make sure you have declared the constructor in the Dell class.");
                }
            } else {
                try {
                    constructor = dell.getDeclaredConstructor();
                    constructor.setAccessible(true);
                } catch (NoSuchMethodException e) {
                    Assert.fail("Make sure you have declared the constructor in the Dell class.");
                }
            }

            return constructor;
        }

        /**
         * Returns a method object of the Dell class based on the name and parameters given
         *
         * @param methodName the name of the method
         * @param args the arguments the method requires
         * @return a method object of the Course class
         */

        private static Method getMethod(String methodName, Class<?>... args) {
            Method method = null;

            try {
                method = dell.getDeclaredMethod(methodName, args);
                method.setAccessible(true);
            } catch (NoSuchMethodException e) {
                Assert.fail(String.format("Make sure the method %s is declared in the Dell class.", methodName));
            }

            return method;
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

        @Test(timeout = 1000)
        public void defaultConstructorDeclaration() {
            Constructor<?> constructor = null;

            constructor = getConstructor(false);

            boolean isPublic = Modifier.isPublic(constructor.getModifiers());

            Assert.assertTrue("Make sure the Dell default constructor is public", isPublic);
        }

        @Test(timeout = 1000)
        public void parameterizedConstructorDeclaration() {
            Constructor<?> constructor = null;

            constructor = getConstructor(true);

            boolean isPublic = Modifier.isPublic(constructor.getModifiers());

            Assert.assertTrue("Make sure the Dell parameterized constructor is public", isPublic);
        }

        @Test(timeout = 1000)
        public void printInfoDeclaration() {

            boolean isPublic = false;
            try {
                Method method = Dell.class.getDeclaredMethod("printInfo");
                isPublic = Modifier.isPublic(method.getModifiers());
            } catch(NoSuchMethodException e) {
                Assert.fail("Missing printInfo method from Dell!");
            }


            Assert.assertTrue("Make sure the Dell printInfo method is public", isPublic);
        }

        @Test(timeout = 1000)
        public void loadOperatingSystemDeclaration() {

            boolean isPublic = false;
            try {
                Method method = Dell.class.getDeclaredMethod("loadOperatingSystem");
                isPublic = Modifier.isPublic(method.getModifiers());
            } catch(NoSuchMethodException e) {
                Assert.fail("Missing loadOperatingSystem method from Dell!");
            }

            Assert.assertTrue("Make sure the Dell loadOperatingSystem method is public", isPublic);
        }

    }
}