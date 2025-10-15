package arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Author: Artyom Aroyan
 * Date: 29.08.25
 * Time: 23:19:25
 * Task016
 * Explanation: Traverse from right to left, track maximum so far.
 * Hint: Last element is always a leader.
 */
public class FindLeadersInArray {
    private static final Logger logger = Logger.getLogger(FindLeadersInArray.class.getName());

    static void main() {
        test("Test_1", new int[]{16, 17, 4, 3, 5, 2});
        test("Test_2", new int[]{5, 90, 69, 9, 50, 27, 7, 34, 66});
        test("Test_3", new int[]{63, 19, 53, 28, 55, 13, 53, 6769, 5, 3, 4, 63, 81, 57, 39});
        test("Test_4", new int[]{21, 43, 90, 58, 92, 38, 70, 86, 87, 68, 40, 17, 91, 55, 16, 43});
    }

    private static void test(String label, int[] array) {
        var result = findLeaders(array);
        logger.info(() -> label + " leader numbers are " + result);
    }

    private static List<Integer> findLeaders(int[] array) {
        int leader = Integer.MIN_VALUE;
        List<Integer> leaders = new ArrayList<>();

        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] >= leader) {
                leaders.add(array[i]);
                leader = array[i];
            }
        }
        return leaders;
    }
}