package bfs;

import java.util.Stack;

public class TopologicalSort {
	
	private Stack<Vertice> stack ;
	
	public TopologicalSort() {
		this.stack = new Stack<Vertice>();
	}
	/**
	 * 
	 * @param v
	 * 
	 * So this is the awsome topological sort algorithm written by extending the dfs :)
	 */
	public void sort(Vertice v){
		if(v!=null && !v.isVisited()){
			for(Vertice vertice : v.getNeighbours()){
				if(v !=null && !v.isVisited()){
					sort(vertice);
				}
			}
			v.setVisited(true);
			this.stack.push(v);
		}
		
		
	}

	public Stack<Vertice> getStack() {
		return stack;
	}

	public void setStack(Stack<Vertice> stack) {
		this.stack = stack;
	}
	
	

}
