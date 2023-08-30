import java.util.ArrayList;

/**
 * PurdueStudent
 * <p>
 * BOILERMAKER!!!!!!
 * <p>
 *
 * @author Edythe Thompson, L09
 * @version 4-13-2020
 */
public class PurdueStudent extends CollegeStudent {
    private static ArrayList<String> idNums = new ArrayList<>();

    public PurdueStudent(int age, String firstName, String lastName, String stateOfResidency, String major,
                         String housing) {
        super(age, firstName, lastName, stateOfResidency, major, housing);
    }

    public PurdueStudent(String id) {
        super(id);
    }

    public PurdueStudent() {
        super();
    }


    @Override
    public double getTuition() {
        return tuition;
    }

    @Override
    public int getStudentAge() {
        return age;
    }

    @Override
    public String getStudentFirstName() {
        return firstName;
    }

    @Override
    public String getStudentLastName() {
        return lastName;
    }

    @Override
    public String getStateOfResidence() {
        return stateOfResidency;
    }

    @Override
    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public void calculateTuition() {
        if (stateOfResidency.equals(getState())) {
            tuition = CollegeConstants.PURDUE_UNIVERSITY_IN_STATE_TUITION;
        } else {
            tuition = CollegeConstants.PURDUE_UNIVERSITY_OUT_OF_STATE_TUITION;
        }

    }

    @Override
    public String getMajor() {
        return major;
    }

    @Override
    public String getHousing() {
        return housing;
    }

    @Override
    public String getState() {
        return CollegeConstants.PURDUE_UNIVERSITY_STATE;
    }

    @Override
    public String generateID() {
        id = "";
        double ah = (Math.random() * 10);
        int ahh = (int) ah;
        id = id + ahh;
        id = id + "1";
        id = id + "3";
        for (int i = 2; i < 9; i++) {
            double r = (Math.random() * 10);
            int are = (int) r;
            id = id + are;
        }
        idNums.add(id);
        return getID();
    }

    @Override
    public String getID() {
        for (int a = 0; a < idNums.size() - 1; a++) {
            if (idNums.get(a).equals(id)) {
                generateID();
            }
        }
        return id;
    }
}
