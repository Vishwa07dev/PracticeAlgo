package ChainOfResponsibility;

public interface NumberHandler {
	
	public void setNextHandler(NumberHandler handler);
	
	public void processNumber(int num);

}
