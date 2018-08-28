package ShortestPathAlgorithm;

public class Edge {
	
	private double weight ;
	
	private Vertex startVertex ;
	private Vertex endVertex ;
	
	public Edge(int weight, Vertex startVertex , Vertex endVertex){
		this.weight = weight ;
		this.startVertex = startVertex ;
		this.endVertex = endVertex;
		
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public Vertex getStartVertex() {
		return startVertex;
	}

	public void setStartVertex(Vertex startVertex) {
		this.startVertex = startVertex;
	}

	public Vertex getEndVertex() {
		return endVertex;
	}

	public void setEndVertex(Vertex endVertex) {
		this.endVertex = endVertex;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.startVertex.getName() + " -> " + this.endVertex.getName() ;
	}

}
