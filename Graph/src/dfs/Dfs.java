package dfs;

import java.util.LinkedList;
import java.util.Stack;

import bfs.Vertex;

public class Dfs {
	
	public void dfsRecursion(Vertex v){
		if(v==null){
			return;
		}
		v.setVisited(true);
		System.out.println(v.getData());
		for(Vertex vertex : v.getVertexList()){
			dfsRecursion(vertex);
		}
	}
	
	public void dfsIteration(Vertex v){
		if(v==null){
			return ;
		}
		
		Stack<Vertex> s = new Stack<>();
		v.setVisited(true);
		s.add(v);
		while(!s.isEmpty()){
			Vertex vertex = s.pop();
			System.out.println(vertex.getData());
			
			for(Vertex ver : vertex.getVertexList()){
				if(!ver.isVisited()){
					ver.setVisited(true);
					s.push(ver);
				}
			}
				
		}
		
	}

}
