import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Optional;

/**
 * EditController
 * <p>
 * I used Piazza and the javadocs for the type Optional
 *
 * @author Edythe Thompson, L09
 * @version 4-27-2020
 */
public final class EditController {

    private TwitterModel twitterModel;
    private EditTweet editTweet;

    /**
     * Implement the AddController constructor per the instructions in the handout
     *
     * @param twitterModel TwitterModel object connecting the model and controller portions of the MVC paradigm.
     * @param editTweet    EditTweet object connecting the view and controller portions of the MVC paradigm.
     */
    public EditController(TwitterModel twitterModel, EditTweet editTweet) throws IllegalArgumentException {
        this.twitterModel = twitterModel;
        this.editTweet = editTweet;
        JButton edit = editTweet.getEditButton();
        JButton clear = editTweet.getClearButton();
        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getEditButtonSemantics();
            }
        });
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getClearButtonSemantics();
            }
        });
    }

    /**
     * A method used to update a specific Tweet's body string.
     *
     * @param aTweet Tweet object containing an ID and body String
     * @param body   String
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

    /**
     * A method to control specific GUI component actions.
     */
    private void getEditButtonSemantics() {
        String id = editTweet.getidTextField().getText();
        if (!twitterModel.searchByID(id).isPresent()) {
            JOptionPane.showMessageDialog(null, "This tweet does not exist. Try another id!",
                    "Null", JOptionPane.INFORMATION_MESSAGE);
        } else if (twitterModel.searchByID(id).isPresent()) {
            Tweet tweet = twitterModel.searchByID(id).get();
            String body = editTweet.getBodyTextField().getText();
            updateBody(tweet, body);
            getClearButtonSemantics();
        }


    }

    /**
     * A method to control specific GUI component actions.
     */
    private void getClearButtonSemantics() {
        editTweet.getidTextField().setText("");
        editTweet.getBodyTextField().setText("");
    }

}
