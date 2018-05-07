import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class DaySeven {

    public static void main(String[] args) throws URISyntaxException, IOException {
        List<String> input = retrieveInput();

    }

    private static List<String> retrieveInput() throws URISyntaxException, IOException {
        URL fileUrl = DaySeven.class.getClassLoader().getResource("input.txt");
        if (fileUrl == null) {
            throw new RuntimeException("Could not read input");
        }

        List<String> allLines = Files.readAllLines(Paths.get(fileUrl.toURI()));
        return allLines;
    }
}
