package AdaptorDesignPatter;

public class SocketAdaptorObjImpl implements Adaptor{
	
	Socket socket = new Socket();

	@Override
	public Volt get3Volt() {
		return new Volt(socket.giveCurrent().getVolt()/4);
	}

	@Override
	public Volt get9Volt() {
		
		return new Volt((socket.giveCurrent().getVolt()/4)*3);
	}

	@Override
	public Volt get12Volt() {
		return socket.giveCurrent();
	}

}
