package string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.logging.Logger;

/**
 * Author: Artyom Aroyan
 * Date: 04.08.25
 * Time: 18:56:41
 */
public class ReverseString {
    private static final Logger logger = Logger.getLogger(ReverseString.class.getName());
    public static void main(String[] args) {
        String str = "adb";
        reverseViaCollections(str);

    }

    private static String reverseViaBuilder(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        return sb.reverse().toString();
    }

    private static String reverseViaBuffer(String str) {
        StringBuffer sb = new StringBuffer(str);
        return sb.reverse().toString();
    }

    private static void reverseViaCharArray(String str) {
        char[] charArray = str.toCharArray();
        for (int i = charArray.length - 1; i >= 0; i--)
            System.out.println(charArray[i]);
    }

    private static String reverseViaBytes(String str) {
        byte[] bytes = str.getBytes();
        byte[] res = new byte[bytes.length];

        for (int i = 0; i < bytes.length; i++) {
            res[i] = bytes[bytes.length - i - 1];
        }
        return new String(res);
    }

    private static void reverseViaCollections(String str) {
        char[] arr = str.toCharArray();
        List<Character> list = new ArrayList<>();
        for (char c : arr)
            list.add(c);

        // this is also work
//        var listReversed = list.reversed();

        Collections.reverse(list);

        ListIterator it  = list.listIterator();
        while (it.hasNext())
            System.out.print(it.next());
    }
}