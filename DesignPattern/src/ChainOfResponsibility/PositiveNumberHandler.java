package ChainOfResponsibility;

public class PositiveNumberHandler implements NumberHandler {
	
	private NumberHandler numberHandler ;

	@Override
	public void setNextHandler(NumberHandler handler) {
		this.numberHandler = handler ;
		
	}

	@Override
	public void processNumber(int num) {
		
		if(num>0){
			System.out.println("Positive number handled");
		}else{
			numberHandler.processNumber(num);
		}
	}

}
