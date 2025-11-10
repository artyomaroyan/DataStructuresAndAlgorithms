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
    }

    private static int findMiddleValue(Node head) {
        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        assert slow != null;
        return slow.data;
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