/**
 * It's a good question but little tricky
 * @author vmohan
 *
 */
public class StringQuestion {
	
	private static int subsequeneCount(String str){
		int aCount = 0;
		int bCount =0 ;
		int cCount = 0 ;
		
		
		for(int i=0;i<str.length();i++){
			if(str.charAt(i)=='a'){
				aCount = 1+ 2*aCount;
			}
			
			if(str.charAt(i)=='c'){
				cCount = bCount+ 2*cCount;
			}
			if(str.charAt(i)=='b'){
				bCount = aCount+ 2*bCount;
			}
		}
		return cCount ;
	}
	
	public static void main(String args[]){
		
		System.out.println(subsequeneCount("abbc"));
		System.out.println(4<<2);
		
	}

}
