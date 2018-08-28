package factory;

public class PersonFactory {
	
	public static Person getPerson(String sex , String name , String age){
		
		if( sex =="FEMALE"){
			return new Girl(age, name) ;
		}
		else if (sex == "MALE"){
			return new Boy(age, name);
		}
		return null;
	}

}
