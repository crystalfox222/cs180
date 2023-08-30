import java.io.*;
import java.util.ArrayList;

/**
 * User
 * <p>
 * This class deals with the files for patron and employee
 * <p>
 * Used stack overflow occasionally
 *
 * @author Edythe Thompson, L09
 * @version 3-30-2020
 */
public class User {
    private ArrayList<Employee> employees = new ArrayList<>();
    private ArrayList<Patron> patrons = new ArrayList<>();

    User() {
    }

    public void loadUsers(File employeeRecords, File patronRecords) throws IOException, UnsupportedFileException {
        BufferedReader bread = new BufferedReader(new FileReader(employeeRecords));
        BufferedReader bread2 = new BufferedReader(new FileReader(patronRecords));
        if (!employeeRecords.exists()) {
            throw new FileNotFoundException();
        }
        if (!patronRecords.exists()) {
            throw new FileNotFoundException();
        }

        String read = bread.readLine();
        Employee employee = null;
        while (read != null) {
            String[] values = read.split(", ", 6);
            if (values.length < 6) {
                throw new UnsupportedFileException("employee");
            }
            String[] action;
            ArrayList<String> actions = new ArrayList<>();
            if (values.length >= 6) {
                action = values[5].split(" ");
                for (String text : action) { //tutorials point
                    actions.add(text);
                }
            }
            int id = Integer.parseInt(values[0]);
            String name = values[1];
            String address = values[2];
            double hourlyRate = Double.parseDouble(values[3]);
            double hoursWorked = Double.parseDouble(values[4]);

            employee = new Employee(id, name, address, hourlyRate, hoursWorked, actions);

            this.employees.add(employee);
            read = bread.readLine();
        }
        bread.close();

        String read2 = bread2.readLine();
        Patron patron = null;
        while (read2 != null) {
            String[] value = read2.split(", ", 6);
            if (value.length < 6) {
                throw new UnsupportedFileException("patron");
            }
            String[] bookLoan;
            ArrayList<Integer> bookLoanList = new ArrayList<>();
            if (value.length >= 6) {
                bookLoan = value[5].split(" ");
                for (String text : bookLoan) { //tutorials point
                    bookLoanList.add(Integer.parseInt(text));
                }
            }
            int id = Integer.parseInt(value[0]);
            String name = value[1];
            String address = value[2];
            String email = value[3];
            String phoneNumber = value[4];

            patron = new Patron(id, name, address, email, phoneNumber, bookLoanList);

            this.patrons.add(patron);
            read2 = bread2.readLine();
        }
        bread2.close();


    }

    public void writeUsers(File employeeRecords, File patronRecords) throws FileNotFoundException {
        FileOutputStream fos;
        FileOutputStream fos2;
        PrintWriter pw = null;
        PrintWriter pw2 = null;

        fos = new FileOutputStream(employeeRecords, false);
        fos2 = new FileOutputStream(patronRecords, false);
        pw = new PrintWriter(fos);
        pw2 = new PrintWriter(fos2);
        int a;
        for (a = 0; a < employees.size(); a++) {
            employees.get(a);
            String actionList = employees.get(a).getActionList().toString();
            actionList = actionList.substring(1, employees.get(a).getActionList().toString().length() - 1);
            int index = actionList.indexOf(",");
            while (actionList.contains(",")) {
                actionList = actionList.replace(",", "");
            }
            pw.println(employees.get(a).getId() + ", " + employees.get(a).getName()
                    + ", " + employees.get(a).getAddress() + ", " +
                    String.format("%.2f", employees.get(a).getHourlyRate()) + ", " +
                    String.format("%.0f", employees.get(a).getHoursWorked()) + ", " + actionList);
        }
        pw.close();

        for (a = 0; a < patrons.size(); a++) {
            patrons.get(a);
            String bookLoanList = patrons.get(a).getBookLoanList().toString();
            bookLoanList = bookLoanList.substring(1, patrons.get(a).getBookLoanList().toString().length() - 1);
            int index = bookLoanList.indexOf(",");
            while (bookLoanList.contains(",")) {
                bookLoanList = bookLoanList.replace(",", "");
            }
            pw2.println(patrons.get(a).getId() + ", " + patrons.get(a).getName()
                    + ", " + patrons.get(a).getAddress() + ", " + patrons.get(a).getEmail() + ", " +
                    patrons.get(a).getPhoneNumber() + ", " + bookLoanList);
        }
        pw2.close();


    }

    public void addEmployee(Employee employee) {
        employees.add(employee);

    }

    public void addPatron(Patron patron) {
        patrons.add(patron);
    }

    public boolean removeEmployee(int id) {
        int check = 0;
        int i = 0;
        for (i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId() == id) {
                check = 1;
                break;
            } else {

            }
        }
        if (check == 1) {
            this.employees.remove(employees.get(i));
            return true;
        } else {
            return false;
        }

    }

    public boolean removePatron(int id) {
        int check = 0;
        int i = 0;
        for (i = 0; i < patrons.size(); i++) {
            if (patrons.get(i).getId() == id) {
                check = 1;
                break;
            } else {

            }
        }
        if (check == 1) {
            this.patrons.remove(patrons.get(i));
            return true;
        } else {
            return false;
        }


    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    public void setPatrons(ArrayList<Patron> patrons) {
        this.patrons = patrons;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public ArrayList<Patron> getPatrons() {
        return patrons;
    }
}
