package coding.hackerrank.ds.maps.dictionary_maps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class DictAndMaps {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		List<String> queryNamesList = new ArrayList<String>();
		int n = Integer.valueOf(scan.nextLine()); // no. of entries.

		for (int count = 0; count < n; count++) {
			String ipEntry = scan.nextLine();
			String[] strArr = ipEntry.split(" ");
			map.put(strArr[0], Integer.valueOf(strArr[1]));
		}

		while (true) {
			String nxtInputLine = scan.nextLine();
			if (!nxtInputLine.isEmpty())
				queryNamesList.add(nxtInputLine);
			else 
				break ; // if input is empty line.
		}

		Iterator<String> itr = queryNamesList.iterator();
		while (itr.hasNext()) {
			String printThis = findStringToPrint(itr.next(), map);
			System.out.println(printThis);
		}

		scan.close();
	}

	public static String findStringToPrint(String nameToSearch, Map<String, Integer> map) {
		String EQ_SYMBOL = "=";
		String NOT_FOUND = "Not found";

		if (map.containsKey(nameToSearch))
			return nameToSearch.concat(EQ_SYMBOL).concat(String.valueOf(map.get(nameToSearch)));

		return NOT_FOUND;
	}

}
