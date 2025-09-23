package string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.logging.Logger;

/**
 * Author: Artyom Aroyan
 * Date: 22.09.25
 * Time: 21:52:19
 * Task005
 * Check if two strings are anagrams.
 */
public class CheckForAnagrams {
    private static final Logger logger = Logger.getLogger(CheckForAnagrams.class.getName());

    public static void main(String[] args) {
        test("Test_1", "listen", "silent");
        test("Test_2", "evil", "vile");
        test("Test_3", "hello", "world");
        test("Test_4", "like", "dislike");
    }

    private static void test(String label, String str1, String str2) {
        boolean result1 = isAnagramSorting(str1, str2);
        logger.info(() -> label + " result1: " + result1);
        boolean result2 = isAnagramHashMap(str1, str2);
        logger.info(() -> label + " result2: " + result2);
    }

    private static boolean isAnagramSorting(String str1, String str2) {
        str1 = str1.replaceAll("\\s", "").toLowerCase();
        str2 = str2.replaceAll("\\s", "").toLowerCase();

        if (str1.length() != str2.length()) {
            return false;
        }

        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        return Arrays.equals(chars1, chars2);
    }

    private static boolean isAnagramHashMap(String str1, String str2) {
        str1 = str1.replaceAll("\\s", "").toLowerCase();
        str2 = str2.replaceAll("\\s", "").toLowerCase();

        if (str1.length() != str2.length()) {
            return false;
        }

        HashMap<Character, Integer> count = new HashMap<>();

        for (char ch : str1.toCharArray()) {
            count.put(ch, count.getOrDefault(ch, 0) + 1);
        }

        for (char ch : str2.toCharArray()) {
            if (!count.containsKey(ch)) {
                return false;
            }
            count.put(ch, count.get(ch) - 1);
            if (count.get(ch) == 0) {
                count.remove(ch);
            }
        }
        return count.isEmpty();
    }
}