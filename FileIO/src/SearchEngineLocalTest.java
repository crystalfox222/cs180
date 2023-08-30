import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchEngineLocalTest {
    private final InputStream originalInput = System.in;

    private final PrintStream originalOutput = System.out;

    private ByteArrayInputStream testIn;

    private ByteArrayOutputStream testOut;

    @Before
    public void outputStart() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }
    @Test(timeout = 1000)
    public void testOutput1()throws IOException,UnsupportedRosterException{
        final String input = "test1.txt\n" + "Output1.txt\n";
        List<String> expectedFileOutput = readAllLinesToList("ExpectedOutput1.txt");
        receiveInput(input);
        SearchEngine.main(new String[0]);
        List<String> studentFileOutput = readAllLinesToList("Output1.txt");
        Assert.assertEquals("Ensure that you are correctly searching for correct players!", expectedFileOutput, studentFileOutput);
    }

    @Test(timeout = 1000, expected = UnsupportedRosterException.class)
    public void testUnsupportedRosterException1() throws IOException, UnsupportedRosterException{
        final String input = "test2.txt\n" + "Output2.txt\n";
        receiveInput(input);
        SearchEngine.main(new String[0]);

    }

    //UTILITY METHODS BELOW!

    private void receiveInput(String str) {
        testIn = new ByteArrayInputStream(str.getBytes());
        System.setIn(testIn);
    }

    private String getOutput() {
        return testOut.toString();
    }

    private List<String> readAllLinesToList(String file) {
        String composePath = file;
        ArrayList<String> arr = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(composePath))) {
            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                arr.add(sCurrentLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return arr;
    }

    @After
    public void restoreInputAndOutput() {
        System.setIn(originalInput);
        System.setOut(originalOutput);
    }

}
