package bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * @author vmohan
 *
 */
public class BFS {
	
	public void bfs(Vertice v){
		Queue<Vertice> q = new LinkedList<>();
		if(v !=null && !v.isVisited()){
			q.add(v);
			
		}
		while(!q.isEmpty()){
			Vertice x = q.remove();
			System.out.println(x);
			x.setVisited(true);
			for(Vertice vertice : x.getNeighbours()){
				if(vertice!=null && !vertice.isVisited()){
					q.add(vertice);
				}
			}
		}
		
		
	}

}
