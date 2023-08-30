import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class SearchEngine {
    public static void main(String[] args) throws IOException, UnsupportedRosterException {
        Scanner scan = new Scanner(System.in);
        String fileInput = scan.nextLine();
        String fileOutput = scan.nextLine();
        PlayerList playing = readFile(fileInput);
        ArrayList<Player> found = findPlayer(playing);
        writeFile(found, fileOutput);
    }

    public static PlayerList readFile(String fileName) throws FileNotFoundException,
            IOException, UnsupportedRosterException {
        File newFile = new File(fileName);
        BufferedReader bread = new BufferedReader(new FileReader(newFile));
        if (!newFile.exists()) {
            throw new FileNotFoundException();
        }
        bread = new BufferedReader(new FileReader(newFile));

        ArrayList playlist = new ArrayList();
        PlayerList list = new PlayerList(playlist);
        String read = bread.readLine(); //StackOverflow
        Player player = null;
        while (read != null) { //ckOverflow
            String[] values = read.split(" ", 10);
            String[] skillz;
            ArrayList<String> skills = new ArrayList<String>();
            if (values.length >= 10) {
                skillz = values[9].split(",");
                for (String text : skillz) { //tutorials point
                    skills.add(text);
                }
                System.out.println();
            }

            String firstName = values[0];
            String lastName = values[1];
            String position = values[2];
            int shooting = Integer.parseInt(values[3]);

            int passing = Integer.parseInt(values[4]);

            int layup = Integer.parseInt(values[5]);

            int athletics = Integer.parseInt(values[6]);

            int defense = Integer.parseInt(values[7]);

            int rebound = Integer.parseInt(values[8]);

            player = new Player(firstName, lastName, position, shooting,
                    passing, layup, athletics, defense, rebound, skills);

            list.addPlayer(player);
            read = bread.readLine();
        }
        bread.close();

        return list;
    }

    public static void writeFile(ArrayList<Player> startup, String output) throws IOException {
        PlayerList players = new PlayerList(startup);
        File f = new File(output);
        FileOutputStream fos;
        PrintWriter pw = null;
        if (!f.exists()) {
            f.createNewFile();
            fos = new FileOutputStream(f);
            pw = new PrintWriter(fos);
        } else {
            fos = new FileOutputStream(f, false);
            pw = new PrintWriter(fos);
        }
        int a;
        for (a = 0; a < startup.size(); a++) {
            startup.get(a);


            pw.println(startup.get(a).getFirstName() + " " + startup.get(a).getLastName()
                    + " " + startup.get(a).getPosition() + " " + startup.get(a).getTotalAttribute());
        }
        pw.close();

    }

    public static ArrayList<Player> findPlayer(PlayerList list) throws UnsupportedRosterException {

        Player pg = list.findPG();

        Player sg = list.findSG();

        Player sf = list.findSF();

        Player pf = list.findPF();

        Player c = list.findC();

        ArrayList<Player> roster = new ArrayList();
        roster.add(pg);
        roster.add(sg);
        roster.add(sf);
        roster.add(pf);
        roster.add(c);
        return roster;
    }

}

