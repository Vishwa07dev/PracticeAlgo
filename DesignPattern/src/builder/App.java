package builder;

public class App {
	
	public static void main(String args[]){
		
		//So I can see, with the builder design patter the creation of the object with multiple attributes become simple
		/**
		 * Yaay, I have learnt a very beautiful design pattern, so now onwards whenever I have to create a complex object, I will try creating the builder
		 * design pattern
		 */
				
		Computer comp  = new Computer.ComputerBuilder(3, 121, "black").setGraphicCard("Graphic Card").setMusicCard("MusicCard").buildComputer();
		
		System.out.println(comp.getGraphicCard());
		
		Computer comp2  = new Computer.ComputerBuilder(3, 121, "black").setMusicCard("MusicCard").buildComputer();
		System.out.println(comp2.getGraphicCard());
	}

}
