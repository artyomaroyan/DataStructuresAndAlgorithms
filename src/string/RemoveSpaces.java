package string;

import java.util.stream.Collectors;

/**
 * Author: Artyom Aroyan
 * Date: 04.10.25
 * Time: 22:10:11
 * Task015
 * Remove spaces from a string.
 */
public class RemoveSpaces {
    static void main() {
        test("Test_1", "java, c++, python, c#");
        test("Test_2", "one, two, three, four");
        test("Test_3", "count words  in  the  array of string");
        test("Test_4", "test different   conditions for   logic,   ");
    }

    private static void test(String label, String str) {
        String method1 = replaceSpacesWithNothing(str);
        IO.println(label + " method_1 " + method1);
        String method2 = replaceSpacesCharacterScanning(str);
        IO.println(label + " method_2 " + method2);
        String method3 = replaceSpacesCharacterScanning2(str);
        IO.println(label + " method_3 " + method3);
        String method4 = replaceSpacesSplitAndJoin(str);
        IO.println(label + " method_4 " + method4);
        String method5 = replaceSpacesRegex(str);
        IO.println(label + " method_5 " + method5);
        String method6 = replaceSpacesJavaStreams(str);
        IO.println(label + " method_6 " + method6);
    }

    // 1. Using a “replace” idea
    private static String replaceSpacesWithNothing(String str) {
        return str.replace(" ", "");
    }

    // 2. Using manual character scanning
    private static String replaceSpacesCharacterScanning(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                result += String.valueOf(str.charAt(i));
            }
        }
        return result;
    }

    // 3. Using a character array or StringBuilder
    private static String replaceSpacesCharacterScanning2(String str) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                result.append(str.charAt(i));
            }
        }
        return result.toString();
    }

    // 4. Using “split and join” thinking
    private static String replaceSpacesSplitAndJoin(String str) {
        String[] split = str.trim().split("\\s+");
        return String.join("", split);
    }

    // 5. Using regular expressions (regex)
    private static String replaceSpacesRegex(String str) {
        return str.replaceAll("\\s+", "");
    }

    // 6. Using Java Streams (functional style)
    private static String replaceSpacesJavaStreams(String str) {
        return str.chars()
                .mapToObj(ch -> (char) ch)
                .filter(ch -> !Character.isWhitespace(ch))
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
}