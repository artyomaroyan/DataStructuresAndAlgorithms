package linkedlist;

import java.util.LinkedList;
import java.util.List;

import static java.lang.IO.println;

/**
 * Author: Artyom Aroyan
 * Date: 13.10.25
 * Time: 23:31:16
 * Task012
 * Merge two sorted linked lists.
 */
public class MergeTwoLinkedLists {
    static void main() {

        // 1. create 2 linked list.
        LinkedList<Integer> list1 = createList(4807, 6757, 8907, 8334,6550, 7879, 7879);
        println("list 1 before sort - " + list1);

        LinkedList<Integer> list2 = createList(1991, 6847, 64, 3801, 3697, 6240, 735, 9412, 5515);
        println("list 2 before sort - " + list2);

        // 2. sort them.
        var sortedList1 = quickSort(list1);
        var sortedList2 = quickSort(list2);

        // 3. marge two sorted linked lists.
        var merged = mergeSortedLists(sortedList1, sortedList2);
        println("Merged list " + merged);
    }

    private static LinkedList<Integer> mergeSortedLists(LinkedList<Integer> list1, LinkedList<Integer> list2) {
        LinkedList<Integer> result = new LinkedList<>();
        int i = 0, j = 0;

        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) <= list2.get(j)) {
                result.add(list1.get(i++));
            } else {
                result.add(list2.get(j++));
            }
        }

        while (i < list1.size()) result.add(list1.get(i++));
        while (j < list2.size()) result.add(list2.get(j++));

        return result;
    }

    private static LinkedList<Integer> quickSort(LinkedList<Integer> list) {
        if (list.size() < 2) return list;

        LinkedList<Integer> smaller = new LinkedList<>();
        LinkedList<Integer> same = new LinkedList<>();
        LinkedList<Integer> larger = new LinkedList<>();

        Integer pivot = list.get(list.size() >> 1);

        for (Integer element : list) {
            if (element < pivot) smaller.add(element);
            else if (element > pivot) larger.add(element);
            else same.add(element);
        }

        LinkedList<Integer> result = new LinkedList<>();
        result.addAll(quickSort(smaller));
        result.addAll(same);
        result.addAll(quickSort(larger));
        return result;
    }

    private static LinkedList<Integer> createList(Integer... values) {
        return new LinkedList<>(List.of(values));
    }
}