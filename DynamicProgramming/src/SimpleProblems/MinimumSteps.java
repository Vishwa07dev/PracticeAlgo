package SimpleProblems;
/**
 * 
 * @author vmohan
 *
 */
public class MinimumSteps {
	
	private static int minimumSteps(int[]arr , int l , int h ){
		
		if (h == l)
	        return 0;
	 
	        // When nothing is reachable 
	        // from the given source
	        if (arr[l] == 0)
	        return Integer.MAX_VALUE;
	 
	        // Traverse through all the points 
	        // reachable from arr[l]. Recursively
	        // get the minimum number of jumps 
	        // needed to reach arr[h] from these
	        // reachable points.
	        int min = Integer.MAX_VALUE;
	        for (int i = l+1; i <= h && i <= l + arr[l]; i++)
	        {
	            int jumps = minimumSteps(arr, i, h );
	            if(jumps != Integer.MAX_VALUE &&
	               jumps + 1 < min)
	              min = jumps + 1;
	             
	        }
	        return min;
	}
	/**
	 * I need to come back here after solving some questions
	 * @param arr
	 * @param l
	 * @param h
	 * @return
	 */
	private static int minimumStepsDynamic(int[]arr , int l , int h){
		
		//m[i] indicate the minimum jump to reach ith element :  so we need to return m[h]   
		int[] m = new int[h+1];
		m[0]=0 ; //steps need to reach the ist step will be zero
		
		for(int i=1;i<=h;i++){
			for(int j=0;j<i ;j++){
				m[i]=Integer.MAX_VALUE ;
				if(j+arr[j] >=i && m[j]!=Integer.MAX_VALUE){
					m[j] = Math.min(m[i], m[j]+1);
					break ;
				}
			}
		}
		return m[h] ;
	}
	
	public static void main(String args[]){
		
		int arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9} ;
		
		System.out.println(minimumSteps(arr, 0, 10));
		
		System.out.println(minimumStepsDynamic(arr, 0, 10));
		
	}

}
