package coding.interview_bit;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
You are in an infinite 2D grid where you can move in any of the 8 directions :
 (x,y) to 
    (x+1, y), 
    (x - 1, y), 
    (x, y+1), 
    (x, y-1), 
    (x-1, y-1), 
    (x+1,y+1), 
    (x-1,y+1), 
    (x+1,y-1) 
You are given a sequence of points and the order in which you need to cover the points. 
Give the minimum number of steps in which you can achieve it.
 You start from the first point.
 */
public class ReachAllPoints {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Integer noPointsInListX;
		Integer noPointsInListY;
		
		noPointsInListX = Integer.parseInt(in.nextLine());
		
		List<Integer> listX  = new ArrayList<Integer>(noPointsInListX);
		
		for (int i = 0; i < noPointsInListX; i++) {
			listX.add(Integer.parseInt(in.nextLine()));
		}
	
		noPointsInListY = Integer.parseInt(in.nextLine());
		
		List<Integer> listY  = new ArrayList<Integer>(noPointsInListX);
		
		for (int i = 0; i < noPointsInListY; i++) {
			listY.add(Integer.parseInt(in.nextLine()));
		}
		
		int noOfSteps = coverPoints(listX ,listY) ;
		
		System.out.println(noOfSteps);
		
		in.close();
	}
	
	// X and Y co-ordinates of the points in order.
    // Each point is represented by (X.get(i), Y.get(i))
	public static int coverPoints(List<Integer> listX, List<Integer> listY) {
		int noStepsRequired  = 0; 
		if (listX.isEmpty() || listY.isEmpty()) {
			return noStepsRequired;
		}
		else if (listX.size() == 1 || listX.size() == 1) {
			noStepsRequired = 1;
		}
		else{
			noStepsRequired = totalStepsRequired(listX,listY) ;
		}
		
		return noStepsRequired ;
	}

	private static int totalStepsRequired(List<Integer> listX, List<Integer> listY) {
		int noStepsRequired = 0 ;
		
		int presentX =0 ;
		int  presentY =0 ;
		int nextX = presentX ;
		int nextY = presentY ;
		int diffX =0;
		int diffY =0;
		for (int i = 0 ;i<listX.size();i++){
			  presentX = listX.get(i) ;
			  presentY = listX.get(i) ;
			
			if(i!=listX.size() -1){
				  nextX = listX.get(i) ;
				  nextY = listX.get(i) ;
			}
			
			// X same Y is different
			if(nextX==presentX && nextY!=presentY){
				noStepsRequired += Math.abs((nextY -presentY)) ;
			}// X is not same but Y is same 
			else if(nextX!=presentX && nextY==presentY){
				noStepsRequired += Math.abs((nextX -presentX)) ;
			}
			else{// Both next X and next Y are different
				diffX =	nextX- presentX ;
				diffY =	nextY- presentY ;
				if(presentX>=0 && presentY >=0  && diffX >=0 && diffY >=0){//CASE:I Let both next points be in +,+ quadrant
					while(presentX!=nextX && presentY!=nextY ){
						if(presentX < nextX && presentY < nextY){
							presentX++;
							presentY++;
							noStepsRequired++ ;
						}
						else if(presentX == nextX && presentY < nextY){
							//presentX++;
							presentY++;
							noStepsRequired++ ;
						}else if(presentX < nextX && presentY == nextY){
							presentX++;
							//presentY++;
							noStepsRequired++ ;
						}
						
					}
				}
				
			}
			
		}
		
		
		
		return noStepsRequired;
	}	
	 	
}
