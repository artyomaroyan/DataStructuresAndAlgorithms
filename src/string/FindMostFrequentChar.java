package string;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: Artyom Aroyan
 * Date: 05.10.25
 * Time: 22:45:33
 * Task018
 * Find the most frequent character.
 */
public class FindMostFrequentChar {
    static void main() {
        test("Test_1 ", "java, c++, python, c#");
        test("Test_2 ", "one, two, three, four");
        test("Test_3 ", "count words  in  the  array of string");
        test("Test_4 ", "test different   conditions for   logic,   ");
        test("Test_5 ", " Spring boot, spring WebFlux");
    }

    private static void test(String label, String str) {
        var method1 = mostCommonChar(str);
        IO.println(label + " method_1 " + method1);
    }

    private static Map.Entry<Character, Integer> mostCommonChar(String str) {
        if (str == null || str.isEmpty()) return null;

        HashMap<Character, Integer> count = new HashMap<>();
        str = str.toLowerCase();

        for (char ch : str.toCharArray()) {
            if (Character.isWhitespace(ch)) continue;
            count.put(ch, count.getOrDefault(ch, 0) + 1);
        }

        Map.Entry<Character, Integer> mostCommon = null;

        for (Map.Entry<Character, Integer> entry : count.entrySet()) {
            if (mostCommon == null || entry.getValue() > mostCommon.getValue()) {
                mostCommon = entry;
            }
        }
        return mostCommon;
    }
}