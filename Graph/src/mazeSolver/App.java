package mazeSolver;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class App {
	
   public static boolean printThePath(int[][] arr , int startX, int startY , int endX , int endY){
	   if(arr ==null || arr.length==0){
		   System.out.println("No path possible as array is empty");
	   }
	   if(startX<0 || startX >=arr.length || startY <0 || startY >=  arr[0].length){
		   System.out.println("No path possible as start point is not in the given arr");
	   }
	   if(endX<0 || endX >=arr.length || endY <0 || endY >=  arr[0].length){
		   System.out.println("No path possible as start point is not in the given arr");
	   }
	   
	   
	   
	   
	   if(startX ==endX && startY == endY){
		   return true ;
	   }
	   
	   
	   
	  int[][] validCoordinates = getValidCoordinates(arr, startX, startY);
	   
	   boolean pathExists = false ;
	   arr[startX][startY] =4 ;
	   
	   
	  
       for(int[] entry : validCoordinates){
    	   if(arr[entry[0]][entry[1]] !=1  && arr[entry[0]][entry[1]]!=4){
    		   pathExists = printThePath(arr, entry[0], entry[1], endX, endY);
    		   if(pathExists){
    			   System.out.println("X :"+ startX +" Y : "+ startY);
    			   
    			   break;
    		   }
    	   }
       }
		   
	   return pathExists ;
	   
	   
   }
   
   /**
    * I need to be extra careful while writing code
    * @param arr
    * @param x
    * @param y
    * @return
    */
   private static int[][] getValidCoordinates(int[][]arr , int x , int y){
	   // We need to initilize the size of both the arrays!
	   int[][] codArr = new int[8][2];
	   if(x-1>=0){
		   codArr[0][0] =(x-1);
		   codArr[0][1]=y;
	   }
	   if(x+1<arr.length){
		   codArr[1][0] =(x+1);
		   codArr[1][1]=y;
	   }
	   if(y-1 >=0){
		   codArr[2][0] =(x);
		   codArr[2][1]=y-1;
		   
	   }
	   if(y+1 < arr[0].length){
		   codArr[3][0] =(x);
		   codArr[3][1]=y+1;
		   
	   }
	   
	   if(x-1>=0 &&y-1 >=0){
		   codArr[4][0] =(x-1);
		   codArr[4][1]=y-1;
		     
	   }
	   if(x+1<arr.length &&y+1 < arr[0].length){
		   codArr[5][0] =(x+1);
		   codArr[5][1]=y+1;
		    
	   }
	   
	   if(x+1<arr.length &&y-1 >=0){
		   codArr[6][0] =(x+1);
		   codArr[6][1]=y-1;
		      
	   }
	   
	   if(x-1>=0 &&y+1 < arr[0].length){
		   codArr[7][0] =(x-1);
		   codArr[7][1]=y+1;
		      
	   }
	   
	   return codArr ;
   }
   
   
   public static void main (String[] args){
	   int[][] arr = {{1 ,1,1,1,1},{1 ,2,0,1,1},{1 ,1,1,1,1},{1 ,1,1,3,1},{1 ,1,1,1,1}};
	   
	   System.out.println(printThePath(arr, 1, 1, 3, 3));
   }

}
