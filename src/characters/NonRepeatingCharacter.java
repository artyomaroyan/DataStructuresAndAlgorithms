package characters;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Author: Artyom Aroyan
 * Date: 04.08.25
 * Time: 20:42:58
 */
public class NonRepeatingCharacter {
    private static final Logger logger = Logger.getLogger(NonRepeatingCharacter.class.getName());
    public static void main(String[] args) {
        String str = "lkmldmsfkskdfn";
        logger.log(Level.INFO, () -> "result: " + findFirstNonRepeatingCharacter(str));
    }

    private static char findFirstNonRepeatingCharacter(String str) {
        HashMap<Character, Integer> count = new HashMap<>();
        for (char ch : str.toCharArray()) {
            count.put(ch, count.getOrDefault(ch, 0) + 1);
        }

        for (char ch : str.toCharArray()) {
            if (count.get(ch) == 1) {
                return ch;
            }
        }
        return 0;
    }
}