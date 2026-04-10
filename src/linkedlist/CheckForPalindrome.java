package linkedlist;

import java.util.LinkedList;
import java.util.List;

import static java.lang.IO.println;

/**
 * Author: Artyom Aroyan
 * Date: 12.11.25
 * Time: 22:27:24
 * Task014
 * Check if a linked list is palindrome.
 */
public class CheckForPalindrome {
    static void main() {
        var list = createList(1, 2, 3, 1);
        var reversed = list.reversed();
        println("List1 - " + list);
        println("List1 - " + reversed);

        println(isPalindrome(list, reversed));
    }

    private static boolean isPalindrome(LinkedList<Integer> original, LinkedList<Integer> reversed) {
        if (original.size() != reversed.size()) return false;

        for (int i = 0; i < original.size(); i++) {
            if (!original.get(i).equals(reversed.get(i))) {
                return false;
            }
        }
        return true;
//        return original.equals(reversed); // better approach
    }

    private static LinkedList<Integer> createList(Integer... values) {
        return new LinkedList<>(List.of(values));
    }
}