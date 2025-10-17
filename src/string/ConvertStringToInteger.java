package string;

/**
 * Author: Artyom Aroyan
 * Date: 04.10.25
 * Time: 22:10:46
 * Task016
 * Convert a string to integer (without using Integer.parseInt).
 */
public class ConvertStringToInteger {
    static void main() {
        test("Test_1 ", "456");
        test("Test_2 ", " 12354");
        test("Test_3 ", "8760345 ");
        test("Test_4 ", "  0908 435");
        test("Test_5 ", " ");
    }

    private static void test(String label, String str) {
        int method1 = convertToIntegerManualScanning(str);
        IO.println(label + " method_1 " + method1);
//        int method2 = convertToIntegerRecursion(str);
//        IO.println(label + " method_2 " + method2);
//        int method3 = convertToIntegerStreams(str);
//        IO.println(label + " method_3 " + method3);
//        int method4 = convertToIntegerCharacter(str);
//        IO.println(label + " method_4 " + method4);
    }

    private static int convertToIntegerManualScanning(String str) {
        str = str.trim().replaceAll("\\s+",  "");
        int num = 0;
        char digit;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            digit = (char) (ch - '0');
            num = num * 10 + digit;
        }
        return num;
    }

    private static int convertToIntegerRecursion(String str) {
        return 0;
    }

    private static int convertToIntegerStreams(String str) {
        return 0;
    }

    private static int convertToIntegerCharacter(String str) {
        return 0;
    }
}