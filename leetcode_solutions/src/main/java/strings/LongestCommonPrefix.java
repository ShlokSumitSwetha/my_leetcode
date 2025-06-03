package strings;

	public class LongestCommonPrefix {

		public static void main(String[] args) {
			String[] arrays= {"Leetcode", "Leeeee", "Lee"};
			System.out.println(longestCommonPrefix(arrays));
		}
		public static String longestCommonPrefix(String[] strs) {
			// write your code here
			String prefix = strs[0];

			if(strs.length ==0){
				return "";
			}

			for(int i=1; i<strs.length; i++){

				while(strs[i].indexOf(prefix)!=0){
					prefix = prefix.substring(0, prefix.length()-1);

					if(prefix.isEmpty()){
						return null;
					}
				}
			}
			return prefix;
		}
	}


