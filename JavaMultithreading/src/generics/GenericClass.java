package generics;

public class GenericClass<T,R,Z>{   //So whatever that we write here, that may parameters has to be provided in generics
	
	private T feild1 ;
	
	private R field2 ;
	
	private Z field3;
	
	
	public void setField(T value){
		this.feild1 = value ;
	}
	
	public T getField(){
		return this.feild1;
	}
	
	
	public static void main(String args[]){
		GenericClass<String,String, String> gc = new GenericClass<>();
		gc.setField("Hello World");
		
		System.out.println(gc.getField());
		
		GenericClass<Integer,String, String> gc1 = new GenericClass<>();
		
		gc1.setField(500);
		System.out.println(gc1.getField());
				
	}

}
