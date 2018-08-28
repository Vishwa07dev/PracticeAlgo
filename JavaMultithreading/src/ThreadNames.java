
public class ThreadNames {
	
	public static void main(String args[]){
		System.out.println("Name of the current thread is : "+Thread.currentThread().getName());
		
		for(int i=0;i<100;i++){
			new Thread("" +i){
				public void run(){
					System.out.println("Current thread is : "+ Thread.currentThread().getName());
				}
			}.start();
		}
	}

}
