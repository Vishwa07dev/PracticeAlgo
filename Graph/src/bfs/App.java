package bfs;

public class App {
	
	public static void main(String[] args){
		
		Bfs bfs = new Bfs();
		
		Vertex vertex1 = new Vertex(1);
		Vertex vertex2 = new Vertex(2);
		Vertex vertex3 = new Vertex(3);
		Vertex vertex4 = new Vertex(4);
		Vertex vertex5 = new Vertex(5);
		
		vertex1.addVertex(vertex2);
		vertex1.addVertex(vertex4);
		vertex4.addVertex(vertex5);
		vertex2.addVertex(vertex3);
		
		
		bfs.bfs(vertex4);
		
	}

}
