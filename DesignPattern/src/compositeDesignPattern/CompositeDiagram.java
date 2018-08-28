package compositeDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class CompositeDiagram {
	
	private List<Diagram> diagrams ;
	
	public CompositeDiagram() {
		diagrams = new ArrayList<>();
	}

	public List<Diagram> getDiagrams() {
		return diagrams;
	}

	public void setDiagrams(List<Diagram> diagrams) {
		this.diagrams = diagrams;
	}
	
	public void addDiagram(Diagram d){
		this.diagrams.add(d);
	}
	
	

}
