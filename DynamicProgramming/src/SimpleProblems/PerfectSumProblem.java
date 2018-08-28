package SimpleProblems;

public class PerfectSumProblem {
	
	private static void printAllSubsetsWithGivenSum(int[] arr , int sum , int index , int[] elements){
		
		if(sum==0){
			printArray(arr);
			clearArray(arr);
		}
		if(sum <0 || index >=arr.length){
			return ;
		}
		
		printAllSubsetsWithGivenSum(arr, sum-arr[index], index+1, elements);
		printAllSubsetsWithGivenSum(arr, sum, index+1, elements);
		
	}
	
	private static void printArray(int[] arr){
		for(int i : arr){
			System.out.print(i);
		}
		System.out.println();
	}
	
	private static void clearArray(int[] arr){
		for(int i=0;i<arr.length;i++){
			arr[i]=0;
		}
	}
	
	
	public static void main (String[] args){
		int arr[] = {2, 3, 5, 6, 8, 10} ;
		printAllSubsetsWithGivenSum(arr, 10, 0, new int[6]);
	}

}
