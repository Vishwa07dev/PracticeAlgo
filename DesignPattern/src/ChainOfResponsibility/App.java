package ChainOfResponsibility;

public class App {
	
	public static void main(String args[]){
		
		NumberHandler hand1 = new NegativeNumberHandler();
		NumberHandler hand2 = new ZeroNumberHandler();
		NumberHandler hand3 = new PositiveNumberHandler();
		
		hand1.setNextHandler(hand2);
		hand2.setNextHandler(hand3);
		
		hand1.processNumber(-1);
		hand1.processNumber(0);
		hand1.processNumber(1);
	}

}
