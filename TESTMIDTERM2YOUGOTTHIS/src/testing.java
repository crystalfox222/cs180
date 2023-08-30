import java.io.File;
import java.io.IOException;

public class testing {
    public static void main(String[] args) throws IOException {
        Stats stats = new Stats();
        File file;
        stats.readFile(file = new File("casestestNumberFormatEx.txt"));
    }
}
