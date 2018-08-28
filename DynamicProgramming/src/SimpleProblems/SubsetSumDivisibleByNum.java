package SimpleProblems;

public class SubsetSumDivisibleByNum {

	private static boolean subsetPresent(int[]arr , int end , int m){
		if(arr ==null || arr.length ==0){
			return false ;
		}
		
		if(m==0){
			return true ;
		}
		if(end<=0 && m!=0){
			return false ;
		}
		return subsetPresent(arr, end-1, arr[end]%m) || subsetPresent(arr, end-1, m)  ;
	}
	
	/**
	 * Awesome, this is a great question to ponder upon :)
	 * @param arr
	 * @param m
	 * @return
	 */
	private static boolean subsetPresent(int[] arr , int m){  //This is know as the method overloading
		
		
		boolean[][] dp = new boolean[arr.length +1][m+1];  //dp[arr.length][m] -> should give the result
		
		for(int i= 0; i<dp.length ;i++){
			for(int j=0;j<=m;j++){
			   if(i==0){
				   dp[i][j]=false ;
				   continue;
			   }
			   
			   if(j==0){
				   dp[i][j]= true;
				   continue;
			   }
			   
			   dp[i][j] = dp[i-1][j] || dp[i-1][(arr[i-1]%j)];
			}
		}
		
		return dp[arr.length][m] ;
	}
	
	
	public static void main(String args[]){
		
		int arr[] = {1, 6};
		
		System.out.println(subsetPresent(arr, 1, 5));
		
		System.out.println(subsetPresent(arr,5));
		
	}
	
	
	
}                                                                            
