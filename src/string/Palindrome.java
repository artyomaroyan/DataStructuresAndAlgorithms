package string;

import java.util.logging.Logger;

/**
 * Author: Artyom Aroyan
 * Date: 04.08.25
 * Time: 18:33:33
 * Task002
 */
public class Palindrome {
    private static final Logger logger = Logger.getLogger(Palindrome.class.getName());

    static void main() {
        test("Test_1", "madam");
        test("Test_2", "racecar");
        test("Test_3", "level");
        test("Test_4", "hello");
        test("Test_5", "java");
        test("Test_6", "world");
    }

    private static void test(String label, String str) {
        boolean result1 = isPalindrome(str);
        logger.info(() -> label + " Result_1: " + result1);
        boolean result2 = isPalindromeOdd(str);
        logger.info(() -> label + " Result_2: " + result2);
        boolean result3 = isPalindromeOdd2(str);
        logger.info(() -> label + " Result_3: " + result3);
    }

    // this is fine but this will return false for "racecar" but should return ture,
    // so I need to ignore middle char if lengt is odd number.
    private static boolean isPalindrome(String str) {
        String prefix = str.substring(0, str.length() / 2);
        String suffix = str.substring(str.length() / 2);
        StringBuilder sb = new StringBuilder(prefix);
        var reversed = sb.reverse().toString();
        return reversed.equals(suffix);
    }

    private static boolean isPalindromeOdd(String str) {
        int length = str.length();
        String prefix = str.substring(0, length / 2);
        String suffix = str.substring((length + 1) / 2); // skips middle char if odd
        return new StringBuilder(prefix).reverse().toString().equals(suffix);
    }

    private static boolean isPalindromeOdd2(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left++) != str.charAt(right--))
                return false;
        }
        return true;
    }
}