package arrays;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Author: Artyom Aroyan
 * Date: 11.07.25
 * Time: 15:03:37
 * <p>
 * Task 003
 * Calculate the sum of all elements
 * Travers through the array and add each element to a cumulative sum
 */
public class CalculateSumOfElements {
    private static final Logger LOGGER = Logger.getLogger(CalculateSumOfElements.class.getName());

    static void main() {
        test("Test_1", new int[] {83, 76, 21});
        test("Test_2", new int[] {5, 2, 70});
        test("Test_3", new int[] {19, 81, 10});
        test("Test_3", new int[] {6, 8, 18, 8, 14, 59, 16, 42, 21, 54, 94, 25, 36, 46, 36, 44, 14, 64, 46, 18, 9, 41, 66, 72});
        test("Test_4", new int[] {8, 0, 21, 34, 22, 54, 62, 5, 68, 62, 39, 79, 88, 49, 21, 9, 74, 75, 0, 62, 64, 51, 60, 33, 57, 64});
        test("Test_5", new int[] {48, 78, 64, 57, 76, 62, 69, 27, 61, 36, 33, 78, 34, 15, 7, 9, 72, 81, 24, 55, 55});
    }

    private static void test(String label, int[] array) {
        int sumOfElements = sumOfElements(array);
        LOGGER.log(Level.INFO, () -> label + ": Sum of elements is: " + sumOfElements);
    }

    private static int sumOfElements(int[] array) {
        int sum = 0;
        for (int element : array) {
            sum += element;
        }
        return sum;
    }
}