package SimpleProblems;

/**
 * Yay I did it again in single attempt
 * @author vmohan
 *
 */
public class MaxPathSumWithJumps {
	
	private static void getMaxPathSum(int[] arr){
		
		int[] m = new int[arr.length];
		
		m[0]=arr[0];
		m[1]=m[0]+arr[1];
		
		for(int i =2;i<arr.length;i++){
			
			int sum = 0 ;
			for(int j =0;j<=Math.sqrt(i+1);j++){
				if((i+1)%(j+1)==0){
					if(sum < m[j]){
						sum = m[j];
					}
				}
			}
			m[i]=arr[i]+sum;
		}
		printArray(m);
	}
	
	private static void printArray(int[] m) {
		for(int i=0;i<m.length;i++){
	    	System.out.print(m[i] + " ");
	    }
	    System.out.println();
	}
	
	public static void main(String args[]){
		int arr[] =  {2, 3, 1, 4, 6, 5};
		getMaxPathSum(arr);
	}
	

}
