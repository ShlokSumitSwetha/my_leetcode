package strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class RepeatedDna {


	public List<String> findRepeatedDnaSequences(String s) {
		// write your code...

		//1. Construct all possible 10 character long sequence

		Map<String, Integer> map  = new HashMap<>();
		for(int i =0; i<= s.length(); i++){

			String subString  = s.substring(i, i+10);
			map.put(subString, map.getOrDefault(subString, 0)+1);
		}

		List<String> result = new ArrayList<>();

		for(Map.Entry<String, Integer> value:  map.entrySet()){

			if(value.getValue()>1){
				result.add(value.getKey());
			}

		}

      return result;
	}
}
