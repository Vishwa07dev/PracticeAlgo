import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureExamples {
	
	private static final int NTHREADS=10;
	
	public static void main(String args[]){
		
		ExecutorService executorService = Executors.newFixedThreadPool(NTHREADS);
		List<Future<Integer>> futures = new ArrayList<>();
		
		for(int i =0;i<20;i++){
			MyCallable myCallable = new MyCallable();
			
			futures.add(executorService.submit(myCallable));
			
		}
		
		System.out.println("Size of the list is : "+ futures.size());
		int sum =0;
		for(Future<Integer> future : futures){
			try {
				int value = future.get();  //So this is the blocking call , in which we are waiting for the future to return the data 
				
				sum +=value;
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("Final sum is : "+ sum );
		executorService.shutdown();
	}

}

class MyCallable implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		
		int sum  = 0 ;
		
		for(int i=0;i<100;i++){
			sum +=i;
		}
		
		Thread.sleep(5000);
		
		return sum ;
	}
	
}
