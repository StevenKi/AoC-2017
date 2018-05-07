package day2;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ChecksumCalculatorTest {

    private ChecksumCalculator checksumCalculator;

    @Before
    public void setup() {
        checksumCalculator = new ChecksumCalculator();
    }

    @Test
    public void testCalculatePartOne() {
        List<String> rows = new ArrayList<>();
        rows.add("5\t1\t9\t5");
        rows.add("7\t5\t3");
        rows.add("2\t4\t6\t8");
        assertEquals(18, checksumCalculator.calculatePartOne(rows));
    }

    @Test
    public void testCalculatePartTwo() {
        List<String> rows = new ArrayList<>();
        rows.add("5\t9\t2\t8");
        rows.add("9\t4\t7\t3");
        rows.add("3\t8\t6\t5");
        assertEquals(9, checksumCalculator.calculatePartTwo(rows));
    }
}