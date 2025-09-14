package strings.LongestPalindromicSubString;

public class LongestPalindromicSubString {

	public static void main(String[] args) {

		String s = "abbacdsfdsffdsfasdfadsfasdfa";
		long startTime = System.nanoTime();
		System.out.println(longestPalindrome_around_centre(s));
		long estimatedTime =System.nanoTime()- startTime;
		System.out.println("Total time taken using palindrome around the centre :"+estimatedTime);



		long startTime1 = System.nanoTime();
		System.out.println(longestPalindrome_recursive(s));
		long estimatedTime1 =System.nanoTime()- startTime1;
		System.out.println("Total time taken for recursive:"+estimatedTime1);


		long startTime2 = System.nanoTime();
		System.out.println(longestPalindrome_dynamic_programming(s));
		long estimatedTime2 = System.nanoTime() - startTime2;
		System.out.println("Total time taken using dynamic programming:"+estimatedTime2);



	}

	public static String longestPalindrome_around_centre(String s) {

		//1. Check if input length < 1

		if (s.length() < 1) {
			return s;
		}


		//2. Every first character itself is palindrome
		String maxPalindrome = s.substring(0, 1);

		// 3 loop
		for (int i = 0; i < s.length() - 1; i++) {

			// 4 For odd length palindrome,
			//we will consider the current character as the center and expand around it.

			String odd = expandFromCenter(s, i, i);

			// 5 For even length palindrome,
			// we will consider the current character and the next character as the center
			// and expand around it.

			String even = expandFromCenter(s, i, i + 1);

			//6 Assign max palindrome with max of odd or even
			String longer = odd.length() > even.length() ? odd : even;
			if (longer.length() > maxPalindrome.length()) {
				maxPalindrome = longer;
			}

		}

		return maxPalindrome;
	}

	// Expand around center
	private static String expandFromCenter(String s, int left, int right) {
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		return s.substring(left + 1, right);
	}


	public static String longestPalindrome_recursive(String s) {
		if (s.equals(new StringBuilder(s).reverse().toString())) {
			return s;
		}

		String left = longestPalindrome_recursive(s.substring(1));
		String right = longestPalindrome_recursive(s.substring(0, s.length() - 1));

		if (left.length() > right.length()) {
			return left;
		} else {
			return right;
		}

	}

	public static String longestPalindrome_dynamic_programming(String s) {

		int n = s.length();
		if (n <= 1) return s;

		boolean[][] dp = new boolean[n][n];
		int start = 0;
		int maxLength = 1;

		// Every single character is a palindrome
		for (int i = 0; i < n; i++) {
			dp[i][i] = true;
		}

		// Check for substrings of length 2
		for (int i = 0; i < n - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				dp[i][i + 1] = true;
				start = i;
				maxLength = 2;
			}
		}

		// Check for substrings longer than 2
		for (int len = 3; len <= n; len++) {
			for (int i = 0; i <= n - len; i++) {
				int j = i + len - 1;
				if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
					dp[i][j] = true;
					start = i;
					maxLength = len;
				}
			}
		}



		return s.substring(start, start + maxLength);
	}
}
