package arrays;

import java.util.Arrays;
import java.util.logging.Logger;

/**
 * Author: Artyom Aroyan
 * Date: 18.08.25
 * Time: 23:28:30
 * Task 010
 * Explanation: Move all elements one step left, and put the first element at the last.
 * Hint: Save the first element before shifting.
 */
public class LeftRotateAnArrayByOnePosition {
    private static final Logger logger = Logger.getLogger(LeftRotateAnArrayByOnePosition.class.getName());

    public static void main(String[] args) {
        test("Test_1", new int[] {71, 54, 14, 28, 10, 39, 5, 2, 68, 14, 23, 38});
        test("Test_2", new int[] {4, 17, 17, 61, 29, 13, 34, 78, 84, 45, 73});
        test("Test_3", new int[] {12});
        test("Test_4", new int[] {});
    }

    private static void test(String label, int[] array) {
        logger.info(() -> label + " before rotate " + Arrays.toString(array));
        leftRotateViaXOR(array);
        logger.info(() -> label + " after rotate" + Arrays.toString(array));

    }

    private static void leftRotate(int[] array) {
        if (array == null || array.length < 1) return;

        int first = array[0];
        for (int i = 1; i < array.length; i++) {
            array[i - 1] = array[i];
        }
        array[array.length - 1] = first;
    }

    private static void leftRotateViaXOR(int[] array) {
        if (array == null || array.length < 1) return;

        for (int i = 0; i < array.length - 1; i++) {
            array[i] = array[i] ^ array[i + 1];
            array[i + 1] = array[i] ^ array[i + 1];
            array[i] = array[i] ^ array[i + 1];
        }
    }
}