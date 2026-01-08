package linkedlist;

/**
 * Author: Artyom Aroyan
 * Date: 11.10.25
 * Time: 00:05:55
 * Task009
 * Remove duplicates from a sorted linked list.
 */
public class RemoveDuplicates {
    static void main() {
        CustomLinkedList<Integer> linkedList = new CustomLinkedList<>();
        linkedList.add(712);
        linkedList.add(324);
        linkedList.add(3465);
        linkedList.add(1234);
        linkedList.add(4534);
        linkedList.add(4534);
        linkedList.add(91029);
        linkedList.add(2345);
        linkedList.add(5345);
        linkedList.add(421);

        Node<?> result = removeDuplicatesIterative(linkedList.head);
        IO.println(result.element);
    }

    // Iterative Approach
    private static Node<?> removeDuplicatesIterative(Node<?> head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node<?> current = head;
        while (current != null && current.next != null) {
            if (current.element == current.next.element) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return current;
    }

    private static final class CustomLinkedList<E> {
        Node<E> head;

        void add(E e) {
            Node<E> newNode = new Node<>(e);
            if (head == null) {
                head = newNode;
                return;
            }

            Node<E> current = head;
            while (current.next != null) {
                current = (Node<E>) current.next;
            }
            current.next = newNode;
        }
    }

    private static final class Node<E> {
        E element;
        Node<?> next;

        Node(E element) {
            this.element = element;
            this.next = null;
        }
    }
}