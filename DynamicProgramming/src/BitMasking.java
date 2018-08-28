import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BitMasking {
	
	
	static final int MOD = 1000000007 ;
	//This is used for reading from the sytem.in -> example of decorator design pattern
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	//dp[i][j] -> maximum combination of caps worn with mask i and j caps
	static int[][] dp = new int[1025][101];
	
	static Map<Integer, List<Integer>> capList = new HashMap<>();
	
	static int allMask ;
	
	static long countsWaysUtil(int mask , int i){
		if(allMask == mask){
			return 1 ;
			
		}
		if(i>100){
			return 0 ;
		}
		
		if(dp[mask][i] != -1){
			return dp[mask][i];
		}
		//Total count when ignoring the current ith cap
		long ways = countsWaysUtil(mask, i+1);
		
		//Case when not ignoring the current ith cap
		int sizePeople = capList.get(i).size();
		
		List<Integer> peopleList = capList.get(i);
		
		for(int people : peopleList){
			if((mask & (1<<people)) !=0){ 
				continue ;
			}else{
				ways = ways + countsWaysUtil(mask | people, i+1);
			}
			ways = ways%MOD ;
		}
		
		return dp[mask][i] = (int)ways;
				
	}
	
	
	public static void main(String args[]){
		
		System.out.println(Integer.toBinaryString( (int) 1));
		System.out.println(Integer.toBinaryString( (int) 1<<10));
		
		System.out.println(Integer.toBinaryString( (int) (1<<10) -1));
		
		System.out.println(1<<3);
	}

}
