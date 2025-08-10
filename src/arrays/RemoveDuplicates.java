package arrays;

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

    }

    private static void test(String label, int[] array) {
        logger.info(label + ": " );
    }

    private static int[] removeDuplicates(int[] array) {
        return sortArray(array);
    }

    private static int[] sortArray(int[] array) {
        return null;
    }
}