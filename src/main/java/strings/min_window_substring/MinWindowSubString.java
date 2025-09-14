package strings.min_window_substring;

import java.util.HashMap;
import java.util.Map;

public class MinWindowSubString {

    public static void main(String[] args) {



        /**
         * Input: s = "ADOBECODEBANC", t = "ABC"
         * Output: "BANC"
         * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
         *
         *
         * Input: s = "a", t = "a"
         * Output: "a"
         * Explanation: The entire string s is the minimum window.
         * Example 3:
         *
         * Input: s = "a", t = "aa"
         * Output: ""
         * Explanation: Both 'a's from t must be included in the window.
         * Since the largest window of s only has one 'a', return empty string.
         */

        System.out.println( minWindow("ADOBECODEBANC", "ABC"));

        System.out.println( minWindow("A", "A"));
        System.out.println( minWindow("A", "AA"));
    }


    public static String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) return "";

        Map<Character, Integer> targetFreq = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetFreq.put(c, targetFreq.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0, minLen = Integer.MAX_VALUE;
        int minStart = 0;
        int required = t.length();

        Map<Character, Integer> windowFreq = new HashMap<>();

        while (right < s.length()) {
            char c = s.charAt(right);
            windowFreq.put(c, windowFreq.getOrDefault(c, 0) + 1);

            if (targetFreq.containsKey(c) &&
                    windowFreq.get(c) <= targetFreq.get(c)) {
                required--;
            }

            // Try to shrink window from the left
            while (required == 0) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minStart = left;
                }

                char leftChar = s.charAt(left);
                windowFreq.put(leftChar, windowFreq.get(leftChar) - 1);

                if (targetFreq.containsKey(leftChar) &&
                        windowFreq.get(leftChar) < targetFreq.get(leftChar)) {
                    required++;
                }

                left++;
            }

            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }

}
