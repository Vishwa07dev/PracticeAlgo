package SimpleProblems;
/**
 * 
 * @author vmohan
 *
 */
public class MaximumInTriangle {
	
	
	private static int getMaxSum(int x , int y , int[][] arr){
		//Using the dynamic programming here
		int[][] m = new int[arr.length][arr[0].length];
		
		for(int i=0;i<arr.length;i++){
			for(int j=0 ; j<arr[0].length ;j++){
				m[i][j]=-1;
			}
		}
		
		return getMaxSumUtil(x, y, arr, m);
	}
	
	private static int getMaxSumUtil(int x, int y, int[][] arr , int[][]m){
		if(x<0 || x >=arr.length ||y<0 || y>=arr[0].length){
			return 0;
		}
		
		if(m[x][y] !=-1){
			return m[x][y];
		}
		
		return m[x][y] =  arr[x][y] + Math.max(getMaxSumUtil(x+1, y, arr ,m), getMaxSumUtil(x+1, y+1, arr,m));
	}
	
	public static void main(String args[]){
		
		int[][] arr = { {3, 0, 0,0},
                {7,4, 0, 0},
                {2, 4, 6,0},
                {8,5,9,3}};
		
		System.out.println(getMaxSum(0, 0, arr));
	}

}
