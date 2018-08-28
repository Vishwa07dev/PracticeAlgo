package SimpleProblems;

public class UglyNumbers {
	/*
	 * This is a really good question
	 */
	private static  int uglyNuber(int num){
		
		int[] arr = new int[num];
		arr[0]=1;
		
		int i=0,j=0,k=0;  //i for 2, j for 3, k for 5
		
		for(int a=1;a<num ;a++){  //iterating through once, so it's complexity will be O(n)  Jai Papa , Jai Papa , Jai Papa
			int nextUglyNUm = Math.min(Math.min(arr[i]*2, arr[j]*3),arr[k]*5);
			if(nextUglyNUm == arr[i]*2){
				i++;
			}
			if(nextUglyNUm == arr[j]*3){
				j++;
			}
			if(nextUglyNUm == arr[k]*5){
				k++;
			}
			arr[a]= nextUglyNUm ;
		}
		
		
		return arr[num-1] ;
	}
	
	public static void main(String[] args){
		System.out.println(uglyNuber(10));
	}
	
	

}
