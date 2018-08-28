package SimpleProblems;

public class FriendsPairing {
	
	/**
	 * So this is a  bottoms up approach
	 * @param n
	 * @return
	 * 
	 * So I need to keep this concept in mind for solving these kinds of questions
	 * 
	 */
	private static int possiblePairings(int n){
		
		int[] dp = new int[n+1];
		dp[0]=0;
		dp[1]=1;
		dp[2] =2;
		
		for(int i=3 ;i<=n ; i++){
			dp[i] =dp[i-1]+ (i-1)*dp[i-2];
		}
		
		return dp[n];
		
	}
	
	public static void main(String args[]){
		System.out.println(possiblePairings(4));
	}

}
