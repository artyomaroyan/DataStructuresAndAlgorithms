package string;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Author: Artyom Aroyan
 * Date: 04.08.25
 * Time: 18:33:33
 */
public class Palindrome {
    private static final Logger logger = Logger.getLogger(Palindrome.class.getName());
    public static void main(String[] args) {
        String str = "abccba";
        logger.log(Level.INFO, () -> "Result: " + isPalindrome(str));
    }

    private static boolean isPalindrome(String str) {
        String prefix = str.substring(0, str.length() / 2);
        String suffix = str.substring(str.length() / 2);
        StringBuilder sb = new StringBuilder(prefix);
        var reversed = sb.reverse().toString();

        return reversed.equals(suffix);
    }
}