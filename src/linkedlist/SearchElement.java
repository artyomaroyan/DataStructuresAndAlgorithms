package linkedlist;

/**
 * Author: Artyom Aroyan
 * Date: 09.10.25
 * Time: 22:58:57
 * Task005
 * Search an element in linked list.
 */
public class SearchElement {
    static void main() {
        GenericLinkedList<Integer> linkedList = new GenericLinkedList<>();
        linkedList.add(45345);
        linkedList.add(9892);
        linkedList.add(9092348);
        linkedList.display();

        IO.println(linkedList.contains(213131));
        IO.println(linkedList.contains(9892));
    }
}