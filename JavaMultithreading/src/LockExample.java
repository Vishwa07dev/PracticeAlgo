
public class LockExample {
	
	protected MonitorObject monitorObject = new MonitorObject();
	protected boolean isLocked = false;
	
	public void lock() throws InterruptedException {
		synchronized(this){
			while(isLocked){
				monitorObject.wait();
			}
			isLocked = true ;
		}
	}
	
	public void unlock(){
		synchronized(this){
			this.isLocked =false ;
			synchronized(this.monitorObject){
				this.monitorObject.notify();
			}
		}
	}
	

}

class MonitorObject {
	
}
