import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectionBreakingPrivate {
	
   public static void main(String[] args){
	   
	   Class<SingleTonClass>  class1 =   SingleTonClass.class ;
	   Constructor<?>[] constructors  = class1.getDeclaredConstructors();
	   
	   Constructor<?> constructor = constructors[0];
	   //So in order to access the private members of the class,we need to set the modifier to private
	   constructor.setAccessible(true);
	   
	   try {
		SingleTonClass  obj1 = (SingleTonClass) constructor.newInstance();
		SingleTonClass  obj2 = (SingleTonClass) constructor.newInstance();
		
		System.out.println(obj1 + "  "+obj2);
	} catch (InstantiationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IllegalAccessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IllegalArgumentException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (InvocationTargetException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }

}
