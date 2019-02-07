package src;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

class SingleTon implements Serializable{
	private static SingleTon instance ;

	private SingleTon() {
	}
	
	public static SingleTon getInstance(){
		if(instance == null){
			synchronized (SingleTon.class) {
				if(instance == null){
					instance = new SingleTon();
				}
			}
		}
		return instance;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return instance;
	}
	
	protected Object readResolve() {
		return instance;
	}
}
public class SingletonTest {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		System.out.println("hello");
		SingleTon s = SingleTon.getInstance();
		try {
			SingleTon s1 =  (SingleTon) s.clone();
			
			System.out.println(s.hashCode());
			System.out.println( s1.hashCode());
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(""));
			
//			oos.writeObject(s1);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
