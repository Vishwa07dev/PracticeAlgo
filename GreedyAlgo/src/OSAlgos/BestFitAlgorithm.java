package OSAlgos;

/**
 * 
 * @author vmohan In the best fit algorithm we try to find the minimum block
 *         where the process should be stored.
 *         
 *         
 *         Awesome, I was able to code this in one go :)
 *
 */
public class BestFitAlgorithm {

	public static void doBestFit(int[] blocks, int[] processes) {

		for (int i = 0; i < processes.length; i++) {

			int minIndex = -1;
			int minData = Integer.MAX_VALUE;
			boolean canBeFit = false;
			for (int j = 0; j < blocks.length; j++) {
				if (blocks[j] > processes[i]) {
					canBeFit = true;
					if (minData > blocks[j]) {
						minData = blocks[j];
						minIndex = j;

					}

				}
			}
			if(!canBeFit){
				System.out.println("Process "+i + " can't be filled in any block");
				
			}else{
				blocks[minIndex] = blocks[minIndex] - processes[i];
				System.out.println("Pricess "+i +" can be filled in block "+ minIndex);
			}
		}
	}
	
	
	public static void main(String args[]){
		int blockSize[]   = {100, 500, 200, 300, 600};
		int processSize[] = {212, 417, 112, 426};
		
		doBestFit(blockSize, processSize);
	}

}
