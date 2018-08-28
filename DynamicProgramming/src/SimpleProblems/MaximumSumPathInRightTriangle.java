package SimpleProblems;

public class MaximumSumPathInRightTriangle {
	
	private static int maxSum(int[][]arr , int x, int y){
		
		if(x>= arr.length || y>=arr.length){
			return 0;
		}
		
		int belowMax = maxSum(arr, x+1, y);
		int belowRightMax = maxSum(arr, x+1, y+1);
		return  arr[x][y]+ Math.max(belowMax , belowRightMax) ;
	}
	
	//Now need to solve this question using dynamic programming
	
	/**
	 * Awesome Vishwa, so you have solved this problem without looking into the hint :)
	 * @param arr
	 * @return
	 */
	
	private static int maxSumDynamic(int[][] arr){
		
		int[][] dp  = new int[arr.length][arr.length];
		
		for(int i=arr.length-1;i>=0 ;i--){
			for(int j=i ;j>=0;j--){
				if(i==arr.length-1){
					dp[i][j]=arr[i][j];
					continue ;
				}
				
				dp[i][j] = arr[i][j] + Math.max(dp[i+1][j], dp[i+1][j+1]);
			}
		}
		return  dp[0][0] ;
	}
	
	
	
	public static void main(String [] args){
		
		int[][] arr  ={ { 1 },
		        {1 ,2},
		        { 4 ,1, 2},
		        {2, 3, 1, 1}}; 
		
		int[][] arr2 = {{2},
		        {4, 1},
		        {1, 2, 7}};
		
		System.out.println(maxSum(arr, 0, 0));
		
		System.out.println(maxSumDynamic(arr));
	}

}
