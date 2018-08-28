package SimpleProblems;

public class LCS {
	
	public int findLCS( char[ ]str1 , char[] str2){
		
	
		
		//let m[i][j] indicates the lcs when ith element from 0 anin str1 and jth element from 0 has been reached
		/**
		 * m[i][j] = if(stt[i] == str[j]) -> m[i-1][j-1] +1
		 *            else
		 *               Math.max(m[i-1][j] , m[i][j-1]
		 *               
		 */
		
		int[][] m = new int[str1.length+1][str2.length+1];
		
		for(int i=1;i<=str1.length ;i++){
			for(int j=1;j<=str2.length;j++){
				if(str1[i]==str2[j]){
					m[i][j] = m[i-1][j-1] +1;
				}
				
				if(m[i][j] < m[i-1][j]){
					m[i][j]=m[i-1][j];
				}
				
				if(m[i][j] < m[i][j-1]){
					m[i][j]=m[i][j-1];
				}
			}
		}
		
		return m[str1.length][str2.length];
		
	}
	/**
	 * Awesome results :)
	 * @param str1
	 * @param str2
	 */
	
	public static void  findLCSImpl2( char[] str1 , char[] str2){
		
		//let str1 be at ith and str2 be at jth  m[i][j] -> indicates the total common subsequence if first at i and second at j
		//if(arr[i] ==arr[j]  -> 1 + m[i+1][j+1]  else maths.max m[i+1][j] or m[i][j+1]  -- cool :)
		
		int[][] m = new int[str1.length+1][str2.length+1];
		
		for(int i=str1.length-1 ;i>=0;i--){
			for(int j=str2.length-1 ;j>=0;j--){
				if(str1[i]==str2[j]){
					m[i][j]= m[i+1][j+1] +1 ;
				}
				if(m[i][j] < m[i+1][j]){
					m[i][j] = m[i+1][j];
				}
				if(m[i][j] < m[i][j+1]){
					m[i][j] = m[i][j+1];
				}
			}
		}
		
		System.out.println("length of maximum common subsequence is : "+ m[0][0]);
		
		int maxValue = m[0][0];
		for(int i=1;i<m[0].length-1;i++){
			if(m[i][0] == maxValue && i!=m[0].length-2){
				continue;
			}else{
				System.out.println(str1[i-1]);
				maxValue=m[i][0];
			}
		}
		
	}
	
	public static void main (String[] args){
		String s1 = "ABCDGH";
		
	    String s2 = "AEDFHR";
	    
	    findLCSImpl2(s1.toCharArray(), s2.toCharArray());
	}
	
	

}
