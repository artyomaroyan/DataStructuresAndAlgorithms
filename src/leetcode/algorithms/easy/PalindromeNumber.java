package leetcode.algorithms.easy;

/**
 * Author: Artyom Aroyan
 * Date: 21.02.26
 * Time: 16:31:21
 * <p>
 * Given an integer x, return true if x is a palindrome, and false otherwise.
 * <p>
 * Example 1:
 * Input: x = 121
 * Output: true
 * Explanation: 121 reads as 121 from left to right and from right to left.
 * Example 2:
 * Input: x = -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore, it is not a palindrome.
 * Example 3:
 * Input: x = 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore, it is not a palindrome.
 */
public class PalindromeNumber {
    static void main() {
        int example1 = 121;
        int example2 = -121;
        int example3 = 10;

//        IO.println(isPalindrome(example1));
//        IO.println(isPalindrome(example2));
//        IO.println(isPalindrome(example3));

        IO.println(isPalindrome2(example1));
        IO.println(isPalindrome2(example2));
        IO.println(isPalindrome2(example3));
    }

    static boolean isPalindrome(int x) {
        if (x == 0) return false;
        
        String num = Integer.toString(x);
        StringBuilder reversed = new StringBuilder();

        for (int i = num.length() - 1; i >= 0; i--) {
            reversed.append(num.charAt(i));
        }
        return num.contentEquals(reversed);
    }

    static boolean isPalindrome2(int x) {
        if (x < 0) return false;

        if (x != 0 && x % 10 == 0) return false;

        int reversedHalf = 0;

        while (x > reversedHalf) {
            reversedHalf = reversedHalf * 10 + x % 10;
            x /= 10;
        }

        return x == reversedHalf || x == reversedHalf / 10;
    }
}