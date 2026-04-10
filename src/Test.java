import static java.lang.IO.*;

/**
 * Author: Artyom Aroyan
 * Date: 13.10.25
 * Time: 23:46:27
 */
void main() {
    LinkedList<Integer> list = new LinkedList<>();
    list.add(428);
    list.add(54);
    list.add(251);
    list.add(3717);
    list.add(78);
    list.add(1510);
    list.add(43);
//    list.add(9845);
//    list.add(61);
//    list.add(9131);
//    list.add(62);
//    list.add(25);
//    list.add(6379);
//    list.add(50);
//    list.add(71);
//    list.add(5803);
//    list.add(24);
//    list.add(6154);
//    list.add(79);
//    list.add(9131);
//    list.add(30);
//    list.add(9230);
//    list.add(66);
//    list.add(8042);
//    list.add(49);

    Integer pivot1 = list.get(list.size() >> 1);
    println("result of Integer pivot = list.get(list.size() >> 2); - " + pivot1);

    Integer pivot2 = list.size() >> 1;
    println("result of Integer pivot2 = list.size() >> 2; - " + pivot2);
}