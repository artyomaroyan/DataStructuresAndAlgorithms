package string;

import java.util.logging.Logger;

/**
 * Author: Artyom Aroyan
 * Date: 28.09.25
 * Time: 16:55:53
 * Task012
 * Implement strstr() (indexOf) function.
 */
public class ImplementFunction {
    private static final Logger log = Logger.getLogger(ImplementFunction.class.getName());

    static void main() {
        test("Test_1", "listen", "st");
        test("Test_2", "hello", "ll");
        test("Test_3", "abcdef", "de");
        test("Test_4", "abcdef", "xy");
        test("Test_4", "aaaaa", "aaa");
    }

    private static void test(String label, String str1, String str2) {
        int result1 = customIndexOf(str1, str2);
        log.info(() -> label + " result1: " + result1);
        int result2 = customIndexOfKMP(str1, str2);
        log.info(() -> label + " result2: " + result2);
    }

    private static int customIndexOf(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();

        if (m == 0) return 0;
        if (n < m) return -1;

        for (int i = 0; i <= n - m; i++) {
            int j = 0;

            while (j < m && text.charAt(i + j) == pattern.charAt(j)) {
                j++;
            }
            if (j == m) {
                return i;
            }
        }
        return -1;
    }

    // KMP -> Knuth–Morris–Pratt
    private static int customIndexOfKMP(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();

        if (m == 0) return 0;
        if (n < m) return -1;

        int[] lps = buildLPS(pattern);
        int i = 0;
        int j = 0;

        while (i < n) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
                if (j == m) return i - j;
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    j++;
                }
            }
        }
        return -1;
    }

    // LPS -> Knuth–Morris–Pratt
    private static int[] buildLPS(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m];
        int len = 0;
        int i = 1;

        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;

            } else {
                if (len != 0) {
                    len = lps[len - 1];

                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}