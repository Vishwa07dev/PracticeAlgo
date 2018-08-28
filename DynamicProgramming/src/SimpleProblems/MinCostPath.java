package SimpleProblems;
//Good question which I solved cofortably

public class MinCostPath {
	
	public static int minCostPath(int[][] arr , int x, int y){
		
		int[][] m = new int[arr.length][arr[0].length]; //m[i][j] -> minimum cost till i, j
		
		m[0][0]=arr[0][0];
		for(int i=1;i<arr.length ;i++){
			m[i][0]=arr[i][0]+m[i-1][0];
		}
		
		for(int i=1;i<arr[0].length ;i++){
			m[0][i]=arr[0][i]+m[0][i-1];
		}
		
		for(int i=1;i<=x;i++){
			for(int j=1;j<=y;j++){
				m[i][j] = arr[i][j] + Math.min(Math.min(m[i-1][j], m[i][j-1]),m[i-1][j-1]);
				
			}
		}
		
		int i=0;int j=0 ;
		while(i!=x && j!=y){
			System.out.println(i+","+j);
			if( i+1<=x && j+1<=y)
			{   
				if( m[i+1][j] <m[i][j+1] && m[i+1][j]<m[i+1][j+1]){
			        i=i+1;
			        
			    }else if(m[i+1][j] <m[i][j+1] && m[i+1][j]>m[i+1][j+1]){
			       i=i+1;
			       j=j+1;
			    }else{
			    	j=j+1;
			    }
			}
		}
		
		return  m[x][y] ;
	}
	
	public static void main(String args[]){
		int cost[][]= {{1, 2, 3},
                {4, 8, 2},
                {1, 5, 3}};
		
		System.out.println("minimum cost to reach (2,2) = " +
                minCostPath(cost,2,2));
		
	}
	
	

}
