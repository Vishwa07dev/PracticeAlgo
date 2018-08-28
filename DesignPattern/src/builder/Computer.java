package builder;
/**
 * 
 * @author vmohan
 *
 *Builder design pattern is used when the object has too many attributes, some are mandatory and some are optional.
 *
 */
public class Computer {
	
	public int ramInMB ;
	public int memoryInGB;
	public String bodyColor ;
	
	public String graphicCard ;
	public String musicCard ;
	
	
	private Computer(ComputerBuilder computerBuilder){
		this.ramInMB= computerBuilder.ramInMB ;
		this.memoryInGB = computerBuilder.memoryInGB;
		this.bodyColor = computerBuilder.bodyColor;
		this.graphicCard= computerBuilder.graphicCard;
		this.musicCard=computerBuilder.musicCard;
		
		
	}


	public int getRamInMB() {
		return ramInMB;
	}


	public void setRamInMB(int ramInMB) {
		this.ramInMB = ramInMB;
	}


	public int getMemoryInGB() {
		return memoryInGB;
	}


	public void setMemoryInGB(int memoryInGB) {
		this.memoryInGB = memoryInGB;
	}


	public String getBodyColor() {
		return bodyColor;
	}


	public void setBodyColor(String bodyColor) {
		this.bodyColor = bodyColor;
	}


	public String getGraphicCard() {
		return graphicCard;
	}


	public void setGraphicCard(String graphicCard) {
		this.graphicCard = graphicCard;
	}


	public String getMusicCard() {
		return musicCard;
	}


	public void setMusicCard(String musicCard) {
		this.musicCard = musicCard;
	}
	
	public static class ComputerBuilder{
		
		public int ramInMB ;
		public int memoryInGB;
		public String bodyColor ;
		
		public String graphicCard ;
		public String musicCard ;
		
		public ComputerBuilder(int ramInMB ,int memoryInGB, String bodyColor){
			this.ramInMB = ramInMB ;
			this.memoryInGB = memoryInGB;
			this.bodyColor = bodyColor ;
	   }
		
	   public ComputerBuilder setGraphicCard(String gCard){
		   this.graphicCard = gCard;
		   return this; 
	   }
	   
	   public ComputerBuilder setMusicCard(String mCard){
		   this.musicCard= mCard;
		   return this ;
	   }
	   /**
	    * This method builds the computer
	    * @return
	    */
	   public Computer buildComputer(){
		   return new Computer(this);
	   }
		
		
	}

}
