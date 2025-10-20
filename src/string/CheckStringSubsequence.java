package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Author: Artyom Aroyan
 * Date: 06.10.25
 * Time: 22:57:44
 * Task020
 * Check if a string is a subsequence of another string.
 */
public class CheckStringSubsequence {
    static void main() {
        test("Test_1 ", "abc", "ahbgdc");
        test("Test_2 ", "axc", "ahbgdc");
        test("Test_3 ", "ace", "abcde");
        test("Test_4 ", "aec", "abcde");
    }

    private static void test(String label, String str1, String str2) {
        boolean method1 = isSubsequenceTwoPointer(str1, str2);
        IO.println(label + " method_1 " + method1);
        boolean method2 = isSubsequenceRecursion(str1, str2);
        IO.println(label + " method_2 " + method2);
        boolean method3 = isSubsequenceDynamic(str1, str2);
        IO.println(label + " method_3 " + method3);
        boolean method4 = isSubsequenceBinary(str1, str2);
        IO.println(label + " method_4 " + method4);
        boolean method5 = isSubsequenceStreams(str1, str2);
        IO.println(label + " method_5 " + method5);
    }

    private static boolean isSubsequenceTwoPointer(String str1, String str2) {
//        if (str1 == null || str1.trim().isEmpty()) return true;
//        if (str2 == null || str2.trim().isEmpty()) return false;
//
//        String str3 = "";
//
//        for (int i = 0; i < str1.length(); i++) {
//            for (int j = 0; j < str2.length(); j++) {
//                if (str1.charAt(i) == str2.charAt(j)) {
//                    str3 += str2.charAt(j);
//
//                    if (str1.equals(str3)) {
//                        return true;
//                    }
//                }
//            }
//        }
//        return false;
        if (str1 == null || str1.trim().isEmpty()) return true;
        if (str2 == null || str2.trim().isEmpty()) return false;

        int i = 0;
        int j = 0;

        while (i < str1.length() && j < str2.length()) {
            if (str1.charAt(i) == str2.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == str1.length();
    }

    private static boolean isSubsequenceRecursion(String str1, String str2) {
        if (str1 == null || str1.isEmpty()) return true;
        if (str2 == null || str2.isEmpty()) return false;

        if (str1.charAt(0) == str2.charAt(0)) {
            return isSubsequenceRecursion(str1.substring(1), str2.substring(1));
        }
        return isSubsequenceRecursion(str1, str2.substring(1));
    }

    private static boolean isSubsequenceDynamic(String str1, String str2) {
        if (str1 == null || str1.isEmpty()) return true;
        if (str2 == null || str2.isEmpty()) return false;

        int n = str1.length();
        int m = str2.length();

        boolean[][] result = new boolean[n + 1][m + 1];

        for (int j = 0; j <= m; j++) {
            result[0][j] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    result[i][j] = result[i - 1][j - 1];
                } else {
                    result[i][j] = result[i][j - 1];
                }
            }
        }
        return result[n][m];
    }

    private static boolean isSubsequenceBinary(String str1, String str2) {
        if (str1 == null || str1.isEmpty()) return true;
        if (str2 == null || str2.isEmpty()) return false;

        Map<Character, List<Integer>> indexMap = new HashMap<>();
        for (int i = 0; i < str2.length(); i++) {
            char ch = str2.charAt(i);
            indexMap.computeIfAbsent(ch, _ -> new ArrayList<>()).add(i);
        }

        int currentPosition = -1;

        for (char c : str1.toCharArray()) {
            if (!indexMap.containsKey(c)) return false;

            List<Integer> indices = indexMap.get(c);

            int nextIndex = findNextGreater(indices, currentPosition);
            if (nextIndex == -1) return false;
            currentPosition = nextIndex;
        }
        return true;
    }

    private static int findNextGreater(List<Integer> list, int target) {
        int left = 0;
        int right = list.size() - 1;
        int ans = -1;

        while (left <= right) {
            int mid = (left - right) / 2;
            if (list.get(mid) > target) {
                ans = list.get(mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    private static boolean isSubsequenceStreams(String str1, String str2) {
        if (str1 == null || str1.isEmpty()) return true;
        if (str2 == null || str2.isEmpty()) return false;

        AtomicInteger index = new AtomicInteger(-1);
        return str1.chars()
                .mapToObj(c -> (char) c)
                .allMatch(ch -> {
                    int nextIndex = str2.indexOf(ch, index.get() + 1);
                    if (nextIndex == -1) return false;

                    index.set(nextIndex);
                    return true;
                });
    }
}