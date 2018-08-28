package Decorator;

public class LuxuryCar  extends CarDecorator{
	
	public LuxuryCar(Car car) {
		
		super(car);
		
	}
	
	@Override
    public void setUpCar(){
    	super.setUpCar();
    	System.out.println("Adding features of luxury car");
    }

	
	

}
