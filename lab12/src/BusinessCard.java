import javax.swing.*;

public class BusinessCard {
    public static void main(String[] args) {
        int reply = JOptionPane.showConfirmDialog(null,
                "Would you like to generate a business card?", "Business Card Generator", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.NO_OPTION) {
            return;
        }
        while (true) {
            String name = JOptionPane.showInputDialog(null, "What is your name?",
                    "Business Card Generator", JOptionPane.QUESTION_MESSAGE);
            String age = JOptionPane.showInputDialog(null, "What is your age?",
                    "Business Card Genoratoe", JOptionPane.QUESTION_MESSAGE);
            String gPA = JOptionPane.showInputDialog(null, "What is your GPA?",
                    "Business Card Generator", JOptionPane.QUESTION_MESSAGE);
            String major = JOptionPane.showInputDialog(null, "What is your major?",
                    "Business Card Generator", JOptionPane.QUESTION_MESSAGE);
            String email = JOptionPane.showInputDialog(null, "What is your email?",
                    "Business Card Generator", JOptionPane.QUESTION_MESSAGE);
            String message = "Name: " + name + "\n" +
                    "Age: " + age + "\n" + "GPA: " + gPA + "\n" + "Major: " + major + "\n" + "Email: " + email;
            JOptionPane.showMessageDialog(null, message,
                    "Here is your business card!", JOptionPane.INFORMATION_MESSAGE);
            int replay = JOptionPane.showConfirmDialog(null,
                    "Would you like to generate another business card?", "Business Card", JOptionPane.YES_NO_OPTION);
            if (replay == JOptionPane.NO_OPTION){
                return;
            }
        }
    }
}

