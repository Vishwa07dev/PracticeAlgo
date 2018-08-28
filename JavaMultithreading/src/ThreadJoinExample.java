
public class ThreadJoinExample {
	
	
	static class MyRunnable implements Runnable{

		@Override
		public void run() {
			System.out.println("Thread started : "+ Thread.currentThread().getName());
			
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("Thread ended : "+ Thread.currentThread().getName());
			
		}
		
	}
	
public static void main(String args[]){
		
		Thread t1  = new Thread(new MyRunnable(),"Thread1");
		Thread t2  = new Thread(new MyRunnable(),"Thread2");
		Thread t3  = new Thread(new MyRunnable(), "Thread3");
		
		t1.start();
		
		try {
			t1.join(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//start t2 when 2 second is passed. t1 will remain sleeping till 4 second
		t2.start();
		
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		t3.start(); //t3 will start only after t1 is done
		
		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//So once we call the join method on a thread...current thread execution will wait till thread on which join method is called is not done executing
		System.out.println("Finally main method is called");
		
	}
	

}
