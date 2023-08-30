/**
 * Book
 * <p>
 * This class creates the type "book"
 * <p>
 * Used stack overflow occasionally
 *
 * @author Edythe Thompson, L09
 * @version 3-30-2020
 */
public class Book {
    private int id;
    private String title;
    private String authorFirstName;
    private String authorLastName;
    private String publisher;
    private String publisherCity;
    private int publicationYear;
    private int numCheckouts;
    private double purchasePrice;
    private boolean currentlyLoaned;

    public Book(int id, String title, String authorFirstName, String authorLastName, String publisher,
                String publisherCity, int publicationYear, int numCheckouts, double purchasePrice,
                boolean currentlyLoaned) throws UnsupportedFileException {
        this.id = id;
        this.authorFirstName = authorFirstName;
        this.authorLastName = authorLastName;
        this.title = title;
        this.publisher = publisher;
        this.publisherCity = publisherCity;
        this.publicationYear = publicationYear;
        this.numCheckouts = numCheckouts;
        this.purchasePrice = purchasePrice;
        this.currentlyLoaned = currentlyLoaned;
    }

    public Book() {

    }

    public double averageLoanCost() {
        return purchasePrice / numCheckouts;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public void setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
    }

    public void setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
    }

    public void setCurrentlyLoaned(boolean currentlyLoaned) {
        this.currentlyLoaned = currentlyLoaned;
    }

    public void setNumCheckouts(int numCheckouts) {
        this.numCheckouts = numCheckouts;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setPublisherCity(String publisherCity) {
        this.publisherCity = publisherCity;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public int getId() {
        return id;
    }

    public int getNumCheckouts() {
        return numCheckouts;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getPublisherCity() {
        return publisherCity;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCurrentlyLoaned() {
        return currentlyLoaned;
    }
}
