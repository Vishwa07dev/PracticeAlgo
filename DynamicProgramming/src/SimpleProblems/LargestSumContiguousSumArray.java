package SimpleProblems;

public class LargestSumContiguousSumArray {
	
	private static int maxSum(int[]arr){
		if(arr ==null || arr.length==0){
			System.out.println("Array is empty or null");
			return Integer.MIN_VALUE ;
		}
		
		boolean allNegative = true ;
		int leastNegative = Integer.MIN_VALUE ;
		
		int maxIndex = 0;
		int maxSum = 0;
		//M[i] ...indicate the maximum contiguous sum till ith element  if m[i-1]+a[i]  > m[i-1]
		int[] m = new int[arr.length];
		if(arr[0] < 0){
			m[0]=0;
			if(leastNegative <arr[0]){
				leastNegative=arr[0];
			}
		}else{
			m[0]=arr[0];
			maxSum = arr[0];
			allNegative = false ;
		}
		
		for(int i=1;i<arr.length;i++){
			if(arr[i] + m[i-1] <0){
				m[i]=0;
			}else{
				m[i]= m[i-1]+arr[i];
				if(maxSum <m[i]){
					maxSum = m[i];
					maxIndex = i;
				}
			}
			
			if(arr[i] >0){
				allNegative = false ;
			}else{
				if(leastNegative <arr[0]){
					leastNegative=arr[0];
				}
			}
		}
		
		if(allNegative){
			return leastNegative;
		}
		
		for(int i=0 ; i<m.length;i++){
			
		}
		
		while(m[maxIndex]>0 && maxIndex>=0){
			System.out.println(arr[maxIndex]);
			maxIndex--;
		}
		return maxSum ;
	}
	
	public static void main(String[] args){
		int[] arr  = {-2,-3,4,-1,-2,1,5,-3} ;
		System.out.println("Max sum : "+ maxSum(arr));
	}


}
