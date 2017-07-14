package coding.hackerrank.warmup.plus_minus;

import java.text.DecimalFormat;
import java.util.Scanner;


public class PlusMinus {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Double noOfElements = 0.0;
		double noOfPositives =0.0 ;
		double noOfZeroes =0.0 ;
		double noOfNegatives =0.0 ;
		
		noOfElements = Double.parseDouble(in.nextLine());
		String numbersInLine = in.nextLine();
		
		String[] numberArray = numbersInLine.split("\\ ");

		for (int i = 0; i < noOfElements; i++) {
		
			Double number = Double.parseDouble(numberArray[i]) ;			
			if(number > 0){
				++noOfPositives ;
			}
			else if(number == 0){
				++noOfZeroes  ;
			}
			else if(number < 0){
				++noOfNegatives  ;
			}
		}

		DecimalFormat df = new DecimalFormat("0.000") ;
	//	double fracPositive =  noOfPositives/noOfElements  ;
	//	double fracNegatives =  noOfNegatives/noOfElements  ;
	//	double fracZeroes =  noOfZeroes/noOfElements  ;
	//	String strPos = df.format(fracPositive) ;
		System.out.println(df.format(noOfPositives/noOfElements));
		System.out.println(df.format(noOfNegatives/noOfElements));
		System.out.println(df.format(noOfZeroes/noOfElements));
		in.close();
	}

}
