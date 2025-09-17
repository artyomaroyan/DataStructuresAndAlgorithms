package arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Author: Artyom Aroyan
 * Date: 02.09.25
 * Time: 21:42:23
 * Task018
 * Find the frequency of each element.
 * Explanation: Use a HashMap to count.
 * Hint: Java's HashMap<Integer, Integer> is your friend.
 */
public class FindTheFrequencyOfEachElement {
    private static final Logger log = Logger.getLogger(FindTheFrequencyOfEachElement.class.getName());

    public static void main(String[] args) {
        test("Test_1", new int[]{-3, 3, -1, -1, 0, 1, -5, -4, -5, -2});
        test("Test_2", new int[]{1, 1, 0, 1, 1, 0, 3, -4, 1, 4, 0});
        test("Test_3", new int[]{-4, -2, 1, -2, 1, 4, 0, 1, 2, -3, -5, -5});
        test("Test_4", new int[]{1, 3, -3, -2, 0, 3, 4, -3, -2, -4, -1});
    }

    private static void test(String label, int[] array) {
        Map<Integer, Integer> result = frequencyOfEachElement(array);
        log.info(() -> label + " result: " + result);
    }

    private static HashMap<Integer, Integer> frequencyOfEachElement(int[] array) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // option 1
        for (int num : array) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return map;

        // option 2
//        for (int num : array) {
//            if (map.containsKey(num)) {
//                int oldCount = map.get(num);
//                map.put(num, oldCount + 1);
//            } else {
//                map.put(num, 1);
//            }
//        }
//        return map;
    }
}