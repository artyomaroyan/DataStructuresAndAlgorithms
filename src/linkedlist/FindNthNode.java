package linkedlist;

/**
 * Author: Artyom Aroyan
 * Date: 10.10.25
 * Time: 08:14:40
 * Task008
 * Find n-th node from end.
 */
public class FindNthNode {
    static void main() {

    }

    // Two Pointer Approach
    private static Node<?> findNthFromEnd(Node<?> head, int n) {
        if (head == null || n <= 0) return null;

        Node<?> first = head;
        Node<?> second = head;

        for (int i = 0; i < n; i++) {
            if (first == null) return null;
            first = first.next;
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }
        return second;
    }

    private static final class Node<E> {
        E element;
        Node<E> next;

        Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }
}