import java.util.ArrayList;

/**
 * Patron
 * <p>
 * This class stores people who get books
 * <p>
 * Used stack overflow occasionally
 *
 * @author Edythe Thompson, L09
 * @version 3-30-2020
 */
public class Patron {
    private int id;
    private String name;
    private String address;
    private String email;
    private String phoneNumber;
    private ArrayList<Integer> bookLoanList = new ArrayList<>();

    public Patron(int id, String name, String address, String email, String phoneNumber,
                  ArrayList<Integer> bookLoanList) throws UnsupportedFileException {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.bookLoanList = bookLoanList;
    }

    public void updateBookLoanList(int bookID) {
        Catalog catalog = new Catalog();
        int i = 0;
        int check = 0;
        for (i = 0; i < bookLoanList.size(); i++) {
            if (bookLoanList.get(i) == bookID) {
                check = 1;
                break;
            } else {
            }
        }
        if (check == 1) {
            bookLoanList.remove(bookLoanList.get(i));
        } else {
            bookLoanList.add(bookID);
        }

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBookLoanList(ArrayList<Integer> bookLoanList) {
        this.bookLoanList = bookLoanList;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public ArrayList<Integer> getBookLoanList() {
        return bookLoanList;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
