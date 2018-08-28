
public class OuterInner {
	
	class InnerClass{
		private String name = "privateName";
	}
	
	public static void main(String args[]){
		
		/*
		 * So, here we see we can find the inner class private members from the outer class
		 * 
		 *  But in the case of Scala, from the outer class we can't see the inner class
		 *  
		 *  But we can see the private variable inside the inner class :)
		 *  
		 */
		InnerClass innerClass = (new OuterInner()).new InnerClass();
		
		System.out.println(innerClass.name);
		
	}

}
