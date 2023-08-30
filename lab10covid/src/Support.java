public class Support extends Employee {
    private double performanceBonus;

    public Support(){
        super();
        this.performanceBonus = 0;
    }
    public Support(double yearlySalary, boolean temporary, boolean insured, double performanceBonus){
        super(yearlySalary,temporary,insured);
        this.performanceBonus = performanceBonus;
    }

    public void setPerformanceBonus(double performanceBonus) {
        this.performanceBonus = performanceBonus;
    }

    public double getPerformanceBonus() {
        return performanceBonus;
    }

    @Override
    public double calculateCompensation() {
       return getYearlySalary() + performanceBonus;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.printf("Total Compensation: %.2f\n", calculateCompensation());
    }
}
