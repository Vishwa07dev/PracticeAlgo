package SimpleProblems;


/**
 * Yay, I got the first part solved.Now I need to optimize this question
 * 
 * Awesome, I have written using dp as well in top down fashion
 * @author vmohan
 *
 */
public class MinimumStepsToMinimize {
	
	
	private static int minWaysCalcualtor(int num){
		int[] arr = new int[num+1];
		arr[1]=0;
		for(int i=0;i<num+1;i++){
			arr[i]=Integer.MAX_VALUE;
		}
		
		minWays(num, arr);
		return arr[num];
		
	}
	
	private static int minWays(int num ,int[]arr){
		if(num ==1){
			return 0 ;
		}
		if(arr[num]!= Integer.MAX_VALUE){
			return arr[num];
		}
		
		int minMinus =1+ minWays(num-1,arr);
		
		int minDiv2 =Integer.MAX_VALUE ;
		int minDiv3 =Integer.MAX_VALUE;;
		if(num%2==0){
			minDiv2 = 1+minWays(num/2,arr);
		}
		
		if(num%3==0){
			minDiv3 =1+minWays(num/3,arr);
		}
		
		return  arr[num]=Math.min(minMinus, Math.min(minDiv2, minDiv3)) ;
	}
	
	
	public static void main(String[] args){
		System.out.println(minWaysCalcualtor(10));
	}

}
