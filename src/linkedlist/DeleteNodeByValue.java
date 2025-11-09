package linkedlist;

/**
 * Author: Artyom Aroyan
 * Date: 08.10.25
 * Time: 15:10:25
 * Task004
 * Delete a node by value.
 */
public class DeleteNodeByValue {
    static void main() {
        GenericLinkedList<Integer> linkedList = new GenericLinkedList<>();
        linkedList.add(45345);
        linkedList.add(9892);
        linkedList.add(9092348);
        linkedList.display();

        linkedList.delete(12312432);
        linkedList.delete(9892);
        linkedList.display();
    }
}