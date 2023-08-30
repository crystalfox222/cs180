import org.junit.Test;
import java.lang.reflect.Field;
import org.junit.Assert;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.io.*;
import java.lang.reflect.*;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * A set of public test cases for question Q1 of Exam 2.
 *
 * <p>Purdue University -- CS18000 -- Spring 2020 -- Exam 2</p>
 */
public class MysteryRunner{
    public static void main(String[] args)
    {
        PrintStream restoreOutput = System.out;
        Result result = JUnitCore.runClasses(MysteryPublicTest.class);
        System.setOut(restoreOutput);

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

    public static class MysteryPublicTest {
        private final PrintStream originalOutput = System.out;

        @Test (timeout = 1000)
        public void caseTests() {
            Case c = new Case("Mummy at LWSN", "David Santos");
            Field caseTitle;
            Field originator;
            /**
             * Testing getters and setters in the Case class
             */
            assertEquals("Mummy at LWSN", c.getCaseTitle());
            assertEquals("David Santos", c.getOriginator());
            c.setCaseTitle("Mummy at HAAS");
            c.setOriginator("Charis");
            assertEquals("Mummy at HAAS", c.getCaseTitle());
            assertEquals("Charis", c.getOriginator());

            /**
             * Testing fields in Case class
             */

            try {
                caseTitle = Case.class.getDeclaredField("caseTitle");

                if(caseTitle.getModifiers() != Modifier.PRIVATE || (!caseTitle.getType().equals(String.class))){
                    throw new NoSuchFieldException();
                }

            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that Case class has a field String caseTitle and it's private!");
            }

            try {
                originator = Case.class.getDeclaredField("originator");

                if(originator.getModifiers() != Modifier.PRIVATE || (!originator.getType().equals(String.class))){
                    throw new NoSuchFieldException();
                }

            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that Case class has a field String originator and it's private!");
            }
            /**
             * Check method singatures
             */
            Method method;
            try {
                Constructor constructor = Case.class.getDeclaredConstructor(String.class, String.class);
                if(constructor.getModifiers() != Modifier.PUBLIC)
                    throw new NoSuchMethodException();
            } catch (NoSuchMethodException e) {
                Assert.fail("Make sure the Case Constructor complies with the question's specifiacations.");
            }

            try {
                method = Case.class.getDeclaredMethod("getCaseTitle");
                if(method.getModifiers() != Modifier.PUBLIC || (!method.getReturnType().equals(String.class)))
                    throw new NoSuchMethodException();
            } catch (NoSuchMethodException e) {
                Assert.fail("Make sure the Case's getCaseTitle method complies with the question's specifiacations.");
            }

            try {
                method = Case.class.getDeclaredMethod("setCaseTitle", String.class);
                if(method.getModifiers() != Modifier.PUBLIC || (!method.getReturnType().equals(void.class)))
                    throw new NoSuchMethodException();
            } catch (NoSuchMethodException e) {
                Assert.fail("Make sure the Case's setCaseTitle method complies with the question's specifiacations.");
            }

            try {
                method = Case.class.getDeclaredMethod("getOriginator");
                if(method.getModifiers() != Modifier.PUBLIC || (!method.getReturnType().equals(String.class)))
                    throw new NoSuchMethodException();
            } catch (NoSuchMethodException e) {
                Assert.fail("Make sure the Case's getOriginator method complies with the question's specifiacations.");
            }

            try {
                method = Case.class.getDeclaredMethod("setOriginator", String.class);
                if(method.getModifiers() != Modifier.PUBLIC || (!method.getReturnType().equals(void.class)))
                    throw new NoSuchMethodException();
            } catch (NoSuchMethodException e) {
                Assert.fail("Make sure the Case's setOriginator method complies with the question's specifiacations.");
            }
            System.setOut(originalOutput);
        }

        @Test (timeout = 1000)
        public void mysteryIncMemberTests() {
            /**
             * Check the MysteryIncMembers constructor
             */
            MysteryIncMember mInc = new MysteryIncMember("Fred");
            assertEquals("Fred", mInc.getName());
            assertEquals(0, mInc.getTotalAwesomeness());
            try{
                assertEquals(0, mInc.getStarredCases().size());
            }catch (NullPointerException ex){
                Assert.fail("Eunsure that you have instantiated an object for starredCases array list in your constructor.");
            }

            /**
             * Check the MysteryIncMembers fields
             */
            try {
                Field name = MysteryIncMember.class.getDeclaredField("name");

                if(name.getModifiers() != Modifier.PRIVATE || (!name.getType().equals(String.class))){
                    throw new NoSuchFieldException();
                }

            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that MysteryIncMembers class has a field String name and it's private!");
            }
            try {
                Field totalAwesomeness = MysteryIncMember.class.getDeclaredField("totalAwesomeness");

                if(totalAwesomeness.getModifiers() != Modifier.PRIVATE || (!totalAwesomeness.getType().equals(int.class))){
                    throw new NoSuchFieldException();
                }

            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that MysteryIncMembers class has a field int totalAwesomeness and it's private!");
            }
            try {
                Field starredCases = MysteryIncMember.class.getDeclaredField("starredCases");

                if(starredCases.getModifiers() != Modifier.PRIVATE || (!starredCases.getType().equals(ArrayList.class))){
                    throw new NoSuchFieldException();
                }
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that MysteryIncMembers class has a field ArrayList starredCases and it's private!");
            }
            /**
             * Test setters
             */
            mInc.setTotalAwesomeness(-100);;
            assertEquals(-100, mInc.getTotalAwesomeness());
            mInc.setName("Nick");
            assertEquals("Nick", mInc.getName());

            /**
             * Other methods
             */
            mInc.addStarredCase(new Case("Human shark at the Miami beach", "Riana"));
            ArrayList<Case> arr = mInc.getStarredCases();
            if (arr.size() == 1){
                Case ca = arr.get(0);
                if ((!ca.getCaseTitle().equals("Human shark at the Miami beach")) && (!ca.getOriginator().equals("Riana"))){
                    Assert.fail("Ensure that the methods getStarredCases and addStarredCase of thr MysteryIncMember class are working properly!");
                }
            }
            else
                Assert.fail("Ensure that the methods getStarredCases and addStarredCase of thr MysteryIncMember class are working properly!");

            /**
             * Checking method signatures
             */
            Method method;
            try {
                Constructor constructor = MysteryIncMember.class.getDeclaredConstructor(String.class);
                if(constructor.getModifiers() != Modifier.PUBLIC)
                    throw new NoSuchMethodException();
            } catch (NoSuchMethodException e) {
                Assert.fail("Make sure the MysteryIncMember's Constructor complies with the question's specifiacations.");
            }

            try {
                method = MysteryIncMember.class.getDeclaredMethod("getName");
                if(method.getModifiers() != Modifier.PUBLIC || (!method.getReturnType().equals(String.class)))
                    throw new NoSuchMethodException();
            } catch (NoSuchMethodException e) {
                Assert.fail("Make sure the MysteryIncMember's getName method complies with the question's specifiacations.");
            }

            try {
                method = MysteryIncMember.class.getDeclaredMethod("setName", String.class);
                if(method.getModifiers() != Modifier.PUBLIC || (!method.getReturnType().equals(void.class)))
                    throw new NoSuchMethodException();
            } catch (NoSuchMethodException e) {
                Assert.fail("Make sure the MysteryIncMember's setName method complies with the question's specifiacations.");
            }

            try {
                method = MysteryIncMember.class.getDeclaredMethod("getTotalAwesomeness");
                if(method.getModifiers() != Modifier.PUBLIC || (!method.getReturnType().equals(int.class)))
                    throw new NoSuchMethodException();
            } catch (NoSuchMethodException e) {
                Assert.fail("Make sure the MysteryIncMember's getTotalAwesomeness method complies with the question's specifiacations.");
            }

            try {
                method = MysteryIncMember.class.getDeclaredMethod("setTotalAwesomeness", int.class);
                if(method.getModifiers() != Modifier.PUBLIC || (!method.getReturnType().equals(void.class)))
                    throw new NoSuchMethodException();
            } catch (NoSuchMethodException e) {
                Assert.fail("Make sure the MysteryIncMember's setTotalAwesomeness method complies with the question's specifiacations.");
            }

            try {
                method = MysteryIncMember.class.getDeclaredMethod("addAwesomeValue", int.class);
                if(method.getModifiers() != Modifier.PUBLIC || (!method.getReturnType().equals(void.class)))
                    throw new NoSuchMethodException();
            } catch (NoSuchMethodException e) {
                Assert.fail("Make sure the MysteryIncMember's addAwesomeValue method complies with the question's specifiacations.");
            }

            try {
                method = MysteryIncMember.class.getDeclaredMethod("addStarredCase", Case.class);
                if(method.getModifiers() != Modifier.PUBLIC || (!method.getReturnType().equals(void.class)))
                    throw new NoSuchMethodException();
            } catch (NoSuchMethodException e) {
                Assert.fail("Make sure the MysteryIncMember's addStarredCase method complies with the question's specifiacations.");
            }

            try {
                method = MysteryIncMember.class.getDeclaredMethod("getStarredCases");
                if(method.getModifiers() != Modifier.PUBLIC || (!method.getReturnType().equals(ArrayList.class)))
                    throw new NoSuchMethodException();
            } catch (NoSuchMethodException e) {
                Assert.fail("Make sure the MysteryIncMember's getStarredCases method complies with the question's specifiacations.");
            }
            System.setOut(originalOutput);
        }

        @Test (timeout = 1000)
        public void statsTests() {
            /**
             * Check fields
             */
            Field field;
            try {
                field = Stats.class.getDeclaredField("fred");

                if(field.getModifiers() != Modifier.PRIVATE || (!field.getType().equals(MysteryIncMember.class))){
                    throw new NoSuchFieldException();
                }

            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that Stats class has a field MysteryIncMember fred and it's private!");
            }
            try {
                field = Stats.class.getDeclaredField("velma");

                if(field.getModifiers() != Modifier.PRIVATE || (!field.getType().equals(MysteryIncMember.class))){
                    throw new NoSuchFieldException();
                }

            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that Stats class has a field MysteryIncMember velma and it's private!");
            }
            try {
                field = Stats.class.getDeclaredField("daphne");

                if(field.getModifiers() != Modifier.PRIVATE || (!field.getType().equals(MysteryIncMember.class))){
                    throw new NoSuchFieldException();
                }

            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that Stats class has a field MysteryIncMember daphne and it's private!");
            }
            try {
                field = Stats.class.getDeclaredField("shaggy");

                if(field.getModifiers() != Modifier.PRIVATE || (!field.getType().equals(MysteryIncMember.class))){
                    throw new NoSuchFieldException();
                }

            } catch (NoSuchFieldException e) {
                //  System.out.println("Ensure that Supervisor has a field int teamSize and it's private!");
                Assert.fail("Ensure that Stats class has a field MysteryIncMember shaggy and it's private!");
            }
            try {
                field = Stats.class.getDeclaredField("scooby_doo");

                if(field.getModifiers() != Modifier.PRIVATE || (!field.getType().equals(MysteryIncMember.class))){
                    throw new NoSuchFieldException();
                }

            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that Stats class has a field MysteryIncMember scooby_doo and it's private!");
            }

            /**
             * Check method signatures
             */
            try {
                Constructor constructor = Stats.class.getDeclaredConstructor();
                if(constructor.getModifiers() != Modifier.PUBLIC)
                    throw new NoSuchMethodException();
            } catch (NoSuchMethodException e) {
                Assert.fail("Make sure the Stats' Constructor complies with the question's specifiacations.");
            }
            Method method;
            try {
                method = Stats.class.getDeclaredMethod("readFile", File.class);
                if(method.getModifiers() != Modifier.PUBLIC || (!method.getReturnType().equals(void.class)))
                    throw new NoSuchMethodException();
            } catch (NoSuchMethodException e) {
                Assert.fail("Make sure the Stats' readFile method complies with the question's specifiacations.");
            }

            try {
                method = Stats.class.getDeclaredMethod("getFred");
                if(method.getModifiers() != Modifier.PUBLIC || (!method.getReturnType().equals(MysteryIncMember.class)))
                    throw new NoSuchMethodException();
            } catch (NoSuchMethodException e) {
                Assert.fail("Make sure the Stats' getFred method complies with the question's specifiacations.");
            }

            try {
                method = Stats.class.getDeclaredMethod("getVelma");
                if(method.getModifiers() != Modifier.PUBLIC || (!method.getReturnType().equals(MysteryIncMember.class)))
                    throw new NoSuchMethodException();
            } catch (NoSuchMethodException e) {
                Assert.fail("Make sure the Stats' getVelma method complies with the question's specifiacations.");
            }
            try {
                method = Stats.class.getDeclaredMethod("getDaphne");
                if(method.getModifiers() != Modifier.PUBLIC || (!method.getReturnType().equals(MysteryIncMember.class)))
                    throw new NoSuchMethodException();
            } catch (NoSuchMethodException e) {
                Assert.fail("Make sure the Stats' getDaphne method complies with the question's specifiacations.");
            }
            try {
                method = Stats.class.getDeclaredMethod("getShaggy");
                if(method.getModifiers() != Modifier.PUBLIC || (!method.getReturnType().equals(MysteryIncMember.class)))
                    throw new NoSuchMethodException();
            } catch (NoSuchMethodException e) {
                Assert.fail("Make sure the Stats' getShaggy method complies with the question's specifiacations.");
            }
            try {
                method = Stats.class.getDeclaredMethod("getScooby_doo");
                if(method.getModifiers() != Modifier.PUBLIC || (!method.getReturnType().equals(MysteryIncMember.class)))
                    throw new NoSuchMethodException();
            } catch (NoSuchMethodException e) {
                Assert.fail("Make sure the Stats' getScooby_doo method complies with the question's specifiacations.");
            }
            try {
                method = Stats.class.getDeclaredMethod("writeAwesomeness", File.class);
                if(method.getModifiers() != Modifier.PUBLIC || (!method.getReturnType().equals(void.class)))
                    throw new NoSuchMethodException();
            } catch (NoSuchMethodException e) {
                Assert.fail("Make sure the Stats' writeAwesomeness method complies with the question's specifiacations.");
            }

            try {
                method = Stats.class.getDeclaredMethod("printTeamLeader");
                if(method.getModifiers() != Modifier.PUBLIC || (!method.getReturnType().equals(void.class)))
                    throw new NoSuchMethodException();
            } catch (NoSuchMethodException e) {
                Assert.fail("Make sure the Stats' printTeamLeader method complies with the question's specifiacations.");
            }

            /**
             * Test: Constructor and getters
             */
            Stats stat = new Stats();
            MysteryIncMember member = stat.getFred();
            assertEquals("Fred", member.getName());
            assertEquals(0, member.getTotalAwesomeness());
            try{
                assertEquals(0, member.getStarredCases().size());
            }catch (NullPointerException ex){
                Assert.fail("Eunsure that you have instantiated an object for starredCases array list in MysteryIncMember constructor.");
            }
            member = stat.getVelma();
            assertEquals("Velma", member.getName());
            assertEquals(0, member.getTotalAwesomeness());
            try{
                assertEquals(0, member.getStarredCases().size());
            }catch (NullPointerException ex){
                Assert.fail("Eunsure that you have instantiated an object for starredCases array list in MysteryIncMember constructor.");
            }
            member = stat.getDaphne();
            assertEquals("Daphne", member.getName());
            assertEquals(0, member.getTotalAwesomeness());
            try{
                assertEquals(0, member.getStarredCases().size());
            }catch (NullPointerException ex){
                Assert.fail("Eunsure that you have instantiated an object for starredCases array list in MysteryIncMember constructor.");
            }
            member = stat.getShaggy();
            assertEquals("Shaggy", member.getName());
            assertEquals(0, member.getTotalAwesomeness());
            try{
                assertEquals(0, member.getStarredCases().size());
            }catch (NullPointerException ex){
                Assert.fail("Eunsure that you have instantiated an object for starredCases array list in MysteryIncMember constructor.");
            }
            member = stat.getScooby_doo();
            assertEquals("Scooby-Doo", member.getName());
            assertEquals(0, member.getTotalAwesomeness());
            try{
                assertEquals(0, member.getStarredCases().size());
            }catch (NullPointerException ex){
                Assert.fail("Eunsure that you have instantiated an object for starredCases array list in MysteryIncMember constructor.");
            }
            System.setOut(originalOutput);
        }

        @Test (timeout = 1000)
        public void readLegitimateFile() throws IOException {
            /**
             * Test: Correctly reading a file
             */
            Stats stats = new Stats();
            File in = new File("casesFileLegitimate.txt");
            stats.readFile(in);
            File out = new File("out.txt");
            stats.writeAwesomeness(out);
            String expected = "Velma: 217\nScooby-Doo: 213\nFred: 167\nShaggy: 163\nDaphne: 89";

            BufferedReader br = new BufferedReader(new FileReader(out));
            String line;
            String contents = "";
            while ((line = br.readLine()) != null){
                contents +=line + "\n";
            }
            br.close();
            if((!expected.equals(contents)) && (!(expected + "\n").equals(contents)))
                assertEquals(expected, contents);

            /**
             * Check the consistency of the fields and the array lists
             */
            assertEquals(217, stats.getVelma().getTotalAwesomeness());
            assertEquals(167, stats.getFred().getTotalAwesomeness());
            assertEquals(213, stats.getScooby_doo().getTotalAwesomeness());
            assertEquals(163, stats.getShaggy().getTotalAwesomeness());
            assertEquals(89, stats.getDaphne().getTotalAwesomeness());

            assertEquals(2, stats.getVelma().getStarredCases().size());
            assertEquals(2, stats.getFred().getStarredCases().size());
            assertEquals(2, stats.getShaggy().getStarredCases().size());
            assertEquals(1, stats.getDaphne().getStarredCases().size());
            assertEquals(3, stats.getScooby_doo().getStarredCases().size());

            System.setOut(originalOutput);
        }

        @Test (timeout = 1000, expected = IOException.class)
        public void testIOException() throws IOException {
            /**
             * Test for checking if IOException is thrown
             */
            Stats stats = new Stats();
            File in = new File("casesIOException.txt");
            stats.readFile(in);
            System.setOut(originalOutput);
        }

        @Test (timeout = 1000)
        public void testNumberFormatEx() throws IOException {
            /**
             * Test for checking if IOException is thrown
             */
            ByteArrayOutputStream testOut = new ByteArrayOutputStream();
            System.setOut(new PrintStream(testOut));
            String expected = "Corrupted line!" + System.getProperty("line.separator") +"Corrupted line!" + System.getProperty("line.separator"); // or \r\n for win, \r for unix or mac
            Stats stats = new Stats();
            File in = new File("casestestNumberFormatEx.txt");
            stats.readFile(in);
            assertEquals(expected, testOut.toString());

            File out = new File("out2.txt");
            stats.writeAwesomeness(out);

            expected = "Scooby-Doo: 183\n" +
                    "Velma: 122\n" +
                    "Fred: 120\n" +
                    "Shaggy: 102\n" +
                    "Daphne: 51\n";

            BufferedReader br = new BufferedReader(new FileReader(out));
            String line;
            String contents = "";
            while ((line = br.readLine()) != null){
                contents +=line + "\n";
            }
            br.close();
            if((!expected.equals(contents)) && (!(expected + "\n").equals(contents)))
                assertEquals(expected, contents);
            /**
             * Check the consistency of the fields and the array lists
             */
            assertEquals(122, stats.getVelma().getTotalAwesomeness());
            assertEquals(120, stats.getFred().getTotalAwesomeness());
            assertEquals(183, stats.getScooby_doo().getTotalAwesomeness());
            assertEquals(102, stats.getShaggy().getTotalAwesomeness());
            assertEquals(51, stats.getDaphne().getTotalAwesomeness());

            assertEquals(1, stats.getVelma().getStarredCases().size());
            assertEquals(2, stats.getFred().getStarredCases().size());
            assertEquals(2, stats.getShaggy().getStarredCases().size());
            assertEquals(0, stats.getDaphne().getStarredCases().size());
            assertEquals(3, stats.getScooby_doo().getStarredCases().size());

            /**
             * Print the team leader
             */
            testOut.reset();
            stats.printTeamLeader();
            expected = "The team leader is: Scooby-Doo" + System.getProperty("line.separator");
            assertEquals(expected, testOut.toString());
            System.setOut(originalOutput);

        }


    }
}