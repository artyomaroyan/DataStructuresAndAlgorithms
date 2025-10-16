import java.util.Random;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * Author: Artyom Aroyan
 * Date: 25.09.25
 * Time: 16:02:15
 */
public class RandomString {
    private static final Random random = new Random();
    private static final Logger log = Logger.getLogger(RandomString.class.getName());
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    static void main() {
        String result = generateRandomString();
        log.info(() -> "Random String " + result);
    }

    private static String generateRandomString() {
        return random
                .ints(15, 0, CHARACTERS.length())
                .mapToObj(CHARACTERS::charAt)
                .map(Object::toString)
                .collect(Collectors.joining());
    }
}