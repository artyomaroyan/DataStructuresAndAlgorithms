package string;

/**
 * Author: Artyom Aroyan
 * Date: 03.10.25
 * Time: 22:41:58
 * Task014
 * Count the number of words in a string.
 */
public class CountWordsInString {
    static void main() {
        test("Test_1", "java, c++, python, c#");
        test("Test_2", "one, two, three, four");
        test("Test_3", "count words  in  the  array of string");
        test("Test_4", "test different   conditions for   logic,   ");
    }

    private static void test(String label, String str) {
        var method1 = splitString(str);
        IO.println(label + " method_1 " + method1);
    }

    private static int splitString(String string) {
        if (string == null) return 0;
        string = string.trim();
        if (string.isEmpty()) return 0;
        String[] words = string.split("\\s+");
        return words.length;
    }
}