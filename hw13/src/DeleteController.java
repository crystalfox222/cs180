import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Optional;

/**
 * DeleteController
 * <p>
 * I used the javadocs to understand the methods for Optional
 *
 * @author Edythe Thompson, L09
 * @version 4-27-2020
 */
public final class DeleteController {

    private TwitterModel twitterModel;
    private DeleteTweet deleteTweet;

    /**
     * Implement the DeleteController constructor per the instructions in the handout
     *
     * @param twitterModel TwitterModel object connecting the model and controller portions of the MVC paradigm.
     * @param deleteTweet  DeleteTweet object connecting the view and controller portions of the MVC paradigm.
     */
    public DeleteController(TwitterModel twitterModel, DeleteTweet deleteTweet) throws IllegalArgumentException {
        this.twitterModel = twitterModel;
        this.deleteTweet = deleteTweet;
        JButton delete = deleteTweet.getDeleteButton();
        JButton clear = deleteTweet.getClearButton();
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getDeleteButtonSemantics();
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
     * A method to control specific GUI component actions.
     */
    private void getDeleteButtonSemantics() {
        if (twitterModel.searchByID(deleteTweet.getidTextField().getText()).isPresent()) {
            Tweet tweet = twitterModel.searchByID(deleteTweet.getidTextField().getText()).get();
            twitterModel.remove(tweet);
            JOptionPane.showMessageDialog(null, "Success!", "Delete",
                    JOptionPane.INFORMATION_MESSAGE);
            getClearButtonSemantics();
        } else {
            JOptionPane.showMessageDialog(null, "A tweet with the given ID does not exist.",
                    "Delete", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    /**
     * A method to control specific GUI component actions.
     */
    private void getClearButtonSemantics() {
        deleteTweet.getidTextField().setText("");
    }
}
