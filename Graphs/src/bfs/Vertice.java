package bfs;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author vmohan
 *
 */
public class Vertice {
	
	private int data ;
	private boolean isVisited ;
	private boolean isBeingVisted ;
	public boolean isBeingVisted() {
		return isBeingVisted;
	}

	public void setBeingVisted(boolean isBeingVisted) {
		this.isBeingVisted = isBeingVisted;
	}

	private List<Vertice> neighbours ;
	
	public Vertice(int data){
		this.data = data ;
		neighbours = new ArrayList<>();
	}
	
	public void addNeighour(Vertice vertice){
		this.neighbours.add(vertice);
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

	public List<Vertice> getNeighbours() {
		return neighbours;
	}

	public void setNeighbours(List<Vertice> neighbours) {
		this.neighbours = neighbours;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Vetex : " +this.data ; 
	}

}
