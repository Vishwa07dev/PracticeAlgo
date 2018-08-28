package SimpleProblems;

/**
 * Superb , I have coded this question in first attempt :)
 * @author vmohan
 *
 */
public class GoldMinerProblem {

	private static int maxGold(int[][] arr) {

		int[][] m = new int[arr.length][arr[0].length];

		// m(i,j) will be the maximum value og gold dug when starting at i,j

		for (int i = 0; i < arr.length; i++) {
			m[i][arr[0].length - 1] = arr[i][arr[0].length - 1];
		}

		for (int j = arr[0].length - 2; j >= 0; j--) {

			for (int i = arr.length - 1; i >= 0; i--) {
				if (i == arr.length - 1) {
					m[i][j] = arr[i][j] + Math.max(m[i - 1][j + 1], m[i][j + 1]);
				} else if (i == 0) {
					m[i][j] = arr[i][j] + Math.max(m[i + 1][j + 1], m[i][j + 1]);
				} else {
					m[i][j] = arr[i][j] + Math.max(m[i + 1][j + 1], Math.max(m[i - 1][j + 1], m[i][j + 1]));
				}

			}

		}
		int count  = Integer.MIN_VALUE;
		printArray(m);
		
		for(int i =0; i<arr.length;i++){
			if(m[i][0]>count){
				count = m[i][0];
			}
		}
       
		return count;
	}
	
	
	public static void printArray(int[][] arr){
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[0].length;j++){
				System.out.print(arr[i][j] +" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String args[]){
		int[][] arr= {{10, 33, 13, 15},
                {22, 21, 04, 1},
                {5, 0, 2, 3},
                {0, 6, 14, 2}};
		//complexity will br o(n2)
		System.out.println(maxGold(arr));
	}

}
