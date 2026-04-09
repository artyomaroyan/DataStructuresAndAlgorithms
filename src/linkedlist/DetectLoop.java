package linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * Author: Artyom Aroyan
 * Date: 11.10.25
 * Time: 00:07:26
 * Task010
 * Detect loop in a linked list.
 */
public class DetectLoop {
    static void main() {
        CustomLinkedList<Integer> list = new CustomLinkedList<>();
        for (int i = 0; i < 50; i++) {
            list.add(i);
        }

        list.createLoop(20);
        boolean hasLoop = detectLoopSet(list.getHead());
        IO.println("Loop detected " + hasLoop);
    }

    private static <E> boolean detectLoopSet(CustomLinkedList.CustomNode<E> head) {
        Set<CustomLinkedList.CustomNode<E>> visited = new HashSet<>();
        CustomLinkedList.CustomNode<E> current = head;

        while (current != null) {
            if (visited.contains(current)) {
                return true;
            }
            visited.add(current);
            current = current.next;
        }
        return false;
    }
}

final class CustomLinkedList<E> {
    private CustomNode<E> head;
    private CustomNode<E> tail;
    private int size;

    public CustomNode<E> getHead() {
        return head;
    }

    E get(int index) {
        checkElementIndex(index);
        return node(index).element;
    }

    void add(E e) {
        final CustomNode<E> newNode = new CustomNode<>(e);
        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }

    void createLoop(int index) {
        checkElementIndex(index);
        tail.next = node(index);
    }

    private CustomNode<E> node(int index) {
        CustomNode<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    private void checkElementIndex(int index) {
        if (!checkIndex(index))
            throw new IndexOutOfBoundsException("Մի բան էն չի!");
    }

    private boolean checkIndex(int index) {
        return index >= 0 && index < size;
    }

    static final class CustomNode<E> {
        E element;
        CustomNode<E> next;

        public CustomNode(E element) {
            this.element = element;
            this.next = null;
        }
    }
}