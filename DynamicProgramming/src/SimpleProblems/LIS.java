package SimpleProblems;

public class LIS {
	/**
	 * This question is like a theory thing,Please bear in mind
	 * 
	 */
	
	public static int getLIS(int[]arr){
		if(arr ==null || arr.length ==0){
			return Integer.MIN_VALUE;
		}
		
		//m[i] -> indicates the logest length till ith element in arr, so m[i] = 1 + max( j-> 0 to i-1 m[j])  such that arr[i] > arr[j]
		
		int[] m = new int[arr.length];
		
		
		m[0]=1;
		for(int i=1;i<arr.length;i++){
			int maxValue =0 ;
			for(int j=0;j<i;j++){
				if(arr[i]>=arr[j]){
					if(maxValue< m[j]){
						maxValue = m[j];
					}
				}
			}
			m[i] = maxValue +1 ;
		}
		for(int i=0;i<m.length;i++){
			System.out.print(m[i]+" ");
		}
		
		int max = Integer.MIN_VALUE ;
		int index = m.length;
		for(int i=m.length-1 ; i>=0;i--){
			if(max<m[i]){
				max =m[i];
				index = i ;
			}
		}
		
		System.out.println("index"+ index);
		
		for(int j=index-1 ;j>=0;j--){
			if(m[j]<m[j+1]){
				System.out.println(arr[j]);
			}
		}
		
		System.out.println();
		return max;
	}
	//I need to solve these question fastly and also in one go :) Need more effort and learning
	
	public static void main(String args[]){
		 int arr[] = { 5,6,7,1,2 };
		System.out.println(getLIS(arr));
		
	}

}
