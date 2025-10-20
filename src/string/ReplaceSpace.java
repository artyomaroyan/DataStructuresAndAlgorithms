package string;

import java.util.stream.Collectors;

/**
 * Author: Artyom Aroyan
 * Date: 06.10.25
 * Time: 22:56:38
 * Task019
 * Replace each space with "%20" (URLify).
 */
public class ReplaceSpace {
    static void main() {
        test("Test_1 ", "java, c++, python, c#");
        test("Test_2 ", "one, two, three, four");
        test("Test_3 ", "count words  in  the  array of string");
        test("Test_4 ", "test different   conditions for   logic,   ");
        test("Test_5 ", " Spring boot, spring WebFlux");
    }

    private static void test(String label, String str) {
        String method1 = replaceSpacesReplace(str);
        IO.println(label + " method_1 " + method1);
        String method2 = replaceSpacesCharScanning(str);
        IO.println(label + " method_2 " + method2);
        String method3 = replaceSpacesStringBuilder(str);
        IO.println(label + " method_3 " + method3);
        String method4 = replaceSpacesSplitJoin(str);
        IO.println(label + " method_4 " + method4);
        String method5 = replaceSpacesStreams(str);
        IO.println(label + " method_5 " + method5);
    }

    private static String replaceSpacesReplace(String str) {
        return str == null || str.trim().isEmpty() ?
                str : str.trim().replace(" ", "%20");
    }

    private static String replaceSpacesCharScanning(String str) {
        if (str == null || str.trim().isEmpty()) return str;
        StringBuilder result = new StringBuilder();

        for (char ch : str.toCharArray()) {
            if (Character.isWhitespace(ch)) {
                result.append("%20");
            }
            result.append(ch);
        }
        return result.toString();
    }

    private static String replaceSpacesStringBuilder(String str) {
        if (str == null || str.trim().isEmpty()) return str;
        StringBuilder result;
        result = new StringBuilder(str.replaceAll("\\s+", "%20"));
        return result.toString();
    }

    private static String replaceSpacesSplitJoin(String str) {
        if (str == null || str.trim().isEmpty()) return str;
        String[] split = str.split("\\s+");
        return String.join("%20", split);
    }

    private static String replaceSpacesStreams(String str) {
        if (str == null || str.trim().isEmpty()) return str;
        return str.chars()
                .mapToObj(ch -> (char) ch)
                .map(ch -> ch == ' ' ? "%20" : String.valueOf(ch))
                .collect(Collectors.joining());
    }
}