package nl.kisoentewari.steven.day1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CaptchaCalculatorTest {

    private CaptchaCalculator captchaCalculator;

    @Before
    public void setup() {
        captchaCalculator = new CaptchaCalculator();
    }

    @Test
    public void testCalculatePartOne() {
        assertEquals(3, captchaCalculator.calculatePartOne("1122"));
        assertEquals(4, captchaCalculator.calculatePartOne("1111"));
        assertEquals(0, captchaCalculator.calculatePartOne("1234"));
        assertEquals(9, captchaCalculator.calculatePartOne("91212129"));
    }

    @Test
    public void testCalculatePartTwo() {
        assertEquals(6, captchaCalculator.calculatePartTwo("1212"));
        assertEquals(0, captchaCalculator.calculatePartTwo("1221"));
        assertEquals(4, captchaCalculator.calculatePartTwo("123425"));
        assertEquals(12, captchaCalculator.calculatePartTwo("123123"));
        assertEquals(4, captchaCalculator.calculatePartTwo("12131415"));

    }

}