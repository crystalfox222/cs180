import java.io.File;
import java.io.IOException;

public class Testing {
    public static void main(String[] args) throws IOException, UnsupportedFileException {
      /* User user = new User();
        File employee = new File("employee.txt");
        File patron = new File("patron.txt");
        user.loadUsers(employee, patron);
        File outputEmp = new File("outputemp.txt");
        File outputPat = new File("outputpat.txt");
        user.writeUsers(outputEmp, outputPat); */
        File book = new File("book.txt");
        Catalog catalog = new Catalog();
        catalog.loadCatalog(book);
        catalog.findBooks("bad");
        File output = new File("outputbook.txt");
        catalog.writeCatalog(output);
    }
}
