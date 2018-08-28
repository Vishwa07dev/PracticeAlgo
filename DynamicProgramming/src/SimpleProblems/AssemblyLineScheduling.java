package SimpleProblems;

public class AssemblyLineScheduling {
	
	private static int calculateMinimumTime(int[][] operationTime , int[][] shiftingTime , int[] entryTime , int[] exitTime ,  int numberOfStations){
		
		int[] line1 = new int[numberOfStations] ;
		int[] line2 = new int[numberOfStations];
		
		//line[i] indicates, the minium cost to exit from i
		
		line1[0] = exitTime[0]+ operationTime[0][0];
		line2[0]=exitTime[1]+operationTime[1][0];
		
		for(int i=1;i<numberOfStations;i++){
			line1[i] = Math.min(line1[i-1] + operationTime[0][i],shiftingTime[1][i]+operationTime[0][i]+line2[i-1]) ;
			line2[i]= Math.min(line2[i-1]+operationTime[1][i], shiftingTime[0][i]+operationTime[1][i] + line1[i-1]);
		}
 		return Math.min(line1[numberOfStations-1] , line2[numberOfStations-1]) ;
	}
	
	
	public static void main(String args[]){
		int a[][] = {{4, 5, 3, 2},
                {2, 10, 1, 4}};
		
		int t[][] = {{0, 7, 4, 5},
                {0, 9, 2, 8}};
		
		 int e[] = {10, 12}, x[] = {18, 7};
		 
		 System.out.println(calculateMinimumTime(a, t, e, x, 4));
		
	}

}
