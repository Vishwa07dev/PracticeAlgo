package AdaptorDesignPatter;
/**
 * 
 * @author vmohan
 * 
 * Adaptor design pattern is used when we want to make one interface work with other interface
 *
 */
public class App {
	
	
	public static void main(String args[]){
		Adaptor adaptor = new  SocketAdaptorObjImpl() ;
		
		System.out.println( "3 Watt current : "+ adaptor.get3Volt().getVolt());
		
	}
}
