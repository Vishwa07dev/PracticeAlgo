package SimpleProblems;
/**
 * Awesome, this was a very good question
 * @author vmohan
 *
 */
public class SubSetSumProblem {
	
	//recursive approach to solve the above problem
	private static boolean sumExists(int[]arr , int sum , int n){
		
		if(sum ==0){
			return true ;
		}
		if(sum!=0 && n==0){
			return false ;
			
		}
		
		return sumExists(arr, sum, n-1 ) || sumExists(arr, sum-arr[n-1], n-1);
		
	}
	
	//Dynamic programming implemnetation for the same question
	
	private static boolean sumExistsDyanamic(int[]arr , int sum , int n){
		if(arr==null || arr.length==0){
			return false ;
			
		}
		
		boolean[][] m = new boolean[sum+1][n+1];
		
		
		
		return sumExistsUtil(arr, sum, n, m);
	}
	
	private static boolean sumExistsUtil(int[]arr , int sum , int n, boolean[][] m){
		//m[i][j]  -> true if elements till j somehow sum to produce i
		
		for(int i=0;i<arr.length;i++){
			m[0][i] = true ;
		}
		
		for(int i=1;i<=sum ;i++){
			m[i][0] = false ;
		}
		
		for(int i=1;i<= sum;i++){
			for(int j=1;j<=arr.length;j++){
				
				m[i][j] = m[i][j-1];
				
				if(arr[j-1] <= i){
					m[i][j] = m[i][j] || m[i-arr[j-1]][j-1];
				}
				
			}
		}
		
		return m[sum][arr.length] ;
	}
	
	public static void main(String [] args){
		
		int set[] = {3, 34, 4, 12, 4, 0,2};
		int sum = 9;
		System.out.println(sumExists(set, sum, 7));
		
		
		System.out.println(sumExistsDyanamic(set, sum, 7));
	}

}
