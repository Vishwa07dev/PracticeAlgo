package dfs;

import java.util.Stack;

import bfs.Vertex;

public class TopologicalSort {
	
	Stack<Vertex> stack ;
	
	public TopologicalSort() {
		stack = new Stack<>();
	}
	
	public void topologicalSort(Vertex vertex){
		if(vertex == null ){
			return ;
		}
		vertex.setVisited(true);
		
		for(Vertex ver : vertex.getVertexList()){
			if(!ver.isVisited()){
				topologicalSort(ver);
			}
		}
		stack.push(vertex);
		
		
		
	}

	public Stack<Vertex> getStack() {
		return stack;
	}

	public void setStack(Stack<Vertex> stack) {
		this.stack = stack;
	}
	
	

}
