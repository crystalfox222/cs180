public class Lenovo extends Computer implements OperatingSystem{
    public Lenovo(){
        super();
    }
    public Lenovo(String name, double cost){
        super(name, cost);
    }

    @Override
    public void loadOperatingSystem() {
        System.out.println("File System: NTFS");
    }

    @Override
    public void printInfo() {
        String cost = String.format("%.2f",getCost());
        System.out.println("Name: "+ getName() +"\n" + "Cost: $" + cost);
    }
}

