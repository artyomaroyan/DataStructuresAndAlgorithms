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

        RecursiveLinkedList recursiveLinkedList = getRecursiveLinkedList();

        IO.println(recursiveLinkedList.delete(878));
        IO.println(recursiveLinkedList.delete(1));

        IO.println(recursiveLinkedList.contains(1212));
        IO.println(recursiveLinkedList.contains(781));

    }

    private static RecursiveLinkedList getRecursiveLinkedList() {
        RecursiveLinkedList recursiveLinkedList = new RecursiveLinkedList();

        recursiveLinkedList.add(4243);
        recursiveLinkedList.add(798);
        recursiveLinkedList.add(31);
        recursiveLinkedList.display();

        recursiveLinkedList.addFirst(324);
        recursiveLinkedList.addFirst(878);
        recursiveLinkedList.display();

        recursiveLinkedList.addLast(5675);
        recursiveLinkedList.addLast(781);
        recursiveLinkedList.display();

        recursiveLinkedList.reverse();
        recursiveLinkedList.display();
        return recursiveLinkedList;
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

class RecursiveLinkedList {
    private Node head;

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    void add(int data) {
        head = addRecursive(head, data);
    }

    void addFirst(int data) {
        head = addFirstRecursive(head, data);
    }

    void addLast(int data) {
        head = addLastRecursive(head, data);
    }

    boolean delete(int data) {
        int initialSize = size();
        head = deleteRecursive(head, data);
        return size() < initialSize;
    }

    boolean contains(int data) {
        return containsRecursive(head, data);
    }

    int size() {
        return sizeRecursive(head);
    }

    void display() {
        displayRecursive(head);
        IO.println("null");
    }

    void reverse() {
        head = reverseRecursive(head);
    }

    private Node addRecursive(Node node, int data) {
        if (node == null) return new Node(data);
        node.next = addRecursive(node.next, data);
        return node;
    }

    private Node addFirstRecursive(Node node, int data) {
        final Node newNode = new Node(data);
        newNode.next = node;
        return newNode;
    }

    private Node addLastRecursive(Node node, int data) {
        if (node == null) return new Node(data);
        node.next = addLastRecursive(node.next, data);
        return node;
    }

    private Node deleteRecursive(Node node, int data) {
        if (node == null) return null;
        if (node.data == data) return node.next;
        node.next = deleteRecursive(node.next, data);
        return node;
    }

    private boolean containsRecursive(Node node, int data) {
        if (node == null) return false;
        if (node.data == data) return true;
        return containsRecursive(node.next, data);
    }

    private int sizeRecursive(Node node) {
        if (node == null) return 0;
        return 1 + sizeRecursive(node.next);
    }

    private void displayRecursive(Node node) {
        if (node == null) return;
        IO.print(node.data + " -> ");
        displayRecursive(node.next);
    }

    private Node reverseRecursive(Node node) {
        if (node == null || node.next == null) return node;
        Node newHead = reverseRecursive(node.next);
        node.next.next = node;
        node.next = null;
        return newHead;
    }
}