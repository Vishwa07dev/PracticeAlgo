package SimpleProblems;
/**
 * I need to very careful about the operators and silly mistakes 
 * @author vmohan
 *
 */

public class MaxSizeSquare {
	
	public static int maxSizeSquare(int[][] arr){
		
		//m[i][j] indicates the maximum size of the square which ends at i,j
		
		int[][] m = new int[arr.length][arr[0].length];
		
		for (int i=0 ;i<arr.length;i++){
			m[i][0] = arr[i][0];
			
		}
		
		for (int i=0 ;i<arr[0].length;i++){
			m[0][i] = arr[0][i];
		}	
		
		int maxSize = Integer.MIN_VALUE ;
		
		int xCord =0;
		int yCord =0 ;
		for(int i =1;i<arr.length;i++){
			for(int j=1;j<arr[0].length ;j++){
				if(arr[i][j]!=0){
					m[i][j] = Math.min(Math.min(m[i-1][j], m[i][j-1]),m[i-1][j-1]) +1;
					if(maxSize <m[i][j]){
						maxSize=m[i][j];
						xCord = i ;
						yCord = j ;
					}
				}
				
			}
		}
		
		System.out.println("Square ends are the co-ordinate : "+ xCord +","+yCord );
		
		return maxSize ;
		
	}
	
	public static void main(String args[]){
		int[][] arr = {{0, 1, 1, 0, 1}, 
                {1, 1, 0, 1, 0}, 
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0}};
		
		System.out.println(maxSizeSquare(arr));
	}

}
