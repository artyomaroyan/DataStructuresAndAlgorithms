package string;

import java.util.Set;
import java.util.logging.Logger;

/**
 * Author: Artyom Aroyan
 * Date: 22.09.25
 * Time: 21:15:05
 * Task003
 * Count vowels and consonants.
 */
public class CountVowels {
    private static final Logger logger = Logger.getLogger(CountVowels.class.getName());
    private static final Set<Character> VOWELS = Set.of('A', 'E', 'I', 'O', 'U');

    public static void main(String[] args) {
        test("Test_1", "hellOo");
        test("Test_2", "world");
        test("Test_3", "JAVA");
        test("Test_4", "somEthIng");
    }

    private static void test(String label, String str) {
        int result = countVowels(str);
        logger.info(() -> label + " result: " + result);
    }

    private static int countVowels(String str) {
        int count = 0;
        String upper = str.toUpperCase();

        for (char ch : upper.toCharArray()) {
            if (VOWELS.contains(ch)) {
                count++;
            }
        }
        return count;
    }
}