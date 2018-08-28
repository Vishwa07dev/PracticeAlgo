/*
 * 
 */
public class CatalanNumber {
	
	private static int calculateCatalanNumberUtil(int num, int[] arr){
		if(num ==0 || num==1){
			return 1;
		}
		if(arr[num] !=0){
			return arr[num];
		}
		for(int i=1;i<=num ;i++){
			arr[num] += calculateCatalanNumberUtil(i-1, arr)*calculateCatalanNumberUtil(num-i, arr);
		}
		return arr[num];
	}
	
	public static int calculateCatalanNumber(int num){
		if(num==0)return 0;
		//This is the memoization we are trying in this.
		int[] arr = new int[num+1];
		 return calculateCatalanNumberUtil(num, arr);
	}
	
	
	public static void main(String[] args){
		System.out.println(calculateCatalanNumber(7));
	}
	

}
