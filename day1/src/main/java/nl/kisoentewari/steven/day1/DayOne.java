package nl.kisoentewari.steven.day1;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class DayOne {

    public static void main(String[] args) throws URISyntaxException, IOException {
        String input = retrieveInput();

        CaptchaCalculator captchaCalculator = new CaptchaCalculator();
        System.out.println(captchaCalculator.calculatePartOne(input));
        System.out.println(captchaCalculator.calculatePartTwo(input));
    }

    private static String retrieveInput() throws URISyntaxException, IOException {
        URL fileUrl = DayOne.class.getClassLoader().getResource("input.txt");
        if (fileUrl == null) {
            throw new RuntimeException("Could not read input");
        }

        List<String> allLines = Files.readAllLines(Paths.get(fileUrl.toURI()));
        return allLines.stream().collect(Collectors.joining());
    }
}
