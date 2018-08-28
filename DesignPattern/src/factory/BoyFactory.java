package factory;


public class BoyFactory extends AbstractFactory{

	@Override
	public Person getPersonObject() {
		
		return new Boy("13", "Vishwa");
	}

}
