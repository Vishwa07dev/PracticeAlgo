package strategy;

public class App {
	//So this is the example of the strategy design pattern
	public static void main(String[] args){
		ProblemSolver problemSolver = new ProblemSolver();
		problemSolver.setProblem(new Problem1());
		problemSolver.solveProblem(new Algorithm1());
		problemSolver.setProblem(new Problem2());
		problemSolver.solveProblem(new Algorithm2());
	}

}
