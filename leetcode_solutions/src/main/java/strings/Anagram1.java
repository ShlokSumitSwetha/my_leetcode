package strings;

class Anagram1 {

	public static void main(String[] args) {
		System.out.println("anagram".charAt(1)-'a');
		//System.out.println(isAnagram("anagram", "nagaram"));
		System.out.println(isAnagram2("aaagram", "nagaram"));

		String s = "aaagramnagaram";

		int value =s.length()/2;

		System.out.println(s.length()/2);
		System.out.println(s.substring(0, s.length()/2));

	}
	public static boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		int[] counter = new int[26];
		for (int i = 0; i < s.length(); i++) {
			char value = s.charAt(i);
			int check = value -'a';

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
		if (s.length() != t.length()) {
			return false;
		}
		int[] table = new int[26];
		for (int i = 0; i < s.length(); i++) {
			table[s.charAt(i) - 'a']++;
		}
		for (int i = 0; i < t.length(); i++) {
			table[t.charAt(i) - 'a']--;
			if (table[t.charAt(i) - 'a'] < 0) {
				return false;
			}
		}
		return true;
	}
}
