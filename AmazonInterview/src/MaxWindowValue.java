import java.util.Deque;
import java.util.LinkedList;


/**
 * 
 * @author vmohan
 * 
 * So, I have solved this problem in a very elegant way :)
 *
 */
public class MaxWindowValue {
	
	private static void printMaxWindowValue(int[] arr , int n, int k){
		Deque< Integer> q = new LinkedList<>();
		
		for(int i=0 ;i <k ;i++){
			
			if(q.isEmpty()){
				q.add(i);
			}else{
				if(!q.isEmpty() && arr[i]>=arr[q.peekLast()]){
					q.removeLast();
					q.addLast(i);
				}
			}
		}
		
		for(int i=k ;i<n ;i++){
			System.out.println(arr[q.peekFirst()]);
			if(q.isEmpty()){
				q.add(i);
				continue ;
			}
			
			if(!q.isEmpty() && ( i-q.peekFirst() <=0)){
				q.removeFirst();
			}
			if(!q.isEmpty() && arr[q.peekLast()] <= arr[i]){
				q.removeLast();
				q.addLast(i);
			}
		}
		
		System.out.println(arr[q.peekFirst()]);
		
	}
	
	public static void main(String args[]){
		
		int arr[] =  {1, 2, 3, 1, 4, 5, 2, 3, 6};
		
		printMaxWindowValue(arr, arr.length, 3);
	}

}
