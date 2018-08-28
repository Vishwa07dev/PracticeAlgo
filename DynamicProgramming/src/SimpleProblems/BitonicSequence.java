package SimpleProblems;

/**
 * Awesome, I am getting hold on the DP problems I am able to solve in On2 complexity
 * @author vmohan
 *
 */
public class BitonicSequence {
	
	
	private static int getMaxBitonicSum(int[]arr){
		int[] m = new int[arr.length];
		//m[i] is the maximum sum till ith index
		getMaximumIncreasingSum(arr, m);
		
		
		int[] n = new int[arr.length];
		getMaximumDecreasingSumTillLast(arr, n);
		
	    int sum = Integer.MIN_VALUE;
		for(int i=0;i<arr.length;i++){
			if(sum < m[i]+n[i]-arr[i]){
				sum = m[i]+n[i]-arr[i];
			}
	    	
	    }
		
	    printArray(m);
	    
	    printArray(n);
		
		return sum ;
	}

	private static void getMaximumDecreasingSumTillLast(int[] arr, int[] n) {
		n[arr.length-1]= arr[arr.length-1];
		
		for(int i=arr.length-2;i>=0;i--){
			int sum = 0;
			for(int j=arr.length-1 ;j>i;j--){
				if(arr[j] <=arr[i]){
					if(sum <n[j]){
						sum = n[j];
					}
				}
			}
			n[i]= sum + arr[i];
		}
	}

	private static void getMaximumIncreasingSum(int[] arr, int[] m) {
		m[0]= arr[0];
		
		for(int i=1;i<arr.length;i++){
			
			int sum =0;
			for(int j=0;j<i ;j++){
				
				if(arr[j]<=arr[i]){
					if(sum < m[j]){
						sum = m[j];
					}
				}
				
			}
			m[i]=sum + arr[i];
		}
	}

	private static void printArray(int[] m) {
		for(int i=0;i<m.length;i++){
	    	System.out.print(m[i] + " ");
	    }
	    System.out.println();
	}
	
	public static void main(String args[]){
		int arr[] =  {80, 60, 30, 40, 20, 10};
		
		System.out.println("Maximum sum is " +getMaxBitonicSum(arr));
	}

}
