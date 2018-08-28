package bfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFS {
	//Similar to the pre-order traversal
	public void dfs(Vertice v){
		Stack<Vertice> stack = new Stack<Vertice>();
		if(v!=null && !v.isVisited()){
			stack.push(v);
		}
		
		
		while(!stack.isEmpty()){
			Vertice x = stack.pop();
			x.setVisited(true);
		    System.out.println(x);
		    for(Vertice vertice : x.getNeighbours()){
		    	if(vertice !=null && !vertice.isVisited()){
		    		stack.push(vertice);
		    	}
		    }
		}
		
	}
	
	
	public void dfsRecursion(Vertice v){
		//System.out.println("Inside dfsRecursion : "+v.getData());
		if(v==null){
			return ;
		}
		System.out.println(v.getData());
		v.setVisited(true);
		for(Vertice vertice : v.getNeighbours()){
			if(vertice!=null && !vertice.isVisited()){
				dfsRecursion(vertice);
			}
		}
	}

}
