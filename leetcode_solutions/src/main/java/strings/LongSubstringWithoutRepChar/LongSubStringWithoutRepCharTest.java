package strings.LongSubstringWithoutRepChar;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LongSubStringWithoutRepCharTest {

    public static void main(String[] args) {

       System.out.println( lengthOfLongestSubString("abcabcd"));
        System.out.println( lengthOfLongestSubStringUsingMap("abcabcd"));
        System.out.println( lengthOfLongestSubStringUsingSubString("abcabcd"));
    }

    public static int lengthOfLongestSubString(String s) {

        int a_pointer = 0;
        int b_pointer = 0;
        int max = 0;

        HashSet<Character> hashSet = new HashSet<>();
        while (b_pointer < s.length())
            if (!hashSet.contains(s.charAt(b_pointer))) {
                hashSet.add(s.charAt(b_pointer));
                b_pointer++;
                max = Math.max(hashSet.size(), max);
            } else {
                hashSet.remove(s.charAt(a_pointer));
                a_pointer++;
            }

        return max;
    }

    public static int lengthOfLongestSubStringUsingMap(String s) {

        int maxlength = 0;

        Map<Character, Integer> visitedCharacters = new HashMap<>();

        for(int right=0, left=0; right<s.length(); right++){
            char currentChar = s.charAt(right);
            // If value already contains then move the left cursor forward one step
	        if(visitedCharacters.containsKey(currentChar) && visitedCharacters.get(currentChar) >= left){
		        left =  visitedCharacters.get(currentChar)+1;
	        }
            maxlength= Math.max(maxlength, right-left+1);
	        visitedCharacters.put(currentChar, right);
        }
        return  maxlength;
    }

    public static int lengthOfLongestSubStringUsingSubString(String s) {

        int maxlength = 0;

        for(int right=0, left=0; right<s.length(); right++){
           int indexOfFirstAppearanceInSubString= s.indexOf(s.charAt(right), left);
            if(indexOfFirstAppearanceInSubString!= right){
                left =  indexOfFirstAppearanceInSubString+1;
            }
            maxlength= Math.max(maxlength, right-left+1);
        }
        return  maxlength;
    }
}
