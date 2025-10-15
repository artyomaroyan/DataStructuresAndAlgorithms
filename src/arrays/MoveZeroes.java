package arrays;

import java.util.Arrays;
import java.util.logging.Logger;

/**
 * Author: Artyom Aroyan
 * Date: 29.08.25
 * Time: 22:42:40
 * Task 014
 * Move all zeroes to end.
 * Explanation: Traverse array, maintain count of non-zero elements, and rearrange.
 * Hint: Think two pointers.
 */
public class MoveZeroes {
    private static final Logger logger = Logger.getLogger(MoveZeroes.class.getName());

    static void main() {
        test("Test_1", new int[]{0, 2, 33, 0, 65, 1, 7, 90});
        test("Test_2", new int[]{32, 1, 4, 7, 43, 0, 23, 30, 434, 0, 1, 0});
        test("Test_3", new int[]{10, 31, 57, 0, 2, 4, 120, 32, 78, 9});
        test("Test_4", new int[]{0, 0, 12, 0, 32, 54, 0, 231, 0, 0, 34});
    }

    private static void test(String label, int[] array) {
        moveZeroes(array);
        logger.info(() -> label + " after move: " + Arrays.toString(array));
    }

    private static void moveZeroes(int[] array) {
        if (array == null || array.length == 0) return;

        int position = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                array[position] = array[i];
                position++;
            }
        }

        while (position < array.length) {
            array[position] = 0;
            position++;
        }
    }
}