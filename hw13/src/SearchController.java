import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Optional;

/**
 * SearchController
 * <p>
 * I used Piazza and the javadocs for functions I didn't understand and the Type optional
 * I used Piazza to find out that I needed to appened the tweets id rather than the tweets address in getOutputString
 *
 * @author Edythe Thompson, L09
 * @version 4-27-2020
 */
public class SearchController {

    private TwitterModel twitterModel;
    private SearchTweet searchTweet;

    /**
     * Implement the SearchController constructor per the instructions in the handout
     *
     * @param twitterModel TwitterModel object connecting the model and controller portions of the MVC paradigm.
     * @param searchTweet  SearchTweet object connecting the view and controller portions of the MVC paradigm.
     */
    public SearchController(TwitterModel twitterModel, SearchTweet searchTweet) throws IllegalArgumentException {
        this.twitterModel = twitterModel;
        this.searchTweet = searchTweet;
        JButton search = searchTweet.getSearchButton();
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getSearchButtonSemantics();
            }
        });
    }

    /**
     * Gets the output {@code String} for the specified product list.
     *
     * @param tweetList the product list to be converted to an output {@code String}
     * @return the output {@code String} for the specified product list
     */
    private String getOutputString(List<? extends Tweet> tweetList) {
        StringBuilder stringBuilder = new StringBuilder();
        String outString;

        for (Tweet aTweet : tweetList) {
            stringBuilder.append(aTweet.getID()).append("\n\n");
        }
        outString = stringBuilder.toString();

        if (outString.length() > 0) {
            outString = stringBuilder.substring(0, stringBuilder.length() - 2);
        }
        return outString;
    }

    /**
     * Searches our TweetList for a given phrase, returning a List containing all Tweets that apply
     *
     * @param body String of text being searched for
     * @return list of applicable Tweets.
     */
    private List searchForString(String body) {
        List<Tweet> list = this.twitterModel.searchByText(body);
        return list;
    }

    /**
     * A method to control specific GUI component actions.
     */
    private void getSearchButtonSemantics() {
        String body = searchTweet.getSearchTermTextField().getText();
        if (searchTweet.getSearchTermTextField().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter a phrase.", "Search",
                    JOptionPane.INFORMATION_MESSAGE);
        } else if (!twitterModel.searchByText(body).isEmpty()) {
            List list = searchForString(body);
            String items = getOutputString(list);
            searchTweet.getidTextArea().setText(items);
        } else {
            searchTweet.getidTextArea().setText("No tweets found.");
        }

    }


}
