import org.junit.*;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Scanner;

public class CollegeStudentLocalTest {

    @Test(timeout = 1000)
    public void testIUStudentInheritsFromCollegeStudent() throws Exception {
        //Set expected values
        String expectedSuperClassName = "CollegeStudent";

        //Create formatted String messages
        String superClassTypeIncorrectMessage = "The IU Student class inherits from %s, not CollegeStudent";

        try {
            //Get immediate superclass name of IU
            String actualSuperClassName = IUStudent.class.getSuperclass().getName();

            //Confirm each superclass has the name "CollegeStudent"
            assertTrue(String.format(superClassTypeIncorrectMessage, actualSuperClassName),
                    actualSuperClassName.equals(expectedSuperClassName));

        } catch (AssertionError e) {
            throw e;
        }
    }

    @Test(timeout = 1000)
    public void testPurdueStudentInheritsFromCollegeStudent() throws Exception {
        //Set expected values
        String expectedSuperClassName = "CollegeStudent";

        //Create formatted String messages
        String superClassTypeIncorrectMessage = "The Purdue Student class inherits from %s, not CollegeStudent";

        try {
            //Get immediate superclass name of IU
            String actualSuperClassName = PurdueStudent.class.getSuperclass().getName();

            //Confirm each superclass has the name "CollegeStudent"
            assertTrue(String.format(superClassTypeIncorrectMessage, actualSuperClassName),
                    actualSuperClassName.equals(expectedSuperClassName));

        } catch (AssertionError e) {
            throw e;
        }
    }

    @Test(timeout = 1000)
    public void testCollegeStudentConstructorGettersAndSetters() throws Exception {
        //Declare valid parameters for residency and livesOffCampus (create two sets)

        String student1FirstName = "Purdue";
        String student1LastName = "Pete";
        String student1Id = "1111111111";

        String student2FirstName = "IU";
        String student2LastName = "Hoosier";
        String student2Id = "2222222222";
        double student2Gpa = 3.22;
        String student2ResidencyString = "IN_STATE";
        boolean student2LivesOffCampus = false;

        //Set expected values for dormCost, tuition, residency, and livesOffCampus
        double expectedDormCost2 = 800.00;
        double expectedTuition2 = 23000.00;
        Residency expectedResidency2 = Residency.IN_STATE;
        boolean expectedLivesOffCampus2 = false;

        //Formatted message String
        String getterResultIncorrectMessage = "The getter method for CollegeStudent.%s returned an incorrect value.";
        String firstNameIncorrectMessage = String.format(getterResultIncorrectMessage, "firstName");
        String lastNameIncorrectMessage = String.format(getterResultIncorrectMessage, "lastName");
        String idIncorrectMessage = String.format(getterResultIncorrectMessage, "id");
        String gpaIncorrectMessage = String.format(getterResultIncorrectMessage, "gpa");
        String dormCostResultIncorrectMessage = String.format(getterResultIncorrectMessage, "dormCost");
        String tuitionResultIncorrectMessage = String.format(getterResultIncorrectMessage, "tuition");
        String residencyResultIncorrectMessage = String.format(getterResultIncorrectMessage, "residency");
        String livesOffCampuseResultIncorrectMessage = String.format(getterResultIncorrectMessage, "livesOffCampus");
        String bookFeesIncorrectMessage = String.format(getterResultIncorrectMessage, "bookFees");
        String financialAidIncorrectMessage = String.format(getterResultIncorrectMessage, "financialAid");


        try {
            //Create instances of CollegeStudent with valid parameters
            CollegeStudent student1 = new CollegeStudent(student1FirstName, student1LastName, student1Id);
            CollegeStudent student2 = new CollegeStudent(student2FirstName, student2LastName, student2Id, student2Gpa,
                    student2ResidencyString, student2LivesOffCampus);

            //Compare getter results against expected values
            assertEquals(firstNameIncorrectMessage, student1FirstName, student1.getFirstName());
            assertEquals(lastNameIncorrectMessage, student1LastName, student1.getLastName());
            assertEquals(idIncorrectMessage, student1Id, student1.getId());

            assertEquals(firstNameIncorrectMessage, student2FirstName, student2.getFirstName());
            assertEquals(lastNameIncorrectMessage, student2LastName, student2.getLastName());
            assertEquals(idIncorrectMessage, student2Id, student2.getId());
            assertEquals(gpaIncorrectMessage, student2Gpa, student2.getGpa(), 0.0001);
            assertEquals(dormCostResultIncorrectMessage, expectedDormCost2, student2.getDormCost(), 0.0001);
            assertEquals(tuitionResultIncorrectMessage, expectedTuition2, student2.getTuition(), 0.0001);
            assertEquals(residencyResultIncorrectMessage, expectedResidency2, student2.getResidency());
            assertEquals(livesOffCampuseResultIncorrectMessage, expectedLivesOffCampus2, student2.isLivingOffCampus());

            // Use setters to adjust fields
            student1.setFirstName("John");
            student1.setLastName("Smith");
            student1.setId("444");
            student1.setGpa(3.91);
            student1.setResidency("OUT_OF_STATE");
            student1.setLivesOffCampus(true);
            student1.setDormCost(1200.00);
            student1.setTuition(27000.00);
            student1.setBookFees(900.00);
            student1.setFinancialAid(3000.00);

            //Compare getter results against expected values
            assertEquals(firstNameIncorrectMessage, "John", student1.getFirstName());
            assertEquals(lastNameIncorrectMessage, "Smith", student1.getLastName());
            assertEquals(idIncorrectMessage, "444", student1.getId());
            assertEquals(dormCostResultIncorrectMessage, 1200.00, student1.getDormCost(), 0.0001);
            assertEquals(tuitionResultIncorrectMessage, 27000.00, student1.getTuition(), 0.0001);
            assertEquals(residencyResultIncorrectMessage, Residency.OUT_OF_STATE, student1.getResidency());
            assertEquals(livesOffCampuseResultIncorrectMessage, true, student1.isLivingOffCampus());
            assertEquals(bookFeesIncorrectMessage, 900.00, student1.getBookFees(), 0.0001);
            assertEquals(financialAidIncorrectMessage, 3000.00, student1.getFinancialAid(), 0.0001);


        } catch (AssertionError e) {
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("testCollegeStudentConstructorGettersAndSetters::An unexpected exception " +
                    "occurred (see stack trace).");
            throw e;
        }
    }

}