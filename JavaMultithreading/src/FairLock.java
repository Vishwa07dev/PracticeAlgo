import java.util.*;

public class FairLock {
	
	private boolean isLocked = false ;
	private Thread lockingThread = null ;
	private List<QueueObject> waitingThread = new ArrayList<QueueObject>();
	
	public void lock() throws InterruptedException{
		QueueObject queueObject = new QueueObject();
		
		synchronized (this) {
			waitingThread.add(queueObject);
			
			while(isLocked || waitingThread.get(0) != queueObject){
				synchronized (queueObject) {
					try{
						queueObject.wait();
					}catch(InterruptedException e){
						waitingThread.remove(queueObject);
						throw e;
					}
				
					
				}
			}
			
			waitingThread.remove(queueObject);
			isLocked= true;
			lockingThread = Thread.currentThread();
		}
	}
	
	public synchronized void unlock(){
		
	}
	
	

}

class QueueObject{
	
}
