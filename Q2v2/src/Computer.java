public class Computer {

    private String name;
    private double cost;

    public Computer (){
        name = "";
        cost = 0.0;
    }
    public Computer(String name, double cost){
        this.name = name;
        this.cost = cost;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }
}
