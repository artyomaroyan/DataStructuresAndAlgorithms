package arrays;

import java.util.logging.Logger;

/**
 * Author: Artyom Aroyan
 * Date: 02.09.25
 * Time: 21:42:54
 * Task019
 * Find the majority element (appears more than n/2 times).
 * Explanation: Use Boyer-Moore voting algorithm.
 * Hint: Find candidate first, then validate.
 */
public class FindTheMajorityElement {
    private static final Logger log = Logger.getLogger(FindTheMajorityElement.class.getName());

    public static void main(String[] args) {
        test("Test_1", new int[]{7, 7, 3, 7, 2, 7, 7, 5, 7});
        test("Test_2", new int[]{4, 1, 4, 2, 4, 3, 4, 4});
        test("Test_3", new int[]{1, 2, 3, 2, 3, 1, 4, 5});
        test("Test_4", new int[]{10, 20, 30, 40, 50, 60});
        test("Test_5", new int[]{9, 1, 9, 2, 9, 3, 9, 4, 9, 9, 9});
    }

    private static void test(String label, int[] array) {
        Integer result = findMajorityElement(array);
        if (result == null) {
            log.info(() -> label + " Majority Element: " + null);
        } else {
            log.info(() -> label + " Result: " + result);
        }
    }

    private static Integer findMajorityElement(int[] array) {
        int count = 0;
        Integer candidate = null;

        for (int num : array) {
            if (count == 0) {
                candidate = num;
                count = 1;
            } else if (candidate == num) {
                count++;
            } else {
                count--;
            }
        }

        if (candidate != null) {
            int frequency = 0;

            for (int num : array) {
                if (num == candidate) {
                    frequency++;
                }
            }
            if (frequency > array.length / 2) {
                return candidate;
            }
        }
        return null;
    }
}