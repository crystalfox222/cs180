import java.io.*;
import java.util.ArrayList;

/**
 * [Add your documentation here]
 *
 * @author your name and section
 * @version date
 */
public class ChatFilter {

    private ArrayList<String> badWords = new ArrayList<>();

    public ChatFilter(String badWordsFileName) throws IOException {
        File file = new File(badWordsFileName);
        BufferedReader read = new BufferedReader(new FileReader(file));
        String place = read.readLine();
        while (place != null) {
            badWords.add(place);
            place = read.readLine();
        }

    }

    public String filter(String msg) {
        String bleep = "";
        // Jed Mods
        msg.toLowerCase();
        // End Jed Mods
        for (int i = 0; i < badWords.size(); i++) {
            if (msg.contains(badWords.get(i))) {
                for (int j = 0; j < badWords.get(i).length(); j++) {
                    bleep = bleep + "*";
                }
                msg = msg.replace(badWords.get(i), bleep);
            }
        }
        return msg;
    }

    public void printFilter() {
        String welcome = "Bad words: ";
        for (int i = 0; i < badWords.size(); i++) {
            welcome = welcome + badWords.get(i) + ", ";
        }
        System.out.println(welcome);
    }
}
