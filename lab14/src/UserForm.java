import javax.swing.*;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.*;

public class UserForm {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("User Form");

        JPanel panel = new JPanel(new GridBagLayout());

        GridBagConstraints constr = new GridBagConstraints();

        constr.gridx = 0;
        constr.gridy = 0;

        JLabel nameLabel = new JLabel("Name");
        panel.add(nameLabel, constr);
        JTextField nameTxt = new JTextField(20);
        constr.gridx = 1;
        panel.add(nameTxt, constr);
        JLabel nameHidden = new JLabel(nameTxt.getText());
        panel.add(nameHidden, constr);

        JLabel emlLabel = new JLabel(("Email"));
        JTextField emlTxt = new JTextField(20);
        constr.gridx = 0;
        constr.gridy = 1;
        panel.add(emlLabel, constr);
        constr.gridx = 1;
        panel.add(emlTxt, constr);
        JLabel emlHidden = new JLabel(emlTxt.getText());
        panel.add(emlHidden, constr);

        JLabel phnLabel = new JLabel(("Phone"));
        JTextField phnTxt = new JTextField(20);
        constr.gridx = 0;
        constr.gridy = 2;
        panel.add(phnLabel, constr);
        constr.gridx = 1;
        panel.add(phnTxt, constr);
        JLabel phnHidden = new JLabel(phnTxt.getText());
        panel.add(phnHidden, constr);

        JButton editButton = new JButton("Edit");
        constr.gridx = 0;
        constr.gridy = 4;
        panel.add(editButton, constr);
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nameTxt.setVisible(true);
                emlTxt.setVisible(true);
                phnTxt.setVisible(true);
                nameHidden.setVisible(false);
                emlHidden.setVisible(false);
                phnHidden.setVisible(false);
            }
        });

        JButton saveButton = new JButton("Save");
        constr.gridx = 1;
        constr.gridy = 4;
        panel.add(saveButton, constr);
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nameHidden.setText(nameTxt.getText());
                emlHidden.setText(emlTxt.getText());
                phnHidden.setText(phnTxt.getText());
                nameTxt.setVisible(false);
                emlTxt.setVisible(false);
                phnTxt.setVisible(false);
                nameHidden.setVisible(true);
                emlHidden.setVisible(true);
                phnHidden.setVisible(true);

            }
        });

        frame.add(panel);
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);


    }
}
