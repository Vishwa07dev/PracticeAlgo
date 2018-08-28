package factory;

public class Boy implements Person{
	
    private String age ;
    private String name ;
    private String sex = "male";
    
    public Boy(String age, String name){
    	this.age = age ;
    	this.name = name ;
    }

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public String getAge() {
		return this.age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	

}
