package SimpleProblems;

public class RodCutting {
	
	/**
	 * I need to be careful about silly mistakes !!!!
	 * 
	 * @param price
	 * @param n
	 * @return
	 */
	
	public static int maxValue( int[]price , int n){
		
		if(n<=0){
			return 0;
		}
		
		int maxValue = Integer.MIN_VALUE ;
		for(int i=0;i<n;i++){
			maxValue = Math.max(maxValue,price[i] + maxValue( price , n-i-1) );
			
		}
		
		return maxValue ;
	}
	
	//Dynamic programming implementation of the same
	
      public static int maxValueDynamic(int[]price , int n){
    	  if(n<=0){
  			return 0;
  		  }
    	  int[] m = new int[n+1];
    	  
    	  return maxValueDynamicUtil( price ,  n , m) ;
      }
	
      public static int maxValueDynamicUtil( int[]price , int n , int[] m){
		
		if(n<=0){
			return 0;
		}
		//let m[i] indicates the maximum  value when size is n
		if(m[n]!=0){
			return m[n];
		}
		
		int maxValue = Integer.MIN_VALUE ;
		for(int i=0;i<n;i++){
			maxValue = Math.max(maxValue,price[i] + maxValueDynamicUtil( price , n-i-1,m) );
			
		}
		
		return m[n]=maxValue ;
	}
	
	
	public static void main(String args[]){
		
		int arr[] = new int[] {1, 5, 8, 9, 10, 17, 17, 20};
		System.out.println(maxValueDynamic(arr,8 ));
	}

}
