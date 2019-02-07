import java.io.Serializable;

interface A1{
	int x = 10;
	
	// static method in interface are not to be override, they only can be used within the interface by default methods
	static void a1(){
		System.out.println("A1");
	}
	default void a(){
		a1();
		System.out.println("A1");
	}
}

interface B1{
	int x = 30;
	static void a(){
		System.out.println("B1");
	}
}


public class InterfaceJavaEight implements A1{
	static int x = 20 ;
	@Override
	public void a() {
		A1.super.a();
	}
	public static void main(String[] args) {
		System.out.println(x);
		InterfaceJavaEight i = new InterfaceJavaEight();
		i.a();
	}
}
