/**
 * Author: Artyom Aroyan
 * Date: 13.10.25
 * Time: 23:46:27
 */
void main() {
    String[] s1 = {"flower", "flow", "flight"};
    String[] s2 = {"dog", "racecar", "car"};
    String[] s3 = {"interview", "internet", "internal", "into"};

    IO.println(commonPrefix2(s1));
    IO.println(commonPrefix(s2));
    IO.println(commonPrefix(s3));
}

String commonPrefix(String[] strings) {
    if (strings == null || strings.length == 0) return "";
    String prefix = strings[0];

    for (int i = 1; i < strings.length; i++) {
        while (!strings[i].startsWith(prefix)) {
            prefix = prefix.substring(0, prefix.length() - 1);

            if (prefix.isEmpty()) return "";
        }
    }
    return prefix;
}

String commonPrefix2(String[] strings) {
    if (strings == null || strings.length == 0) return "null";
    StringBuilder prefix = new StringBuilder();
    String first = strings[0];

    for (int i = 0; i < first.length(); i++) {
        char ch = first.charAt(i);

        for (int j = 1; j < strings.length; j++) {
            if (i >= strings[j].length() || strings[j].charAt(i) != ch)
                return prefix.toString();
        }
        prefix.append(ch);
    }
    return prefix.toString();
}