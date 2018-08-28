import java.util.concurrent.CountDownLatch;

//We can use the countdownlatch to make a thread wait till some conditions are met
public class UsingCountDownLatch {
	
	
	public static void main(String args[]){
		
		System.out.println("Inside the main function");
		
		CountDownLatch countDownLatch = new CountDownLatch(3);
		
		Thread waitingThread = new Thread(new WaitingThread(countDownLatch));
		waitingThread.start();
		Thread releasingThread = new Thread(new ReleasingThread(countDownLatch));
		releasingThread.start();
	}

}

class WaitingThread implements Runnable{
	
	private CountDownLatch countDownLatch;
	
	public WaitingThread(CountDownLatch countDownLatch) {
		this.countDownLatch=countDownLatch;
	}

	@Override
	public void run() {
		
		try {
			this.countDownLatch.await();
			System.out.println("Waiting for the CDL count to get 0");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("HUrray am free now");
	}
	
}


class ReleasingThread implements Runnable{

	private CountDownLatch countDownLatch;
	
	public ReleasingThread(CountDownLatch countDownLatch) {
		this.countDownLatch = countDownLatch;
	}
	
	@Override
	public void run() {
		this.countDownLatch.countDown();
		System.out.println("Bringing down 1 ");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.countDownLatch.countDown();
		System.out.println("Bringing down 2 ");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.countDownLatch.countDown();
		System.out.println("Bringing down 3 ");
		
		System.out.println("Go live free !");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
