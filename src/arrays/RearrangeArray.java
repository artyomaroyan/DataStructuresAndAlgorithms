package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

/**
 * Author: Artyom Aroyan
 * Date: 12.09.25
 * Time: 14:59:52
 * Task020
 * Rearrange array in alternating positive and negative numbers.
 * Explanation: Separate positive and negative numbers, then interleave.
 * Hint: Maintain two separate lists or modify in-place with indexing tricks.
 */
public class RearrangeArray {
    private static final Logger logger = Logger.getLogger(RearrangeArray.class.getName());

    static void main() {
        test("Test_1", new int[]{-61, -86, 11, 39, -69, 21, 71, -79, 95, -26, 88, -40, 83, -16, 6});
        test("Test_2", new int[]{68, 47, -35, 9, 80, 38, 10, 28, -97, -43, 55, 46, -8, -28, 59, 13, -24});
        test("Test_3", new int[]{-15, 32, 16, 7, -27, 27, -82, -57, 95, -80, 25, 2, 79, -89, 27, -38, -12});
        test("Test_4", new int[]{65, -79, 38, 28, -12, 37, 41, -1, -73, 97, -49, -43, -49, -10, 48, 40, 73});
    }

    private static void test(String label, int[] array) {
        int[] result1 = rearrangeWithLists(array);
        logger.info(() -> label + " rearrange with two lists: " + Arrays.toString(result1));

        int[] result2 = rearrangeInPlace(array);
        logger.info(() -> label + " rearrange in place:       " + Arrays.toString(result2));

    }

    private static int[] rearrangeWithLists(int[] array) {
        List<Integer> positive = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();

        for (int num : array) {
            if (num >= 0) positive.add(num);
            else negative.add(num);
        }

        int i = 0;
        int p = 0;
        int n = 0;
        boolean turnPositive = true;

        while (p < positive.size() && n < negative.size()) {
            array[i++] = turnPositive ? positive.get(p++) : negative.get(n++);
            turnPositive = !turnPositive;
        }

        while (p < positive.size()) array[i++] = positive.get(p++);
        while (n < negative.size()) array[i++] = negative.get(n++);
        return array;
    }

    private static int[] rearrangeInPlace(int[] array) {
        for (int i = 0; i < array.length; i++) {
            boolean needsPositive = (i % 2 == 0);
            boolean mismatch = (needsPositive && array[i] < 0) || (!needsPositive && array[i] >= 0);

            if (mismatch) {
                int j = i + 1;
                while (j < array.length && ((needsPositive && array[j] < 0) || (!needsPositive && array[j] >= 0))) {
                    j++;
                }

                if (j == array.length) {
                    return array;
                }
                rightRotate(array, i, j);
            }
        }
        return array;
    }

    private static void rightRotate(int[] array, int i, int j) {
        int temp = array[j];
        for (int k = j; k > i; k--) {
            array[k] = array[k - 1];
        }
        array[i] = temp;
    }
}