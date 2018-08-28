import java.util.Stack;

public class MaximumRectangleSum {
	//Awesome !...Finally am able to solve this question :)
	public static int getMaxAreaNew(int[] arr){
		
		int i=0;
		Stack<Integer> s = new Stack<>();
		int maxArea = Integer.MIN_VALUE ;
		while(i<arr.length){
			
			if(s.isEmpty() || arr[s.peek()] <= arr[i]){
				s.push(i++);
			}else{
				while(!s.isEmpty() && arr[s.peek()] > arr[i]){
					int index = s.pop();
					int area = s.isEmpty() ? i*arr[index] : (i-s.peek() -1)*arr[index];
					if(maxArea <area){
						maxArea = area ;
					}
					
				}
			}
			
		}
		
		while(!s.isEmpty()){
			int index = s.pop();
			int area = s.isEmpty() ? i*arr[index] : (i-s.peek() -1)*arr[index];
			if(maxArea <area){
				maxArea = area ;
			}
			
		}
		
		return maxArea ;
	}


	public static void main(String args[]){
		int[] arr = {6, 2, 5, 4, 5, 1, 6};
		System.out.println(getMaxAreaNew(arr));
 	}
}
