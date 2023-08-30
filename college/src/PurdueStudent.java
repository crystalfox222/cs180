public class PurdueStudent extends CollegeStudent {
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

    private double tuition;
    private double bookFees;
    private double financialAid;
    private String major;

    public PurdueStudent(String firstName, String lastName, String id, double gpa, String residency, boolean livesOffCampus, String major) {
        super(firstName, lastName, id, gpa, residency, livesOffCampus);
        this.major = major;
        if (major.equals("Engineering")) {
            this.bookFees = 500.00;
        } else if (major.equals("Computer Science")) {
            this.bookFees = 200.00;
        } else if (major.equals("Liberal Arts")) {
            this.bookFees = 750.00;
        } else {
            this.bookFees = 100.00;
        }
        if (gpa >= 3.75 & gpa < 4.0) {
            financialAid = 5000;
        } else if (gpa >= 3.5 & gpa < 3.75) {
            financialAid = 4500;
        } else if (gpa >= 3.00 & gpa < 3.5) {
            financialAid = 3000;
        } else if (gpa >= 2.50 & gpa < 3.0) {
            financialAid = 2500;
        } else {
            financialAid = 0;
        }
        if (residency.equals(Residency.OUT_OF_STATE)) {
            tuition = 28794;
        } else if (residency.equals(Residency.IN_STATE)) {
            tuition = 9992;
        } else if (residency.equals(Residency.INTERNATIONAL)) {
            tuition = 30954;
        }
    }

    public PurdueStudent() {

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

    public void setTuition(double tuition) {
        this.tuition = tuition;
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

    public double getTuition() {
        return tuition;
    }

    public Residency getResidency() {
        return residency;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getMajor() {
        return major;
    }
}
