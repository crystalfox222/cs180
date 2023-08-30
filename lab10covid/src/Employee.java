public abstract class Employee {
    private double yearlySalary;
    private boolean temporary;
    private boolean insured;

    public Employee(){
        this.yearlySalary = 45000.00;
        this.temporary = false;
        this.insured = false;
    }
    public Employee(double yearlySalary, boolean temporary, boolean insured){
        this.yearlySalary = yearlySalary;
        this.temporary = temporary;
        this.insured = insured;
    }

    public abstract double calculateCompensation();
    public void printInfo(){
        System.out.printf("Base Salary: %.2f\n", yearlySalary);
        System.out.println("Temporary: "+temporary);
        System.out.println("Insured: "+insured);
    }

    public void setInsured(boolean insured) {
        this.insured = insured;
    }

    public void setTemporary(boolean temporary) {
        this.temporary = temporary;
    }

    public void setYearlySalary(double yearlySalary) {
        this.yearlySalary = yearlySalary;
    }

    public double getYearlySalary() {
        return yearlySalary;
    }

    public boolean isInsured() {
        return insured;
    }

    public boolean isTemporary() {
        return temporary;
    }
}
