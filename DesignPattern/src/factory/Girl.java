package factory;

public class Girl implements Person{
	private String age ;
    private String name ;
    private String sex = "female";
    
    public  Girl(String age, String name){
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
