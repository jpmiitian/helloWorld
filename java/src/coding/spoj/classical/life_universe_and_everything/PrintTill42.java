package coding.spoj.classical.life_universe_and_everything;

import java.util.Scanner;

public class PrintTill42 {
/** optimized solution
 * 	
 *
 public static void main (String[] args) throws java.lang.Exception
 {
     java.io.BufferedReader r = new java.io.BufferedReader (new java.io.InputStreamReader (System.in));
     String s;
     while (!(s=r.readLine()).startsWith("42")) System.out.println(s);
  }

 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int input;
		input = scan.nextInt();
		print(input);
		scan.close();
	}
	
	public static void print(int input){
		if(input==42){
			System.exit(0);
		}
		while (input != 42) {
			System.out.println(input);
			Scanner scan2 = new Scanner(System.in);
			int input2;
			input2 = scan2.nextInt();
			print(input2);
			scan2.close();
		}
	} 

}
