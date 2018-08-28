package SimpleProblems;

public class EditDistance {
	
	private static int findEditDistance(String str1 , String str2 , int pos1 , int pos2 ){
		
		   if(pos1==0){
			   //first string is empty, so have to insert all
			   return pos2;
		   }
		   
		   if(pos2 ==0){
			   return pos1;
		   }
		   if(str1.charAt(pos1-1)==str2.charAt(pos2-1)){
				return findEditDistance(str1, str2, pos1-1, pos2-1);
			}else{
				//It can be either delete | add | update
				// So we can see, that there are overlapping problems
				int add = 1+ findEditDistance(str1, str2, pos1, pos2-1);
				int remove = 1+ findEditDistance(str1, str2, pos1-1, pos2);
				int replace = 1+ findEditDistance(str1, str2, pos1-1, pos2-1);
				
				return Math.min(Math.min(add,remove),replace);
				
			}
		}
	
	//This is a more effecient method   Good that I didn't commit any mistake
	private static int findEditDistanceDynamic(String str1 , String str2 , int pos1 , int pos2){
		 if(pos1==0){
			   //first string is empty, so have to insert all
			   return pos2;
		   }
		   
		   if(pos2 ==0){
			   return pos1;
		   }
		   int[][] m = new int[pos1+1][pos2+1]; //m[i][j] -> indicates the minEditDistance till ith element in str1 and jth element in str2
		   
		   
		   for(int i=0;i< pos1;i++){
			   m[i][0]=i;
		   }
		   
		   for(int i=0;i< pos2;i++){
			   m[0][i]=i;
		   }
		   
		   for(int i=1;i<=pos1 ;i++){
			   for(int j=1;j<=pos2 ;j++){
				   if(str1.charAt(i-1) == str2.charAt(j-1)){
					   m[i][j]=m[i-1][j-1];
				   }else{
					   m[i][j] = 1+ Math.min(Math.min(m[i-1][j], m[i][j-1]), m[i-1][j-1]);
				   }
			   }
		   }
		   
		   
		   return m[pos1][pos2];
	}
	
	
	public static void main(String args[]){
		System.out.println(findEditDistance("sunday", "saturday", 5, 7));
		
		System.out.println(findEditDistanceDynamic("sunday", "saturday", 5, 7));
	}

}
