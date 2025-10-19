package string;

import java.util.regex.Pattern;

/**
 * Author: Artyom Aroyan
 * Date: 05.10.25
 * Time: 22:44:25
 * Task017
 * Capitalize the first letter of each word in a string.
 */
public class CapitalizeFirstLetter {
    static void main() {
        test("Test_1 ", "java, c++, python, c#");
        test("Test_2 ", "one, two, three, four");
        test("Test_3 ", "count words  in  the  array of string");
        test("Test_4 ", "test different   conditions for   logic,   ");
        test("Test_5 ", " Spring boot, spring WebFlux");
    }

    private static void test(String label, String str) {
        String method1 = capitalizeFirstLetterSplit(str);
        IO.println(label + " method_1 " + method1);
        String method2 = capitalizeFirstLetterCharacterScanning(str);
        IO.println(label + " method_2 " + method2);
        String method3 = capitalizeFirstLetterStringBuilder(str);
        IO.println(label + " method_3 " + method3);
        String method4 = capitalizeFirstLetterRegex(str);
        IO.println(label + " method_4 " + method4);
        String method5 = capitalizeFirstLetterStreams(str);
        IO.println(label + " method_5 " + method5);
    }

    private static String capitalizeFirstLetterSplit(String str) {
        if (str == null || str.trim().isEmpty()) return null;

        String[] strings = str.trim().split("\\s+");

        for (int i = 0; i < strings.length; i++) {
            if (!strings[i].isEmpty()) {
                strings[i] = strings[i].substring(0, 1).toUpperCase() +
                        strings[i].substring(1).toLowerCase();
            }
        }
        return String.join(" ", strings);
    }

    private static String capitalizeFirstLetterCharacterScanning(String str) {
        if (str == null || str.trim().isEmpty()) return null;

        StringBuilder result = new StringBuilder();
        boolean stratOfWord = true;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isWhitespace(ch)) {
                result.append(ch);
                stratOfWord = true;
            } else {
                if (stratOfWord) {
                    result.append(Character.toUpperCase(ch));
                    stratOfWord = false;
                } else {
                    result.append(Character.toLowerCase(ch));
                }
            }
        }
        return result.toString().trim();
    }

    private static String capitalizeFirstLetterStringBuilder(String str) {
        if (str == null || str.trim().isEmpty()) return null;

        String[] words = str.trim().split("\\s+");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) {
                result.append(Character.toUpperCase(word.charAt(0)))
                        .append(word.substring(1).toLowerCase())
                        .append(" ");
            }
        }
        return result.toString().trim();
    }

    private static String capitalizeFirstLetterRegex(String str) {
        if (str == null || str.trim().isEmpty()) return null;

        return Pattern.compile("\\b[a-z]")
                .matcher(str.toLowerCase())
                .replaceAll(m -> m.group().toUpperCase())
                .trim();
    }

    private static String capitalizeFirstLetterStreams(String str) {
        if (str == null || str.trim().isEmpty()) return null;

        StringBuilder result = new StringBuilder();
        final boolean[] startOfWord = {true};

        str.chars().forEach(ch -> {
            char c = (char) ch;
            if (Character.isWhitespace(c)) {
                result.append(c);
                startOfWord[0] = true;

            } else {
                if (startOfWord[0]) {
                    result.append(Character.toUpperCase(c));
                    startOfWord[0] = false;

                } else {
                    result.append(Character.toLowerCase(c));
                }
            }
        });
        return result.toString().trim();
    }
}