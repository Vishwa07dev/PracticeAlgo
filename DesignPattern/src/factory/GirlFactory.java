package factory;

public class GirlFactory extends AbstractFactory{

	@Override
	public Person getPersonObject() {
		
		return new Girl("13", "Shivani");
	}

}
