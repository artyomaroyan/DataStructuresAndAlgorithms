package arrays;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Author: Artyom Aroyan
 * Date: 19.07.25
 * Time: 01:09:47
 * <p>
 * Task 006
 * Find the second largest element.
 * Track both largest and second largest as you traverse.
 * Hint: Don't just sort; think in O(n) without sorting.
 */
public class FindSecondLargestElement {
    private static final Logger logger = Logger.getLogger(FindSecondLargestElement.class.getName());

    static void main() {
        test("Test_1", new int[] {82, 74, 15, 5, 29, 100, 38, 18, 31, 98, 74, 80, 76, 92, 55, 63, 39, 50});
        test("Test_2", new int[] {69, 76, 54, 10, 28, 31, 64, 58, 22, 98, 60, 81, 67, 9, 8, 100, 8, 37, 97, 16, 22, 8, 58, 23, 87, 7, 9, 14});
        test("Test_3", new int[] {86, 50, 2, 40, 58, 43, 93, 86, 39, 96, 35, 76, 56, 94, 56, 51, 36, 88, 16, 0, 58, 33, 27, 35, 36, 93, 37, 43});
    }

    private static void test(String label, int[] array) {
        int secondLargest = secondLargestNumber(array);
        logger.log(Level.INFO, () -> label + ": Second largest number in array is: " + secondLargest);
    }

    private static int secondLargestNumber(int[] nums) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            }  else if (num < largest && num > secondLargest) {
                secondLargest = num;
            }
        }
        return secondLargest;
    }
}