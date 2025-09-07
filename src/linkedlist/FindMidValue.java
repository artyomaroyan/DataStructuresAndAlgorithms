package linkedlist;

import java.util.logging.Logger;

/**
 * Author: Artyom Aroyan
 * Date: 03.09.25
 * Time: 21:51:39
 * find middle value of one way linkedlist without knowing it's length.
 */
public class FindMidValue {
    private static final Logger logger = Logger.getLogger(FindMidValue.class.getName());

    public static void main(String[] args) {

    }

    private static int findMiddleValue(Node head) {
        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
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