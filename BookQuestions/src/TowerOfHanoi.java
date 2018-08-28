/**
 * 
 * @author vmohan
 * 
 * Well I have solved it correctly, but I need to do it more fast w/o looking at the hint
 *
 */
public class TowerOfHanoi {
	
	
	private static int moves(int n , String start , String end , String intermediate){
		
		if(n==0 || n==1){
			return n;
		}
		return  moves(n-1, start,intermediate, end) +1+ moves(n-1, intermediate, end, start) ;
	}
	
	public static void main(String [] args){
		System.out.println(moves(4, "s","e","i"));
	}

}
