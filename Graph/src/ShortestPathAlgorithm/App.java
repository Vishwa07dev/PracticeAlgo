package ShortestPathAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class App {
	
	public static void main(String args[]){
		
		Vertex vertex1 = new Vertex("A");
		Vertex vertex2 = new Vertex("B");
		Vertex vertex3 = new Vertex("C");
		
		
		
		Edge edAB = new Edge(1, vertex1, vertex2);
		
		Edge edBC = new Edge(1, vertex2, vertex3);
		Edge edAC = new Edge(3, vertex1, vertex3);
		
		vertex1.addEdges(edAB);
		vertex1.addEdges(edAC);
		vertex2.addEdges(edBC);
		
		vertex1.setDistance(Integer.MAX_VALUE);
		vertex2.setDistance(Integer.MAX_VALUE);
		vertex3.setDistance(Integer.MAX_VALUE);
		
		List<Vertex> vertexs = new ArrayList<>();
		vertexs.add(vertex1);
		vertexs.add(vertex2);
		vertexs.add(vertex3);
		
		List<Edge> edges = new ArrayList<>();
		edges.add(edAB);
		edges.add(edAC);
		edges.add(edBC);
		
		
		DjikstraAlgorithm djikstraAlgorithm = new DjikstraAlgorithm();
		//djikstraAlgorithm.printShortestPath(vertex1 , vertex3);
		
		
		BellManFordAlgorithm bellManFordAlgorithm = new BellManFordAlgorithm();
		bellManFordAlgorithm.setEdges(edges);
		bellManFordAlgorithm.setVertices(vertexs);
		
		bellManFordAlgorithm.getShortestPath(vertex1, vertex3);
		
		DAGMinimumDistanceAlgorith dagMinimumDistanceAlgorith = new DAGMinimumDistanceAlgorith();
		dagMinimumDistanceAlgorith.setEdges(edges);
		dagMinimumDistanceAlgorith.setVertices(vertexs);
		dagMinimumDistanceAlgorith.dagDistance(vertex1, vertex3);
	}

}
