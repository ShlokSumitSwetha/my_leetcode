package two_pointers.is_subsequence;

public class Twopointer1 {

	public static void main(String[] args) {
		Twopointer1 twopointer1 = new Twopointer1();

		//twopointer1.isSubsequence( "abc", "ahbgdc");
	}

	public boolean isSubsequence(String s, String t) {
		int l=0,r=s.length()-1;

		for (int i=0; i<t.length(); i++) {
		  char match= t.charAt(i);
			while(l<r){
				if(s.charAt(l)!=match){//comparing characters from starting and ending
					l++;//if it is same then increase l and decrease r then continue to next iteration
					r--;
				}

			}
		}

		return true;
	}
}