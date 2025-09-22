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
 * Task001
 */
public class ReverseString {
    private static final Logger logger = Logger.getLogger(ReverseString.class.getName());

    public static void main(String[] args) {
        test("Test_1", "asdad");
        test("Test_2", "reyrt");
        test("Test_3", "sfsdkm");
        test("Test_4", "fghjgh");
    }

    private static void test(String label, String str) {
        String builderResult = reverseViaBuilder(str);
        logger.info(() -> label + " reverse with builder: " + builderResult);
        String bufferResult = reverseViaBuffer(str);
        logger.info(() -> label + " reverse with buffer: " + bufferResult);
        String charArrayResult = reverseViaCharArray(str);
        logger.info(() -> label + " revers with char array: " + charArrayResult);
        String byteResult = reverseViaBytes(str);
        logger.info(() -> label + " revers with byte array: " + byteResult);
        String collectionResult = reverseViaCollections(str);
        logger.info(() -> label + " revers with collections: " + collectionResult);
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

    private static String reverseViaCharArray(String str) {
        char[] charArray = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = charArray.length - 1; i >= 0; i--) {
            sb.append(charArray[i]);
        }
        return sb.toString();
    }

    private static String reverseViaBytes(String str) {
        byte[] bytes = str.getBytes();
        byte[] res = new byte[bytes.length];

        for (int i = 0; i < bytes.length; i++) {
            res[i] = bytes[bytes.length - i - 1];
        }
        return new String(res);
    }

    private static String reverseViaCollections(String str) {
        char[] arr = str.toCharArray();
        List<Character> list = new ArrayList<>();
        for (char c : arr)
            list.add(c);

        // this also works
//        var listReversed = list.reversed();

        Collections.reverse(list);

        ListIterator<Character> it = list.listIterator();
        while (it.hasNext())
            System.out.print(it.next());
        return String.valueOf(list);
    }
}