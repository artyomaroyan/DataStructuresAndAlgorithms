package arrays;

import java.util.logging.Logger;

import static java.util.logging.Level.INFO;

/**
 * Author: Artyom Aroyan
 * Date: 09.07.25
 * Time: 16:43:53
 * <p>
 * Task 001
 * Find the maximum element in an array.
 * Traverse the array and compare each element with a variable max. Update max if a bigger element is found.
 */
public class FindMaximumElement {
    private static final Logger logger = Logger.getLogger(FindMaximumElement.class.getName());

    static void main() {
        test("Test_1", new int[]{84, 95, 99, 73, 97, 17, 42, 75, 90, 36, 23, 67, 26, 86, 88, 96, 13, 96, 66, 80, 41});
        test("Test_2", new int[]{9, 51, 30, 30, 2, 24, 47, 61, 12, 8, 29, 28, 14, 95, 18, 22, 14, 77, 36, 38, 20, 0, 13, 80, 5});
        test("Test_3", new int[]{56, 56, 72, 92, 38, 9, 60, 84, 97, 33, 9, 19, 11, 26, 90, 35, 75, 43, 49, 71, 42, 34, 85, 37, 49, 61, 17, 100, 40});
    }

    private static void test(String label, int[] array) {
        int maxElement = findMax(array);
        logger.log(INFO, () -> label + ": Largest number in array is: " + maxElement);
    }

    private static int findMax(int[] array) {
        int max  = array[0];
        for (int index : array) {
            if (index > max) {
                max = index;
            }
        }
        return max;
    }
}