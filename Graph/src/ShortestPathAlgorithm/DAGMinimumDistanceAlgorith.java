package ShortestPathAlgorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;





/*
 * This will be linear algorith, provided there is no cycle in the graph. First we will do the topological sorting
 */
public class DAGMinimumDistanceAlgorith {
	
	private List<Vertex> vertices ;
	private List<Edge> edges ;
	Stack<Vertex>stack ;
	
	public DAGMinimumDistanceAlgorith() {
		vertices = new ArrayList<>();
		edges = new ArrayList<>();
		stack  = new Stack<>();
	}
	
	
	//So now we have done the topological sorting
	public void topologicalSort(){
		for(Vertex vertex : vertices){
			if(!vertex.isVisited()){
				dfs(vertex);
				
			}
		}
		while(!stack.isEmpty()){
			System.out.print(stack.pop().getName() + " -> ");
		}
		System.out.println();
		
	}
	
	private void dfs(Vertex v){
		if(v==null || v.isVisited()){
			return ;
		}
		
		for(Edge edge : v.getNeighours()){
			Vertex  vertex = edge.getEndVertex();
			if(!vertex.isVisited()){
				dfs(vertex);
			}
		}
		v.setVisited(true);
		stack.push(v);
		
	}
	
	
	public void dagDistance(Vertex source , Vertex destination){
		source.setDistance(0);
		topologicalSort(); //This sorts the DAG in topological order O(V+E) lineat sorting algorithm is being used
		
		for(Vertex vertex : stack){
			for(Edge edge : vertex.getNeighours()){
				Vertex start = edge.getStartVertex();
				Vertex end  = edge.getEndVertex();
				if(start.getDistance()==Double.MAX_VALUE) continue ;
				
				double distance = start.getDistance() + edge.getWeight();
				
				if(distance<end.getDistance()){
					end.setDistance(distance);
				}
			}
		}
		
		if(destination.getDistance() == Double.MAX_VALUE){
			System.out.println("Minimum distance can't be found");
			return ;
		}else{
			System.out.println("DAG : "+destination.getDistance());
			Vertex  ver = destination;
			while(ver !=null){
				System.out.print(ver.getName() + " ");
				ver = ver.getPredecessor();
			}
			System.out.println();
		}
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



	public Stack<Vertex> getStack() {
		return stack;
	}



	public void setStack(Stack<Vertex> stack) {
		this.stack = stack;
	}



	public static void main(String args[]){
		
		List<Vertex> vertices = new ArrayList<>() ;
		
        Vertex v0 = new Vertex("0");
		Vertex v1 = new Vertex("1");
		Vertex v2 = new Vertex("2");
		Vertex v3 = new Vertex("3");
		Vertex v4 = new Vertex("4");
		Vertex v5 = new Vertex("5");
		Vertex v6 = new Vertex("6");
		Vertex v7 = new Vertex("7");
		
		vertices.add(v0);
		vertices.add(v1);
		vertices.add(v2);
		vertices.add(v3);
		vertices.add(v4);
		vertices.add(v5);
		vertices.add(v6);
		vertices.add(v7);
		
		Edge edge1  = new Edge(1, v0, v6);
		Edge edge2  = new Edge(1, v1, v2);
		Edge edge3  = new Edge(1, v1, v4);
		Edge edge4  = new Edge(1, v1, v6);
		Edge edge5  = new Edge(1, v3, v4);
		Edge edge6  = new Edge(1, v3, v6);
		
		List<Edge> edges = new ArrayList<>();
		edges.add(edge1);
		edges.add(edge2);
		edges.add(edge3);
		edges.add(edge4);
		edges.add(edge5);
		edges.add(edge6);
		
		v0.addEdges(edge1);
		v1.addEdges(edge2);
		v1.addEdges(edge3);
		v1.addEdges(edge4);
		v3.addEdges(edge5);
		v3.addEdges(edge6);
		
		DAGMinimumDistanceAlgorith dagMinimumDistanceAlgorith = new DAGMinimumDistanceAlgorith();
		dagMinimumDistanceAlgorith.setEdges(edges);
		dagMinimumDistanceAlgorith.setVertices(vertices);
		
		dagMinimumDistanceAlgorith.topologicalSort();
		/**
		 * 7
5
3
1
4
2
0
6
		 */
	
		
		
		
	}

}
