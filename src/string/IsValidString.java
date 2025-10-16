package string;

import java.util.logging.Logger;

/**
 * Author: Artyom Aroyan
 * Date: 25.09.25
 * Time: 01:30:25
 * Task008
 * Check if a string is a valid shuffle of two strings.
 */
public class IsValidString {
    private static final Logger log = Logger.getLogger(IsValidString.class.getName());

    static void main() {
        test("Test_1", "abc", "def", "adbcef");
        test("Test_2", "abc", "def", "dabecf");
        test("Test_3", "xy", "12", "x1y2");
        test("Test_4", "xy", "12", "y1x2");
        test("Test_5", "asd", "", "asd");
        test("Test_6", "", "dsa", "dsa");
    }

    private static void test(String label, String str1, String str2, String result) {
        boolean result1 = isValidShuffle(str1, str2, result);
        log.info(() -> label + " result_1: " + result1);
    }

    private static boolean isValidShuffle(String str1, String str2, String result) {
        if (str1.length() + str2.length() != result.length()) {
            return false;
        }

        int i = 0;
        int j = 0;
        int k = 0;

        while (k < result.length()) {
            if (i < str1.length() && result.charAt(k) == str1.charAt(i)) {
                i++;
            } else if (j < str2.length() && result.charAt(k) == str2.charAt(j)) {
                j++;
            } else {
                return false;
            }
            k++;
        }
        return i == str1.length() && j == str2.length();
    }
}