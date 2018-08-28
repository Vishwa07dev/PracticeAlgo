package factory;

public class App {
	
	public static void main(String[] args){
		
		//This is an example of factory pattern
		Person person = PersonFactory.getPerson("MALE", "Shivani", "17");
		System.out.println(person.getSex());
		
		Person person2 = PersonAbstractFactory.getPerson(new BoyFactory());
		
		System.out.println(person2.getName()+" sex is "+ person2.getSex());
		
		
		
		
		
		/**
		 * Now in the case if we want to get rid of multiple if else block we can try for abstract factory design pattern, which is mostly the factory of factory
		 */
	}

}
