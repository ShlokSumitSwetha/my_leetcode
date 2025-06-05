package strings.anagram;

class Anagram1 {

	public static void main(String[] args) {
		System.out.println("anagram".charAt(1)-'a');
		System.out.println(isAnagram("anagram", "nagaram"));
		System.out.println(isAnagram2("anagram", "nagaram"));

	}
	public static boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		int[] counter = new int[26];
		for (int i = 0; i < s.length(); i++) {
			counter[s.charAt(i) - 'a']++;
			counter[t.charAt(i) - 'a']--;
		}
		for (int count : counter) {
			if (count != 0) {
				return false;
			}
		}
		return true;
	}

	public static boolean isAnagram2(String s, String t) {
		// If lengths are not equal, they can't be anagrams
		if (s.length() != t.length()) {
			return false;
		}

		// Frequency table for lowercase letters a-z
		int[] table = new int[26];

		// Count each character in string s
		for (int i = 0; i < s.length(); i++) {
			table[s.charAt(i) - 'a']++;
		}

		// Subtract counts based on string t
		for (int i = 0; i < t.length(); i++) {
			table[t.charAt(i) - 'a']--;
			if (table[t.charAt(i) - 'a'] < 0) {
				return false; // More of a char in t than in s
			}
		}

		return true; // All counts matched
	}
}
