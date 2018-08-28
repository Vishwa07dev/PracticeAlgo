
public class SingleTonClass {
	
	private SingleTonClass(){
		
	}
	
	private static  class InnerSingleTonClass {
		
		private final static SingleTonClass INSTANCE = new SingleTonClass();
		
	}
	
	public static SingleTonClass getSingleTonClass(){
		return InnerSingleTonClass.INSTANCE;
	}

}
