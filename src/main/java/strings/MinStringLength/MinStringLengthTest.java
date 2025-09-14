package strings.MinStringLength;

/**
 * Input: s = "ABFCACDB"
 * Output: 2
 * Explanation: We can do the following operations:
 * - Remove the substring "ABFCACDB", so s = "FCACDB".
 * - Remove the substring "FCACDB", so s = "FCAB".
 * - Remove the substring "FCAB", so s = "FC".
 * So the resulting length of the string is 2.
 * It can be shown that it is the minimum length that we can obtain.
 */

public class MinStringLengthTest {

    public static void main(String[] args) {
        String s = "ABFCACDB";
        StringBuilder result = new StringBuilder();

        for (char c : s.toCharArray()) {
            int len = result.length();
            if (len > 0) {
                char last = result.charAt(len - 1);
                if ((last == 'A' && c == 'B') || (last == 'C' && c == 'D')) {
                    result.deleteCharAt(len - 1); // Remove matching pair
                    continue;
                }
            }
            result.append(c); // Push character if no match
        }

        System.out.println("Reduced string: " + result.toString());
        System.out.println("Min Length: " + result.length());
    }
}
