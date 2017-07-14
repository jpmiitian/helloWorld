package coding.interview_bit;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**

Find out the maximum sub-array of non negative numbers from an array.
The sub-array should be continuous. That is, a sub-array created by 
choosing the second and fourth element and skipping the third element is invalid.

Maximum sub-array is defined in terms of the sum of the elements in the sub-array.
Sub-array A is greater than sub-array B if sum(A) > sum(B).
 
NOTE1: If there is a tie, then compare with segment's length and return segment which has maximum length
NOTE2: If there is still a tie, then return the segment with minimum starting index

 */
public class MaxSubArray {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Integer noOfInputs;
		noOfInputs = Integer.parseInt(in.nextLine());
		ArrayList<Integer> intArrayList = new ArrayList<Integer>(noOfInputs);
		for (int i = 0; i < noOfInputs; i++) {
			intArrayList.add(Integer.parseInt(in.nextLine()));
		}
		
		ArrayList<Integer> arrayListResult = maxset( intArrayList);
		for(int j=0 ;j<arrayListResult.size() ; j++){
			System.out.println(arrayListResult.get(j));
		}
		in.close();
	}
	
	
	public static ArrayList<Integer> maxset(ArrayList<Integer> inputList) {
		Boolean isListOneActive = false;
		Boolean isListTwoActive = false;
		ArrayList<Integer> resultArrayList = new ArrayList<Integer>();
		List<Integer> resultSubList = null ;
		int startIndxA = -1;
		int startIndxB = -1;
		int endIndxA = -1;
		int endIndxB = -1;
		Long sumListA = null;
		Long sumListB = null;
	//	MaxSubArray maxSubArray = new MaxSubArray();
				
		for (int i = 0; i < inputList.size(); i++) {
			int numAtIndex = inputList.get(i);
			if (numAtIndex >= 0) {
				// list one not active and positive number
				if (!isListOneActive && !isListTwoActive && sumListA == null) {
					isListOneActive = true;// activate list
					startIndxA = i;
					endIndxA = i;
					sumListA = (sumListA == null) ? numAtIndex : (sumListA + numAtIndex);
					}
				else if (!isListTwoActive && !isListOneActive && sumListB == null) {
					isListTwoActive = true;// activate list
					startIndxB = i;
					endIndxB = i;
		//			Long sumListB_Long = (sumListB == null) ? numAtIndex : (sumListB.longValue() + numAtIndex);
					sumListB = (sumListB == null) ? numAtIndex : (sumListB + numAtIndex);
					 } // listOne is Active add numbers in it.
				else if (!isListOneActive && !isListTwoActive && sumListA != null && sumListB != null) {
					if (sumListA < sumListB || (sumListA == sumListB && startIndxA > startIndxB)) {
						sumListA = null;
						isListOneActive = true;// activate list
						startIndxA = i;
						endIndxA = i;
						sumListA = (sumListA == null) ? numAtIndex : (sumListA + numAtIndex); 
						}
					else if (sumListA > sumListB || (sumListA == sumListB && startIndxA > startIndxB)) {
						sumListB = null;// set sum to null for RE-ACTIVATING
						isListTwoActive = true;// activate list
						startIndxB = i;
						endIndxB = i;
						sumListB = (sumListB == null) ? numAtIndex : (sumListB + numAtIndex); // sumListB
						}
					} 
				else if (isListOneActive && !isListTwoActive && startIndxA >= 0 && sumListA != null) {
					sumListA += numAtIndex;
					endIndxA = i;// update EndIndex to currentIndex
				} 
				else if (isListTwoActive && !isListOneActive && startIndxB >= 0 && sumListB != null) {
	//				Long sumListB_Long = (sumListB == null) ? numAtIndex : (sumListB.longValue() + numAtIndex);
					sumListB += numAtIndex;
					endIndxB = i;// update EndIndex to currentIndex
				}

				// Need to Check big list condition
				if (i == inputList.size() - 1) {
					if (sumListA == null && sumListB == null) {
						return resultArrayList;
					} 
					else if (isListOneActive && !isListTwoActive) {
						if ((sumListA != null && sumListB == null) || ((sumListA != null && sumListB != null))) {
							resultSubList = returnGreaterSubList(inputList, sumListA, sumListB, startIndxA, startIndxB,
									endIndxA, endIndxB);
						}
					} 
					else if (!isListOneActive && isListTwoActive) {
						if ((sumListA == null && sumListB != null) || ((sumListA != null && sumListB != null))) {
							resultSubList = returnGreaterSubList(inputList, sumListA, sumListB, startIndxA, startIndxB,
									endIndxA, endIndxB);
						}
					} 
					else if (!isListOneActive && isListTwoActive && sumListA == null && sumListB != null) {
						resultSubList = inputList.subList(startIndxB, endIndxB + 1);
					}
					else if (!isListOneActive && !isListTwoActive && sumListA != null && sumListB != null) {
						resultSubList = returnGreaterSubList(inputList, sumListA, sumListB, startIndxA, startIndxB,
								endIndxA, endIndxB);
					}
				}
			} else if (numAtIndex < 0) {
				if (isListOneActive) {
					isListOneActive = false; // DE-ACTIVATE FIRST LIST
				} else if (isListTwoActive) {
					isListTwoActive = false; // DE-ACTIVATE SECOND LIST
				}
				//Need to Check big list condition	
				if((i==inputList.size()-1 )&&(!isListOneActive && !isListTwoActive && sumListA == null && sumListB == null)){
					resultArrayList  =	new ArrayList<Integer>() ;
					return resultArrayList ;
				}
				else if((i==inputList.size()-1 )&&(!isListOneActive && !isListTwoActive && sumListA != null && sumListB != null)){
					resultSubList =	returnGreaterSubList(  inputList, sumListA,  sumListB, startIndxA, startIndxB , endIndxA,  endIndxB ) ;
				}
				else if((i==inputList.size()-1 ) && ((sumListA != null && sumListB == null) || ((sumListA!=null&&sumListB!=null) )) ){
					resultSubList =	returnGreaterSubList(  inputList, sumListA,  sumListB, startIndxA, startIndxB , endIndxA,  endIndxB ) ;	
				}
			}
		}
		for(Integer numberInList : resultSubList){
			resultArrayList.add(numberInList) ;
		}
		return resultArrayList;
	}

 	private static List<Integer> returnGreaterSubList(ArrayList<Integer> mainList, Long sumListA, Long sumListB,
			int startIndxA, int startIndxB, int endIndxA, int endIndxB) {
		List<Integer> resultList = null;
		List<Integer> subListFirst = null;
		List<Integer> subListSecond = null;
		if (startIndxA != -1) {//form subListFirst
			subListFirst = mainList.subList(startIndxA, endIndxA + 1);
		}
		if (startIndxB != -1) {//form subListSecond
			subListSecond = mainList.subList(startIndxB, endIndxB + 1);
		}
 
		if (sumListA != null && sumListB == null) {
			resultList = subListFirst;
		} 
		else if (sumListA == null && sumListB != null) {
			resultList = subListSecond;
		} 
		else if (sumListA != null && sumListA == sumListB) {
			if (subListFirst.size() > subListSecond.size()) {
				resultList = subListFirst;
			}
			else if (subListFirst.size() < subListSecond.size()) {
				resultList = subListSecond;
			}
			else if (subListFirst.size() == subListSecond.size() && startIndxA <= startIndxB) {
				resultList = subListFirst;
			} else  {
				resultList = subListSecond;
			}
		} 
		else if ((sumListA != null && sumListB != null  )) {
			if (sumListA > sumListB) {
				resultList = subListFirst;
			} else if (sumListA < sumListB) {
				resultList = subListSecond;
			}
		}
		return resultList;
	} 
	
 	
 	
}
