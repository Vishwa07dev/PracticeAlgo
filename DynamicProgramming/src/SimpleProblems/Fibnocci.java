package SimpleProblems;

public class Fibnocci {
	
	public static int getFib(int n){
		if(n==0){
			return 0;
		}
		
		if(n==1 || n==2){
			return 1 ;
		}
		
		
		int prev =1 ;
		int prevPrev =1 ;
		int sum = 0;
		for(int i=3 ; i<=n ;i++){
			sum = prev + prevPrev ;
			prevPrev = prev ;
			prev= sum;
		}
		
		return  sum ;
	}
	
	public static void main(String args[]){
		//case 0
		//System.out.println(getFib(0));
		
		//case 2
		//System.out.println(getFib(2));
		
		for(int i =0 ; i<10 ; i++){
			System.out.println(i + "   " + getFib(i));
		}
		
	}

}
