package AdaptorDesignPatter;

public class SocketAdaptor extends Socket implements Adaptor{

	@Override
	public Volt get3Volt() {
		
		return new Volt(giveCurrent().getVolt()/4);
	}

	@Override
	public Volt get9Volt() {
		
        return new Volt((giveCurrent().getVolt()/4)*3);
	}

	@Override
	public Volt get12Volt() {
		return giveCurrent();
	}

}
