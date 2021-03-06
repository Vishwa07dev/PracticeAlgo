package SimpleProblems;

public class SubSetProblem {
	
	/**
	 * Awesome, so I have solved this question beautifully
	 * @param arr
	 * @param sum
	 * @return
	 */
	private static boolean subsetSumExists(int[] arr , int sum){
		if(sum==0){
			return true ;
		}
		
		if(arr == null || arr.length ==0){
			return false ;
		}
		
		boolean[][] dp  = new boolean [arr.length+1][sum+1]; //dp[i][j] -> will show if sum j is possible by elements till i
		
		for(int i =0;i<=arr.length ;i++){
			for(int j=0;j<=sum ;j++){
				if(j==0){
					dp[i][j] = true ;
					continue ;
				}
				if(i==0){
					dp[i][j]=false ;
					continue ;
				}
				if(j>=arr[i-1]){
					dp[i][j] = dp[i][j] || dp[i-1][j-arr[i-1]] ;
				}
				if(dp[i-1][j]){
					dp[i][j] = dp[i-1][j];
				}
				
			}
		}
		return dp[arr.length][sum] ;
	}
	public static void main(String args[]){
		int[] arr = {3, 34, 4, 12, 2};
		
		System.out.println(subsetSumExists(arr, 9));
	}
}
