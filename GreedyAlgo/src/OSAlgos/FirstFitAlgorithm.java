package OSAlgos;

/**
 * This algorithm is used for the memory allocation.
 * We need to find the first available block which can serve the process and use it
 * @author vmohan
 *
 */
public class FirstFitAlgorithm {
	
	public static void serveProcess(int[] block , int[] processes){
		
		for(int i=0;i<processes.length;i++){
			boolean memoryAlloted = false ;
			for(int j=0;j<block.length;j++){
				if(block[j] >= processes[i]){
					System.out.println("process " + i + " can be allocated the block "+ j );
					block[j] = block[j] - processes[i];
					memoryAlloted = true ;
					break;
				}
			}
			
			if(!memoryAlloted){
				System.out.println("process " + i + " can't be allocated any block " );
			}
		}
	}
	
	public static void main(String args[]){
		int blockSize[]   = {100, 500, 200, 300, 600};
		int processSize[] = {212, 417, 112, 426};
		
		serveProcess(blockSize, processSize);
	}

}
