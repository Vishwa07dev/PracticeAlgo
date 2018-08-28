package Decorator;

public class App {
	
	public static void main(String args[]){
		
		Car car = new SportsCar(new SimpleCar());
		
		car.setUpCar();
		
		Car car1 = new LuxuryCar(new SportsCar(new SimpleCar()));
		car1.setUpCar();
	}

}
