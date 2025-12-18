/**
 * Author: Artyom Aroyan
 * Date: 17.12.25
 * Time: 23:30:56
 */
void main() {
    
}

class Trie {
    String data;

    void insert(String word) {
        data = word;
    }

    boolean search(String word) {
        return Objects.equals(data, word);
    }

    boolean startsWith(String word) {
        return data.startsWith(word);
    }
}