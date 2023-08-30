import javax.swing.*;
import java.util.Optional;

/**
 * EditController
 *
 * [your documentation here]
 *
 * @author your name here
 *
 * @version date here
 *
 */
public final class EditController {

    private TwitterModel twitterModel;
    private EditTweet editTweet;

    /** Implement the AddController constructor per the instructions in the handout
     * @param twitterModel TwitterModel object connecting the model and controller portions of the MVC paradigm.
     * @param editTweet EditTweet object connecting the view and controller portions of the MVC paradigm.
     */
    //TODO: Implement the EditController constructor.
    public EditController(TwitterModel twitterModel, EditTweet editTweet) throws IllegalArgumentException {

    }

    /** A method used to update a specific Tweet's body string.
     * @param aTweet Tweet object containing an ID and body String
     * @param body String
     */
    private void updateBody(Tweet aTweet, String body) {
        if (body.equals("")) {
            JOptionPane.showMessageDialog(
                    this.editTweet.getMainPanel(),
                    "This message body is empty. Maybe you should instead delete it?",
                    "Message Board",
                    JOptionPane.ERROR_MESSAGE);
            this.editTweet.getBodyTextField().requestFocus();
        } else {
            aTweet.setBody(body);
            JOptionPane.showMessageDialog(
                    this.editTweet.getMainPanel(),
                    "This message was properly updated!",
                    "Message Board",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /** A method to control specific GUI component actions. */
    //TODO: Implement the getEditButtonSemantics method.
    private void getEditButtonSemantics() {

    }

    /** A method to control specific GUI component actions. */
    //TODO: Implement the getClearButtonSemantics method.
    private void getClearButtonSemantics() {

    }

}
