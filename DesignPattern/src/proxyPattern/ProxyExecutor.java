package proxyPattern;

public class ProxyExecutor extends RootExecutor implements SystemExecutor{
	
	
	private boolean isAdmin ;
	
	public ProxyExecutor(boolean isAdmin){
		this.isAdmin = isAdmin ;
		
	}
	@Override
	public void executeCommand(String command) {
		if(isAdmin){
			super.executeCommand(command);
		}else{
			System.out.println("executing command by non admin : "+ command);
		}
		
		
	}

}
