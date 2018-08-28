
public class HelloThread {
	
	public static void main(String args[]){
		
		System.out.println(Thread.currentThread().getName());
		Thread t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName() + " created ");
				
			}
		});
		
		t.start();
		
		Thread t1  = new Thread(() ->{
			System.out.println("Now inside the second thread " + Thread.currentThread().getName());
		});
		
		t1.start();
	}

}
