import java.util.ArrayList;

public class PlayerList {
    private ArrayList<Player> players = new ArrayList<Player>();

    public PlayerList(ArrayList<Player> players) {
        this.players = players;
    }

    public void addPlayer(Player newPlayer) {
        this.players.add(newPlayer);
    }

    public Player findPG() throws UnsupportedRosterException {
        int a = 0;
        int max = 0;
        Player pG = null;
        for (a = 0; a < this.players.size(); a++) {
            if (players.get(a).getSkills() == null) {
                continue;
            }
            if (players.get(a).getPosition().equals("PG") &&
                    (players.get(a).getShooting() + players.get(a).getPassing() + players.get(a).getLayup()) > 280 &&
                    players.get(a).getSkills().contains("Point Phenom") && max < players.get(a).getDefense()) {
                max = players.get(a).getDefense();
                pG = players.get(a);
                players.get(a);
            }

        }

        if (pG == null) {

            for (a = 0; a < this.players.size(); a++) {
                if (players.get(a).getPosition().equals("PG")) {
                    pG = players.get(a);
                    break;
                }
            }
            if (pG == null) {
                throw new UnsupportedRosterException("nah");
            }
        }

        return pG;
    }

    public Player findSG() throws UnsupportedRosterException {
        int a = 0;
        int max = 0;
        Player gOAT = null;
        for (a = 0; a < this.players.size(); a++) {
            if (players.get(a).getSkills() == null) {
                continue;
            }
            if (players.get(a).getPosition().equals("SG") && players.get(a).getSkills().contains("GOAT")) {
                gOAT = players.get(a);
            } else if (players.get(a).getPosition().equals("SG") && (max < players.get(a).getDefense() + players.get(a).getShooting() +
                    players.get(a).getPassing() + players.get(a).getLayup() + players.get(a).getAthletics())) {
                max = players.get(a).getDefense() + players.get(a).getShooting()
                        + players.get(a).getPassing() + players.get(a).getLayup() + players.get(a).getAthletics();
                gOAT = players.get(a);
            }

        }
        if (gOAT == null) {
            for (a = 0; a < this.players.size(); a++) {
                if (players.get(a).getPosition().equals("SG")) {
                    gOAT = players.get(a);
                    break;
                }
            }
            if (gOAT == null) {
                throw new UnsupportedRosterException("nah");
            }
        }
        return gOAT;
    }

    public Player findSF() throws UnsupportedRosterException {
        int a = 0;
        int max = 0;
        Player sF = null;
        for (a = 0; a < this.players.size(); a++) {
            if (players.get(a).getSkills() == null) {
                continue;
            }
            if ((players.get(a).getPosition().equals("SF") && ((players.get(a).getSkills().contains("The King")
                    || players.get(a).getSkills().contains("Floor General"))))
                    && (max < players.get(a).getTotalAttribute())) {
                max = players.get(a).getTotalAttribute();
                sF = players.get(a);
            }
        }
        if (sF == null) {
            for (a = 0; a < this.players.size(); a++) {
                if (players.get(a).getPosition().equals("SF")) {
                    sF = players.get(a);
                    break;
                }
            }
            if (sF == null) {
                throw new UnsupportedRosterException("nah");
            }
        }
        return sF;
    }

    public Player findPF() throws UnsupportedRosterException {
        int a = 0;
        int max = 0;
        Player pF = null;
        for (a = 0; a < this.players.size(); a++) {
            if ((players.get(a).getPosition().equals("PF") && (players.get(a).getShooting() > 80
                    && players.get(a).getLayup() > 95)) && (max < (players.get(a).getDefense()
                    + players.get(a).getRebound() + players.get(a).getAthletics()))) {
                max = players.get(a).getDefense() + players.get(a).getRebound() + players.get(a).getAthletics();
                pF = players.get(a);
            }
        }
        if (pF == null) {
            for (a = 0; a < this.players.size(); a++) {
                if (players.get(a).getPosition().equals("PF")) {
                    pF = players.get(a);
                    break;
                }
            }
            if (pF == null) {
                throw new UnsupportedRosterException("nah");
            }
        }
        return pF;
    }

    public Player findC() throws UnsupportedRosterException {
        int a = 0;
        int max = 0;
        Player c = null;
        for (a = 0; a < this.players.size(); a++) {
            if (players.get(a).getSkills() == null) {
                if (players.get(a).getPosition().equals("C") && max < players.get(a).getDefense()
                        + players.get(a).getShooting() + players.get(a).getRebound()
                        + players.get(a).getAthletics() + players.get(a).getLayup()) {
                    max = players.get(a).getDefense() + players.get(a).getShooting()
                            + players.get(a).getRebound() + players.get(a).getAthletics() + players.get(a).getLayup();
                    c = players.get(a);
                }
            } else {
                if (players.get(a).getPosition().equals("C") &&
                        players.get(a).getSkills().contains("Paint Dominator") &&
                        max < players.get(a).getDefense() + players.get(a).getShooting()
                                + players.get(a).getRebound() + players.get(a).getAthletics()
                                + players.get(a).getLayup()) {
                    max = players.get(a).getDefense() + players.get(a).getShooting()
                            + players.get(a).getRebound() + players.get(a).getAthletics()
                            + players.get(a).getLayup();
                    c = players.get(a);
                }
            }
        }
        if (c == null) {
            for (a = 0; a < this.players.size(); a++) {
                if (players.get(a).getPosition().equals("C")) {
                    c = players.get(a);
                    break;
                }
            }
            if (c == null) {
                throw new UnsupportedRosterException("nah");
            }
        }
        return c;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }
}
