package day2;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ChecksumCalculator {

    public int calculatePartOne(List<String> rows) {
        return rows.stream()
                .mapToInt(row -> {
                    String[] split = row.split("\\W");
                    int maxValue = Stream.of(split).mapToInt(Integer::valueOf).max().getAsInt();
                    int minValue = Stream.of(split).mapToInt(Integer::valueOf).min().getAsInt();

                    return maxValue - minValue;
                })
                .sum();
    }

    public int calculatePartTwo(List<String> rows) {
        return rows.stream()
                .mapToInt(row -> {
                    String[] split = row.split("\\W");
                    List<Integer> rowValues = Stream.of(split).map(Integer::valueOf).collect(Collectors.toList());

                    for (int i = 0, length = rowValues.size(); i < length; i++) {
                        Integer currentValue = rowValues.get(i);

                        for (Integer rowValue : rowValues) {
                            if (currentValue.equals(rowValue)) {
                                continue;
                            }

                            int remainder = currentValue % rowValue;
                            if (remainder == 0) {
                                return currentValue / rowValue;
                            }
                        }

                    }

                    return 0;
                })
                .sum();
    }
}
