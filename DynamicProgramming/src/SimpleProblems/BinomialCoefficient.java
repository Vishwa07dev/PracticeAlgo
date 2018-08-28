package SimpleProblems;

public class BinomialCoefficient {
	
	public static int getBinomialCoefficentVallue(int n , int r){
		if(n<=0 || n<r){
			return Integer.MIN_VALUE ;
		}
		
		int[] m = new int[n+1];
		// I need to be careful about this !!!!!
		m[0]=1;
		m[1]=1;
		
		int factN =  factorial(n, m);
		int factR = factorial(r, m);
		int factNminusR = factorial(n-r, m);
		
		return factN/(factR*factNminusR);
				
		
	}
	
	
	//So here am using the bottomsUp approach to store the data in array to avoid the call back of URL
	public static int getBinomialCoefficient(int n, int r){
		
		if(n<=0 || n<r){
			return Integer.MIN_VALUE ;
		}
		if(r==0 || n==r){
			return n;
		}
		
		int[][] arr = new int[n+1][r+1];
		
		for(int i=0;i<=n ;i++){
			for(int j=0;j<=Math.min(i, r) ; j++){
				if(i==j){
					arr[i][j]=1;
				}
				else if(j==0){
					arr[i][j]=1;
				}else{
					arr[i][j] = arr[i-1][j]+ arr[i-1][j-1];
				}
			}
		}
		
		return arr[n][r];
		
	}
	
	
	
	
	public static  int factorial( int n , int [] arr){
		
		if( n==0 || n==1){
			
			return 1 ;
		}
		
		if(arr[n] !=0){
			return arr[n];
		}
		
		for(int i =2 ;i<=n ;i++){
			arr[i] = i* arr[i-1];
		}
		return arr[n] ;
	}
	
	public static void main(String[] args){
		//System.out.println(getBinomialCoefficentVallue(5, 3));
		
		System.out.println(getBinomialCoefficient(5, 3));
	}

}
