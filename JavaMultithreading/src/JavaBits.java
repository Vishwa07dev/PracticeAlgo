
public class JavaBits {
	
	
	
	
	private static int countSetBits(int n){
		
		int i =0 ;
		
		int count = 0;
		while(1<<i <=n){
			
			boolean isSet = false ;
			int value  = 1<<i; 
			
			for(int j=0;j<=n;j++){
				if(isSet){
					count++;
				}
				
				if(value ==1){
					isSet=!isSet;
					value = value<<2;
				}else{
					value--;
				}
			}
			
			i++;
			
		}
		return  count ;
	}
	
	public static void main(String args[]){
		System.out.println( countSetBits(8));
	}

}
