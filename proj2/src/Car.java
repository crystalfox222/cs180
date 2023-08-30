public class Car {
    private Classification type;
    private int maxSeating;
    private int towingCapacity;
    private double fuelEconomy;
    private String make;
    private String model;
    private String vin;
    private double purchasePrice;
    private int mileage;

    public Car (Classification type, int maxSeating, int towingCapacity, double fuelEconomy, String make, String model, String vin, double purchasePrice, int milage ){
        this.type = type;
        this.maxSeating = maxSeating;
        this.towingCapacity = towingCapacity;
        this.fuelEconomy = fuelEconomy;
        this.make = make;
        this.model = model;
        this.vin = vin;
        this.purchasePrice = purchasePrice;
        this.mileage = milage;
    }
    public Car(){

    }
    public double calculateRate(int numDays, boolean insurance){
        double rate = 0.0;
        double days = numDays;
        if (type.equals(Classification.ECONOMY)||type.equals(Classification.COMPACT)){
            rate = (days)*30.00;
        } else if (type.equals(Classification.PREMIUM)||type.equals(Classification.SPORT)){
            rate = (days)*40.00;
        } else if (type.equals(Classification.SUV)||type.equals(Classification.PICKUP)){
            rate =  (days)*50.00;
        } else if (type.equals(Classification.LUXURY)){
            rate = (days)*60.00;
        }
        else{

        }
        if (insurance){
            rate = rate + days*15.00;
        }
        return rate;
    }
    public double calculateSellPrice(){
        double price = purchasePrice - mileage*0.05;
        return price;
    }

    public void setType(Classification type) {
        this.type = type;
    }

    public void setMaxSeating(int maxSeating) {
        this.maxSeating = maxSeating;
    }

    public void setTowingCapacity(int towingCapacity) {
        this.towingCapacity = towingCapacity;
    }

    public void setFuelEconomy(double fuelEconomy) {
        this.fuelEconomy = fuelEconomy;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Classification getType() {
        return type;
    }

    public int getMaxSeating() {
        return maxSeating;
    }

    public int getTowingCapacity() {
        return towingCapacity;
    }

    public double getFuelEconomy() {
        return fuelEconomy;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getVin() {
        return vin;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public int getMileage() {
        return mileage;
    }
}
