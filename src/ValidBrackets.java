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

/*
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

    static boolean areValidBracketsAlternative(String input) {
        String previous;
        String current = input;

        do {
            previous = current;
            for (String pair : VALID_BRACKETS) {
                current = current.replace(pair, "");
            }
        } while (!previous.equals(current));
        return current.isEmpty();
    }
}
 */

/*
static class Solution {
    static boolean areValidBrackets(String input) {
        Map<Character, Character> map = Map.of(
                ')', '(',
                '}', '{',
                ']', '['
        );

        Stack<Character> stack = new Stack<>();
        for (char ch : input.toCharArray()) {
            if (map.containsValue(ch)) {
                stack.push(ch);
            } else if (map.containsKey(ch)) {
                if (stack.isEmpty() || stack.pop() != stack.get(ch)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
 */

static class Solution {
    static boolean areValidBrackets(String input) {
        char[] stack = new char[input.length()];
        int top = -1;

        for (char ch : input.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack[++top] = ch;

            } else if (ch == ')' || ch == '}' || ch == ']') {
                if (top == -1) return false;

                char opening = stack[top--];
                if ((ch == ')' && opening != '(') || (ch == '}' && opening != '{') || (ch == ']' && opening != '[')) {
                    return false;
                }
            }
        }
        return top == -1;
    }
}