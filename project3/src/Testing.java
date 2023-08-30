import java.io.File;
import java.io.IOException;

public class Testing {
    public static void main(String[] args) throws IOException, UnsupportedFileException {
       User user = new User();
        File employee = new File("employee.txt");
        File patron = new File("patron.txt");
        user.loadUsers(employee, patron);
        File output = new File("output.txt");
        user.writeUsers(output, output);
      /* File book = new File("book.txt");
       Catalog catalog = new Catalog();
       catalog.loadCatalog(book);
       File output = new File("output.txt");
       catalog.writeCatalog(output); */
    }
}
