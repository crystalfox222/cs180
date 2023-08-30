public class Employee {
    private String name;
    private int yearsWorked;
    private int totalRentals;
    private double baseSalary;
    private int id;

    public Employee(String name, int yearsWorked, int totalRentals, double baseSalary, int id){
        this.name = name;
        this.yearsWorked = yearsWorked;
        this.totalRentals = totalRentals;
        this.baseSalary = baseSalary;
        this.id = id;
    }
    public Employee(){

    }
    public double calculateSalary(){
        double salary = this.baseSalary + this.yearsWorked * 0.5 * this.totalRentals;
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYearsWorked(int yearsWorked) {
        this.yearsWorked = yearsWorked;
    }

    public void setTotalRentals(int totalRentals) {
        this.totalRentals = totalRentals;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getYearsWorked() {
        return yearsWorked;
    }

    public int getTotalRentals() {
        return totalRentals;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public int getId() {
        return id;
    }
}
