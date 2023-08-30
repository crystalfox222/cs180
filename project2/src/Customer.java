public class Customer {
    private String name;
    private String address;
    private String zipCode;
    private int numRentals;

    public Customer(String name, String address, String zipCode, int numRentals){
        this.name = name;
        this.address = address;
        this.zipCode = zipCode;
        this.numRentals = numRentals;
    }
    public Customer(){

    }
    public double calculateDiscount(){
       double discount = (this.numRentals*0.25)/100.00;
       return discount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setNumRentals(int numRentals) {
        this.numRentals = numRentals;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public int getNumRentals() {
        return numRentals;
    }
}
