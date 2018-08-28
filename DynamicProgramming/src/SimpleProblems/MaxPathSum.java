package SimpleProblems;

/**
 * Awesome, I was able to solve this problem as well
 * @author vmohan
 *
 */
public class MaxPathSum {
	
	private static int maxPathSum(int[][] arr){
		
		//Path down, downLeft or downRight
		
		int[][] m = new int[arr.length][arr[0].length];
		
		for (int i = 0; i < arr[0].length; i++) {
			m[arr.length-1][i] = arr[arr.length-1][i];
		}
		
		for(int i=arr.length-2;i>=0 ;i--){
			for(int j=arr[0].length-1;j>=0;j--){
				if(j==arr[0].length-1){
					m[i][j]= arr[i][j]+ Math.max(m[i+1][j], m[i+1][j-1]);
				}else if(j==0){
					m[i][j]= arr[i][j]+ Math.max(m[i+1][j], m[i+1][j+1]);
				}else{
					m[i][j]= arr[i][j]+ Math.max(Math.max(m[i+1][j], m[i+1][j+1]),m[i+1][j-1]);
				}
			}
		}
		
		
		return  m[0][0];
	}
	
	public static void main(String args[]){
		int[][] arr = { {4, 2, 3, 4},
                {2, 9, 1, 10},
                {15, 1, 3, 0},
                {16, 92, 41, 44} };
		
		System.out.println(maxPathSum(arr));
	}

}
