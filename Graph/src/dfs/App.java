package dfs;

import java.util.ArrayList;
import java.util.List;

import bfs.Vertex;

public class App {
	/**
	 * So for a DAG, a graph can have multiple topological orderings 
	 * @param args
	 */
	public static void main(String[] args){
		
		List<Vertex> vertices = new ArrayList<>() ;
		
		        Vertex v0 = new Vertex(0);
				Vertex v1 = new Vertex(1);
				Vertex v2 = new Vertex(2);
				Vertex v3 = new Vertex(3);
				Vertex v4 = new Vertex(4);
				Vertex v5 = new Vertex(5);
				Vertex v6 = new Vertex(6);
				Vertex v7 = new Vertex(7);
				
				vertices.add(v0);
				vertices.add(v1);
				vertices.add(v2);
				vertices.add(v3);
				vertices.add(v4);
				vertices.add(v5);
				vertices.add(v6);
				vertices.add(v7);
				
				v0.addVertex(v6);
				
				v1.addVertex(v2);
				v1.addVertex(v4);
				v1.addVertex(v6);
				
				v3.addVertex(v4);
				v3.addVertex(v0);
				
				TopologicalSort topologicalSort = new TopologicalSort();
				
				for (Vertex v : vertices){
					if(!v.isVisited())
					topologicalSort.topologicalSort(v);
				}
				
				while(!topologicalSort.getStack().isEmpty()){
					System.out.println(topologicalSort.getStack().pop().getData());
				}
				
				v5.addVertex(v1);
				
				v7.addVertex(v1);
				v7.addVertex(v0);
		
	}
	
	
	
	

}
