package string;

import java.util.Arrays;
import java.util.logging.Logger;

/**
 * Author: Artyom Aroyan
 * Date: 03.10.25
 * Time: 22:41:22
 * Task013
 * Longest common prefix among a set of strings.
 */
public class LongestCommonPrefix {
    private static final Logger log = Logger.getLogger(LongestCommonPrefix.class.getName());

    static void main() {
        test("Test_1", new String[]{"flower", "flow", "flight"});
        test("Test_2", new String[]{"dog", "racecar", "car"});
        test("Test_3", new String[]{"interview", "internet", "internal", "into"});
    }

    private static void test(String label, String[] str) {
        String metho1 = horizontalScanning(str);
        log.info(() -> label + " Method_1: " + metho1);
        String metho2 = verticalScanning(str);
        log.info(() -> label + " Method_2: " + metho2);
        String metho3 = sortAndCompare(str);
        log.info(() -> label + " Method_3: " + metho3);
        String metho4 = sortAndCompareReduce(str);
        log.info(() -> label + " Method_4: " + metho4);

    }

    private static String horizontalScanning(String[] str) {
        if (str == null || str.length == 0) return "null";
        String prefix = str[0];

        for (int i = 1; i < str.length; i++) {
            while (!str[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "empty prefix";
            }
        }
        return prefix;
    }

    private static String verticalScanning(String[] str) {
        if (str == null || str.length == 0) return "null";
        StringBuilder prefix = new StringBuilder();
        String first = str[0];

        for (int i = 0; i < first.length(); i++) {
            char ch = first.charAt(i);

            for (int j = 1; j < str.length; j++) {
                if (i >= str[j].length() || str[j].charAt(i) != ch)
                    return prefix.toString();
            }
            prefix.append(ch);
        }
        return prefix.toString();
    }

    private static String sortAndCompare(String[] str) {
        if (str == null || str.length == 0) return "null";

        Arrays.sort(str);
        String first = str[0];
        String last = str[str.length - 1];

        int i = 0;
        while (i < first.length() && i < last.length() && first.charAt(i) == last.charAt(i)) {
            i++;
        }
        return first.substring(0, i);
    }

    private static String sortAndCompareReduce(String[] str) {
        if (str == null || str.length == 0) return "null";

        return Arrays.stream(str)
                .reduce((a, b) -> {
                    int i = 0;
                    while (i < a.length() && i < b.length() && a.charAt(i) == b.charAt(i)) {
                        i++;
                    }
                    return a.substring(0, i);
                })
                .orElse("");
    }
}