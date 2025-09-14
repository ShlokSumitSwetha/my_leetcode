package strings.reverse_string;

import java.util.Stack;

public class ReverseString {

	public static void main(String[] args) {
		char[] input= {'s','u', 'm','i', 't', 'h'};

		System.out.println(rs_backward_traversal("sumith swetha shlok"));
		System.out.println(rs_two_pointer("sumith swetha shlok"));
		System.out.println(rs_stack("sumith swetha shlok"));
		System.out.println(rs_recursive("sumith swetha shlok"));
		System.out.println(rs_stringBuilder("sumith swetha shlok"));
		System.out.println(rs_stringBuilder("sumith swetha shlok"));
		System.out.println(rs_swap(input));
	}


	static String rs_backward_traversal(String s) {
		StringBuilder res = new StringBuilder();

		// Traverse on s in backward direction
		// and add each character to a new string
		for (int i = s.length() - 1; i >= 0; i--) {
			res.append(s.charAt(i));
		}
		return res.toString();
	}

	public static char[] rs_swap(char[] s) {
		int firstPointer = 0;
		int lastPointer = s.length - 1;

		while (firstPointer < lastPointer) {
			char temp = s[firstPointer];
			s[firstPointer] = s[lastPointer];
			s[lastPointer] = temp;
			firstPointer++;
			lastPointer--;
		}

		System.out.println(s);
		return s;
	}

	static String rs_two_pointer(String s) {
		int left = 0, right = s.length() - 1;

		// Use StringBuilder for mutability
		StringBuilder res = new StringBuilder(s);

		// Swap characters from both ends till we reach
		// the middle of the string
		while (left < right) {
			char temp = res.charAt(left);
			res.setCharAt(left, res.charAt(right));
			res.setCharAt(right, temp);
			left++;
			right--;
		}

		// Convert StringBuilder back to string
		return res.toString();
	}

	static String rs_stack(String s) {
		Stack<Character> st = new Stack<>();

		// Push the characters into stack
		for (int i = 0; i < s.length(); i++)
			st.push(s.charAt(i));

		StringBuilder res = new StringBuilder();

		// Pop the characters of stack into the original string
		for (int i = 0; i < s.length(); i++)
			res.append(st.pop());

		return res.toString();
	}

		public static String rs_stringBuilder(String str) {
			return new StringBuilder(str).reverse().toString();
		}


	// Function to reverse a string using recursion
	static String rs_recursive(String s) {
		char[] arr = s.toCharArray();
		reverseStringRec(arr, 0, arr.length - 1);
		return new String(arr);
	}

	// Recursive function to reverse a string from l to r
	static void reverseStringRec(char[] s, int l, int r) {
		if (l >= r)
			return;

		// Swap the characters at the ends
		char temp = s[l];
		s[l] = s[r];
		s[r] = temp;

		// Recur for the remaining string
		reverseStringRec(s, l + 1, r - 1);
	}



}
