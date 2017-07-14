package problems.string.find_most_frequent_character_in_string;

import java.util.HashMap;
import java.util.Map;

public class MostFrequentCharInString {

	public char getMostFrequentCharInString(String string) {
		int len = string.length();
		Map<Character,Integer> map ;
		map = new HashMap<Character, Integer>(len);
		
		int maxSoFar = 1;
		char maxChar = string.charAt(0);
		
		for(int i=0;i< len ;i++){
			int current ;
			char keyChar = string.charAt(0);
			Integer occuredNoOfTime = map.get(keyChar );/**Returns value mapped by this Key */
			if(occuredNoOfTime==null){
				current = 1; /** If null value in map (Value does not existed), set occuredNoOfTimes to 1   */
			}
			else{
				/** else if occurCount not null, get occuredNoOfTimes    */
				current = Integer.valueOf(occuredNoOfTime.intValue()+1);
			}
			
			map.put(keyChar, Integer.valueOf(current));
			if(maxSoFar < current){
				maxSoFar = current ;
				maxChar = keyChar ; 
			}
		}
		
		return maxChar;
	}
	
}
