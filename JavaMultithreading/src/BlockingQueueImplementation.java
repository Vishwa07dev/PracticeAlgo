import java.util.ArrayList;
import java.util.List;

public class BlockingQueueImplementation {
	
	private List<String> blockingQueue ;
	private int capacity ;
	
	
	public BlockingQueueImplementation(int capacity) {
		this.capacity=capacity ;
		blockingQueue = new ArrayList<>(); //This can act as the first in first out manner
		
	}
	
	
	public  synchronized void enQue(String data) throws InterruptedException{
		
		while(blockingQueue.size() == capacity){
			System.out.println("Thread wating is : "+ Thread.currentThread().getName());
			wait(); // so the calling thread will wait till the blocking queue is free and release the lock on the object
		}
		if(blockingQueue.size()==0){
			notifyAll();
		}
		System.out.println("data is being added by thread : "+Thread.currentThread().getName());
		this.blockingQueue.add(data);
		
	}
	
	
	public synchronized String deQueue() throws InterruptedException{
		while(blockingQueue.size() ==0){
			wait();
		}
		if(blockingQueue.size()==capacity){
			notifyAll();
		}
		System.out.println("data got deleted by thread : "+Thread.currentThread().getName());
		return this.blockingQueue.remove(0);
	}
	
	
	public static void main(String args[]){
		BlockingQueueImplementation blockingQueueImplementation = new BlockingQueueImplementation(5);
		//These are the producer threads
		for(int i=0;i< 7;i++){   //So all these thread are working on the same object, so they will take log on the same object
			Thread t = new Thread(new Runnable() {
				
				@Override
				public void run() {
					try {
						blockingQueueImplementation.enQue("Data");
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			});
			t.start();
			
		}
		
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//These are the consumer threads
		for(int i=0;i< 3;i++){
			Thread t = new Thread(new Runnable() {
				
				@Override
				public void run() {
					try {
						blockingQueueImplementation.deQueue();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			});
			t.start();
			
		}
		
		
	}
	

}
