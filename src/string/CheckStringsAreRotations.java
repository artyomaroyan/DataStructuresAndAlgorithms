package string;

import java.util.logging.Logger;

/**
 * Author: Artyom Aroyan
 * Date: 28.09.25
 * Time: 16:53:05
 * Task011
 * Check if two strings are rotations of each other.
 */
public class CheckStringsAreRotations {
    private static final Logger log = Logger.getLogger(CheckStringsAreRotations.class.getName());

    public static void main(String[] args) {
        test("Test_1", "listen", "silent");
        test("Test_2", "hello", "helol");
        test("Test_3", "abcd", "cdab");
        test("Test_4", "like", "ekild");
    }

    private static void test(String label, String str1, String str2) {
        var result1 = isRotations(str1, str2);
        log.info(() -> label + " result: " + result1);
    }

    private static boolean isRotations(String str1, String str2) {
        if (str1.length() != str2.length() || str1.isEmpty()) {
            return false;
        }
        String doubled = str1 + str1;
        return doubled.contains(str2);
    }
}