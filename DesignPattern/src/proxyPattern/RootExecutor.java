package proxyPattern;

public class RootExecutor implements SystemExecutor{

	@Override
	public void executeCommand(String command) {
		System.out.println("executing command by admin : "+ command);
		
	}

}
