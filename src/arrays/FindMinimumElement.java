package arrays;

import java.util.logging.Logger;

import static java.util.logging.Level.INFO;

/**
 * Author: artyom_aroyan
 * Date: 10.07.25
 * Time: 02:28:31
 * <p>
 * Task 002
 * Find the minimum element in an array.
 * Similar to finding maximum, but update a min variable instead if a smaller element is found.
 */
public class FindMinimumElement {
    private static final Logger logger = Logger.getLogger(FindMinimumElement.class.getName());

    public static void main(String[] args) {
        test("Test_1", new int[]{8, 19, 98, 99, 41, 79, 36, 51, 88, 1, 58, 8, 87, 100, 14, 13, 94, 85, 63, 81, 28, 87});
        test("Test_2", new int[]{58, 23, 92, 5, 70, 53, 26, 23, 64, 82, 71, 80, 30, 28, 2, 71, 26, 81, 85, 73, 29, 57});
        test("Test_3", new int[]{44, 87, 81, 16, 86, 14, 71, 35, 33, 39, 71, 26, 46, 4, 14, 86, 12, 62, 40, 76, 49, 98, 5, 45, 51, 98, 34, 11, 53});
    }

    private static void test(String label, int[] array) {
        int minElement = findMin(array);
        logger.log(INFO, () -> label + ": Smallest number is " + minElement);
    }

    private static int findMin(int[] array) {
        int min = array[0];

        for (int index :  array) {
            if (index < min) {
                min = index;
            }
        }
        return min;
    }
}