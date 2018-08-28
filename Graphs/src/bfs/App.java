package bfs;

import java.util.ArrayList;
import java.util.List;

public class App {
	
	public static void main(String[] args){
		
		Vertice vertice1 = new Vertice(1);
		Vertice vertice2 = new Vertice(2);
		Vertice vertice3= new Vertice(3);
		Vertice vertice4 = new Vertice(4);
		Vertice vertice5 = new Vertice(5);
		Vertice vertice6 = new Vertice(6);
		
		vertice1.addNeighour(vertice2);
		vertice1.addNeighour(vertice4);
		vertice4.addNeighour(vertice5);
		
		vertice2.addNeighour(vertice3);
		vertice6.addNeighour(vertice4);
		
		List<Vertice> vertices = new ArrayList<Vertice>();
		vertices.add(vertice1);
		vertices.add(vertice2);
		vertices.add(vertice3);
		vertices.add(vertice4);
		vertices.add(vertice5);
		vertices.add(vertice6);
		
		
		
		BFS bfs = new BFS();
		
		for( Vertice vertice : vertices){
			bfs.bfs(vertice);
		}
		
		for( Vertice vertice : vertices){
			vertice.setVisited(false);
		}
		
		System.out.println("BFS Above ################## DFS below");
		
		DFS dfs = new DFS();
		
		for( Vertice vertice : vertices){
			dfs.dfs(vertice);
		}
		
		for( Vertice vertice : vertices){
			vertice.setVisited(false);
		}
		
		System.out.println("topological sorting");
		
		//dfs.dfsRecursion(vertice1);
		
		TopologicalSort topologicalSort = new TopologicalSort();
		
		for( Vertice vertice : vertices){
			topologicalSort.sort(vertice);
		}
		
		while(!topologicalSort.getStack().isEmpty()){
			System.out.print(topologicalSort.getStack().pop().getData() +" -> ");
		}
	}

}
