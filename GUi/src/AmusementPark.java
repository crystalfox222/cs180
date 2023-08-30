import javax.swing.*;

/**
 * AmusementPark
 * <p>
 * This program allows the user to purchase tickets to theme parks using menus
 * <p>
 *
 * @author Edythe Thompson, L09
 * @version 4-20-2020
 */
public class AmusementPark {
    public static void main(String[] args) {

        while (true) {
            double total = 0;
            String ticketSelection = "";
            int parkType = 0;
            int check = 0;
            int tickets = 0;
            double adult = 0;
            double child = 0;
            double student = 0;
            double senior = 0;
            int truth = 0;
            UIManager.put("OptionPane.okButtonText", "Continue"); // found on Piazza
            JOptionPane.showMessageDialog(null, "Welcome", "Welcome",
                    JOptionPane.INFORMATION_MESSAGE);
            String[] firstChoice = {"Walt Disney World", "Universal Studios", "Beto Carrero World", "Cedar Point"};
            String[] mainMenu = {"Add New Ticket", "Check Order", "Checkout"};
            String[] ticketType = {"Single-Park", "Multi-Park"};
            String[] ticketClass = {"Adult", "Child", "Student", "Senior"};
            UIManager.put("OptionPane.okButtonText", "Continue"); // found on Piazza
            Object userPick = JOptionPane.showInputDialog(null,
                    "Which park would you like to visit?",
                    "Parks", JOptionPane.QUESTION_MESSAGE, null, firstChoice, firstChoice[0]);
            if (userPick.equals(firstChoice[0])) {
                child = 60;
                student = 95;
                adult = 130;
                senior = 95;
            } else if (userPick.equals(firstChoice[1])) {
                child = 35;
                student = 110;
                adult = 110;
                senior = 80;

            } else if (userPick.equals(firstChoice[2])) {
                child = 70;
                student = 100;
                adult = 115;
                senior = 70;
            } else if (userPick.equals(firstChoice[3])) {
                child = 20;
                student = 40;
                adult = 60;
                senior = 30;
            } else {
                return;
            }
            while (truth == 0) {
                UIManager.put("OptionPane.okButtonText", "Continue"); // found on Piazza
                Object menu = JOptionPane.showInputDialog(null, "Please make a selection.",
                        "Main Menu", JOptionPane.QUESTION_MESSAGE, null, mainMenu, mainMenu[0]);
                if (menu.equals(mainMenu[0])) {
                    check = 1;
                } else if (menu.equals(mainMenu[1])) {
                    check = 2;
                } else if (menu.equals(mainMenu[2])) {
                    check = 3;
                } else {
                    return;
                }

                if (check == 1) {
                    UIManager.put("OptionPane.okButtonText", "Continue"); // found on Piazza
                    Object type = JOptionPane.showInputDialog(null,
                            "Please select ticket type.",
                            "Ticket Type", JOptionPane.QUESTION_MESSAGE, null, ticketType, ticketType[0]);
                    if (type == null) { //cancel handling found on StackOverflow
                        continue;
                    }
                    if (type.equals(ticketType[0])) {
                        parkType = 1;
                    } else if (type.equals(ticketType[1])) {
                        parkType = 2;
                    } else {

                    }
                }
                if (check == 1) {
                    UIManager.put("OptionPane.okButtonText", "Continue"); // found on Piazza
                    Object clases = JOptionPane.showInputDialog(null,
                            "Please select ticket class.",
                            "Ticket Class", JOptionPane.QUESTION_MESSAGE, null, ticketClass,
                            ticketClass[0]);
                    if (clases == null) { //cancel handling found on StackOverflow
                        continue;
                    }
                    if (clases.equals(ticketClass[0])) {
                        if (parkType == 2) {
                            adult = adult * 1.3;
                            total = total + adult;
                            ticketSelection = ticketSelection + "Adult/Multi-Park: $" +
                                    String.format("%.2f", adult) + "\n";
                            ++tickets;
                        } else {
                            total = total + adult;
                            ticketSelection = ticketSelection + "Adult/Single-Park: $" +
                                    String.format("%.2f", adult) + "\n";
                            ++tickets;
                        }
                    } else if (clases.equals(ticketClass[1])) {
                        if (parkType == 2) {
                            child = child * 1.3;
                            total = total + child;
                            ticketSelection = ticketSelection + "Child/Multi-Park: $" +
                                    String.format("%.2f", child) + "\n";
                            ++tickets;
                        } else {
                            total = total + child;
                            ticketSelection = ticketSelection + "Child/Single-Park: $" +
                                    String.format("%.2f", child) + "\n";
                            ++tickets;
                        }
                    } else if (clases.equals(ticketClass[2])) {
                        if (parkType == 2) {
                            student = student * 1.3;
                            total = total + student;
                            ticketSelection = ticketSelection + "Student/Multi-Park: $" +
                                    String.format("%.2f", student) + "\n";
                            ++tickets;
                        }
                        total = total + student;
                        ticketSelection = ticketSelection + "Student/Single-Park: $" +
                                String.format("%.2f", student) + "\n";
                        ++tickets;
                    } else if (clases.equals(ticketClass[3])) {
                        if (parkType == 2) {
                            senior = senior * 1.3;
                            total = total + senior;
                            ticketSelection = ticketSelection + "Senior/Multi-Park: $" +
                                    String.format("%.2f", senior) + "\n";
                            ++tickets;
                        }
                        total = total + senior;
                        ticketSelection = ticketSelection + "Senior/Single-Park: $" +
                                String.format("%.2f", senior) + "\n";
                        ++tickets;
                    }
                }

                if (check == 2) {
                    if (tickets == 0) {
                        UIManager.put("OptionPane.okButtonText", "Continue"); // found on Piazza
                        JOptionPane.showMessageDialog(null, "No Tickets",
                                "Check Order", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, ticketSelection, "Check Order",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                if (check == 3) {
                    if (tickets == 0) {
                        int error = JOptionPane.showConfirmDialog(null,
                                "Warning: No tickets" + "\n" + "Would you like to exit?", "Warning",
                                JOptionPane.YES_NO_OPTION);
                        if (error == JOptionPane.YES_OPTION) {
                            return;
                        }
                    } else {
                        double tax = total * .07;
                        total = total + tax;
                        UIManager.put("OptionPane.okButtonText", "Continue"); // found on Piazza
                        int buy = JOptionPane.showConfirmDialog(null, "Total: $"
                                        + String.format("%.2f", total) + "\n" + "Would you like to checkout?",
                                "Checkout", JOptionPane.YES_NO_OPTION);
                        if (buy == JOptionPane.YES_OPTION) {
                            UIManager.put("OptionPane.okButtonText", "Exit"); // found on Piazza
                            JOptionPane.showMessageDialog(null, "Order Complete",
                                    "Order Complete", JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }
                    }
                }
            }

        }


    }
}
