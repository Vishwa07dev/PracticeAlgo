package ShortestPathAlgorithm;

import java.util.List;
import java.util.PriorityQueue;

public class DjikstraAlgorithm {
	//This can be used only when  the edgeWeight is positive. It can be used to find the distance of each node from the source
	
	public void printShortestPath(Vertex source, Vertex destination){
		//This creates a tree, in which get to know the minimum distance of each vertex from the source
		
		source.setDistance(0);
		
		PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>();
		priorityQueue.add(source);
		while(!priorityQueue.isEmpty()){
			Vertex vertex = priorityQueue.poll();
			if(vertex == null){
				continue ;
			}
			
			List<Edge> edges = vertex.getNeighours();
			
			for(Edge edge : edges){
				Vertex verNeighour  = edge.getEndVertex() ;
				if( vertex.getDistance() + edge.getWeight() < verNeighour.getDistance()){
					verNeighour.setDistance(vertex.getDistance() + edge.getWeight());
					priorityQueue.add(verNeighour);
					verNeighour.setPredecessor(vertex);
				}
			}
		}
		
		System.out.println("Minimum distance is : "+ destination.getDistance());
		
		Vertex temp = destination ;
		while(temp !=null){
			System.out.println(temp);
			temp = temp.getPredecessor();
			
		}
		
		
	}

}
