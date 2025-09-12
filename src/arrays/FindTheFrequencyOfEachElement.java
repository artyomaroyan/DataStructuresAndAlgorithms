package arrays;

import java.util.Arrays;
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

    }

    private static void test(String label, int[] array) {
        log.info(() -> label + " result: " + Arrays.toString(array));
    }

    private static void findSumSubarray(int[] array) {
        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;
    }
}