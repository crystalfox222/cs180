public class Dell extends Computer implements OperatingSystem {
    public Dell(){
        super();
    }
    public Dell(String name, double cost){
        super(name, cost);
    }

    @Override
    public void loadOperatingSystem() {
        System.out.println("File System: EXT4");

    }

    @Override
    public void printInfo() {
        String cost = String.format("%.2f",getCost());
        System.out.println("Name: "+ getName() +"\n" + "Cost: $" + cost);
    }
}
