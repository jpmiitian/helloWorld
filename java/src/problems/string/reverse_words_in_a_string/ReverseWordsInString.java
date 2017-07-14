package problems.string.reverse_words_in_a_string;

import java.util.Scanner;

public class ReverseWordsInString {

 
	
	public static String reverseAWord(String inStrW) {
		if(inStrW==null || inStrW.length()==1)
			return inStrW ;
		String inStr = inStrW.trim() ;
		char[] charArray = inStr.toCharArray();
		for (int i = 0; i < charArray.length / 2; i++) {
			char temp = inStr.charAt(i);
			charArray[i] = charArray[charArray.length-1 - i];
			charArray[charArray.length-1 - i] = temp;
		}
		String charStr = String.valueOf(charArray)  ;
		return charStr ;
	}
	/*
	 * This method reverses a string removing trailing spaces.
	 */
	public static String reverseWordsInString(String string) {
		String trimmedStr = string.trim() ;
		String reversedString = reverseAWord(trimmedStr) ;
		StringBuilder builder = new StringBuilder();
		String[] revWordsArray = reversedString.split(" ") ;
		
		for (int i = 0; i < revWordsArray.length ; i++) {
			String revWord = null ;
			if(revWordsArray[i].isEmpty())
				continue ;
			else  
			revWord = reverseAWord(revWordsArray[i])  ;
			
			if(i<revWordsArray.length-1){
				builder.append(revWord).append(" ") ;
			} else if(i==revWordsArray.length-1){
				builder.append(revWord);
			}
		}
		return builder.toString();
	}

	public static void main(String[] args) {
//		System.out.println(reverseWordsInString("   a   b "));
		  int i = 4;
	        double d = 4.0;
	        String s = "HackerRank ";
			
	        Scanner scan = new Scanner(System.in);
		
	        i+= Integer.parseInt(scan.nextLine() ); 
            d+= Double.parseDouble(scan.nextLine()) ;
             String   p = scan.nextLine() ;

            System.out.println(i) ;
            System.out.println(d) ;
            System.out.println(s.concat(p)) ;

            scan.close(); 
	}
	
	
	
	
}
