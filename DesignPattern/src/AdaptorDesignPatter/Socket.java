package AdaptorDesignPatter;

/**
 * 
 * @author vmohan
 * 
 * Now this is the socket adaptor which give 12 v current
 *
 */
public class Socket {
	
	public Volt giveCurrent(){
		return new Volt(12);
	}

}
