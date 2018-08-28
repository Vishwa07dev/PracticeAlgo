package prototype;

import java.util.ArrayList;
import java.util.List;
/**
 * Prototype design pattern is used when the object creation from the scratch will be a very costly
 * affair. So we take the existing object and created a new object on the top of it and then modify
 * that.
 * @author vmohan
 *
 */
public class BigObject implements Cloneable {
   
	
	private List<String> items;
	
	public BigObject() {
		items = new ArrayList<>();
	}
	

	
    
	
	public List<String> getItems() {
		return items;
	}





	public BigObject setItems(List<String> items) {
		this.items = items;
		return this ;
	}
	
	public void  loadItemsFromDB(){
		this.items.add("Hello");
		this.items.add("World");
	}





	@Override
	public BigObject clone(){
		
		List<String> items = this.getItems();
		
		List<String>itemsCloned = new ArrayList<>();
		
		for(String item : items){
			itemsCloned.add(item);
			
		}
		return new BigObject().setItems(itemsCloned); 
		
		
	}
}
