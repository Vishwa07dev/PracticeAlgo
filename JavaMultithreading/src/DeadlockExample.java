/*
 * 
 */
public class DeadlockExample {
	
	
	public static void main(String args[]){
		
		String lock1 ="lock1";
		String lock2 = "lock2";
		
		Thread t1  = new Thread( new Runnable(){
			
			@Override
			public void run(){
				
				synchronized(lock1){
					System.out.println("First thread took the lock");
					
					try{
						Thread.sleep(3000);
					}catch(InterruptedException e){
						
					}
					synchronized(lock2){
						System.out.println("Second thread took the lock");
					}
				}
			}
		});
		
      Thread t2  = new Thread( new Runnable(){
			
			@Override
			public void run(){
				
				synchronized(lock2){
					System.out.println("Second thread took the lock");
					
					try{
						Thread.sleep(3000);
					}catch(InterruptedException e){
						
					}
					synchronized(lock1){
						System.out.println("First thread took the lock");
					}
				}
			}
		});
      
      t1.start();
      t2.start();
		
	}
	
	
	

}
