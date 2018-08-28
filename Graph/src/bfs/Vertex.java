package bfs;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
	
	private int data;
	private boolean isVisited;
	private List<Vertex> vertexList ;
	
	public Vertex(int data){
		this.data = data;
		vertexList = new ArrayList<>();
	}
	
	public void addVertex(Vertex vertex){
		vertexList.add(vertex);
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public boolean isVisited() {
		return isVisited;
	}
	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}
	public List<Vertex> getVertexList() {
		return vertexList;
	}
	public void setVertexList(List<Vertex> vertexList) {
		this.vertexList = vertexList;
	}
	
	

}
