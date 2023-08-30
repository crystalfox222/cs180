public class CollegeStudent {
    private String firstName;
    private String lastName;
    private String id;
    private double gpa;
    private Residency residency;
    private boolean livesOffCampus;

    private double dormCost() {
        if (livesOffCampus) {
            return 500.0 * 12.0;
        } else {

        }
        return 800.0 * 12.0;
    }

    private double tuition() {
        if (residency.equals(Residency.IN_STATE)) {
            return 23000;
        } else if (residency.equals(Residency.OUT_OF_STATE)) {
            return 42000;
        } else if (residency.equals(Residency.INTERNATIONAL)) {
            return 44500;
        } else {
            throw new IllegalArgumentException();
        }
    }

    private double bookFees;
    private double financialAid;

    public CollegeStudent(String firstName, String lastName, String id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;

    }

    public CollegeStudent(String firstName, String lastName, String id, double gpa, String residency, boolean livesOffCampus) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.gpa = gpa;
        this.residency = Residency.valueOf(residency);
        this.livesOffCampus = livesOffCampus;

    }

    public CollegeStudent() {

    }

    public double CalculateYearlyCost() {
        double yearlyCost = (tuition() + bookFees + dormCost()) - financialAid;
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
        this.gpa = gpa;
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

    public void setResidency(Residency residency) {
        this.residency = residency;
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

}
