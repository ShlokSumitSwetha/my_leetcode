package number.ReverseInteger;

public class ReverseIntegerTest {

	public static void main(String[] args) {

		System.out.println(reverse(123));

	}

		public static int reverse(int x) {
			int reversed = 0;
			while (x != 0) {
				int pop = x % 10;
				x /= 10;

				// Overflow check before updating reversed
				if (reversed > Integer.MAX_VALUE / 10 || (reversed == Integer.MAX_VALUE / 10 && pop > 7)) {
					return 0;
				}
				if (reversed < Integer.MIN_VALUE / 10 || (reversed == Integer.MIN_VALUE / 10 && pop < -8)) {
					return 0;
				}

				reversed = reversed * 10 + pop;
			}
			return reversed;
		}

}
