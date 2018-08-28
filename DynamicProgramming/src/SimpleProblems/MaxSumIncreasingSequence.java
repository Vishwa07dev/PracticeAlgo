package SimpleProblems;
/**
 * 
 * @author vmohan
 *
 */
public class MaxSumIncreasingSequence {
	
	
	/**
	 * Good question, I need to practice more to solve these kind of question very fast.
	 * @param arr
	 * @return
	 */
	private static int maxSum(int[] arr){
		
		int[] m = new int[arr.length];
		
		//m[i] 
		
		for(int i=0;i<arr.length;i++){
			m[i]=arr[i];
		}
		for(int i=1;i<arr.length;i++){
			for(int j=0;j<i;j++){
				if(arr[i]>=arr[j] && m[i] <m[j] + arr[i] ){
					m[i] = m[j] +arr[i];
				}
			}
		}
		
		int sum = m[0];
		System.out.println(m[0]);
		for(int i=1;i<m.length;i++){
			System.out.println(m[i]);
			
			if(sum < m[i]){
				sum=m[i];
			}
		}
		return sum;
		
	}
	
	public static void main(String[] args){
		int arr[] = new int[]{1, 101, 2, 3, 100, 4, 5};
		System.out.println(maxSum(arr));
	}

}
