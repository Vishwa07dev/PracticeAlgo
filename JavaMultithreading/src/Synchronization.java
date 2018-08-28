
public class Synchronization {
	
	public static void main(String args[]){
		
		Counter c = new Counter();
		
		Runnable1 runnable1 = new Runnable1(c);
		Runnable2 runnable2 = new Runnable2(c);
		
		
		Thread t1 = new Thread(runnable1);
		Thread t2 = new Thread(runnable2);
		
		t1.start();
		t2.start();
		
		
	}
	
	

}

class Counter{
private int count ;
	
	public synchronized void increaseCount(){
		for(int i=0;i<5;i++){
			System.out.println(count);
			count +=2;
		}
	}
}

class Runnable1 implements Runnable{
	private Counter counter ;
	
	public Runnable1(Counter counter) {
		this.counter = counter ;
	}
	

	@Override
	public void run() {
		counter.increaseCount();
		
	}
	
}

class Runnable2 implements Runnable{
	private Counter counter ;
	
	public Runnable2(Counter counter) {
		this.counter = counter ;
	}
	

	@Override
	public void run() {
		counter.increaseCount();
		
	}
	
}
