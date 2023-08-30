import java.io.*;
import java.util.Scanner;

/**
 * The main class of the program, that links together all of the other classes in this project.
 *
 * @author Edythe Thompson, L09
 * @version 4-13-2020
 */
public class StudentOperator {

    private static String firstName;
    private static String lastName;
    private static int age;
    private static String ageInput;
    private static String major;
    private static String collegeName;
    private static String state;
    private static CollegeStudent student;
    private static String housing;
    private static CollegeStudent lookedupStudent;

    public static void main(String[] args) throws InvalidStateException, InvalidCollegeException,
            InvalidStudentException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the College Student Database!");
        while (true) {
            int initialChoice;
            do {
                System.out.println("What would you like to do today?");
                System.out.println("(1) Add my information to the database");
                System.out.println("(2) Lookup Student Information");
                System.out.println("(3) Exit");
                initialChoice = scanner.nextInt();
                scanner.nextLine();
            } while (initialChoice > 3 | initialChoice <= 0);

            switch (initialChoice) {
                case 1: {
                    System.out.println("What college are you attending?");
                    collegeName = scanner.nextLine();

                    if (!verifyCollege(collegeName)) {
                        throw new InvalidCollegeException("The college you entered is not one supported by this " +
                                "logger!");
                    }

                    System.out.println("What is your first name?");
                    firstName = scanner.nextLine();

                    if (!verifyName(firstName)) {
                        throw new InvalidStudentException("The student's first name can only contain characters!");
                    }

                    System.out.println("What is your last name?");
                    lastName = scanner.nextLine();

                    if (!verifyName(lastName)) {
                        throw new InvalidStudentException("The student's last name can only contain characters!");
                    }

                    System.out.println("How old are you?");
                    ageInput = scanner.nextLine();

                    if (!verifyAge(ageInput)) {
                        throw new InvalidStudentException("The student's age must be a number between 16 and 22!");
                    } else {
                        age = Integer.parseInt(ageInput);
                    }

                    System.out.println("What is your major?");
                    major = scanner.nextLine();

                    if (!verifyMajor(major)) {
                        throw new InvalidStudentException("The student's major must not be blank and only contain " +
                                "letters with the exception of a space or the '/' character!");
                    }

                    System.out.println("What state do you currently reside in?");
                    state = scanner.nextLine();

                    if (!verifyState(state)) {
                        throw new InvalidStateException("The state you entered was not a state in the " +
                                "United States!");
                    }

                    System.out.println("Do you plan to live on or off campus?");
                    housing = scanner.nextLine();

                    if (!verifyHousing(housing)) {
                        throw new InvalidStudentException("The student must be living either on campus or off campus!"
                                +
                                "");
                    }
                    switch (collegeName) {
                        case CollegeConstants.PURDUE_UNIVERSITY_NAME:
                            student = new PurdueStudent(age, firstName, lastName, state, major,
                                    housing);
                            break;
                        case CollegeConstants.INDIANA_UNIVERSITY_NAME:
                            student = new IndianaStudent(age, firstName, lastName, state, major,
                                    housing);
                            break;
                        case CollegeConstants.OHIO_STATE_UNIVERSITY_NAME:
                            student = new OhioStateStudent(age, firstName, lastName, state, major,
                                    housing);
                            break;
                        case CollegeConstants.PENN_STATE_UNIVERSITY_NAME:
                            student = new PennStateStudent(age, firstName, lastName, state, major,
                                    housing);
                            break;
                        case CollegeConstants.UNIVERSITY_OF_MICHIGAN_NAME:
                            student = new MichiganStudent(age, firstName, lastName, state, major,
                                    housing);
                            break;
                    }
                    student.calculateTuition();
                    student.generateID();
                    writeStudentToFile(student);
                    System.out.println("Here is your new student ID : " + student.getID());
                    System.out.println("Thank you for the information! Your information has been documented. "
                            + "Good luck in college!");
                    break;
                }
                case 2: {
                    String nameOfCollege;
                    System.out.println("Please enter the college of the student you would like to lookup.");
                    nameOfCollege = scanner.nextLine();
                    if (!verifyCollege(nameOfCollege)) {
                        throw new InvalidCollegeException("Not a college supported by this logger!");
                    }
                    System.out.println("Enter the ID of the student you would like to know information about.");
                    String id = scanner.nextLine();
                    CollegeStudent collegeStudent;
                    switch (nameOfCollege) {
                        case CollegeConstants.PURDUE_UNIVERSITY_NAME:
                            collegeStudent = new PurdueStudent(id);
                            break;
                        case CollegeConstants.INDIANA_UNIVERSITY_NAME:
                            collegeStudent = new IndianaStudent(id);
                            break;
                        case CollegeConstants.UNIVERSITY_OF_MICHIGAN_NAME:
                            collegeStudent = new MichiganStudent(id);
                            break;
                        case CollegeConstants.OHIO_STATE_UNIVERSITY_NAME:
                            collegeStudent = new OhioStateStudent(id);
                            break;
                        case CollegeConstants.PENN_STATE_UNIVERSITY_NAME:
                            collegeStudent = new PennStateStudent(id);
                            break;
                        default: {
                            throw new InvalidStudentException("That student doesn't exist in the database!");
                        }
                    }
                    if (lookupID(collegeStudent)) {
                        String input;
                        do {
                            System.out.println("What information would you like to know about the student?");
                            System.out.println("(1) Name");
                            System.out.println("(2) Age");
                            System.out.println("(3) Housing");
                            System.out.println("(4) Major");
                            System.out.println("(5) Student Origin");
                            input = scanner.nextLine();
                        } while (Integer.parseInt(input) > 5 | Integer.parseInt(input) < 1);

                        collegeStudent = lookedupStudent;
                        if (Integer.parseInt(input) == 1) {
                            System.out.println("The student's name is " + collegeStudent.getFullName());
                        } else if (Integer.parseInt(input) == 2) {
                            System.out.println("The student's age is " + collegeStudent.getStudentAge());
                        } else if (Integer.parseInt(input) == 3) {
                            System.out.println("The student's housing is considered " + collegeStudent.getHousing());
                        } else if (Integer.parseInt(input) == 4) {
                            System.out.println("The student's major is " + collegeStudent.getMajor());
                        } else if (Integer.parseInt(input) == 5) {
                            System.out.println("The student's home is in " + collegeStudent.getStateOfResidence());
                        }
                    } else {
                        System.out.println("That student doesn't exist in the database. " +
                                "Thank you for using the Lookup Tool!");
                    }
                    break;
                }
                case 3: {
                    System.out.println("Thank you for using the College Database Program!");
                    return;
                }
            }
        }
    }

    /**
     * The {@code verifyState()} method takes in a state and makes sure it is present in the enum {@code States}. If
     * the state is not present, then the method returns false. If it is, then the method returns true. If the name
     * of the state is two words, like New York, then this method should also convert it to where the space is now
     * an underscore character.If this method returns false, the method that called it should throw a {@code
     * InvalidStateException}.
     *
     * @param str The state to be checked
     * @return The result of whether the state is in the United States
     */
    private static boolean verifyState(String str) throws InvalidStateException {
        str = str.replaceAll(" ", "_"); // found on piazza
        if (str.equals(States.valueOf(str).toString())) {
            return true;
        } else {
            throw new InvalidStateException();
        }
    }

    /**
     * The {@code verifyAge()} method verifies that the age is between the specified bounds of being 16 years or older
     * and being 22 years or younger. Since the main method will read any input, you should also ensure that the
     * input is an integer.If this method returns false, the method that called it should throw a {@code
     * InvalidStudentException}.
     *
     * @param ageToVerify The age to verify
     * @return The result of whether the age falls between the specified bounds
     */
    private static boolean verifyAge(String ageToVerify) throws InvalidStudentException {
        int ageTest = Integer.parseInt(ageToVerify);
        if (ageTest >= 16 && ageTest <= 22) {
            return true;
        } else {
            throw new InvalidStudentException("");
        }
    }

    /**
     * The {@code verifyMajor()} method verifies whether the major is not a blank line. If the major is a blank line,
     * the method returns false. If the major is anything except a blank line, the method returns true. In addition,
     * the method should only allow letters. The only three characters allowed besides letters are a space, a '/'
     * character, and a '-' character. You should remove these in this method, and replace them with nothing. If this
     * method returns false, the method that called it should throw a {@code InvalidStudentException}.
     *
     * @param majorToVerify The major to verify
     * @return The result of whether the major is a valid major.
     */
    private static boolean verifyMajor(String majorToVerify) throws InvalidStudentException {
        while (majorToVerify.contains(" ")) {
            majorToVerify = majorToVerify.replace(" ", "");
        }
        while (majorToVerify.contains("/")) {
            majorToVerify = majorToVerify.replace("/", "");
        }
        while (majorToVerify.contains(",")) {
            majorToVerify = majorToVerify.replace(",", "");
        }
        for (int i = 0; i < majorToVerify.length(); i++) {
            if (majorToVerify.charAt(i) >= 'a' && majorToVerify.charAt(i) <= 'z') {
            } else if (majorToVerify.charAt(i) >= 'A' && majorToVerify.charAt(i) <= 'Z') {
            } else {
                throw new InvalidStudentException();
            }
        }
        majorToVerify = major;
        return true;
    }

    /**
     * The {@code verifyHousing()} method verifies that the housing statement matches either the on campus or
     * off campus housing constants in the {@code CollegeConstants} class.If this method returns false, the method
     * that called it should throw a {@code InvalidStudentException}.
     *
     * @param housingToVerify The housing status to verify
     * @return The result of whether the housing is valid.
     */
    private static boolean verifyHousing(String housingToVerify) throws InvalidStudentException {
        if (housingToVerify.equals(CollegeConstants.ON_CAMPUS)) {
            return true;
        } else if (housingToVerify.equals(CollegeConstants.OFF_CAMPUS)) {
            return true;
        } else {
            throw new InvalidStudentException("");
        }
    }

    /**
     * The {@code verifyCollege()} method verifies that the college is one of the give colleges supported by
     * the CollegeLogger project. If it is not one of the five colleges, the method returns false. If it is,
     * the method returns true. If this method returns false, the method that called it should throw a {@code
     * InvalidCollegeException}.
     *
     * @param str The college to check support for
     * @return The result of whether or not this college is supported by this program.
     */
    @SuppressWarnings("BooleanMethodIsAlwaysInverted")
    private static boolean verifyCollege(String str) throws InvalidCollegeException {
        switch (str) {
            case CollegeConstants.PURDUE_UNIVERSITY_NAME:
                return true;
            case CollegeConstants.INDIANA_UNIVERSITY_NAME:
                return true;
            case CollegeConstants.OHIO_STATE_UNIVERSITY_NAME:
                return true;
            case CollegeConstants.PENN_STATE_UNIVERSITY_NAME:
                return true;
            case CollegeConstants.UNIVERSITY_OF_MICHIGAN_NAME:
                return true;
            default:
                throw new InvalidCollegeException("");
        }

    }

    /**
     * The {@code verifyName()} method will check whether the name is composed purely of letters. A name containing
     * anything other than letters is considered an invalid name. Similarly, an empty string is also considered an
     * invalid name.If this method returns false, the method that called it should throw a {@code
     * InvalidStudentException}.
     *
     * @param str The name to check validity of
     * @return Whether the name is a valid name for the program to use.
     */
    @SuppressWarnings("BooleanMethodIsAlwaysInverted")
    private static boolean verifyName(String str) throws InvalidStudentException {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
            } else if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
            } else {
                throw new InvalidStudentException("");
            }
        }
        return true;
    }

    /**
     * The {@code writeStudentToFile()} method takes the information provided by the user to the program and
     * pretty prints it to the appropriate text file. If the file is not empty, meaning there are
     * already one or more entries, a row of 20 dashes separated by a single space should be printed to separate
     * the entries. This information should be put to the appropriate file based on the student's college name. Refer
     * to the handout in order to understand the order of the data to be printed. In addition, keep in mind that the
     * tuition should be printed without a dollars sign but have two decimal places.
     * <p>
     * The files will be named as follows:
     * <p>
     * For Purdue University, data is stored in a file called purdueUniversityStudents.txt
     * For Indiana University, data is stored in a file called indianaUniversityStudents.txt
     * For University of Michigan, data is stored in a file called universityOfMichiganStudents.txt
     * For Pennsylvania State University, data is stored in a file called pennsylvaniaStateUniversityStudents.txt
     * For The Ohio State University, data is stored in a file called theOhioStateUniversityStudents.txt
     *
     * @param studentToWrite The {@code CollegeStudent} to write data about.
     */
    private static void writeStudentToFile(CollegeStudent studentToWrite) {
        String tut = String.format("%.2f", studentToWrite.getTuition());
        try {
            File file = null;
            PrintWriter pw = null;
            if (collegeName.equals(CollegeConstants.PURDUE_UNIVERSITY_NAME)) {
                file = new File("purdueUniversityStudents.txt");
            } else if (collegeName.equals(CollegeConstants.INDIANA_UNIVERSITY_NAME)) {
                file = new File("indianaUniversityStudents.txt");
            } else if (collegeName.equals(CollegeConstants.UNIVERSITY_OF_MICHIGAN_NAME)) {
                file = new File("universityOfMichiganStudents.txt");
            } else if (collegeName.equals(CollegeConstants.PENN_STATE_UNIVERSITY_NAME)) {
                file = new File("pennsylvaniaStateUniversityStudents.txt");
            } else if (collegeName.equals(CollegeConstants.OHIO_STATE_UNIVERSITY_NAME)) {
                file = new File("theOhioStateUniversityStudents.txt");
            }
            if (!file.exists()) {
                file.createNewFile();
            }
            if (file.length() != 0) {
                pw = new PrintWriter(new FileWriter(file, true));
                pw.println("- - - - - - - - - - - - - - - - - - - -");
                pw.println(studentToWrite.getID());
                pw.println(studentToWrite.getStudentLastName().toUpperCase() + ", "
                        + studentToWrite.getStudentFirstName().toUpperCase());
                pw.println(studentToWrite.getStudentAge());
                pw.println(studentToWrite.getHousing());
                pw.println(studentToWrite.getMajor());
                pw.println(studentToWrite.getStateOfResidence());
                pw.println(tut);
                pw.close();
            } else {
                pw = new PrintWriter(new FileWriter(file));
                pw.println(studentToWrite.getID());
                pw.println(studentToWrite.getStudentLastName().toUpperCase() + ", "
                        + studentToWrite.getStudentFirstName().toUpperCase());
                pw.println(studentToWrite.getStudentAge());
                pw.println(studentToWrite.getHousing());
                pw.println(studentToWrite.getMajor());
                pw.println(studentToWrite.getStateOfResidence());
                pw.println(tut);
                pw.close();

            }
        } catch (IOException e) {
            System.out.println();
        }
    }


    /**
     * The {@code lookupID} method will take a parameter of a {@code CollegeStudent} object, and return whether
     * the ID of the student was found. If it was found, it should also set the appropriate fields of an object
     * of type {@code CollegeStudent} to the values found of the student.
     *
     * @param studentToLookup The {@code CollegeStudent} to check existence in the database.
     * @return a boolean indicator that represents if the student was found in the respective database or not.
     */
    private static boolean lookupID(CollegeStudent studentToLookup) {
        int check = 0;
        try {
            File file1 = new File("indianaUniversityStudents.txt");
            File file2 = new File("purdueUniversityStudents.txt");
            File file3 = new File("universityOfMichiganStudents.txt");
            File file4 = new File("pennsylvaniaStateUniversityStudents.txt");
            File file5 = new File("theOhioStateUniversityStudents.txt");
            BufferedReader read1 = new BufferedReader(new FileReader(file1));
            BufferedReader read2 = new BufferedReader(new FileReader(file2));
            BufferedReader read3 = new BufferedReader(new FileReader(file3));
            BufferedReader read4 = new BufferedReader(new FileReader(file4));
            BufferedReader read5 = new BufferedReader(new FileReader(file5));
            String reading1 = read1.readLine();
            String reading2 = read2.readLine();
            String reading3 = read3.readLine();
            String reading4 = read4.readLine();
            String reading5 = read5.readLine();
            while (reading1 != null) {
                if (reading1.equals(studentToLookup.getID())) {
                    check = 1;
                    String id = reading1;
                    String name = read1.readLine();
                    int agee = Integer.parseInt(read1.readLine());
                    String residence = read1.readLine();
                    String majorr = read1.readLine();
                    String statee = read1.readLine();
                    String firstNamee = name.substring(name.indexOf(" ") + 1, name.length());
                    String lastNamee = name.substring(0, name.indexOf(","));
                    firstNamee = toNameCase(firstNamee);
                    lastNamee = toNameCase(lastNamee);
                    lookedupStudent = new IndianaStudent(agee, firstNamee, lastNamee, statee, majorr, residence);
                    break;
                } else {
                    reading1 = read1.readLine();
                }
            }
            read1.close();
            while (reading2 != null) {
                if (reading2.equals(studentToLookup.getID())) {
                    check = 1;
                    String id = reading2;
                    String name = read2.readLine();
                    int agee = Integer.parseInt(read2.readLine());
                    String residence = read2.readLine();
                    String majorr = read2.readLine();
                    String statee = read2.readLine();
                    String firstNamee = name.substring(name.indexOf(" ") + 1, name.length());
                    String lastNamee = name.substring(0, name.indexOf(","));
                    firstNamee = toNameCase(firstNamee);
                    lastNamee = toNameCase(lastNamee);
                    lookedupStudent = new PurdueStudent(agee, firstNamee, lastNamee, statee, majorr, residence);
                    break;
                } else {
                    reading2 = read2.readLine();
                }
            }
            read2.close();
            while (reading3 != null) {
                if (reading3.equals(studentToLookup.getID())) {
                    check = 1;
                    String id = reading3;
                    String name = read3.readLine();
                    int agee = Integer.parseInt(read3.readLine());
                    String residence = read3.readLine();
                    String majorr = read3.readLine();
                    String statee = read3.readLine();
                    String firstNamee = name.substring(name.indexOf(" ") + 1, name.length());
                    String lastNamee = name.substring(0, name.indexOf(","));
                    firstNamee = toNameCase(firstNamee);
                    lastNamee = toNameCase(lastNamee);
                    lookedupStudent = new MichiganStudent(agee, firstNamee, lastNamee, statee, majorr, residence);
                    break;
                } else {
                    reading3 = read3.readLine();
                }
            }
            read3.close();
            while (reading4 != null) {
                if (reading4.equals(studentToLookup.getID())) {
                    check = 1;
                    String id = reading4;
                    String name = read1.readLine();
                    int agee = Integer.parseInt(read4.readLine());
                    String residence = read4.readLine();
                    String majorr = read4.readLine();
                    String statee = read4.readLine();
                    String firstNamee = name.substring(name.indexOf(" ") + 1, name.length());
                    String lastNamee = name.substring(0, name.indexOf(","));
                    firstNamee = toNameCase(firstNamee);
                    lastNamee = toNameCase(lastNamee);
                    lookedupStudent = new PennStateStudent(agee, firstNamee, lastNamee, statee, majorr, residence);
                    break;
                } else {
                    reading4 = read4.readLine();
                }
            }
            read4.close();
            while (reading5 != null) {
                if (reading5.equals(studentToLookup.getID())) {
                    check = 1;
                    String id = reading5;
                    String name = read5.readLine();
                    int agee = Integer.parseInt(read5.readLine());
                    String residence = read5.readLine();
                    String majorr = read5.readLine();
                    String statee = read5.readLine();
                    String firstNamee = name.substring(name.indexOf(" ") + 1, name.length());
                    String lastNamee = name.substring(0, name.indexOf(","));
                    firstNamee = toNameCase(firstNamee);
                    lastNamee = toNameCase(lastNamee);
                    lookedupStudent = new OhioStateStudent(agee, firstNamee, lastNamee, statee, majorr, residence);
                    break;
                } else {
                    reading5 = read5.readLine();
                }
            }
            read5.close();


        } catch (IOException e) {
            System.out.println();
        }
        return check == 1;
    }

    /**
     * The {@code toNameCase} method should take a {@code String} parameter, and convert it to "name case". Name
     * Case is represented by the String having a capitalized first letter, and the rest of the {@code String} being
     * lowercase. For example:
     * <p>
     * Given a String - purdue
     * This method should convert it to say - Purdue
     * <p>
     * Given a String - dunsmore
     * This method should convert it to say - Dunsmore
     *
     * @param str the wrongly formatted {@code String} that must be converted to name case
     * @return the correctly formatted String, following name case standards.
     */
    private static String toNameCase(String str) {
        String part1 = str.substring(0, 1);
        String part2 = str.substring(1, str.length());
        part1 = part1.toUpperCase();
        part2 = part2.toLowerCase();
        return part1 + part2;
    }
}
