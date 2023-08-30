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
 * ComputerTest.java
 *
 * @author Dylan Martin, mart1243@purdue.edu
 * @version 1.0, 03/30/2020
 */

public class ComputerRunner{
    public static void main(String[] args)
    {
        Result result = JUnitCore.runClasses(ComputerTest.class);
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
    public static class ComputerTest {

        private static Class<?> computer;

        /**
         * Sets up class for testing
         */
        @BeforeClass
        public static void setup() {
            try {
                computer = Class.forName("Computer");
            } catch (ClassNotFoundException e) {
                Assert.fail(e.getMessage());
            }
        }

        /**
         * Returns a field object of the Computer class based on the name given
         *
         * @param fieldName the name of the field to be returned
         * @return a field object of the Computer class
         */
        private static Field getField(String fieldName) {
            Field field = null;

            try {
                field = computer.getDeclaredField(fieldName);
                field.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Assert.fail(String.format("Make sure the %s variable is declared.", fieldName));
            }

            return field;
        }


        /**
         * Returns a constructor object of the Computer class
         *
         * @return a constructor object of the Computer class
         */
        private static Constructor<?> getConstructor(boolean isParamaterized) {
            Constructor<?> constructor = null;

            if (isParamaterized) {
                try {
                    constructor = computer.getDeclaredConstructor(String.class, double.class);
                    constructor.setAccessible(true);
                } catch (NoSuchMethodException e) {
                    Assert.fail("Make sure you have declared the constructor in the Computer class.");
                }
            } else {
                try {
                    constructor = computer.getDeclaredConstructor();
                    constructor.setAccessible(true);
                } catch (NoSuchMethodException e) {
                    Assert.fail("Make sure you have declared the constructor in the Computer class.");
                }
            }

            return constructor;
        }

        /**
         * Returns a method object of the Computer class based on the name and parameters given
         *
         * @param methodName the name of the method
         * @param args       the arguments the method requires
         * @return a method object of the Course class
         */
        private static Method getMethod(String methodName, Class<?>... args) {
            Method method = null;

            try {
                method = computer.getDeclaredMethod(methodName, args);
                method.setAccessible(true);
            } catch (NoSuchMethodException e) {
                Assert.fail(String.format("Make sure the method %s is declared in the Computer class.", methodName));
            }

            return method;
        }


        /**
         * Returns an object based on the Computer class
         *
         * @param constructor the constructor of the Computer class
         * @return an object based on the Computer class
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
         * Tests the fields of the {@code Computer} class
         */
        @Test(timeout = 1000)
        public void testNameFieldDeclaration() {
            Field field = null;

            try {
                field = computer.getDeclaredField("name");
            } catch (NoSuchFieldException e) {
                Assert.fail("Make sure the `name` field in the Computer class is declared.");
            }

        }

        @Test(timeout = 1000)
        public void testCostFieldDeclaration() {
            Field field = null;

            try {
                field = computer.getDeclaredField("cost");
            } catch (NoSuchFieldException e) {
                Assert.fail("Make sure the `cost` field in the Computer class is declared.");
            }

        }

        @Test(timeout = 1000)
        public void constructorImplementation() {
            final String EXPECTED_NAME = "Alienware m17";
            final double EXPECTED_COST = 2000.01;

            Field modelField = null;
            Field costField = null;
            Constructor<?> constructor = null;
            Object computerPartObject = null;

            try {
                modelField = computer.getDeclaredField("name");
                modelField.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Assert.fail("Make sure the `name` field in the Computer class is declared.");
            }

            try {
                costField = computer.getDeclaredField("cost");
                costField.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Assert.fail("Make sure the `cost` field in the Computer class is declared.");
            }

            try {
                constructor = computer.getDeclaredConstructor(String.class, double.class);
                constructor.setAccessible(true);
            } catch (NoSuchMethodException e) {
                Assert.fail("Make sure you have declared a parameterized constructor in the Computer class.");
            }

            try {
                computerPartObject = constructor.newInstance(EXPECTED_NAME, EXPECTED_COST);
            } catch (ReflectiveOperationException e) {
                Assert.fail(e.getMessage());
            }

            String actualModel = null;
            double actualCost = 0.0;

            try {
                actualModel = (String) modelField.get(computerPartObject);
                actualCost = (Double) costField.get(computerPartObject);
            } catch (IllegalAccessException e) {
                Assert.fail(e.getMessage());
            }

            Assert.assertEquals("Make sure the `name` field is initialized in the Computer constructor.", EXPECTED_NAME, actualModel);
            Assert.assertEquals("Make sure the `cost` field is initialized in the Computer constructor.", EXPECTED_COST, actualCost, 0.001);
        }

        @Test(timeout = 1000)
        public void getNameMethodImplementation() {
            final String EXPECTED_NAME = "Razer Blade Stealth";
            String actualName = null;

            Constructor<?> constructor = getConstructor(true);
            Field nameField = getField("name");
            Method method = getMethod("getName");
            Object computerObject = getObject(constructor);

            try {
                nameField.set(computerObject, EXPECTED_NAME);
            } catch (IllegalAccessException e) {
                Assert.fail(e.getMessage());
            }

            try {
                actualName = (String) method.invoke(computerObject);
            } catch (ReflectiveOperationException e) {
                Assert.fail(e.getMessage());
            }

            Assert.assertEquals("Make sure the `getName` method returns the correct name.", EXPECTED_NAME, actualName);
        }

        @Test(timeout = 1000)
        public void getCostMethodImplementation() {
            final double EXPECTED_COST = 1700.99;
            double actualCost = 0.0;

            Constructor<?> constructor = getConstructor(true);
            Field costField = getField("cost");
            Method method = getMethod("getCost");
            Object computerObject = getObject(constructor);

            try {
                costField.set(computerObject, EXPECTED_COST);
            } catch (IllegalAccessException e) {
                Assert.fail(e.getMessage());
            }

            try {
                actualCost = (double) method.invoke(computerObject);
            } catch (ReflectiveOperationException e) {
                Assert.fail(e.getMessage());
            }

            Assert.assertEquals("Make sure the `getCost` method returns the correct cost.", EXPECTED_COST, actualCost, 0.001);
        }

    }
}