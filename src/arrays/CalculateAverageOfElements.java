package arrays;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Author: Artyom Aroyan
 * Date: 11.07.25
 * Time: 15:43:33
 * <p>
 * Task 004
 * Calculate the average of array elements.
 * After calculating the sum, divide it by the number of elements (length)
 */
public class CalculateAverageOfElements {
    private static final Logger logger = Logger.getLogger(CalculateAverageOfElements.class.getName());
    public static void main(String[] args) {
        test("Test_1", new int[] {10, 19, 22, 56});
        test("Test_2", new int[] {3, 28, 85, 64, 45});
        test("Test_3", new int[] {52, 7, 67, 3, 20, 41});
        test("Test_4", new int[] {55, 38, 18, 18, 65, 87});
    }

    private static void test(String label, int[] array) {
        int average = averageOfElements(array, array.length);
        logger.log(Level.INFO, () -> label + ": Average of elements is " + average);
    }

    private static int averageOfElements(int[] array, int length) {
        int sum = sumElements(array);
        return sum / length;
    }

    private static int sumElements(int[] array) {
        int sum = 0;
        for (int element : array) {
            sum += element;
        }
        return sum;
    }
}