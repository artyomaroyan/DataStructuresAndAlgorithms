package linkedlist;

import java.util.Iterator;
import java.util.NoSuchElementException;

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
        linkedList.add(421);

        IO.println("before remove");
        for (Integer element : linkedList) {
            IO.println(element);
        }
        IO.println("size before remove " + linkedList.getSize() + "\n");

        removeDuplicatesIterative(linkedList);

        IO.println("after remove");
        for (Integer element : linkedList) {
            IO.println(element);
        }
        IO.println("size after remove " + linkedList.getSize());
    }

    // Iterative Approach
    private static <T> void removeDuplicatesIterative(CustomLinkedList<T> list) {
        if (list.head == null || list.head.next == null) {
            return;
        }

        Node<T> current = list.head;
        while (current != null && current.next != null) {
            Node<T> runner = current;
            while (runner.next != null) {
                if (current.element.equals(runner.next.element)) {
                    runner.next = runner.next.next;
                    list.size--;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }

    private static final class CustomLinkedList<E> implements Iterable<E> {
        Node<E> head;
        transient int size = 0;

        void add(E e) {
            Node<E> newNode = new Node<>(e);
            if (head == null) {
                head = newNode;
            } else {
                Node<E> current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
            size++;
        }

        int getSize() {
            return size;
        }

        @Override
        public Iterator<E> iterator() {
            return new Iterator<>() {
                private Node<E> current = head;

                @Override
                public boolean hasNext() {
                    return current != null;
                }

                @Override
                public E next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    E data = current.element;
                    current = current.next;
                    return data;
                }
            };
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