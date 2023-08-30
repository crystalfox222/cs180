import java.util.ArrayList;

public class MysteryIncMember {
    private String name;
    private int totalAwesomeness;
    private ArrayList<Case> starredCases = new ArrayList<>();

    public MysteryIncMember(String name){
        this.name = name;
    }
   public  MysteryIncMember(){

    }

    public void addAwesomeValue(int value){
        totalAwesomeness = totalAwesomeness + value;
    }
    public void addStarredCase(Case casse){
        starredCases.add(casse);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Case> getStarredCases() {
        return starredCases;
    }

    public int getTotalAwesomeness() {
        return totalAwesomeness;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTotalAwesomeness(int totalAwesomeness) {
        this.totalAwesomeness = totalAwesomeness;
    }
}
