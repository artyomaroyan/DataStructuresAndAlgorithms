package arrays;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Author: Artyom Aroyan
 * Date: 11.07.25
 * Time: 16:11:27
 * <p>
 * Task 005
 * Reverse an array.
 * Swap elements from the two ends (start and end) moving toward center
 */
public class ReverseArray {
    private static final Logger logger = Logger.getLogger(ReverseArray.class.getName());
    public static void main(String[] args) {
        test("Test_1", new int[] {3, 38, 57, 12, 88, 9, 77, 99, 24, 94, 98, 38, 46, 87, 48, 71, 60, 77, 94});
        test("Test_2", new int[] {96, 73, 29, 67, 5, 13, 85, 49, 50, 73, 59, 94, 74, 39, 26, 64, 24, 92, 57, 57, 90, 50, 67});
        test("Test_3", new int[] {33, 96, 11, 90, 40, 45, 42, 86, 14, 59, 79, 76, 53, 7, 29, 84, 47, 26, 79, 20, 4, 7, 29, 65, 78, 0, 33, 23});
        test("Test_4", new int[] {83, 7, 31, 32, 63, 29, 87, 89, 95, 47, 57, 61, 58, 25, 79, 87, 16, 46, 81, 28, 68, 39, 64, 6, 44, 65, 64, 97, 13, 15});
        test("Test_5", new int[] {14, 78, 90, 53, 54, 91, 52, 18, 82, 61, 27, 75, 61, 90, 1, 79, 66, 96, 95, 86, 17, 98, 79, 33, 41, 80, 62, 63, 20});
    }

    private static void test(String label, int[] array) {
        logger.log(Level.INFO, () -> label + " before swap: " + Arrays.toString(array));
        swap(array);
        logger.log(Level.INFO, () -> label + " after swap: " + Arrays.toString(array));
    }

    private static void swap(int[] array) {
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start ++;
            end--;
        }
    }
}