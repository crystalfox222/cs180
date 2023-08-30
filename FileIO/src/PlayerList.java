import java.util.ArrayList;
public class PlayerList {
    private ArrayList<Player> players = new ArrayList<Player>();

    public PlayerList(ArrayList<Player> players){
        this.players = players;
    }

    public void addPlayer(Player newPlayer){
    this.players.add(newPlayer);
    }
    public Player findPG() throws UnsupportedRosterException{
        int a = 0;
        int max = players.get(a).getDefense();
        for(a = 0; a < this.players.size(); a++){
            if (players.get(a).getShooting() + players.get(a).getPassing() + players.get(a).getLayup() > 280 && players.get(a).getSkills().contains("Point Phenom") && max < players.get(a).getDefense()){
                if (max < players.get(a).getDefense()){
                    max = players.get(a).getDefense();
                }
                players.get(a);
            }
        }
        Player PG = players.get(a);
        return PG;
    }
    public Player findSG() throws UnsupportedRosterException{
        int a = 0;
        int max = players.get(a).getDefense() + players.get(a).getShooting() + players.get(a).getPassing() + players.get(a).getLayup() + players.get(a).getLayup();
        for(a = 0; a < this.players.size(); a++){
            if (players.get(a).getSkills().contains("GOAT")||max < players.get(a).getDefense() + players.get(a).getShooting() + players.get(a).getPassing() + players.get(a).getLayup() + players.get(a).getLayup() ){
                max = players.get(a).getDefense() + players.get(a).getShooting() + players.get(a).getPassing() + players.get(a).getLayup() + players.get(a).getLayup();
                players.get(a);
            }

        }
        Player GOAT = players.get(a);
        return GOAT;
    }
    public Player findSF() throws UnsupportedRosterException{
        int a = 0;
        int max = players.get(a).getTotalAttribute();
        for(a = 0; a < this.players.size(); a++){
            if (players.get(a).getSkills().contains("The King")||players.get(a).getSkills().contains("Floor General")||max < players.get(a).getTotalAttribute()){
                max = players.get(a).getTotalAttribute();
                players.get(a);
            }
        }
        Player SF = players.get(a);
        return SF;
    }
    public Player findPF() throws UnsupportedRosterException{
        int a = 0;
        int max = players.get(a).getDefense() + players.get(a).getRebound() + players.get(a).getAthletics();
        for(a = 0; a < this.players.size(); a++){
            if (players.get(a).getShooting() > 80 && players.get(a).getLayup() > 95 && max < players.get(a).getDefense() + players.get(a).getRebound() + players.get(a).getAthletics()){
                max = players.get(a).getDefense() + players.get(a).getRebound() + players.get(a).getAthletics();
                players.get(a);
            }
        }
        Player PF = players.get(a);
        return PF;
    }
    public Player findC() throws UnsupportedRosterException{
        int a = 0;
        int max = players.get(a).getDefense() + players.get(a).getShooting() + players.get(a).getRebound() + players.get(a).getAthletics() + players.get(a).getLayup();
        for(a = 0; a < this.players.size(); a++){
            if (players.get(a).getSkills().contains("Paint Dominator")&& max < players.get(a).getDefense() + players.get(a).getShooting() + players.get(a).getRebound() + players.get(a).getAthletics() + players.get(a).getLayup()){
                max = players.get(a).getDefense() + players.get(a).getShooting() + players.get(a).getRebound() + players.get(a).getAthletics() + players.get(a).getLayup();
                players.get(a);
            }
        }
        Player C = players.get(a);
        return C;
    }
    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }
}
