package nl.kisoentewari.steven.day1;

public class CaptchaCalculator {

    public int calculatePartOne(String digitString) {
        String[] digits = digitString.split("");
        int sum = 0;
        for (int i = 0, digitsLength = digits.length; i < digitsLength; i++) {
            String digit = digits[i];
            String nextDigit;
            if (i >= digitsLength - 1) {
                nextDigit = digits[0];
            } else {
                nextDigit = digits[i + 1];
            }

            if (digit.equals(nextDigit)) {
                sum += Integer.valueOf(digit);
            }
        }

        return sum;
    }

    public int calculatePartTwo(String digitString) {
        String[] digits = digitString.split("");
        int sum = 0;
        for (int i = 0, digitsLength = digits.length; i < digitsLength; i++) {
            String digit = digits[i];
            int digitStep = digitsLength / 2;
            if (i + digitStep >= digitsLength) {
                continue;
            }

            String nextDigit = digits[i + digitStep];
            if (digit.equals(nextDigit)) {
                sum += Integer.valueOf(digit) * 2;
            }
        }

        return sum;
    }

}
