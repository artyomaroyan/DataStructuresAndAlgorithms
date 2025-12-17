/**
 * Author: Artyom Aroyan
 * Date: 17.12.25
 * Time: 23:30:12
 */
void main() {
    Scanner scanner = new Scanner(System.in);
    IO.println("input");
    String input = scanner.nextLine();
    IO.println(Solution.areValidBrackets(input));
}

/*
// this is my solution which I write on interview.
static class Solution {
    private static final String[] VALID_BRACKETS = {"()", "{}", "[]"};

    static boolean areValidBrackets(String input) {
        String prefix;
        String suffix;

        for (int i = 0; i < VALID_BRACKETS.length; i++) {
            if (input.contains(VALID_BRACKETS[i])) {
                prefix = VALID_BRACKETS[i];
                suffix = VALID_BRACKETS[i + 1];

                if (input.startsWith(prefix) && input.endsWith(suffix)) {
                    return true;
                }
            }
        }
        return false;
    }
}
 */

// fixed version of my solution.
static class Solution {
    private static final String[] VALID_BRACKETS = {"()", "{}", "[]"};

    static boolean areValidBrackets(String input) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            if (currentChar == '(' || currentChar == '{' || currentChar == '[') {
                stack.push(currentChar);

            } else if (currentChar == ')' || currentChar == '}' || currentChar == ']') {
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();
                if (!isMatchingPair(top, currentChar)) {
                    return false;
                }

            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }

    private static boolean isMatchingPair(char opening, char closing) {
        return (opening == '(' && closing == ')') ||
                (opening == '{' && closing == '}') ||
                (opening == '[' && closing == ']');
    }
}