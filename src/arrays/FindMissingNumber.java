package arrays;

import java.util.logging.Logger;

/**
 * Author: Artyom Aroyan
 * Date: 28.08.25
 * Time: 01:20:49
 * Task 012
 * Find missing number in a sequence 1 to n.
 * Explanation: Sum 1 to n formula is n*(n+1)/2. Subtract sum of array from this.
 * Hint: Handle overflow if n is large.
 */
public class FindMissingNumber {
    private static final Logger logger = Logger.getLogger(FindMissingNumber.class.getName());

    static void main() {
        test("Test_1", new int[] {1, 2, 3, 5, 6}, 6);
        test("Test_2", new int[] {1, 2, 3, 4, 5, 7, 8}, 8);
        test("Test_3", new int[] {2, 3, 4, 5, 6, 7, 8, 9, 10, 11}, 11);
        test("Test_4", new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12}, 12);
    }

    private static void test(String label, int[] array, int n) {
        int sumResult = findMissingBySum(array, n);
        int xorResult = findMissingByXor(array, n);
        logger.info(() -> label + " (Sum method) missing number is: " + sumResult);
        logger.info(() -> label + " (XOR method) missing number is: " + xorResult);
    }

    private static int findMissingBySum(int[] array, int n) {
        long expected = (long) n * (n + 1) / 2;
        int actual = 0;
        for (int num : array) {
            actual += num;
        }
        return (int) (expected - actual);
    }

    private static int findMissingByXor(int[] array, int n) {
        int xor1 = 0;
        for (int i = 1; i <= n; i++) {
            xor1 ^= i;
        }

        int xor2 = 0;
        for (int num : array) {
            xor2 ^= num;
        }
        return xor1 ^ xor2;
    }
}