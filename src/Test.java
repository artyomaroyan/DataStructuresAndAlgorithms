/**
 * Author: Artyom Aroyan
 * Date: 13.10.25
 * Time: 23:46:27
 */
void main() {
    int num = 12154;
    String number = Integer.toString(num);
    String reversed;
    char[] character = number.toCharArray();

    for (int i = character.length - 1; i >= 0; i--) {
        reversed = String.valueOf(character[i]);
        IO.println(reversed);
    }
}