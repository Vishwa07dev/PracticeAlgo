package strategy;

public class ProblemSolver {
	
	private Problem problem ;
	
	public void solveProblem(Algorith algorithm){
		algorithm.Solve(problem);
	}

	public Problem getProblem() {
		return problem;
	}

	public void setProblem(Problem problem) {
		this.problem = problem;
	}
	
	

}
