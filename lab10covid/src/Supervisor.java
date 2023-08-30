public class Supervisor extends Employee{
    private int teamSize;

    public Supervisor(){
        super();
        this.teamSize = 0;
    }
    public Supervisor(double yearlySalary, boolean temporary, boolean insured, int teamSize){
        super(yearlySalary,temporary,insured);
        this.teamSize = teamSize;
    }

    @Override
    public double calculateCompensation() {
        return getYearlySalary() + teamSize*2000;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Team Size: "+teamSize);
        System.out.printf("Total Compensation: %.2f\n", calculateCompensation());
    }

    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }

    public int getTeamSize() {
        return teamSize;
    }
}
