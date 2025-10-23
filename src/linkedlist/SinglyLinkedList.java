package linkedlist;


/**
 * Author: Artyom Aroyan
 * Date: 07.10.25
 * Time: 22:57:52
 * Task001
 * Create a singly linked list.
 */
public class SinglyLinkedList {
    static void main() {
        IterativeLinkedList iterativeLinkedList = new IterativeLinkedList();
        iterativeLinkedList.add(43);
        iterativeLinkedList.add(1);
        iterativeLinkedList.add(90);
        iterativeLinkedList.addFirst(12);
        iterativeLinkedList.addFirst(132);
        iterativeLinkedList.addLast(64);
        iterativeLinkedList.addLast(987);

        iterativeLinkedList.display();
        IO.println();

        iterativeLinkedList.delete(64);
        iterativeLinkedList.delete(64552);

        iterativeLinkedList.display();
        IO.println();

        IO.println(iterativeLinkedList.contains(13232));
        IO.println(iterativeLinkedList.contains(12));

        iterativeLinkedList.reverse();
        iterativeLinkedList.display();
    }
}

class IterativeLinkedList {
    private Node head;
    private int size;

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    void add(int data) {
        final Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) current = current.next;
        current.next = newNode;
    }

    void addFirst(int data) {
        final Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    void addLast(int date) {
        final Node newNode = new Node(date);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    void delete(int data) {
        if (head == null) return;

        if (head.data == data) {
            head = head.next;
            size--;
            return;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.data == data) {
                current.next = current.next.next;
                size--;
                return;
            }
            current = current.next;
        }
    }

    boolean contains(int data) {
        Node current = head;
        while (current != null) {
            if (current.data == data) return true;
            current = current.next;
        }
        return false;
    }

    void display() {
        Node current = head;
        while (current != null) {
            IO.print(current.data + " -> ");
            current = current.next;
        }
        IO.print("null");
    }

    void reverse() {
        Node previous = null;
        Node current = head;
        Node next;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
    }
}