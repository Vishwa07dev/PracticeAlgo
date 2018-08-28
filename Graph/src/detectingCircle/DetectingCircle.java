package detectingCircle;

public class DetectingCircle {
	
	//This will be the dfs implementation
	public boolean isCirclePresent(Vertex v){
		
		if(v==null){
			return false ;
		}
		boolean circleExists = false ;
		v.setBeingVisited(true);
		for(Vertex ver : v.getNeighours()){
			if(ver!=null){
				if(ver.isBeingVisited()){
					return true ;
					
				}else{
					//ver.setBeingVisited(true);
					circleExists = isCirclePresent(ver);
					if(circleExists) break;
				}
			}
		}
		v.setBeingVisited(false);
		v.setVisited(true);
		return circleExists ;
	}
	
	
	

}
