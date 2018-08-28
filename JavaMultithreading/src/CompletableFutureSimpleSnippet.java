import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import javax.security.auth.login.CredentialException;

public class CompletableFutureSimpleSnippet {
	
	private  static CompletableFuture<Integer> createCompletableFuture(){
		
		CompletableFuture<Integer> futureCount = CompletableFuture.supplyAsync(()->{
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 5;
		});
		return futureCount ;
	}
	
	public static void main(String args[]){
		
		long started = System.currentTimeMillis();
		
	/*	//So here we will not get blocked
		CompletableFuture<Integer> futureCount = createCompletableFuture();
		
		System.out.println("Time took : "+ (System.currentTimeMillis() - started));
		
		try {
			int count  = futureCount.get();
			System.out.println("Completable took time : "+(System.currentTimeMillis() -started));
			
			System.out.println("total count : "+ count);
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} */
		
		CompletableFuture<String> data  = createCompletableFuture().thenApply((Integer count)->{
			 int transFormedValue = count*10;
			 return transFormedValue;
		}).thenApply(transformed -> "Transformed value is : "+ transformed);
		
		try {
			System.out.println(data.get());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
		
		
		
	}

}
