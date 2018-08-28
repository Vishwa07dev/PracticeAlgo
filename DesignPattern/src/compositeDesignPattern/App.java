package compositeDesignPattern;
/**
 * 
 * @author vmohan
 * 
 * composite design pattern can be applied when common set of rules has to be applied to multiple objects
 *
 */
public class App {
	
	public static void main(String args[]){
		
		CompositeDiagram compositeDiagram = new CompositeDiagram();
		
		compositeDiagram.addDiagram(new Circle());
		compositeDiagram.addDiagram(new Rectangle());
		
		//So here we are using the composite design patter as same operation has to be done on multiple objects
		for(Diagram diagram : compositeDiagram.getDiagrams()){
			diagram.paint();
		}
		
	}

}
