package ShortestPathAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class Vertex  implements Comparable<Vertex>{
	
	private String name ;
	private Vertex predecessor ;
	private boolean isVisited ;
	private List<Edge> neighours ;
	private double distance ;
	
	public Vertex(String name) {
		this.name = name ;
		neighours = new ArrayList<>();
	}

	
	public Vertex getPredecessor() {
		return predecessor;
	}

	public void setPredecessor(Vertex predecessor) {
		this.predecessor = predecessor;
	}

	public boolean isVisited() {
		return isVisited;
	}

	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}

	public List<Edge> getNeighours() {
		return neighours;
	}

	public void setNeighours(List<Edge> neighours) {
		this.neighours = neighours;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getDistance() {
		return distance;
	}


	public void setDistance(double distance) {
		this.distance = distance;
	}
    
	public void addEdges(Edge edge){
		this.neighours.add(edge);
	}

	@Override
	public int compareTo(Vertex otherVertex) {
		// TODO Auto-generated method stub
		return Double.compare(this.getDistance(),otherVertex.getDistance());
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name;
	}
	
	
	
	

}
