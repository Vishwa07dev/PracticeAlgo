package ShortestPathAlgorithm;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author vmohan
 * 
 * O(V*E)  -> quadratic complexity
 *
 */
public class BellManFordAlgorithm {
	
	private List<Vertex> vertices ;
	private List<Edge> edges ;
	
	public void getShortestPath(Vertex source , Vertex destination ){
		source.setDistance(0);
		
		for(int i=0;i<vertices.size()-1 ;i++){
			
			for(Edge edge : edges){
				Vertex start = edge.getStartVertex();
				Vertex end  = edge.getEndVertex();
				if(start.getDistance() == Double.MAX_VALUE){
					continue ;
				}
				
				double distance  = start.getDistance() + edge.getWeight();
				if(distance <end.getDistance()){
					edge.getEndVertex().setDistance(distance);
					edge.getEndVertex().setPredecessor(edge.getStartVertex());//This will set the predecessor
				}
			}
		}// n vertices will have the n-1 edges
		
		//One more cycle to determine the negative cycle
		for(Edge edge : edges){
			Vertex start = edge.getStartVertex();
			Vertex end  = edge.getEndVertex();
			if(start.getDistance() == Double.MAX_VALUE){
				continue ;
			}
			double distance  = start.getDistance() + edge.getWeight();
			if(distance <end.getDistance()){
				System.out.println("Negative cycle exists, so no minimum path");
				//This will kick in , only if there is a cycle and total weight is negative
				return ;
			}
		}
		
		System.out.println("Minimum distance is : "+ destination.getDistance());
		
		Vertex temp = destination;
		while(temp !=null){
			System.out.print(temp.getName() + "  ");
			temp= temp.getPredecessor();
		}
		System.out.println();
	}
	
	public BellManFordAlgorithm() {
		vertices = new ArrayList<>();
		edges = new ArrayList<>();
	}

	public List<Vertex> getVertices() {
		return vertices;
	}

	public void setVertices(List<Vertex> vertices) {
		this.vertices = vertices;
	}

	public List<Edge> getEdges() {
		return edges;
	}

	public void setEdges(List<Edge> edges) {
		this.edges = edges;
	}
	
	
	

}
