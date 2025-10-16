package string;

import java.util.Arrays;
import java.util.Comparator;
import java.util.logging.Logger;

/**
 * Author: Artyom Aroyan
 * Date: 25.09.25
 * Time: 17:21:43
 * Task010
 * Find the longest word in a string.
 */
public class FindLongestWord {
    private static final Logger log = Logger.getLogger(FindLongestWord.class.getName());

    static void main() {
        test("Test_1", "I love programming in Java");
        test("Test_2", "After three hours of debugging, the error was simply a missing semicolon.");
        test("Test_3", "She refactored the entire module just to make the variable names more poetic.");
        test("Test_4", "The algorithm hummed along efficiently, sorting through petabytes of data as if it were arranging a deck of cards.");
    }

    private static void test(String label, String str1) {
        var result1 = longestWordLoop(str1);
        log.info(() -> label + " result_1: " + result1);
        var result2 = longestWordStream(str1);
        log.info(() -> label + " result_2: " + result2);
    }

    private static String longestWordLoop(String sentence) {
        if (sentence == null || sentence.trim().isBlank()) return "";

        String[] words = sentence.split("\\s+");
        String result = words[0];

        for (String word : words) {
            if (word.length() > result.length()) {
                result = word;
            }
        }
        return result;
    }

    private static String longestWordStream(String sentence) {
        return Arrays.stream(sentence.split("\\s+"))
                .max(Comparator.comparingInt(String::length))
                .orElse("");
    }
}