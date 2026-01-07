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
        CustomLinkedList<Integer> linkedList = new CustomLinkedList<>();
        linkedList.add(9123);
        linkedList.add(8109);
        linkedList.add(1234);
        linkedList.add(34612);
        linkedList.add(12);
        linkedList.add(4835);
        linkedList.add(71291);
        linkedList.add(92130);
        Node<?> twoPointerElement1 = findNthFromEndTwoPointer(linkedList.head, 5);
        Node<?> twoPointerElement2 = findNthFromEndTwoPointer(linkedList.head, 8);
        IO.println(twoPointerElement1.element);
        IO.println(twoPointerElement2.element);
        Node<?> lengthCalculationElement1 = findNthFromEndLengthCalculation(linkedList.head, 2);
        Node<?> lengthCalculationElement2 = findNthFromEndLengthCalculation(linkedList.head, 3);
        IO.println(lengthCalculationElement1.element);
        IO.println(lengthCalculationElement2.element);
    }

    // Two Pointer Approach
    private static Node<?> findNthFromEndTwoPointer(Node<?> head, int n) {
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

    // Length Calculation Approach
    private static Node<?> findNthFromEndLengthCalculation(Node<?> head, int n) {
        if (head == null || n <= 0) return null;

        int length = 0;
        Node<?> current = head;
        while (current != null) {
            length++;
            current = current.next;
        }

        if (n > length) return null;

        int targetPosition = length - n;
        current = head;
        for (int i = 0; i < targetPosition; i++) {
            current = current.next;
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
                current = current.next;
            }
            current.next = newNode;
        }
    }

    private static final class Node<E> {
        E element;
        Node<E> next;

        Node(E element) {
            this.element = element;
            this.next = null;
        }
    }
}