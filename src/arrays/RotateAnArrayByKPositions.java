package arrays;

import java.util.Arrays;
import java.util.logging.Logger;

/**
 * Author: Artyom Aroyan
 * Date: 18.08.25
 * Time: 23:29:33
 * Task 011
 * Explanation: Rotate left/right by k. Do it efficiently, not by rotating one by one.
 * Hint: Try reversing parts of the array.
 */
public class RotateAnArrayByKPositions {
    private static final int K_POSITION = 2;
    private static final Logger logger = Logger.getLogger(RotateAnArrayByKPositions.class.getName());

    public static void main(String[] args) {
        test("Test_1", new int[]{89, 89, 17, 85, 79, 4, 53, 73, 63, 35, 50, 31, 66, 33, 11, 40});
        test("Test_2", new int[]{92, 54, 62, 5, 52, 91, 85, 31, 32, 57, 4, 34, 82, 72, 66, 18, 67, 55, 52, 27});
        test("Test_3", new int[]{12, 32, 1});
        test("Test_4", new int[]{});
    }

    private static void test(String label, int[] array) {
        logger.info(() -> label + " before rotate " + Arrays.toString(array));
        rotate(array);
        logger.info(() -> label + " after rotate " + Arrays.toString(array));
    }

    private static void rotate(int[] array) {
        if (array == null || array.length < 1) return;

        int n = array.length;
        int k = K_POSITION % n;

        reverse(array, 0, k - 1);
        reverse(array, k, n - 1);
        reverse(array, 0, n - 1);
    }

    public static void reverse(int[] array, int start, int end) {
        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }
}