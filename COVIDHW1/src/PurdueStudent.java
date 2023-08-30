/**
 * PurdueStudent
 * <p>
 * This class extends College Student
 * <p>
 * Used stack overflow occasionally
 *
 * @author Edythe Thompson, L09
 * @version 3-26-2020
 */

public class PurdueStudent extends CollegeStudent {
    private String major;

    public PurdueStudent(String firstName, String lastName, String id, double gpa, String residency,
                         boolean livesOffCampus, String major) {
        super(firstName, lastName, id, gpa, residency, livesOffCampus);
        this.major = major;
        if (major.equals("Engineering")) {
            setBookFees(500.00);
        } else if (major.equals("Computer Science")) {
            setBookFees(200.00);
        } else if (major.equals("Liberal Arts")) {
            setBookFees(750.00);
        } else {
            setBookFees(100.00);
        }
        if (gpa >= 3.75 & gpa <= 4.0) {
            setFinancialAid(5000.00);
        } else if (gpa >= 3.5 & gpa < 3.75) {
            setFinancialAid(4500.00);
        } else if (gpa >= 3.00 & gpa < 3.5) {
            setFinancialAid(3000.00);
        } else if (gpa >= 2.50 & gpa < 3.0) {
            setFinancialAid(2500.00);
        } else {
            setFinancialAid(0);
        }
        if (residency.equals("OUT_OF_STATE")) {
            setTuition(28794);
        } else if (residency.equals("IN_STATE")) {
            setTuition(9992);
        } else if (residency.equals("INTERNATIONAL")) {
            setTuition(30954);
        }
    }

    public PurdueStudent() {

    }

    public double calculateYearlyCost() {
        double yearlyCost = (getTuition() + getBookFees() + (getDormCost() * 12)) - getFinancialAid();
        return yearlyCost;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}