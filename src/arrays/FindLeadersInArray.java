package arrays;

import java.util.Arrays;
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

    public static void main(String[] args) {

    }

    private static void test(String label, int[] array) {
        logger.info(() -> " " + Arrays.toString(array));
    }
}