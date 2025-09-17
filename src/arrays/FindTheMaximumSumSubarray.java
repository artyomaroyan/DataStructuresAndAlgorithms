package arrays;

import java.util.logging.Logger;

/**
 * Author: Artyom Aroyan
 * Date: 02.09.25
 * Time: 21:41:39
 * Task016
 * Find the maximum sum subarray (Kadane's Algorithm - easy version).
 * Explanation: Maintain current sum and maximum sum.
 * Hint: If current sum drops below 0, reset to 0.
 */
public class FindTheMaximumSumSubarray {
    private static final Logger log = Logger.getLogger(FindTheMaximumSumSubarray.class.getName());

    public static void main(String[] args) {
        test("Test_1", new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        test("Test_2", new int[]{-26, -74, 80, 21, -12, -95, 64, 75, -41});
        test("Test_3", new int[]{-80, 21, -41, 13, -18, 26, 80, 2, 10, 29});
        test("Test_4", new int[]{-3, -5, -1});
    }

    private static void test(String label, int[] array) {
        int result = findMaxSum(array);
        log.info(() -> label + " result: " + result);
    }

    private static int findMaxSum(int[] array) {
        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int num : array) {
            currentSum += num;

            maxSum = Math.max(maxSum, currentSum);

            if (currentSum < 0) {
                currentSum = 0;
            }
        }
        return maxSum;
    }
}