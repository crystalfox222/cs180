import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * AddController
 * <p>
 * Javadocs for the methods for optional and Piazza to move the focus cursor
 *
 * @author Edythe Thompson, L09
 * @version 4-27-2020
 */
public final class AddController {

    private TwitterModel twitterModel;
    private AddTweet addTweet;

    /**
     * Implement the AddController constructor per the instructions in the handout
     *
     * @param twitterModel TwitterModel object connecting the model and controller portions of the MVC paradigm.
     * @param addTweet     AddTweet object connecting the view and controller portions of the MVC paradigm.
     */
    public AddController(TwitterModel twitterModel, AddTweet addTweet) throws IllegalArgumentException {
        this.twitterModel = twitterModel;
        this.addTweet = addTweet;
        JButton add = addTweet.getTweetButton();
        JButton clear = addTweet.getClearButton();
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getAddButtonSemantics();
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
     * A method used to verify if a given string is strictly containing numeric values.
     *
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
            for (char c : aString.toCharArray()) {
                if (Character.isDigit(c)) {
                    counter++;
                }
            }

            return counter == aString.length();

        }
    }

    /**
     * A method to control specific GUI component actions.
     */
    private void getAddButtonSemantics() {
        int id = 0;
        String tweet = addTweet.getBodyTextField().getText();
        String stringID = addTweet.getidTextField().getText();
        if (!isNumeric(stringID)) {
            addTweet.getBodyTextField().requestFocus();
            JOptionPane.showMessageDialog(null, "Error: ID must be numeric", "Error",
                    JOptionPane.INFORMATION_MESSAGE);
        } else if (Integer.parseInt(addTweet.getidTextField().getText()) < 0) {
            JOptionPane.showMessageDialog(null, "Error", "Error: ID must be positive",
                    JOptionPane.INFORMATION_MESSAGE);
            addTweet.getBodyTextField().requestFocus();
        } else if (twitterModel.searchByID(stringID).isPresent()) {
            JOptionPane.showMessageDialog(null, "This ID is taken. Please enter a new id.",
                    "Taken ID", JOptionPane.INFORMATION_MESSAGE);
            addTweet.getBodyTextField().requestFocus();

        } else {
            id = Integer.parseInt(addTweet.getidTextField().getText());
            Tweet newTweet = new Tweet(stringID, tweet);
            if (twitterModel.add(newTweet)) {
                JOptionPane.showMessageDialog(null, "Success!", "Success",
                        JOptionPane.INFORMATION_MESSAGE);
                getClearButtonSemantics();
            }
        }


    }

    /**
     * A method to control specific GUI component actions.
     */
    public void getClearButtonSemantics() {
        addTweet.getidTextField().setText("");
        addTweet.getBodyTextField().setText("");
    }
}
