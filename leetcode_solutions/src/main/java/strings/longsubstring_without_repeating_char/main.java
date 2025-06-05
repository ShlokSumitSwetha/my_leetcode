package strings.longsubstring_without_repeating_char;

public class main {

	public static void main(String[] args) {
		String s= "abcabcd";

		System.out.println(s.indexOf(s.charAt(0), 2));
	}
}
