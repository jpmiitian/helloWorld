package coding.interview_bit.find_min_steps_in_2D_grid;


import java.util.ArrayList;

public class MinStepsIn2dGrid { 
	
	/*
	 * X and Y co-ordinates of the points in order.
     * Each point is represented by (X.get(i), Y.get(i))
     */	
    public static  int coverPoints(ArrayList<Integer> X, ArrayList<Integer> Y) {
	Integer stepRequired = 0 ;
        
        if(X.size()==1)
    	    return 0 ;	
    
//    	Integer prevX = X.get(1) ;
//		Integer prevY = Y.get(1) ;
	
    	Integer prevX = X.get(0) ;
		Integer prevY = Y.get(0) ;
	
    	
		for (int i = 1; i < X.size(); i++) {
			Integer nextX = X.get(i);
			Integer nextY = Y.get(i);

			Integer xDiff = Math.abs(nextX - prevX);
			Integer yDiff = Math.abs(nextY - prevY);

			prevX = nextX;
			prevY = nextY;

			if(xDiff==0 && yDiff==0){
				stepRequired = stepRequired + 0 ;
				continue ;
			}
				
			
			if (xDiff == 0)
				stepRequired += yDiff;
			if (yDiff == 0)
				stepRequired += xDiff;

			if (xDiff > yDiff)
				stepRequired += xDiff;
			if (xDiff <= yDiff)
				stepRequired += yDiff;

		}
    	
    	return stepRequired ;
    
    }
    
    /*
     * 2 -7 -13 
		2 1 -5
     */
    public static void main(String [] args) {
    	ArrayList<Integer> X = new ArrayList<>(); 
    	ArrayList<Integer> Y = new ArrayList<>();
    	

//    	String[] xArray =  ("4 8 -7 -5 -13 9 -7 8").split(" ") ; 
//    	String[] yArray =  ("4 -15 -10 -3 -13 12 8 -8").split(" ") ; 
    	
    	String[] xArray =  ("-7 -13").split(" ") ; 
    	String[] yArray =  ("1 -5").split(" ") ; 
    	
    	
    	for(String num : xArray ){
    		X.add(Integer.parseInt(num)) ;
    	}
    	for(String num : yArray ){
    		Y.add(Integer.parseInt(num)) ;
    	}
    		
    	
//    		X.add(2) ;
//    		X.add(-7) ;
//    		X.add(-13) ;
//    		
//    		Y.add(2) ;
//    		Y.add(1) ;
//    		Y.add(-5) ;
    		
    		System.out.println( coverPoints(X,Y)) ;
    	
	}
    
    
    //performOps was called with A : [5, 10, 2, 1]. What would be the output of the following call :
    ArrayList<Integer> performOps(ArrayList<Integer> A) {
        ArrayList<Integer> B = new ArrayList<Integer>();
        for (int i = 0; i < 2 * A.size(); i++) // 8 
        	B.add(0); // 8 times 0
        for (int i = 0; i < A.size(); i++) {
                B.set(i, A.get(i)); //5  10 2 1 
                B.set(i + A.size(), A.get((A.size() - i) % A.size())); // (i+ 5 ) , a  [(5- 1 ) % 5  ] 
                /*
                 * B[5] =  a.get [ 0] 5 
                 * B[6] =  a.get [3 ] 1
                 * B[6] =  a.get [2] 2
                 * B[0] = A[0]   10
                 * B[1] =  A [ ] 
                 */
        }
        return B;
}
 // 5, 10, 2, 1   
	
}
