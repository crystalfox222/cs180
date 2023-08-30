import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * Purdue CS18000 Midterm 2
 * LenovoTest.java
 *
 * @author Dylan Martin, mart1243@purdue.edu
 * @version 1.0, 03/30/2020
 */

public class LenovoRunner{
    public static void main(String[] args)
    {
        Result result = JUnitCore.runClasses(LenovoTest.class);
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

    public static class LenovoTest {

        private static Class<?> lenovo;

        /**
         * Sets up class for testing
         */
        @BeforeClass
        public static void setup() {
            try {
                lenovo = Class.forName("Lenovo");
            } catch (ClassNotFoundException e) {
                Assert.fail(e.getMessage());
            }
        }

        /**
         * Returns a field object of the Lenovo class based on the name given
         *
         * @param fieldName the name of the field to be returned
         * @return a field object of the Lenovo class
         */
        private static Field getField(String fieldName) {
            Field field = null;

            try {
                field = lenovo.getDeclaredField(fieldName);
                field.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Assert.fail(String.format("Make sure the %s variable is declared.", fieldName));
            }

            return field;
        }

        /**
         * Returns a constructor object of the Lenovo class
         *
         * @return a constructor object of the Lenovo class
         */
        private static Constructor<?> getConstructor(boolean isParamaterized) {
            Constructor<?> constructor = null;

            if (isParamaterized) {
                try {
                    constructor = lenovo.getDeclaredConstructor(String.class, double.class);
                    constructor.setAccessible(true);
                } catch (NoSuchMethodException e) {
                    Assert.fail("Make sure you have declared the constructor in the Lenovo class.");
                }
            } else {
                try {
                    constructor = lenovo.getDeclaredConstructor();
                    constructor.setAccessible(true);
                } catch (NoSuchMethodException e) {
                    Assert.fail("Make sure you have declared the constructor in the Lenovo class.");
                }
            }

            return constructor;
        }

        /**
         * Returns a method object of the Lenovo class based on the name and parameters given
         *
         * @param methodName the name of the method
         * @param args the arguments the method requires
         * @return a method object of the Course class
         */

        private static Method getMethod(String methodName, Class<?>... args) {
            Method method = null;

            try {
                method = lenovo.getDeclaredMethod(methodName, args);

                method.setAccessible(true);
            } catch (NoSuchMethodException e) {
                Assert.fail(String.format("Make sure the method %s is declared in the Lenovo class.", methodName));
            }

            return method;
        }

        /**
         * Returns an object based on the Lenovo class
         *
         * @param constructor the constructor of the Lenovo class
         * @return an object based on the Lenovo class
         */
        private static Object getObject(Constructor<?> constructor) {
            Object object = null;

            try {
                object = constructor.newInstance("", 0.0);
            } catch (ReflectiveOperationException e) {
                Assert.fail(e.getMessage());
            }

            return object;
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

            Assert.assertTrue("Make sure the Lenovo default constructor is public", isPublic);
        }

        @Test(timeout = 1000)
        public void parameterizedConstructorDeclaration() {
            Constructor<?> constructor = null;

            constructor = getConstructor(true);

            boolean isPublic = Modifier.isPublic(constructor.getModifiers());

            Assert.assertTrue("Make sure the Lenovo parameterized constructor is public", isPublic);
        }

        @Test(timeout = 1000)
        public void printInfoDeclaration() {

            boolean isPublic = false;
            try {
                Method method = Lenovo.class.getDeclaredMethod("printInfo");
                isPublic = Modifier.isPublic(method.getModifiers());
            } catch(NoSuchMethodException e) {
                Assert.fail("Missing printInfo method from Lenovo!");
            }


            Assert.assertTrue("Make sure the Lenovo printInfo method is public", isPublic);
        }

        @Test(timeout = 1000)
        public void loadOperatingSystemDeclaration() {

            boolean isPublic = false;
            try {
                Method method = Lenovo.class.getDeclaredMethod("loadOperatingSystem");
                isPublic = Modifier.isPublic(method.getModifiers());
            } catch(NoSuchMethodException e) {
                Assert.fail("Missing loadOperatingSystem method from Lenovo!");
            }



            Assert.assertTrue("Make sure the Lenovo printInfo method is public", isPublic);
        }

    }
}
