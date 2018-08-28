import java.util.PriorityQueue;

public class ShortestPathAlgo {
	
	private static int getShortestPath(int[][] arr , int xStart, int yStart , int xEnd , int yEnd){
		return  0 ;
	}
	
	
	private static void dizikStraAlgo(int[][] nodes , int[] start , int[] end , int[][]distance){
		
		
		
		int[][] directions  = {{0,1},{0,-1} ,{1,0},{-1,0}};
		
		//So this is the way of passing the comparator 
		PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> a[2]-b[2]);
		
		q.offer(new int[]{start[0],start[1],0});
		
		while(q.isEmpty()){
			int[] node = q.poll();
			
			if(distance[node[0]][node[1]] < node[2]){
				continue ;
			}
			
			for(int[] d : directions){
				int x = node[0] + d[0];
				int y = node[1] + d[1];
				int count = 0;
				
				/*while(x>=0 && y>=0 && x < nodes.length && y <nodes[0].length && node[x][y]==0){
					x +=d[0];
					y+=d[0];
				}*/
			}
		}
		
		
	}
				
}

