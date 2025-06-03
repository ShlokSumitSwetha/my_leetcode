package strings.StringToInteger;

public class StringToIntegerTest {
	public static void main(String[] args) {
		System.out.println(myAtoi("words and 987"));
	}

	public static int myAtoi(String s) {
		int i = 0, n = s.length(), sign = 1, result = 0;

		// Step 1: Skip leading whitespace
		while (i < n && s.charAt(i) == ' ') i++;

		// Step 2: Check for optional sign
		if (i < n && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
			sign = s.charAt(i) == '-' ? -1 : 1;
			i++;
		}

		// Step 3: Convert digits to integer
		while (i < n && Character.isDigit(s.charAt(i))) {
			int digit = s.charAt(i) - '0';
			// Check for overflow
			if (result > (Integer.MAX_VALUE - digit) / 10) {
				return sign == 1 ? Integer.MAX_VALUE  : Integer.MIN_VALUE;
			}
			result = result * 10 + digit;
			i++;
		}

		return sign * result;
	}
}
