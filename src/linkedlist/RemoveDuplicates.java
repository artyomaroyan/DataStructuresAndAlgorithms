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

    private static final class Node<E> {
        E element;
        Node<?> next;

        Node(E element) {
            this.element = element;
            this.next = null;
        }
    }
}