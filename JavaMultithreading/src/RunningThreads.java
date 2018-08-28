import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author vmohan
 *
 */
public class RunningThreads {
	
	public static void main(String args[]){
		
		List<Thread> threadList  = new ArrayList<Thread>();
		
		for(int i =0;i<500 ;i++){
			Thread t = new Thread(new MyThread(10000000L + i));
			t.start();
			threadList.add(t);
		}
		
		int activeCount = 0 ;
		do{ 
		    activeCount = 0 ;
			for(Thread t : threadList){
				if(t.isAlive()){
					activeCount ++ ;
				}
			}
			System.out.println("Count of active thread is : "+ activeCount);
		}while(activeCount>0);
		
	}

}

class MyThread implements Runnable{
	
	private final long timeDuration ;
	
	public MyThread (long timeDuration){
		this.timeDuration = timeDuration ;
	}

	
	@Override
	public void run() {
		long sum = 0;
		for(int i=0 ; i <timeDuration ;i++ ){
			sum += i;
		}
		
		System.out.println(sum);
		
	}
	
}
