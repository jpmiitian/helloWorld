package coding.hackerrank.string.prob2_letter_pairs_histogram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class LetterPairHisto {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter text: ");
//	BufferedReader br = new BufferedReader(new InputStreamReader(System.in) ) ;
//	String inpText = br.readLine() ;	
	
		String inpText = in.nextLine();
		/*
		 * Assumption 
		 * Input text is in lower cases with words separated by space
		 */
		String[] wordArray = inpText.toLowerCase().split(" ") ;
		Map<String,Integer> lpHistoMap  = findLetterPairHistogram(wordArray )  ;
		
	//	printOutput(  lpHistoMap )   ;
		printOutput(  sortMapByValuesInDescOrder (lpHistoMap )  ) ;
		in.close(); // closing scanner
	}
	
	/**
	 * This method return List of entries in a map, after sorting them on values.
	 * 
	 * @param lpHistoMap
	 * 				The input map that needs to be sorted based on values.
	 * @return
	 * 		 entryLinkList : Link List containing entries from map, which are sorted based on entry.getValue() .
	 */
	private static List<Entry<String, Integer>> sortMapByValuesInDescOrder (Map<String,Integer> lpHistoMap){	
		Set<Entry<String, Integer>> histoMapEntrySet =  lpHistoMap.entrySet() ;  
		List<Entry<String, Integer>> entryLinkList = new LinkedList<>(histoMapEntrySet) ;
		/*
		 * Comparator to sort entries based on values.
		 * We need to sort on descending order based on values
		 */
		Collections.sort(entryLinkList, new Comparator<Entry<String, Integer>>() {
			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				return  - o1.getValue().compareTo(o2.getValue()) ; // minus for descending order 
			}
		});
		
		return entryLinkList ; //return sorted entryList
	}
	
	
	
	private static void printOutput(List<Entry<String, Integer>> entryList){
		System.out.print("Histogram: ");	
		Iterator<Map.Entry<String,Integer>> lnkPairItr  =  entryList.iterator() ;
		
		while(lnkPairItr.hasNext() ){
			Entry<String, Integer> pair = lnkPairItr.next() ;
			// print pair 
			System.out.print(pair.getKey() +":"+pair.getValue());	
			
			//print comma if its any other entry exists after this entry.
			if( lnkPairItr.hasNext()) {
				System.out.print(",");	
			}
		}
	}
	
	
	
	private static void printOutput(Map<String,Integer> lpHistoMap ){
		System.out.print("Histogram: ");	
		Iterator<String> lnkPairItr  =  lpHistoMap.keySet().iterator() ;
		
		while(lnkPairItr.hasNext() ){
			String pairKey = lnkPairItr.next() ;
			// print pair 
			System.out.print(pairKey +":"+lpHistoMap.get(pairKey));	
			
			//print comma if its any other entry exists after this entry.
			if( lnkPairItr.hasNext()) {
				System.out.print(",");	
			}
		}
	}
	
	
	
	private static Map<String, Integer> findLetterPairHistogram(String[] wordArray) {
		Map<String, Integer> lpHistoMap = new LinkedHashMap<String, Integer>();

		for (String word : wordArray) {
			if (word.length() == 1)
				continue; // skip this word
			else {
				char[] charArr = word.toCharArray();
				for (int i = 1; i < charArr.length; i++) {
					char[] pair = new char[] { charArr[i - 1], charArr[i] };
					String pairKey = new String(pair);
					/*
					 * If this key is not present in histogram map. Put this key in map with corresponding count
					 */
					if (!lpHistoMap.keySet().contains(pairKey)) {
						lpHistoMap.put(pairKey, 1);
					} else {
						Integer count = lpHistoMap.get(pairKey);
						lpHistoMap.put(pairKey, count + 1);
					}
				}
			}
		}
		return lpHistoMap;
	}
	
 

}
