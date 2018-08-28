package SimpleProblems;

import java.util.HashSet;
import java.util.Set;
/**
 * Awesome, finally I solved this question. It took a lot of time :)
 * @author vmohan
 *
 */
public class EndLessPoints {

	public static int getEndLessPoints(int[][] arr) {

		// m[][] m(i,j) indicates if i,j is the stating point

		int[][] mVert = new int[arr.length][arr[0].length];
		int[][] mHorz = new int[arr.length][arr[0].length];
		
		mVert[arr.length-1][arr[0].length-1] = mHorz[arr.length-1][arr[0].length-1] =arr[arr.length-1][arr[0].length-1] ;
		int count = 0;

		
        
		boolean first = true;
		for (int i = arr.length - 1; i >= 0; i--) {
			for (int j = arr[0].length - 1; j >= 0; j--) {
			    if(j==arr[0].length-1){
			    	mHorz[i][j] = arr[i][j];
			    }
			    else if(i==arr.length-1){
			    	mVert[i][j]=arr[i][j];
			    }else{
			    	if(arr[i][j]==1 && mVert[i+1][j]==1){
			    		mVert[i][j]=1;
			    	}
			    	if(arr[i][j]==1 && mHorz[i][j+1]==1){
			    		mHorz[i][j]=1;
			    	}
			    }
			    
			}
		}
		
		/**
		 * if (mVert[i + 1][j] == 1 && mHorz[i][j + 1] == 1 && arr[i][j] == 1) {
					count++;
					mVert[i][j] = 1;
					mHorz[i][j]=1;
					continue ;
				}
				if(arr[i][j]==1){
					if(mVert[i + 1][j] == 1){
						mVert[i][j]=1;
					}
					if(mHorz[i][j+1]==1){
						mVert[i][j]=1;
					}
				}
		 */
		
		printArray(mVert);
		
		System.out.println();
		printArray(mHorz);
		
		for (int i = arr.length - 1; i >= 0; i--) {
			for (int j = arr[0].length - 1; j >= 0; j--) {
				if(j==arr[0].length-1 && i==arr.length-1){
			    	if(arr[i][j]==1){
			    		count++;
			    		
			    	}
			    }
				
			    else if(i==arr.length-1){
			    	if(arr[i][j]==1 && mHorz[i][j+1]==1){
			    	   count++ ;
			    	  
			    	}
			    }else if(j==arr[0].length-1){
			    	if(arr[i][j]==1 && mVert[i+1][j]==1){
				    	   count++ ;
				    	  
				    	}
			    }else{
			    	if(arr[i][j]==1 && mVert[i+1][j]==1 && mHorz[i][j+1]==1){
				    	   count++ ;
			    	}
			    }
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

	public static void main(String args[]) {
		int[][] arr ={{ 0, 1, 1},
				      { 1, 1, 0},
		              {0 ,1 ,0}};

		System.out.println(getEndLessPoints(arr));
		
		Set s = new HashSet<>();
		s.add(1);
		System.out.println("Print "+ s.contains(null));

	}

}
