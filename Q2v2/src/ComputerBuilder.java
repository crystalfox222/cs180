public class ComputerBuilder {
    public static void main(String[] args) {
        Lenovo lenovo = new Lenovo("Y540",1010.00);
        Dell dell = new Dell("G7",850.00);
        lenovo.loadOperatingSystem();
        lenovo.printInfo();
        dell.loadOperatingSystem();
        dell.printInfo();
    }
}
