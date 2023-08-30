import java.util.ArrayList;

/**
 * Employee
 * <p>
 * This class organizes employees
 * <p>
 * Used stack overflow occasionally
 *
 * @author Edythe Thompson, L09
 * @version 3-30-2020
 */
public class Employee {
    private int id;
    private String name;
    private String address;
    private double hourlyRate;
    private double hoursWorked;
    private ArrayList<String> actionList = new ArrayList<>();

    public Employee(int id, String name, String address, double hourlyRate,
                    double hoursWorked, ArrayList<String> actionList) throws UnsupportedFileException {
        this.id = id;
        this.name = name;
        this.address = address;
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
        this.actionList = actionList;

    }

    public Employee() {

    }

    public void recordAction(int patronId, int bookId, int code) {
        String action = String.valueOf(patronId) + "-" + String.valueOf(bookId) + "-" + String.valueOf(code);
        actionList.add(action);

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setActionList(ArrayList<String> actionList) {
        this.actionList = actionList;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public ArrayList<String> getActionList() {
        return actionList;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }
}
