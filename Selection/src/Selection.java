import java.util.Scanner;
public class Selection {
    static final String QUESTION1 = "Does your tree have compound leaves?";
    static final String QUESTION2 = "Does your tree have 7 or fewer leaflets?";
    static final String QUESTION3 = "Are the leaflets rounded?";
    static final String QUESTION4 = "Is the leaf 6-8 inches long?";
    static final String QUESTION5 = "Are the leaves lobed?";
    static final String QUESTION6 = "Is the bark papery?";
    static final String QUESTION7 = "Are the leaf petioles flat?";
    static final String QUESTION8 = "Are the leaves triangular?";
    static final String QUESTION9 = "Is the leaf width equal to the length?";
    static final String QUESTION10 = "Are the leaves finely toothed?";
    static final String QUESTION11 = "Is the leaf at least 3 times longer than the width?";
    static final String QUESTION12 = "Are the leaf veins thin?";
    static final String QUESTION13 = "Is the bark dark?";
    static final String QUESTION14 = "Are the leaves shiny";
    static final String QUESTION15 = "Is the leaf base even?";
    static final String ERROR = "There was an error!";
    static final int SH = 1;
    static final int BL = 2;
    static final int MA = 3;
    static final int BW = 4;
    static final int O = 5;
    static final int Bi = 6;
    static final int EC = 7;
    static final int A = 8;
    static final int BP = 9;
    static final int Ba = 10;
    static final int W = 11;
    static final int BC = 12;
    static final int HB = 13;
    static final int IW = 14;
    static final int E = 15;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String yes = "y";
        String no = "n";
        int tree = 0;
        int quest = 0;
        int done = 0;
        System.out.println("Let's see what kind of tree you have!");
        System.out.println("--------------------------------------");
        System.out.println(QUESTION1);
        String input = scan.nextLine();
        input = input.toLowerCase();
        if (input.equals("y") || input.equals("n")) {
            while (done < 2) {
                switch (quest) {
                    case 0:
                        if (input.equals("y")) {
                            tree = ++tree;
                            quest = ++quest;
                            break;
                        } else if (input.equals("n")) {
                            quest = quest + 4;
                            break;
                        } else {
                        }
                    case 1:
                        System.out.println(QUESTION2);
                        input = scan.nextLine();
                        input = input.toLowerCase();
                        if (input.equals("y")) {
                            tree = ++tree;
                            quest = ++quest;
                            if (tree == 2 && quest == 2) {
                                System.out.println("Your tree: Shagbark Hickory!");
                                done = done + 2;
                                break;
                            }
                        } else if (input.equals("n")) {
                            quest = ++quest;
                        } else {
                        }
                    case 2:
                        System.out.println(QUESTION3);
                        input = scan.nextLine();
                        input = input.toLowerCase();
                        if (input.equals("y")) {
                            tree = ++tree;
                            quest = ++quest;
                            if (tree == 2 && quest == 3) {
                                System.out.println("Your tree: Black Locust!");
                                done = done + 2;
                                break;
                            }

                        } else if (input.equals("n")) {
                            ++quest;
                        } else {
                        }
                    case 3:
                        System.out.println(QUESTION4);
                        input = scan.nextLine();
                        input = input.toLowerCase();
                        if (input.equals("y")) {
                            tree = ++tree;
                            quest = ++quest;
                            if (tree == 2 && quest == 4) {
                                System.out.println("Your tree: Mountain Ash!");
                                done = done + 2;
                                break;
                            }

                        } else if (input.equals("n")) {
                            ++quest;
                            if (tree == 1 && quest == 4) {
                                System.out.println("Your tree: Black Walnut!");
                                done = done + 2;
                                break;
                            }
                        } else {
                        }
                    case 4:
                        System.out.println(QUESTION5);
                        input = scan.nextLine();
                        input = input.toLowerCase();
                        if (input.equals("y")) {
                            tree = ++tree;
                            quest = ++quest;
                            if (tree == 1 && quest == 5) {
                                System.out.println("Your tree: Oak!");
                                done = done + 2;
                                break;
                            }

                        } else if (input.equals("n")) {
                            ++quest;
                            break;
                        } else {
                        }
                    case 5:
                        System.out.println(QUESTION6);
                        input = scan.nextLine();
                        input = input.toLowerCase();
                        if (input.equals("y")) {
                            tree = ++tree;
                            quest = ++quest;
                            if (tree == 1 && quest == 6) {
                                System.out.println("Your tree: Birch!");
                                done = done + 2;
                                break;
                            }

                        } else if (input.equals("n")) {
                            ++quest;
                            break;
                        } else {
                        }
                    case 6:
                        System.out.println(QUESTION7);
                        input = scan.nextLine();
                        input = input.toLowerCase();
                        if (input.equals("y")) {
                            tree = ++tree;
                            quest = ++quest;
                            break;
                        } else if (input.equals("n")) {
                            quest = quest + 2;
                            break;
                        } else {
                        }
                    case 7:
                        System.out.println(QUESTION8);
                        input = scan.nextLine();
                        input = input.toLowerCase();
                        if (input.equals("y")) {
                            tree = ++tree;
                            quest = ++quest;
                            if (tree == 2 && quest == 8) {
                                System.out.println("Your tree: Eastern Cottonwood!");
                                done = done + 2;
                                break;
                            }

                        } else if (input.equals("n")) {
                            quest = ++quest;
                            if (tree == 1 && quest == 8) {
                                System.out.println("Your tree: Aspen!");
                                done = done + 2;
                                break;
                            }
                        } else {
                        }
                    case 8:
                        System.out.println(QUESTION9);
                        input = scan.nextLine();
                        input = input.toLowerCase();
                        if (input.equals("y")) {
                            tree = ++tree;
                            quest = ++quest;
                            break;
                        } else if (input.equals("n")) {
                            quest = quest + 2;
                            break;
                        } else {
                        }
                    case 9:
                        System.out.println(QUESTION10);
                        input = scan.nextLine();
                        input = input.toLowerCase();
                        if (input.equals("y")) {
                            tree = ++tree;
                            quest = ++quest;
                            if (tree == 2 && quest == 10) {
                                System.out.println("Your tree: Balsam Poplar!");
                                done = done + 2;
                                break;
                            }

                        } else if (input.equals("n")) {
                            ++quest;
                            if (tree == 1 && quest == 10) {
                                System.out.println("Your tree: Basswood!");
                                done = done + 2;
                                break;
                            }
                            break;
                        } else {
                        }
                    case 10:
                        System.out.println(QUESTION11);
                        input = scan.nextLine();
                        input = input.toLowerCase();
                        if (input.equals("y")) {
                            tree = ++tree;
                            quest = ++quest;
                            if (tree == 1 && quest == 11) {
                                System.out.println("Your tree: Willow!");
                                done = done + 2;
                                break;
                            }

                        } else if (input.equals("n")) {
                            ++quest;
                            break;
                        } else {
                        }
                    case 11:
                        System.out.println(QUESTION12);
                        input = scan.nextLine();
                        input = input.toLowerCase();
                        if (input.equals("y")) {
                            tree = ++tree;
                            quest = ++quest;
                            break;

                        } else if (input.equals("n")) {
                            quest = quest + 2;
                            break;
                        } else {
                        }
                    case 12:
                        System.out.println(QUESTION13);
                        input = scan.nextLine();
                        input = input.toLowerCase();
                        if (input.equals("y")) {
                            tree = ++tree;
                            quest = ++quest;
                            if (tree == 2 && quest == 13) {
                                System.out.println("Your tree: Black Cherry!");
                                done = done + 2;
                                break;
                            }

                        } else if (input.equals("n")) {
                            quest = ++quest;
                            if (tree == 1 && quest == 13) {
                                System.out.println("Your Tree: Hackberry!");
                                done = done + 2;
                                break;
                            }
                        } else {
                        }
                    case 13:
                        System.out.println(QUESTION14);
                        input = scan.nextLine();
                        input = input.toLowerCase();
                        if (input.equals("y")) {
                            tree = ++tree;
                            quest = ++quest;
                            if (tree == 1 && quest == 14) {
                                System.out.println("Your tree: Beech!");
                                done = done + 2;
                                break;
                            }

                        } else if (input.equals("n")) {
                            ++quest;
                        } else {
                        }
                    case 14:
                        System.out.println(QUESTION15);
                        input = scan.nextLine();
                        input = input.toLowerCase();
                        if (input.equals("y")) {
                            tree = ++tree;
                            quest = ++quest;
                            if (tree == 1 && quest == 15) {
                                System.out.println("Your tree: Ironwood!");
                                done = done + 2;
                                break;
                            }

                        } else if (input.equals("n")) {
                            quest = ++quest;
                            if (quest == 15) {
                                System.out.println("Your Tree: Elm!");
                                done = done + 2;
                                break;
                            }
                        } else {
                        }
                    default:
                        System.out.println(ERROR);

                }

            }
        }else{
            System.out.println(ERROR);
        }
    }

}

