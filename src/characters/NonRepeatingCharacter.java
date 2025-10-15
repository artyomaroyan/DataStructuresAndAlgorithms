package characters;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Author: Artyom Aroyan
 * Date: 04.08.25
 * Time: 20:42:58
 */
public class NonRepeatingCharacter {
    private static final Logger logger = Logger.getLogger(NonRepeatingCharacter.class.getName());

    static void main() {
        String str = "lkmldmsfkskdfn";
        logger.log(Level.INFO, () -> "result: " + findFirstNonRepeatingCharacter(str));
    }

    private static Character findFirstNonRepeatingCharacter(String str) {
        HashMap<Character, Integer> count = new LinkedHashMap<>();
        for (char ch : str.toCharArray()) {
            count.put(ch, count.getOrDefault(ch, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : count.entrySet()) {
            if (entry.getValue() == 1)
                return entry.getKey();
        }
        return null;
    }
}