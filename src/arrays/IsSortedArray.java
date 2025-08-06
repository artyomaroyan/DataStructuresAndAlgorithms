package arrays;

import java.util.logging.Logger;

/**
 * Author: Artyom Aroyan
 * Date: 04.08.25
 * Time: 21:17:08
 * <p>
 * Task 007
 * Explanation: Check every pair arr[i] <= arr[i+1].
 * Hint: As soon as you find arr[i] > arr[i+1], array is not sorted.
 */
public class IsSortedArray {
    private static final Logger logger = Logger.getLogger(IsSortedArray.class.getName());
    public static void main(String[] args) {
        test("Test_1", new int[] {10, 24, 71, 79, 98, 9, 14, 16, 73, 33, 51, 24, 40, 61, 69, 72, 78, 15, 19, 29, 47});
        test("Test_1.1", new int[] {9, 10, 14, 15, 16, 19, 24, 24, 29, 33, 40, 47, 51, 61, 69, 71, 72, 73, 78, 79, 98});
        test("Test_2", new int[] {48, 93, 23, 74, 32, 50, 27, 72, 37, 56, 13, 12, 15, 37, 41, 56, 49, 28, 2, 22, 40, 97, 23, 52, 40, 7, 100, 19});
        test("Test_2.1", new int[] {2, 7, 12, 13, 15, 19, 22, 23, 23, 27, 28, 32, 37, 37, 40, 40, 41, 48, 49, 50, 52, 56, 56, 72, 74, 93, 97, 100});
        test("Test_3", new int[] {26, 6, 46, 77, 52, 53, 27, 99, 78, 41, 32, 21, 41, 16, 61, 22, 42, 57, 9, 55, 9, 74, 60, 44, 58, 32, 92, 77, 1, 93});
        test("Test_3.1", new int[] {1, 6, 9, 9, 16, 21, 22, 26, 27, 32, 32, 41, 41, 42, 44, 46, 52, 53, 55, 57, 58, 60, 61, 74, 77, 77, 78, 92, 93, 99});

//        int[] arr1 = {10, 24, 71, 79, 98, 9, 14, 16, 73, 33, 51, 24, 40, 61, 69, 72, 78, 15, 19, 29, 47};
//        int[] arr2 = {48, 93, 23, 74, 32, 50, 27, 72, 37, 56, 13, 12, 15, 37, 41, 56, 49, 28, 2, 22, 40, 97, 23, 52, 40, 7, 100, 19};
//        int[] arr3 = {26, 6, 46, 77, 52, 53, 27, 99, 78, 41, 32, 21, 41, 16, 61, 22, 42, 57, 9, 55, 9, 74, 60, 44, 58, 32, 92, 77, 1, 93};
//
//        Arrays.sort(arr1);
//        Arrays.sort(arr2);
//        Arrays.sort(arr3);
//
//        logger.info(() -> "Sorted " + Arrays.toString(arr1));
//        logger.info(() -> "Sorted " + Arrays.toString(arr2));
//        logger.info(() -> "Sorted " + Arrays.toString(arr3));
    }

    private static void test(String label, int[] array) {
        boolean result = isSorted(array);
        logger.info(() -> label + " result is: " + result);
    }

    private static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }
}