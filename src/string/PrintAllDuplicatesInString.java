package string;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Author: Artyom Aroyan
 * Date: 25.09.25
 * Time: 15:45:15
 * Task009
 * Print all duplicates in the input string.
 */
public class PrintAllDuplicatesInString {
    private static final Logger log = Logger.getLogger(PrintAllDuplicatesInString.class.getName());

    public static void main(String[] args) {
        test("Test_1", "cYnBkbVMTjPdmJT");
        test("Test_2", "JTkTKANNwMEfiij");
        test("Test_3", "PMjksQTaMyIFdOy");
        test("Test_4", "KtHtCSVfnIWNLUw");
    }

    private static void test(String label, String str1) {
        var result1 = printDuplicatesMap(str1);
        log.info(() -> label + " result_1: " + result1);
        var result2 = printDuplicatesInt(str1);
        log.info(() -> label + " result_2: " + result2);
    }

    private static Map<Character, Integer> printDuplicatesMap(String input) {
        Map<Character, Integer> count = new HashMap<>();
        for (char ch : input.toCharArray()) {
            count.put(ch, count.getOrDefault(ch, 0) + 1);
        }
        Map<Character, Integer> duplicates = new HashMap<>();
        for (Map.Entry<Character, Integer> entry : count.entrySet()) {
            if (entry.getValue() > 1) {
                duplicates.put(entry.getKey(), entry.getValue());
            }
        }
        return duplicates;
    }

    private static Map<Character, Integer> printDuplicatesInt(String input) {
        int[] count = new int[256];
        for (char ch : input.toCharArray()) {
            count[ch]++;
        }
        Map<Character, Integer> duplicates = new HashMap<>();
        for (char ch : input.toCharArray()) {
            if (count[ch] > 1) {
                duplicates.put(ch, count[ch]);
                count[ch] = 0;
            }
        }
        return duplicates;
    }
}