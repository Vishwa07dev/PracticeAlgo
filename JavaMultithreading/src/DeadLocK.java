

/**
 * So, this is a very crucial question and very important also. Many people ask this Thread Deadlock question :)
 * @author vmohan
 *
 */
public class DeadLocK {
	
	private static String obj1 ="Lock1" ;
	private static String obj2 ="Lock2";
	
	
	public static void main(String args[]){
		Runnable  runnable1 = new Runnable() {
			
			@Override
			public void run() {
				 
				synchronized (obj1){
					System.out.println("Inside the first runnable taking lock on obj1");
					try {
						Thread.sleep(4000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					System.out.println("Waiting for the lock2 to get released ");
					
					synchronized(obj2){
						System.out.println("Inside the first runnable taking lock on obj2");
					}
				}
				
				
				
			}
		};
		
		
        Runnable  runnable2 = new Runnable() {
			
			@Override
			public void run() {
				
				synchronized(obj2){
					System.out.println("Inside the second runnable taking lock on obj2");
					try{
					 Thread.sleep(3000);
					}catch(InterruptedException e){
						e.printStackTrace();
					}
					System.out.println("Waiting for the lock1 to get released");
					synchronized(obj1){
						System.out.println("Inside the second runnable taking lock on obj1");
					}
				}
				
				
				
				
			}
		};
		
		Thread t1 = new Thread(runnable1);
		Thread t2 = new Thread(runnable2);
		t1.start();
		t2.start();
	}

}
