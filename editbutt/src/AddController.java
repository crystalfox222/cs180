import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * AddController
 *
 * [your documentation here]
 *
 * @author your name here
 *
 * @version date here
 *
 */
public final class AddController {

    private TwitterModel twitterModel;
    private AddTweet addTweet;

    /** Implement the AddController constructor per the instructions in the handout
     * @param twitterModel TwitterModel object connecting the model and controller portions of the MVC paradigm.
     * @param addTweet AddTweet object connecting the view and controller portions of the MVC paradigm.
     */
    //TODO: Implement the AddController constructor.
    public AddController(TwitterModel twitterModel, AddTweet addTweet) throws IllegalArgumentException {
            this.twitterModel = twitterModel;
            this.addTweet = addTweet;

            JButton add = new JButton("Add");
            add.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            });
    }

    /** A method used to verify if a given string is strictly containing numeric values.
     * @param aString A string to verify
     * @return boolean
     */
    public static boolean isNumeric(String aString) {
        if (aString == null) {
            return false;
        } else if (aString.isEmpty()) {
            return false;
        } else if (aString.indexOf(".") != aString.lastIndexOf(".")) {
            return false;
        } else {
            int counter = 0;
            for ( char c : aString.toCharArray()) {
                if ( Character.isDigit(c)) {
                    counter++;
                }
            }

            return counter == aString.length();

        }
    }

    /** A method to control specific GUI component actions. */
    //TODO: Implement the getAddButtonSemantics method.
    private void getAddButtonSemantics() {

    }

    /** A method to control specific GUI component actions. */
    //TODO: Implement the getClearButtonSemantics method.
    public void getClearButtonSemantics() {

    }
}
