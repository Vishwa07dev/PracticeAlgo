package bfs;

import java.util.ArrayList;
import java.util.List;
//Awsome :) , we can now find out the circles :P
public class GraphAlgorithms {
	
	public boolean circleExists(Vertice v){
		v.setBeingVisted(true);
		for(Vertice vertice :v.getNeighbours()){
			if(vertice.isBeingVisted()){
				System.out.println("Circle exists");
				return true ;
				
				
			}
			vertice.setVisited(true);
			return circleExists(vertice);
		}
		
		v.setBeingVisted(false);
		v.setVisited(true);
		return false ;
	}
	
	public static void main(String[] args){
		Vertice vertice1 = new Vertice(1);
		Vertice vertice2 = new Vertice(2);
		Vertice vertice4= new Vertice(4);
		Vertice vertice8 = new Vertice(8);
		Vertice vertice9 = new Vertice(9);
		Vertice vertice5 = new Vertice(5);
		
		vertice1.addNeighour(vertice2);
		vertice2.addNeighour(vertice4);
		vertice2.addNeighour(vertice5);
		vertice4.addNeighour(vertice8);
		vertice4.addNeighour(vertice9);
		//vertice5.addNeighour(vertice1);
		
		List<Vertice> vertices = new ArrayList<>();
		vertices.add(vertice1);
		vertices.add(vertice2);
		vertices.add(vertice4);
		vertices.add(vertice8);
		vertices.add(vertice9);
		vertices.add(vertice5);
		boolean circleExists = false ;
		GraphAlgorithms graphAlgorithms = new GraphAlgorithms();
		for(Vertice v : vertices){
			if(!v.isVisited()){
				if(graphAlgorithms.circleExists(v)){
					System.out.println(true);
					circleExists = true ;
					break ;
				}
			}
		}
		if(!circleExists){
			System.out.println("Circle doesn't exist");
		}
		
	}

}
