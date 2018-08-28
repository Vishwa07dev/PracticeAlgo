package proxyPattern;

/**
 * 
 * @author vmohan
 * 
 * Proxy design pattern is used when we don't want to expose the real method to the external world.
 *
 */
public class App {
	
	public static void main(String[] args){
		SystemExecutor systemExecutor1 = new ProxyExecutor(true);
		SystemExecutor systemExecutor2 = new ProxyExecutor(false);
		
		systemExecutor1.executeCommand("ls -ltr");
		systemExecutor2.executeCommand("ls -ltr");
	}
	
	
	
	

}
