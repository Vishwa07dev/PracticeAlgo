import java.util.ArrayList;
import java.util.List;
import java.util.Map ;
import java.util.stream.Collectors;

public class ListToMap {
	
	public static void main(String[] args){
		CustomObject customObject1  = new CustomObject("Vishwa", 1);
		CustomObject customObject2  = new CustomObject("Mohan", 2);
		CustomObject customObject3  = new CustomObject("Roshan", 3);
		CustomObject customObject4  = new CustomObject("Kumar", 4);
		CustomObject customObject5  = new CustomObject("Shivani", 5);
		CustomObject customObject6  = new CustomObject("Vishwa", 6);
		
	
		List<CustomObject> list = new ArrayList<CustomObject>();
		list.add(customObject1);
		list.add(customObject2);
		list.add(customObject3);
		list.add(customObject4);
		list.add(customObject5);
		list.add(customObject6);
		
		Map<String, Integer> map = list.stream().collect(Collectors.toMap(x -> x.getName() ,x -> x.getCount() ,(x1,x2) -> {
			
			return x1 +x2;
		})) ;
		
		System.out.println(map);
	}
	
	

}

class CustomObject {
	private String name ;
	private int count ;
	
	public CustomObject(String name, int count) {
		super();
		this.name = name;
		this.count = count;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name + " "+ count;
	}
	
	
	
	
}
