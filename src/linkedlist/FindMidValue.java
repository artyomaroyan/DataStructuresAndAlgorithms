package linkedlist;

/**
 * Author: Artyom Aroyan
 * Date: 03.09.25
 * Time: 21:51:39
 * Task007
 * Find middle of linked list.
 */
public class FindMidValue {
    static void main() {
        CustomLinkedList linkedList = new CustomLinkedList();
        linkedList.add(213);
        linkedList.add(345);
        linkedList.add(934);
        linkedList.add(9);
        linkedList.add(912);
        linkedList.add(24);
        linkedList.add(983);
        linkedList.add(90);
        linkedList.add(234);

        IO.println(findMiddleValue(linkedList.head));
    }

    private static int findMiddleValue(Node head) {
        if (head == null) {
            throw new IllegalArgumentException("List can not be null");
        }
        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }

    private static class CustomLinkedList {
        Node head;

        void add(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                return;
            }

            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
}