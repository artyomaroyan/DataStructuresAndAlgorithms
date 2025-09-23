package string;

import java.util.logging.Logger;

/**
 * Author: Artyom Aroyan
 * Date: 23.09.25
 * Time: 16:11:22
 * Task006
 * Remove all vowels from a string.
 */
public class RemoveAllVowels {
    private static final Logger log = Logger.getLogger(RemoveAllVowels.class.getName());
    private static final String[] VOWELS = {"A", "E", "I", "O", "U"};

    public static void main(String[] args) {
        test("Test_1", "listen");
        test("Test_2", "evil");
        test("Test_3", "hello");
        test("Test_4", "like");
    }

    private static void test(String label, String str1) {
        String result1 = removeVowelsLoop(str1);
        log.info(() -> label + " result1: " + result1);
        String result2 = removeVowelsRegex(str1);
        log.info(() -> label + " result2: " + result2);
    }

    private static String removeVowelsLoop(String str) {
        String result = str;
        for (String vowel : VOWELS) {
            result = result.replace(vowel, "")
                    .replace(vowel.toLowerCase(), "");
        }
        return result;
//        str = str.toUpperCase();
//
//        for (int i = 0; i < str.length(); i++) {
//            if (str.contains(VOWELS[i])) {
//                str = str.replace(VOWELS[i], "");
//            }
//        }
//        return str;
    }

    private static String removeVowelsRegex(String str) {
        return str.replaceAll("[aeiouAEIOU]", "");
    }
}