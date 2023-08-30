import java.io.*;
import java.util.ArrayList;

import static java.lang.System.exit;

public class Stats {

    private MysteryIncMember fred;
    private MysteryIncMember velma;
    private MysteryIncMember daphne;
    private MysteryIncMember shaggy;
    private MysteryIncMember scooby_doo;

    public Stats() {
        fred = new MysteryIncMember("Fred");
        velma = new MysteryIncMember("Velma");
        daphne = new MysteryIncMember("Daphne");
        shaggy = new MysteryIncMember("Shaggy");
        scooby_doo = new MysteryIncMember("Scooby-Doo");
    }

    public void readFile(File caseFile) throws IOException {
        try {
            BufferedReader buff = new BufferedReader(new FileReader(caseFile));
            String read = buff.readLine();
            int score_Fred = 0;
            int score_Daphne = 0;
            int score_Velma = 0;
            int score_Shaggy = 0;
            int score_ScoobyDoo = 0;
            while (read != null) {
                String[] values = read.split(",");
                int check = 0;
                MysteryIncMember star = new MysteryIncMember();
                String caseTitle = "";
                String originator = "";
                try {
                    if (values.length > 8) {
                        throw new IOException("Corrupted file!");
                    }
                    for (int i = 2; i < 7; i++) {
                        for (int j = 0; j < values[i].length(); j++) {
                            char currentChar = values[i].charAt(j);
                            if ((currentChar >= 'a' && currentChar <= 'z')) {
                                System.out.println("Corrupted line!");
                                check = 1;
                            } else if (currentChar >= 'A' && currentChar <= 'Z') {
                                System.out.println("Corrupted line!");
                                check = 1;
                            } else {
                                continue;
                            }
                        }
                    }
                } catch (IndexOutOfBoundsException e) {
                    throw new IOException("Corrupted file!");
                }
                if (check == 0) {
                    try {
                        caseTitle = values[0];
                        originator = values[1];
                        score_Fred = Integer.parseInt(values[2]);
                        score_Daphne = Integer.parseInt(values[3]);
                        score_Velma = Integer.parseInt(values[4]);
                        score_Shaggy = Integer.parseInt(values[5]);
                        score_ScoobyDoo = Integer.parseInt(values[6]);
                        star = new MysteryIncMember(values[7]);
                    } catch (IndexOutOfBoundsException e) {
                        throw new IOException("Corrupted file!");
                    }

                    fred.addAwesomeValue(score_Fred);
                    daphne.addAwesomeValue(score_Daphne);
                    velma.addAwesomeValue(score_Velma);
                    shaggy.addAwesomeValue(score_Shaggy);
                    scooby_doo.addAwesomeValue(score_ScoobyDoo);

                    Case case1 = new Case(caseTitle, originator);
                    if (star.getName().equals("Velma")) {
                        velma.addStarredCase(case1);
                    } else if (star.getName().equals("Shaggy")) {
                        shaggy.addStarredCase(case1);
                    } else if (star.getName().equals("Daphne")) {
                        daphne.addStarredCase(case1);
                    } else if (star.getName().equals("Fred")) {
                        fred.addStarredCase(case1);
                    } else if (star.getName().equals("Scooby-Doo")) {
                        scooby_doo.addStarredCase(case1);
                    }
                }

                read = buff.readLine();
            }
            buff.close();
        } catch (IndexOutOfBoundsException e){
            throw new IOException("Corrupted file!");
        }
    }

    public void writeAwesomeness(File out) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(out);
        ArrayList<MysteryIncMember> list = new ArrayList<>();
        list.add(fred);
        list.add(velma);
        list.add(daphne);
        list.add(shaggy);
        list.add(scooby_doo);
        while (list.size() > 0) {
            int max = 0;
            int i = 0;
            int b = 0;
            for (i = 0; i < list.size(); i++) {
                if (max < list.get(i).getTotalAwesomeness()) {
                    b = i;
                    max = list.get(i).getTotalAwesomeness();
                }
            }
            String name = list.get(b).getName();
            int total = list.get(b).getTotalAwesomeness();
            pw.println(name + ": " + total);
            list.remove(b);

        }
        pw.close();

    }

    public void printTeamLeader() {
        ArrayList<MysteryIncMember> list = new ArrayList<>();
        list.add(fred);
        list.add(velma);
        list.add(daphne);
        list.add(shaggy);
        list.add(scooby_doo);
        int max = 0;
        int i = 0;
        for (i = 0; i < list.size(); i++) {
            if (max < list.get(i).getTotalAwesomeness()) {
                max = list.get(i).getTotalAwesomeness();
            }
        }
        System.out.println("The Team Leader is: " + list.get(i).getName());


    }

    public MysteryIncMember getFred() {
        return fred;
    }

    public MysteryIncMember getVelma() {
        return velma;
    }

    public MysteryIncMember getDaphne() {
        return daphne;
    }

    public MysteryIncMember getScooby_doo() {
        return scooby_doo;
    }

    public MysteryIncMember getShaggy() {
        return shaggy;
    }
}
