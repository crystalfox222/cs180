/**
 * CollegeStudent
 * <p>
 * This class is the base for students
 * <p>
 * Used stack overflow occasionally
 *
 * @author Edythe Thompson, L09
 * @version 3-26-2020
 */
public class CollegeStudent {
    private String firstName;
    private String lastName;
    private String id;
    private double gpa;
    private Residency residency;
    private boolean livesOffCampus;

    private double dormCost;

    private double tuition;


    private double bookFees;
    private double financialAid;

    public CollegeStudent(String firstName, String lastName, String id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;

    }

    public CollegeStudent(String firstName, String lastName, String id, double gpa, String residency,
                          boolean livesOffCampus) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        if (gpa < 0) {
            throw new IllegalArgumentException("GPA needs to be above or equal to 0");
        } else {
            this.gpa = gpa;
        }
        this.livesOffCampus = livesOffCampus;
        if (residency.equals(Residency.IN_STATE.toString())) {
            this.residency = Residency.valueOf(residency);
            tuition = 23000;
        } else if (residency.equals(Residency.OUT_OF_STATE.toString())) {
            this.residency = Residency.valueOf(residency);
            tuition = 42000;
        } else if (residency.equals(Residency.INTERNATIONAL.toString())) {
            this.residency = Residency.valueOf(residency);
            tuition = 44500;
        } else {
            throw new IllegalArgumentException("Student residency must be in one of the three specified statuses");
        }
        if (livesOffCampus) {
            dormCost = 500.0;
        } else {
            dormCost = 800.0;
        }

    }

    public CollegeStudent() {


    }

    public double calculateYearlyCost() {
        double yearlyCost = (tuition + bookFees + (dormCost * 12)) - financialAid;
        return yearlyCost;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setGpa(double gpa) {
        if (gpa >= 0) {
            this.gpa = gpa;
        } else {
            throw new IllegalArgumentException("GPA needs to be above or equal to 0");
        }
    }

    public void setBookFees(double bookFees) {
        this.bookFees = bookFees;
    }

    public void setFinancialAid(double financialAid) {
        this.financialAid = financialAid;
    }

    public void setLivesOffCampus(boolean livesOffCampus) {
        this.livesOffCampus = livesOffCampus;
    }

    public void setResidency(String residency) {
        if (residency.equals(Residency.IN_STATE.toString())) {
            this.residency = Residency.valueOf(residency);
        } else if (residency.equals(Residency.OUT_OF_STATE.toString())) {
            this.residency = Residency.valueOf(residency);
        } else if (residency.equals(Residency.INTERNATIONAL.toString())) {
            this.residency = Residency.valueOf(residency);
        } else {
            throw new IllegalArgumentException("Student residency must be in one of the three specified statuses");
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getId() {
        return id;
    }

    public double getGpa() {
        return gpa;
    }

    public double getBookFees() {
        return bookFees;
    }

    public double getFinancialAid() {
        return financialAid;
    }

    public Residency getResidency() {
        return residency;
    }

    public double getTuition() {
        return tuition;
    }

    public double getDormCost() {
        return dormCost;
    }

    public void setTuition(double tuition) {
        this.tuition = tuition;
    }

    public void setDormCost(double dormCost) {
        this.dormCost = dormCost;
    }

    public boolean isLivingOffCampus() {
        return livesOffCampus;
    }
}
