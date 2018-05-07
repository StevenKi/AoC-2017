package day2;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class DayTwo {

    public static void main(String[] args) throws IOException, URISyntaxException {
        List<String> input = retrieveInput();
        ChecksumCalculator checksumCalculator = new ChecksumCalculator();
        System.out.println(checksumCalculator.calculatePartOne(input));
        System.out.println(checksumCalculator.calculatePartTwo(input));
    }

    private static List<String> retrieveInput() throws URISyntaxException, IOException {
        URL fileUrl = DayTwo.class.getClassLoader().getResource("input.txt");
        if (fileUrl == null) {
            throw new RuntimeException("Could not read input");
        }

        List<String> allLines = Files.readAllLines(Paths.get(fileUrl.toURI()));
        return allLines;
    }
}
