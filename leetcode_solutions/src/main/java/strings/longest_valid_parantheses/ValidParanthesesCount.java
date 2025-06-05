package strings.longest_valid_parantheses;

import java.util.Stack;

public class ValidParanthesesCount {
    public static void main(String[] args) {
        System.out.println(isValid("{{{({})}}}}"));
        System.out.println(isValid(")("));
    }
    public static int isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();

        int count =0;

        for (char c : arr) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c); // add to the stack
            } else if (c == ')' || c == '}' || c == ']') {

                if (stack.isEmpty()) return 0;
                char top = stack.pop(); // remove from stack
                if (Math.abs(c - top) <=2){
                   count = count+2;
                }
            } else {
                return 0;
            }
        }
        return count;
    }
}
