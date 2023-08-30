import java.util.ArrayList;

/**
 * PennStateStudent
 * <p>
 * Student who attends Penn State
 * <p>
 *
 * @author Edythe Thompson, L09
 * @version 4-13-2020
 */
public class PennStateStudent extends CollegeStudent {
    private static ArrayList<String> idNums = new ArrayList<>();

    public PennStateStudent(int age, String firstName, String lastName, String stateOfResidency, String major,
                            String housing) {
        super(age, firstName, lastName, stateOfResidency, major, housing);
    }

    public PennStateStudent(String id) {
        super(id);
    }

    public PennStateStudent() {
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
            tuition = CollegeConstants.PENN_STATE_UNIVERSITY_IN_STATE_TUITION;
        } else {
            tuition = CollegeConstants.PENN_STATE_UNIVERSITY_OUT_OF_STATE_TUITION;
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
        return CollegeConstants.PENN_STATE_UNIVERSITY_STATE;
    }

    @Override
    public String generateID() {
        id = "";
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                double r = (Math.random() * 4);
                int are = (int) r;
                id = id + are;
            } else {
                double ah = (Math.random() * 10);
                int ahh = (int) ah;
                id = id + ahh;
            }
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
