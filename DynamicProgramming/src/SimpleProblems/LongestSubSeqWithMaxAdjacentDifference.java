package SimpleProblems;

/**
 * Yay, am able to solve this question in On2 compelxity
 * @author vmohan
 *We can apply dp here as well but with same complexity
 */
public class LongestSubSeqWithMaxAdjacentDifference {
	
	private static int maxSum(int[] arr){
		int maxSum =Integer.MIN_VALUE;
		for(int i=1;i<arr.length;i++){
			
			
			int currentValue = arr[i];
			int sum = 1;
			for(int j=i-1;j>=0;j--){
				if(Math.abs(currentValue - arr[j]) ==1){
					sum++ ;
					currentValue = arr[j];
					
					
					if(maxSum <sum){
						maxSum = sum;
					}
					
				}
				
			}
		}
		return  maxSum ;
	}
	
	public static void main(String args[]){
		int arr[] =  {1, 2, 3, 2, 3, 7, 2, 1};
		System.out.println(maxSum(arr));
	}

}
