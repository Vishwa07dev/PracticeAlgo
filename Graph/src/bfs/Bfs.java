package bfs;

import java.util.LinkedList;
import java.util.Queue;
/**
 * BFS is same as the level order traversal in trees
 * @author vmohan
 *
 */
public class Bfs {
	
	public void bfs(Vertex v){
		if(v==null){
			System.out.println("Vertex passed is null");
		}
		
		Queue<Vertex> q = new LinkedList<Vertex>();
		v.setVisited(true);
		q.add(v);
		while(!q.isEmpty()){
			Vertex ver = q.remove();
			System.out.println(ver.getData());
			for(Vertex vertex : ver.getVertexList()){
				if(!vertex.isVisited()){
					vertex.setVisited(true);
					q.add(vertex);
				}
			}
		}
	}

}
