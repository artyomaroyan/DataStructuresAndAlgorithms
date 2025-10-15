package arrays;

import java.util.Arrays;
import java.util.logging.Logger;

/**
 * Author: Artyom Aroyan
 * Date: 28.08.25
 * Time: 01:21:31
 * Task 013
 * Find the number that appears once when all others appear twice.
 * Explanation: Use XOR. x^x = 0, and x^0 = x.
 * Hint: XOR all elements together.
 */
public class FindTheNumber {
    private static final Logger logger = Logger.getLogger(FindTheNumber.class.getName());

    static void main() {
        test("Test_1", new int[] {1, 2, 3, 4, 3, 2, 1});
        test("Test_2", new int[] {7, 3, 5, 1, 5, 3, 7});
        test("Test_3", new int[] {2, 2, 1});
        test("Test_4", new int[] {10, 20, 10, 30, 20});
    }

    private static void test(String label, int[] array) {
        logger.info(() -> " original array: " + Arrays.toString(array));
        int num = xorArray(array);
        logger.info(() -> label + " unique number is: " + num);
    }

    private static int xorArray(int[] array) {
        int xor = 0;
        for (int num : array) {
            xor ^= num;
        }
        return xor;
    }
}