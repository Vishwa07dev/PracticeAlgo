package DynamicProgramming;
/**
 * Awsome algorithm I have written :)
 * @author vmohan
 *
 */
public class MaximumContiguousSum {
	
	public static int maxSum(int[] arr){
		int[] m = new int[arr.length];
		
		m[0]= arr[0];
		
		for(int i=1;i<arr.length ;i++){
			if(m[i-1]+arr[i] <arr[i]){
				m[i] = arr[i] ;
			}else{
				m[i] = m[i-1]+arr[i];
			}
		}
		
		int maxSum =Integer.MIN_VALUE;
		for(int i=0 ;i<m.length ;i++){
			if(maxSum < m[i]){
				maxSum = m[i];
			}
		}
		return  maxSum ;
	}
	
	
	public static int maxSumNoThreeContiguous(int[] arr ){
		int[] m = new int[arr.length];
		
		m[0]=arr[0];
		
		m[1] = m[0]+arr[1]>arr[1]? m[0]+arr[1] : arr[1] ;
		
		m[2] = m[1] > arr[0]+arr[2]? m[1] : arr[0]+arr[2];
		
		if(m[2]<arr[1]+arr[2]){
			m[2] = arr[1]+arr[2];
		}
		
		if(m[2] < arr[2]){
			m[2] = arr[2];
		}
		
		for(int i=3;i<arr.length;i++){
			m[i] = m[i-2] + arr[i] >arr[i] ?  m[i-2] + arr[i] : arr[i];
			if(m[i] < m[i-1]){
				m[i] = m[i-1];
			}
			
			if(m[i] < m[i-3]+arr[i-1]+arr[i]){
				m[i] = m[i-3]+arr[i-1]+arr[i] ;
			}
		}
		
		int maxValue = Integer.MIN_VALUE;
		
		for(int i=0;i<m.length;i++){
			System.out.print(m[i]+" ");
			if(maxValue < m[i]){
				maxValue = m[i];
			}
		}
		System.out.println();
		System.out.println(m[m.length-1]);
		return maxValue;
	}
	
	
	public static void main(String[] args){
		int[] arr1 = {22,11,4,13,5,12};
		//System.out.println(maxSum(arr1));
		
		
		int[] arr2 ={1, 2, 3, 4, 5, 6, 7, 8} ;
		
		System.out.println(maxSumNoThreeContiguous(arr2));
	}

}
