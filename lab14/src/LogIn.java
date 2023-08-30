import javax.swing.*;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.*;

public class LogIn {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("GUI Walkthrough");

        JPanel panel = new JPanel(new GridBagLayout());

        GridBagConstraints constr = new GridBagConstraints();

        constr.gridx = 0;
        constr.gridy = 0;

        JLabel userNameLabel = new JLabel("Enter your username :");
        panel.add(userNameLabel, constr);

        JTextField userNameTxt = new JTextField(20);
        constr.gridx = 1;
        panel.add(userNameTxt, constr);

        JLabel pwdLabel = new JLabel(("Enter your password :"));
        JPasswordField pwdTxt = new JPasswordField(20);
        constr.gridx = 0;
        constr.gridy = 1;
        panel.add(pwdLabel, constr);
        constr.gridx = 1;
        panel.add(pwdTxt, constr);

        JButton button = new JButton("Sign In");
        constr.gridy=4;
        panel.add(button, constr);

        frame.add(panel);
        frame.setSize(500,400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);



    }
}
