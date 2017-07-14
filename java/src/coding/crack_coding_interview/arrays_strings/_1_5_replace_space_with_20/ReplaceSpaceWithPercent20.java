package coding.crack_coding_interview.arrays_strings._1_5_replace_space_with_20;

import java.util.Scanner;

/**
 * Replace space character in string by "%20",
 * Approach : Using copying chars in new char[] 
 * @author jay.prakash
 *
 */
public class ReplaceSpaceWithPercent20 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String inLine = in.nextLine();
		replaceSpaceWithPercent20(inLine);
		in.close();
	}

	public static void replaceSpaceWithPercent20(String str) {
		char[] charArray = str.toCharArray();
		System.out.println(charArray);
		int length = str.length() ;
		int countSpaces = 0; // Initialize count to zero
		for (char character : charArray) {
			countSpaces = character == ' ' ? 
							++countSpaces : //PreIncrement : First increase count then use   
								countSpaces;// else don't increase count space.
		}
		
		int newLength = length + countSpaces * 2 ;
		
		char []	charNewArray = new char[newLength]   ;
		
		for(int i =length-1 ;i >=0 ; i--){
		
			if(charArray[i]==' '){
				charNewArray[newLength - 1] = '0' ;
				charNewArray[newLength - 2] = '2' ;
				charNewArray[newLength - 3] = '%' ;
				newLength = newLength-3 ;
			}
			else {
				charNewArray[newLength - 1] = charArray[i] ;
				newLength-- ;
			}
		}
		
		System.out.println(charNewArray);	
	}

}
 