package strings.longest_valid_parantheses;

import java.util.Stack;

/**
 * Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed) parentheses substring.
 *
 * (() = 2
 * ((({}{}{{}{}}}}}
 *
 * Example 1:
 *
 * Input: s = "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()".
 * Example 2:
 *
 * Input: s = ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()".
 * Example 3:
 *
 * Input: s = ""
 * Output: 0
 */

public class Longest_Valid_parantheses {
    public static void main(String[] args) {
        System.out.println(longestValidParentheses("((({}{}{{}{})})"));
        System.out.println(isValid("((({}{}{{}{})})"));
        System.out.println(longestValidParentheses1("((({}{}{{}{})})"));
    }

    public static int longestValidParentheses1(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1); // base index
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                stack.push(i);
            } else {
                stack.pop();

                if (stack.isEmpty()) {
                    stack.push(i); // reset base
                } else {
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }

        return maxLen;
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


    public static  int longestValidParentheses(String s) {
     Stack stack = new Stack();

     int count = 0;

     for (int i = 0; i < s.length(); i++) {
         if(s.charAt(i) == '(' ||s.charAt(i) == '[' ||s.charAt(i) == '{'){
             stack.push(s.charAt(i));
         }else {
             if(stack.isEmpty()){
                 stack.push(s.charAt(i));
             }else if(s.charAt(i) == ')' && (char)stack.peek() == '('){
                 stack.pop();
                 count += 2;
             }else if(s.charAt(i) == ']' && (char)stack.peek() == '['){
                 stack.pop();
                 count += 2;
             }else if(s.charAt(i) == '}' && (char)stack.peek() == '{'){
                 stack.pop();
                 count += 2;
             }
         }


         }

        return count;
    }
}
