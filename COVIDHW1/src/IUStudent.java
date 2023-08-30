/**
 * IUStudent
 * <p>
 * This class extends College Student for the worst school ever
 * <p>
 * Used stack overflow occasionally
 *
 * @author Edythe Thompson, L09
 * @version 3-26-2020
 */
public class IUStudent extends CollegeStudent {

    private double transportationCost;

    public IUStudent(String firstName, String lastName, String id, double gpa, String residency,
                     boolean livesOffCampus) {
        super(firstName, lastName, id, gpa, residency, livesOffCampus);
        setBookFees(1034.00);
        if (livesOffCampus) {
            this.transportationCost = 500;
        } else {
            this.transportationCost = 100;
        }
        if (gpa >= 3.75 & gpa < 4.0) {
            setFinancialAid(4500.00);
        } else if (gpa >= 3.5 & gpa < 3.75) {
            setFinancialAid(3500.00);
        } else if (gpa >= 3.00 & gpa < 3.5) {
            setFinancialAid(2750.00);
        } else if (gpa >= 2.50 & gpa < 3.0) {
            setFinancialAid(2500.00);
        } else {
            setFinancialAid(0);
        }
        if (residency.equals("OUT_OF_STATE")) {
            setTuition(34896);
        } else if (residency.equals("IN_STATE")) {
            setTuition(10534);
        } else if (residency.equals("INTERNATIONAL")) {
            setTuition(38314);
        }
    }

    public IUStudent() {

    }

    public double calculateYearlyCost() {
        double yearlyCost = (getTuition() + getBookFees() + transportationCost + (getDormCost() * 12))
                - getFinancialAid();
        return yearlyCost;
    }

    public void setTransportationCost(double transportationCost) {
        this.transportationCost = transportationCost;
    }

    public double getTransportationCost() {
        return transportationCost;
    }
}
