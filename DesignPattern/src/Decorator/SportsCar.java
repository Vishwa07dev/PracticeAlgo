package Decorator;

public class SportsCar extends  CarDecorator {

    
    public SportsCar(Car car) {
		super(car);
	}
    
    @Override
    public void setUpCar(){
    	super.setUpCar();
    	System.out.println("Adding features of sports car");
    }

}
