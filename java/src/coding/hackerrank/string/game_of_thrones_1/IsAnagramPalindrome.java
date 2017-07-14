package coding.hackerrank.string.game_of_thrones_1;

import java.util.HashMap;
import java.util.Scanner;


public class IsAnagramPalindrome {

			
    public static void main(String[] args) {
        Scanner myScan = new Scanner(System.in);
        String string = myScan.nextLine();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < string.length(); i++) {
			Integer val =map.get(string.charAt(i));
        	if(val==null || val==0){
        		map.put(string.charAt(i), 1);
        	}
        	else{
        		map.put(string.charAt(i),++val);
        	}
		}
        // Assign ans a value of YES or NO, depending on whether or not inputString satisfies the required condition
        System.out.println(isAnagramPalindrome(map));
        map =null;
        myScan.close();
    }
	
    static String isAnagramPalindrome(HashMap<Character, Integer> map){
    	String response = null;
    	Integer countVal =0;
    	Integer countDiffChars =0;
    	for(Character key: map.keySet()){
    		countDiffChars++;// total different chars in this map
    		countVal+=map.get(key); // total letters in this map including repeating chars
    	}
  /*
   *   	COUNT IS ODD.. ALL EXCEPT ONE SHOULD BE IN PAIRS.... CVAL = ODD, A c C D C D C
    	COUNT VAL IS EVEN ...ALL SHPULD BE IN PAIRS  ...A C A V C D.. a a c c (v,d) should be in pairs
  */  	
    	if(countVal%2==0){   //total count is even, all should be in pairs
    		for(Character key: map.keySet()){
        		if(map.get(key)%2==1){
        			response="NO";
        		} 
        	}
    		response="YES"; 
    	}
    	else if(countVal%2==1){ //total count is odd, all except one should be in pairs
    		int notInPairs=0;
    		for(Character key: map.keySet()){
        		if(map.get(key)%2==1){
        			notInPairs++;
        		} 
        	}
    		if(notInPairs==1){
    			response="YES";
    			}
    		else if (notInPairs > 1){
    			response ="NO";
    			}
    	}
    	return response;
    }
	
}
