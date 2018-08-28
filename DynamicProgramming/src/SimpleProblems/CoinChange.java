package SimpleProblems;

public class CoinChange {
	
	private static int totalWays(int[]s , int coins , int sum){
		if(sum ==0){
			return 1 ;
		}
		if(sum <0){
			return 0; //No way can the change be maded
		}
		
		if(coins<=0 && sum >0){
			return 0;
		}
		
		//There can be two ways -> if mth coin is selected or mth coin is not selected
		
		return totalWays(s, coins, sum - s[coins-1]) + totalWays(s, coins-1, sum);
		
	}
	
	private static int dynamicFlavour(int[]s , int coins, int num){
		int[][] m = new int[coins+1][num+1];   //m[i][j] -> maximum number of combibations or changes in i coin and j total value
		
		m[0][0]=1;
		for(int i=1;i<coins+1;i++){
			m[i][0]=1;
		}
		
		for(int i=1;i<num+1;i++){
			m[0][i]=0; //can't be delivered
		}
		
		return totalWaysUtil(s,coins,num, m);
	}
	/*
	 * This approach is the top down , same thing can be coded in the bottoms up way as well :)
	 * 
	 */
	private static int totalWaysUtil(int[]s, int coins, int num, int[][]m){
		if(num <0){
			return 0;
		}
		if(num ==0){
			return 1 ;
		}
		
		if( coins <=0 && num >0){
			return 0;
		}
		
		if(m[coins][num]!=0){
			return m[coins][num] ;
		}
		return  m[coins][num] = totalWaysUtil(s, coins-1, num , m ) + totalWaysUtil(s, coins, num-s[coins-1], m);
	}
	
	/**
	 * Good question, I need to focus on the implementation part :) so that I don't commit mistake while writing the code
	 * @param args
	 */
	public static void main(String args[]){
		int arr[] = {2, 3, 5,6};
		System.out.println(totalWays(arr, 4, 10));
		
		System.out.println(dynamicFlavour(arr, 4, 10));
	}

}
