package strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


class RepeatedDna_hashset {


	public List<String> findRepeatedDnaSequences(String s) {
		// write your code...

		//1. Construct all possible 10 character long sequence

		Set<String> set  = new HashSet<>();
		Set<String> result  = new HashSet<>();
		for(int i =0; i<= s.length(); i++){

			String subString  = s.substring(i, i+10);

			if(!set.add(subString)){
				result.add(subString);
			}
		}

		return new ArrayList<>(result);
	}
}
