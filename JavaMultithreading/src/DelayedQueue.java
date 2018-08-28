import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @author vmohan
 *
 */
public class DelayedQueue {
	
   

}

class ItemToBeQueued implements Delayed {  // Class to be 
    
	private String data ;
	private long startTime ;
	
	public ItemToBeQueued(String data , long startTime) {
		this.data = data ;
		this.startTime = startTime ;
	}
	
	
	@Override
	public int compareTo(Delayed o) {
		
       		return 0;
	}

	@Override
	public long getDelay(TimeUnit unit) {
		// TODO Auto-generated method stub
		return 0;
	}


	public String getData() {
		return data;
	}


	public void setData(String data) {
		this.data = data;
	}


	public long getStartTime() {
		return startTime;
	}


	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}
	
	
	
}
