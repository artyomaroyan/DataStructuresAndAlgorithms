package arrays;

import java.util.Arrays;
import java.util.logging.Logger;

/**
 * Author: Artyom Aroyan
 * Date: 05.08.25
 * Time: 23:20:22
 * Task 008
 * Explanation: Use two pointers to pick smaller elements from each array and put into new array.
 * Hint: Handle remaining elements once one array is exhausted.
 */
public class MergeTwoSortedArrays {
    private static final Logger logger = Logger.getLogger(MergeTwoSortedArrays.class.getName());

    static void main() {
        test("Test_1 ",
                new int[] {89, 39, 33, 64, 59, 58, 77, 97, 49, 89, 38},
                new int[] {70, 50, 21, 98, 67, 82, 25, 92, 12, 60, 92, 45,});
        test("Test_2 ",
                new int[] {75, 81, 83, 0, 80, 82, 34, 5, 10, 16, 73, 53, 89},
                new int[] {26, 23, 79, 49, 63, 20, 26, 81, 62, 87, 62, 54, 43});
        test("Test_3 ",
                new int[] {36, 42, 15, 76, 78, 78, 36, 60, 84, 80},
                new int[] {33, 79, 54, 77, 62, 20, 31, 56, 7, 84});
    }

    private static void test(String label, int[] firstArray,  int[] secondArray) {
        int[] mergedArray = mergeTwoSortedArrays(firstArray, secondArray);
        logger.info(() -> label + "merged array: " + Arrays.toString(mergedArray));
    }

    private static int[] mergeTwoSortedArrays(int[] firstArray, int[] secondArray) {
        int i = 0;
        int j = 0;
        int k = 0;
        int[] result = new int[firstArray.length + secondArray.length];
        Arrays.sort(firstArray);
        Arrays.sort(secondArray);

        while (i < firstArray.length && j < secondArray.length) {
            if (firstArray[i] < secondArray[j]) {
                result[k++] = firstArray[i++];
            }  else {
                result[k++] = secondArray[j++];
            }
        }

        while (i < firstArray.length) {
            result[k++] = firstArray[i++];
        }

        while (j < secondArray.length) {
            result[k++] = secondArray[j++];
        }
        return result;
    }
}