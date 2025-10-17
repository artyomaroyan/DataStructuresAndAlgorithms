package string;

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
        String[] strings = str.trim().split(" ");
        for (int i = 0; i < strings.length; i++) {
            if (!strings[i].isEmpty()) {
                strings[i] = strings[i].substring(0, 1).toUpperCase() +
                        strings[i].substring(1).toLowerCase();
            }
        }
        return String.join(" ", strings);
    }

    private static String capitalizeFirstLetterCharacterScanning(String str) {
        return null;
    }

    private static String capitalizeFirstLetterStringBuilder(String str) {
        return null;
    }

    private static String capitalizeFirstLetterRegex(String str) {
        return null;
    }

    private static String capitalizeFirstLetterStreams(String str) {
        return null;
    }
}