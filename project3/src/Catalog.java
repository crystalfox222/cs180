import java.io.*;
import java.util.ArrayList;

/**
 * Catalog
 * <p>
 * This the organizing software
 * <p>
 * Used stack overflow occasionally
 *
 * @author Edythe Thompson, L09
 * @version 3-30-2020
 */
public class Catalog {
    private ArrayList<Book> catalog = new ArrayList<>();

    public Catalog() {
    }

    public void loadCatalog(File bookCatalog) throws IOException, UnsupportedFileException {
        BufferedReader bread = new BufferedReader(new FileReader(bookCatalog));
        if (!bookCatalog.exists()) {
            throw new FileNotFoundException();
        }
        bread = new BufferedReader(new FileReader(bookCatalog));

        String read = bread.readLine(); //StackOverflow
        Book book = null;
        while (read != null) { //ckOverflow
            String[] values = read.split(", ");
            if (values.length < 10) {
                throw new UnsupportedFileException("book");
            }

            int id = Integer.parseInt(values[0]);
            String title = values[1];
            String firstName = values[2];
            String lastName = values[3];
            String publisher = values[4];
            String publisherCity = values[5];

            int publicationYear = Integer.parseInt(values[6]);

            int numCheckouts = Integer.parseInt(values[7]);

            double purchasePrice = Double.parseDouble(values[8]);

            boolean currentlyLoaned = Boolean.parseBoolean(values[9]);

            book = new Book(id, title, firstName, lastName, publisher,
                    publisherCity, publicationYear, numCheckouts, purchasePrice, currentlyLoaned);

            this.catalog.add(book);
            read = bread.readLine();
        }
        bread.close();

    }

    public void writeCatalog(File bookCatalog) throws FileNotFoundException {

        FileOutputStream fos;
        PrintWriter pw = null;

        fos = new FileOutputStream(bookCatalog, false);
        pw = new PrintWriter(fos);
        int a;
        for (a = 0; a < catalog.size(); a++) {
            catalog.get(a);


            pw.println(catalog.get(a).getId() + ", " + catalog.get(a).getAuthorFirstName()
                    + ", " + catalog.get(a).getAuthorLastName() + ", " + catalog.get(a).getPublisher() + ", " +
                    catalog.get(a).getPublisherCity() + ", " + catalog.get(a).getPublicationYear()
                    + ", " + catalog.get(a).getNumCheckouts() + ", " + catalog.get(a).getPurchasePrice() + ", "
                    + catalog.get(a).isCurrentlyLoaned());
        }
        pw.close();

    }

    public void addBook(Book book) {
        this.catalog.add(book);
    }

    public boolean removeBook(int id) {
        int check = 0;
        for (int i = 0; i < catalog.size(); i++) {
            if (catalog.get(i).getId() == id) {
                check = 1;
                break;
            } else {

            }
        }
        if (check == 1) {
            this.catalog.remove(id);
            return true;
        } else {
            return false;
        }
    }

    public boolean loanBook(int id) {
        int check = 0;
        int i = 0;
        Book book = null;
        for (i = 0; i < catalog.size(); i++) {
            if (catalog.get(i).getId() == id && !catalog.get(i).isCurrentlyLoaned()) {
                check = 1;
                break;
            } else {
            }
        }
        if (check == 1) {
            catalog.get(i).setCurrentlyLoaned(true);
            catalog.get(i).setNumCheckouts(catalog.get(i).getNumCheckouts() + 1);
            removeBook(id);
            return true;

        } else {
            return false;
        }

    }

    public ArrayList<Book> findBooks(String search) {
        ArrayList<Book> list = new ArrayList<>();
        for (int i = 0; i < catalog.size(); i++) {
            if (catalog.get(i).getAuthorFirstName().toLowerCase().equals(search.toLowerCase())) {
                list.add(catalog.get(i));
            } else if (catalog.get(i).getAuthorFirstName().toLowerCase().equals(search.toLowerCase())) {
                list.add(catalog.get(i));
            } else if (catalog.get(i).getPublisher().toLowerCase().equals(search.toLowerCase())) {
                list.add(catalog.get(i));
            } else if (catalog.get(i).getPublisherCity().toLowerCase().equals(search.toLowerCase())) {
                list.add(catalog.get(i));
            } else {

            }
        }
        return list;
    }

    public ArrayList<Book> bookSale() {
        ArrayList<Book> list = new ArrayList<>();
        for (int i = 0; i < catalog.size(); i++) {
            if (catalog.get(i).getNumCheckouts() < 10) {
                list.add(catalog.get(i));
            } else {
            }
        }
        return list;
    }

    public double avgCostPerLoan() {
        double total = 0;
        for (int i = 0; i < catalog.size(); i++) {
            total = total + catalog.get(i).averageLoanCost();
        }
        return total / catalog.size();
    }

    public void printCatalogToFile(int mode, File newFile) throws FileNotFoundException {
        FileOutputStream fos;
        PrintWriter pw = null;
        int i;
        fos = new FileOutputStream(newFile, false);
        pw = new PrintWriter(fos);
        if (mode == 1) {

            for (i = 0; i < catalog.size(); i++) {
                pw.println("MLA: " + catalog.get(i).getAuthorLastName()
                        + ", " + catalog.get(i).getAuthorFirstName() + ". "
                        + catalog.get(i).getTitle() + ". " + catalog.get(i).getPublisher() + ", "
                        + catalog.get(i).getPublicationYear() + ".");
            }
            pw.close();

        } else if (mode == 2) {
            String firstLetter = "";
            for (i = 0; i < catalog.size(); i++) {
                firstLetter = catalog.get(i).getAuthorFirstName().substring(0, 1);
                pw.println("APA: " + catalog.get(i).getAuthorLastName() + ", " + firstLetter + ". ("
                        + catalog.get(i).getPublicationYear() + "). " + catalog.get(i).getTitle() + ". "
                        + catalog.get(i).getPublisherCity() + ": " + catalog.get(i).getPublisher() + ".");
            }
            pw.close();

        } else if (mode == 3) {
            String isCheckedOut = "";

            for (i = 0; i < catalog.size(); i++) {
                if (catalog.get(i).isCurrentlyLoaned()) {
                    isCheckedOut = "Yes";
                } else {
                    isCheckedOut = "No";
                }
                pw.println("CS: " + catalog.get(i).getAuthorLastName()
                        + ", " + catalog.get(i).getAuthorFirstName() + ". "
                        + catalog.get(i).getTitle() + ". Number of Checkouts: " + catalog.get(i).getNumCheckouts()
                        + ". Currently Checked Out: " + isCheckedOut + ".");
            }
            pw.close();


        }


    }

    public int numBooksLoaned() {
        int num = 0;
        for (int i = 0; i < catalog.size(); i++) {
            if (catalog.get(i).isCurrentlyLoaned()) {
                ++num;
            } else {
            }
        }
        return num;
    }

    public ArrayList<Book> getCatalog() {
        return catalog;
    }

    public void setCatalog(ArrayList<Book> catalog) {
        this.catalog = catalog;
    }
}
