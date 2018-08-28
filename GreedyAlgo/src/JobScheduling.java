import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JobScheduling {
	
	public static void main(String args[]){
		Jobs job1 = new Jobs("a",100,2);
		Jobs job2 = new Jobs("b",19,1);
		Jobs job3 = new Jobs("c",27,2);
		Jobs job4 = new Jobs("d",25,1);
		Jobs job5 = new Jobs("e",15,3);
		
		List<Jobs> jobs  = new ArrayList<>();
		jobs.add(job1);
		jobs.add(job2);
		jobs.add(job3);
		jobs.add(job4);
		jobs.add(job5);
		
		Collections.sort(jobs);
		
		int time = 1;
		for(Jobs job :jobs){
			if(time <= job.getDeadLine()){
				System.out.println(job);
				time++;
			}
		}
		
		
		
		
	}
	

}


class Jobs implements Comparable<Jobs>{
	private String jobId ;
	private double profit ;
	private double deadLine ;
	
	
	public Jobs(String jobId) {
		super();
		this.jobId = jobId;
	}
	
	
	
	public Jobs(String jobId, double profit, double deadLine) {
		super();
		this.jobId = jobId;
		this.profit = profit;
		this.deadLine = deadLine;
	}



	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public double getProfit() {
		return profit;
	}
	public void setProfit(double profit) {
		this.profit = profit;
	}
	public double getDeadLine() {
		return deadLine;
	}
	public void setDeadLine(double deadLine) {
		this.deadLine = deadLine;
	}

	@Override
	public int compareTo(Jobs otherJob) {
		return (int) (-this.profit + otherJob.profit);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return jobId +" " + profit +" "+deadLine;
	}
	
	
}
