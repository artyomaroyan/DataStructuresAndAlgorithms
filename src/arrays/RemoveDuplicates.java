package arrays;

import java.util.Arrays;
import java.util.logging.Logger;

/**
 * Author: Artyom Aroyan
 * Date: 10.08.25
 * Time: 23:18:11
 * Task 009
 * Remove duplicates from a sorted array.
 * Explanation: Since array is sorted, duplicates are adjacent. Copy only unique elements.
 * Hint: Use two-pointer approach: i for unique index, j for traversing.
 */
public class RemoveDuplicates {
    private static final Logger logger = Logger.getLogger(RemoveDuplicates.class.getName());

    public static void main(String[] args) {
        test("Test_1", new int[]{19, 57, 27, 33, 85, 14, 26, 58, 70, 27, 36, 83, 32, 51, 62, 100, 44, 54, 33, 23, 99, 13, 37, 42, 45});
        test("Test_2", new int[]{50, 4, 71, 78, 40, 41, 93, 57, 59, 97, 71, 100, 91, 72, 0, 36, 95, 30, 0, 35, 30, 16, 59, 2, 57, 87, 57});
        test("Test_3", new int[]{40, 47, 28, 65, 63, 7, 75, 22, 79, 58, 95, 56, 83, 56, 66, 63, 1, 62, 83, 91, 45, 79, 39, 89, 44, 15, 77, 20, 14, 90});
    }

    private static void test(String label, int[] array) {
        int[] sorted = removeDuplicates(array);
        logger.info(() -> label + ": " + Arrays.toString(sorted));
    }

    private static int[] removeDuplicates(int[] array) {
        Arrays.sort(array);

        int uniqueIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != array[uniqueIndex]) {
                uniqueIndex++;
                array[uniqueIndex] = array[i];
            }
        }
        return Arrays.copyOf(array, uniqueIndex);
    }
}