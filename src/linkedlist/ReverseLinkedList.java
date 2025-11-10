package linkedlist;

/**
 * Author: Artyom Aroyan
 * Date: 09.10.25
 * Time: 23:00:03
 * Task006
 * Reverse a linked list.
 */
public class ReverseLinkedList {
    static void main() {
        GenericLinkedList<Integer> linkedList = new GenericLinkedList<>();
        linkedList.add(321);
        linkedList.add(43653);
        linkedList.add(79791);
        linkedList.add(908123);
        linkedList.addFirst(3221);
        linkedList.addFirst(7231213);
        linkedList.addFirst(564564);
        linkedList.display();

        linkedList.reverse();
        linkedList.display();
    }
}