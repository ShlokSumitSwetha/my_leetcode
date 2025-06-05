package strings.longest_valid_parantheses;

import java.util.Stack;

public class ValidParantheses {
    public static void main(String[] args) {
        System.out.println(isValid("{{{{}}}}"));
        System.out.println(isValid(")("));
    }
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();

        for (char c : arr) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c); // add to the stack
            } else if (c == ')' || c == '}' || c == ']') {

                if (stack.isEmpty()) return false;
                char top = stack.pop(); // remove from stack
                if (Math.abs(c - top) > 2) return false;
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
