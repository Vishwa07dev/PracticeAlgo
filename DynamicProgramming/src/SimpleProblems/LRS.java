package SimpleProblems;
/**
 * 
 * @author vmohan
 * 
 * longestRepeatingSubsequence
 *
 */
public class LRS {
	
    public static void getLRS(char[] str){
    	if(str == null || str.length ==0){
    		return ;
    	}
    	int[][] m = new int[str.length+1][str.length+1];
    	
    	for(int i=str.length-1 ;i>=0;i--){
    		for(int j= str.length-1 ; j>=0 ;j--){
    			if(str[i] ==str[j] && i!=j){
    				m[i][j] = 1+ m[i+1][j+1];
    			}
    			if(m[i][j] < Math.max(m[i+1][j], m[i][j+1])){
    				m[i][j] = Math.max(m[i+1][j], m[i][j+1]) ;
    			}
    		}
    	}
    	
    	System.out.println(m[0][0]);
    	/**
    	 * Awesome way of printing these characters :)
    	 */
    	int maxValue  = m[0][0];
    	for( int i=1; i< m[0].length-1;i++){
    		if(m[i][0] < maxValue || i==m[0].length-2){
    			maxValue=m[i][0];
    			System.out.println(str[i-1]);
    			
    		}
    	}
    }
    
    public static void main(String args[]){
    	getLRS("ATACTCGGA".toCharArray());
    }

}
