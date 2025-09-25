package string;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Author: Artyom Aroyan
 * Date: 23.09.25
 * Time: 17:17:29
 * Task007
 * Find the first non-repeating character.
 */
public class FindFirstNonRepeatingChar {
    private static final Logger log = Logger.getLogger(FindFirstNonRepeatingChar.class.getName());

    public static void main(String[] args) {
        test("Test_1", "swiss");
        test("Test_2", "level");
        test("Test_3", "aabbcc");
        test("Test_4", "abcde");
    }

    private static void test(String label, String str1) {
        var result1 = findFirstNonRepeatingCharLinkedHashMap(str1);
        log.info(() -> label + " result_1: " + result1);
        char result2 = findFirstNonRepeatingCharArray(str1);
        log.info(() -> label + " result2: " + result2);
    }

    private static char findFirstNonRepeatingCharLinkedHashMap(String input) {
        Map<Character, Integer> count = new LinkedHashMap<>();
        for (char ch : input.toCharArray()) {
            count.put(ch, count.getOrDefault(ch, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : count.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return '0';
    }

    private static char findFirstNonRepeatingCharArray(String input) {
        int[] count = new int[26];
        for (char ch : input.toCharArray()) {
            count[ch - 'a']++;
        }

        for (char ch : input.toCharArray()) {
            if (count[ch - 'a'] == 1) {
                return ch;
            }
        }
        return '0';
    }
}