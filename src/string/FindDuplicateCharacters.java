package string;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Author: Artyom Aroyan
 * Date: 22.09.25
 * Time: 21:32:38
 * Task004
 * Find duplicate characters in a string.
 */
public class FindDuplicateCharacters {
    private static final Logger logger = Logger.getLogger(FindDuplicateCharacters.class.getName());

    public static void main(String[] args) {
        test("Test_1", "klllasda");
        test("Test_2", "asdawer");
        test("Test_3", "vxcsdsd");
        test("Test_4", "ljfpwqeq");
    }

    private static void test(String label, String str) {
        var result = countDuplicates(str);
        logger.info(() -> label + " result: " + result);
    }

    private static Map<Character, Integer> countDuplicates(String str) {
        Map<Character, Integer> counts = new HashMap<>();
        for (char ch : str.toCharArray()) {
            counts.put(ch, counts.getOrDefault(ch, 0) + 1);
        }

        Map<Character, Integer> duplicates = new HashMap<>();
        for (var entry : counts.entrySet()) {
            if (entry.getValue() > 1) {
                duplicates.put(entry.getKey(), entry.getValue());
            }
        }
        return duplicates;
    }
}