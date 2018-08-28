package detectingCircle;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
	
	private int data ;
	private boolean visited ;
	private boolean beingVisited ;
	
	private List<Vertex> neighours ;
	
	public Vertex(int data){
		this.data=data;
		neighours = new ArrayList<>();
		
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public boolean isBeingVisited() {
		return beingVisited;
	}

	public void setBeingVisited(boolean beingVisited) {
		this.beingVisited = beingVisited;
	}

	public List<Vertex> getNeighours() {
		return neighours;
	}

	public void setNeighours(List<Vertex> neighours) {
		this.neighours = neighours;
	}
	
	public void addNeighour(Vertex v){
		this.neighours.add(v);
	}
	
	

}
