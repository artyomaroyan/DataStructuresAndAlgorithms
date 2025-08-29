package arrays;

import java.util.Arrays;
import java.util.logging.Logger;

/**
 * Author: Artyom Aroyan
 * Date: 29.08.25
 * Time: 23:09:03
 * Task 015
 * Segregate even and odd numbers.
 * Explanation: Move even numbers to the beginning, odd numbers to the end.
 * Hint: Use two pointers (low, high).
 */
public class SegregateNumbers {
    private static final Logger logger = Logger.getLogger(SegregateNumbers.class.getName());

    public static void main(String[] args) {
        test("Test_1", new int[] {68, 92, 28, 42, 52, 33, 87, 27, 53, 42, 79, 58, 83, 9, 14, 53, 4, 74});
        test("Test_2", new int[] {20, 12, 85, 34, 0, 13, 1, 58, 76, 55, 83, 64, 24, 80, 70, 51, 64});
        test("Test_3", new int[] {3, 36, 67, 88, 9, 8, 35, 62, 44, 19, 62, 0, 7, 70, 53, 2, 78, 46, 40, 58, 53, 51, 2, 39, 22, 74, 73});
        test("Test_4", new int[] {89, 76, 87, 24, 44, 26, 87, 28, 35, 92, 70, 83, 17, 22, 81, 43, 98, 30, 88});

    }

    private static void test(String label, int[] array) {
        logger.info(() -> label + " before segregate " + Arrays.toString(array));
        segregateEvenAndOdd(array);
        logger.info(() -> label + " after segregate " + Arrays.toString(array));
    }

    private static void segregateEvenAndOdd(int[] array) {
        if (array == null || array.length < 1) return;

        int low = 0;
        int high = array.length - 1;

        while (low < high) {
            while (low < high && array[low] % 2 == 0) low++;
            while (low < high && array[high] % 2 != 0) high--;

            if (low < high) {
                int temp = array[low];
                array[low] = array[high];
                array[high] = temp;
            }
        }
    }
}