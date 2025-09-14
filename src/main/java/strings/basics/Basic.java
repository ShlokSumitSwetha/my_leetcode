package strings.basics;

public class Basic {
    public static void main(String[] args) {
        String s1 = "Hello Lee!";
        System.out.println(s1.indexOf("Lee"));  // Output: 6

        System.out.println(s1.indexOf("lee"));  // Output: -1 (case-sensitive)

        System.out.println(s1.indexOf("o"));    // Output: 4

        System.out.println(s1.indexOf("eU"));    // Output: 4
        System.out.println(s1.indexOf(0));    // Output: 4

        System.out.println(s1.lastIndexOf("L"));    // Output: 4

        System.out.println(s1.repeat(8));    // Output: 4

        System.out.println(s1.subSequence(0, 4));    // Output: 4
    }
}
