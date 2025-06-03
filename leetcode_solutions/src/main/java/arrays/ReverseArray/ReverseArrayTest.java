package arrays.ReverseArray;

public class ReverseArrayTest {
	public static void main(String[] args) {

		char[] s={'s','u','m','i','t', 'h'};
		ReverseArrayTest test=new ReverseArrayTest();
		char[] result=test.reverseString(s);
		for(int i=0;i<result.length;i++){
			System.out.println(result[i]);
		}

	}
	public char[] reverseString(char[] s) {
		int left=0; // initial
		int right=s.length-1;// last
		char temp;

		while(left<right){
			// Swap the elements at left and right indexes
			temp=s[left];
			s[left]=s[right];
			s[right]=temp;
			// Move towards the center
			left++;
			right--;
		}
		return s;
	}
}
