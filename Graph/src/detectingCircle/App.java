package detectingCircle;

import java.util.ArrayList;
import java.util.List;

import detectingCircle.Vertex;

public class App {
	
	public static void main(String args[]){
		Vertex v1 = new Vertex(1);
		Vertex v2 = new Vertex(2);
		Vertex v3 = new Vertex(3);
		Vertex v4 = new Vertex(4);
		Vertex v5 = new Vertex(5);
		Vertex v6 = new Vertex(6);
		
		v1.addNeighour(v2);
		v1.addNeighour(v3);
		v2.addNeighour(v3);
		v4.addNeighour(v1);
		v4.addNeighour(v5);
		v5.addNeighour(v6);
		v6.addNeighour(v4);
		
		
		List<Vertex> vertexList = new ArrayList<>();
		vertexList.add(v1);
		vertexList.add(v2);
		vertexList.add(v3);
		vertexList.add(v4);
		vertexList.add(v5);
		vertexList.add(v6);
		
		/*List<Vertex> vertices = new ArrayList<>() ;
		
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
		
		v0.addNeighour(v6);
		
		v1.addNeighour(v2);
		v1.addNeighour(v4);
		v1.addNeighour(v6);
		
		v3.addNeighour(v4);
		v3.addNeighour(v0);*/
		
		for(Vertex v : vertexList){
			System.out.println("Cycle exists : " + new DetectingCircle().isCirclePresent(v) );
			v.setBeingVisited(false);
			v.setVisited(false);
		}
		
		
	}

}
