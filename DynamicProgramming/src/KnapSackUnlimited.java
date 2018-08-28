
public class KnapSackUnlimited {
	
	public static int maxValue(int[] size , int[] value , int n , int c){ 
		if(size == null || size.length==0 || c==0){
			return 0;
		}
		//m[i] indicated the maximum value at the capacity i
		int[] m = new int[c+1];
		m[0] =0 ;
		
		for(int i =1 ;i <=c ; i++){
			m[i]= m[i-1];
			for(int j=0;j<n;j++){
				if(size[j]<=i){
					if(m[i] < m[i-size[j]]+value[j]){
						m[i]= m[i-size[j]] +value[j];
					}
				}
				
			}
		}
		
		return m[c];
	}
	
	
	public static void main(String[] args){
		int W = 100;
	    int val[]  = {1, 30};
			int wt[] = {1, 50};
			
			System.out.println(maxValue(wt, val, 2, 100));
	}

}
