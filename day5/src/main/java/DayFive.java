import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class DayFive {

    public static void main(String[] args) throws IOException, URISyntaxException {
        List<String> input = retrieveInput();
        List<Integer> maze = input.stream().map(Integer::valueOf).collect(Collectors.toList());

        MazeCalculator mazeCalculator = new MazeCalculator();
        System.out.println(mazeCalculator.countStepsToExitPartOne(maze));
        System.out.println(mazeCalculator.countStepsToExitPartTwo(maze));
    }

    private static List<String> retrieveInput() throws URISyntaxException, IOException {
        URL fileUrl = DayFive.class.getClassLoader().getResource("input.txt");
        if (fileUrl == null) {
            throw new RuntimeException("Could not read input");
        }

        List<String> allLines = Files.readAllLines(Paths.get(fileUrl.toURI()));
        return allLines;
    }

}
