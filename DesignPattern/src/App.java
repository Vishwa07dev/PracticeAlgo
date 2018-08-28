
public class App {
	
	public static void main(String args[]){
		SingleTonClass singleTonClass1 = SingleTonClass.getSingleTonClass();
		
		SingleTonClass singleTonClass2 = SingleTonClass.getSingleTonClass();
		
		System.out.println("singleton1 : "+ singleTonClass1 +" and singleton2 : "+ singleTonClass2);
		
	    EnumSingleton singleton1 = EnumSingleton.INSTANCE;
	    
	    System.out.println(singleton1 +"  "+ singleton1.getValue());
		
	}

}
