package factory;

public class PersonAbstractFactory {
	/**
	 * Since this is an abstractFactory which is a factory of factory, so we don't need to write the multiple if else blocks
	 * @param abstractFactory
	 * @return
	 */
	public static Person getPerson(AbstractFactory abstractFactory){
		return abstractFactory.getPersonObject();
	}

}
