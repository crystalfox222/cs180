import java.util.ArrayList;

public class Player {
    private String firstName;
    private String lastName;
    private String position;
    private int shooting;
    private int passing;
    private int layup;
    private int athletics;
    private int defense;
    private int rebound;
    private ArrayList<String> skills = new ArrayList<String>();
    private int totalAttribute;

    public Player(String fn, String ln, String pos, int shoot, int pass, int lay,
                  int athl, int def, int reb, ArrayList<String> skill) throws UnsupportedRosterException {
        this.firstName = fn;
        this.lastName = ln;
        this.position = pos;
        if (shoot < 0 || shoot > 100) {
            throw new UnsupportedRosterException("out bound");
        }
        this.shooting = shoot;
        if (pass < 0 || pass > 100) {
            throw new UnsupportedRosterException("out bound");
        }
        this.passing = pass;
        if (lay < 0 || lay > 100) {
            throw new UnsupportedRosterException("out bound");
        }
        this.layup = lay;
        if (athl < 0 || athl > 100) {
            throw new UnsupportedRosterException("out bound");
        }
        this.athletics = athl;
        if (def < 0 || def > 100) {
            throw new UnsupportedRosterException("out bound");
        }
        this.defense = def;
        if (reb < 0 || reb > 100) {
            throw new UnsupportedRosterException("out bound");
        }
        this.rebound = reb;
        this.skills = skill;
        this.totalAttribute = defense + shooting + passing + layup + athletics + rebound;

    }

    public Player() {

    }

    public boolean checkSkill(String skill) {
        if (skills.contains(skill)) {

        } else {
            return false;
        }
        return true;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setShooting(int shooting) {
        this.shooting = shooting;
    }

    public void setPassing(int passing) {
        this.passing = passing;
    }

    public void setLayup(int layup) {
        this.layup = layup;
    }

    public void setAthletics(int athletics) {
        this.athletics = athletics;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setRebound(int rebound) {
        this.rebound = rebound;
    }

    public void setSkills(ArrayList<String> skills) {
        this.skills = skills;
    }

    public void setTotalAttribute(int totalAttribute) {
        this.totalAttribute = totalAttribute;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPosition() {
        return position;
    }

    public int getShooting() {
        return shooting;
    }

    public int getPassing() {
        return passing;
    }

    public int getRebound() {
        return rebound;
    }

    public int getAthletics() {
        return athletics;
    }

    public int getDefense() {
        return defense;
    }

    public int getLayup() {
        return layup;
    }

    public int getTotalAttribute() {
        return totalAttribute;
    }

    public ArrayList<String> getSkills() {
        return skills;
    }
}
