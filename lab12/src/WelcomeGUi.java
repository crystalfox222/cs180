import javax.swing.JOptionPane;
public class WelcomeGUi {
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Welcome to Lab 13!", "Welcome",
                JOptionPane.INFORMATION_MESSAGE);
        String favoriteFood = JOptionPane.showInputDialog(null, "What is your favorite food?",
                "Food", JOptionPane.QUESTION_MESSAGE);
        int reply = JOptionPane.showConfirmDialog(null, "Would you like to exit?",
                "Exit", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION){
            return;
        } else {
            JOptionPane.showMessageDialog(null, "Sorry! Theres no more panels.",
                    "Exit", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
