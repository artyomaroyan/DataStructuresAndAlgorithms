import static java.lang.IO.*;

/**
 * Author: Artyom Aroyan
 * Date: 13.10.25
 * Time: 23:46:27
 */
void main() {
    var list = createList(10, 43, 55, 55, 43, 10, 9);
    var reversed = list.reversed();
    println("List1 - " + list);
    println("List1 - " + reversed);
}

private static LinkedList<Integer> createList(Integer... values) {
    return new LinkedList<>(List.of(values));
}