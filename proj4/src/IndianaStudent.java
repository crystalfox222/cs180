import java.util.ArrayList;

/**
 * IndianaStudent
 * <p>
 * Student at IU
 * <p>
 * Used stack overflow and the javadocs occasionally, especially for randomizing numbers
 *
 * @author Edythe Thompson, L09
 * @version 3-30-2020
 */

public class IndianaStudent extends CollegeStudent {
    private static ArrayList<String> idNums = new ArrayList<>();

    public IndianaStudent(int age, String firstName, String lastName, String stateOfResidency, String major,
                          String housing) {
        super(age, firstName, lastName, stateOfResidency, major, housing);
    }

    public IndianaStudent(String id) {
        super(id);
    }

    public IndianaStudent() {
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
            tuition = CollegeConstants.INDIANA_UNIVERSITY_IN_STATE_TUITION;
        } else {
            tuition = CollegeConstants.INDIANA_UNIVERSITY_OUT_OF_STATE_TUITION;
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
        return CollegeConstants.INDIANA_UNIVERSITY_STATE;
    }

    @Override
    public String generateID() {
        id = "";
        id = id + "8";
        for (int i = 1; i < 8; i++) {
            double r = (Math.random() * 10);
            int are = (int) r;
            id = id + are;
        }
        id = id + "2";
        id = id + "1";
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
