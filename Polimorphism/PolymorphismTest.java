class A{
	int x = 10 ; 
	/*// it gives an error .. 
	 * int method(){
		System.out.println("method in A class");
		return 10;
	}*/
	void method(){
		System.out.println("method in A class");
	}

/*	static void staticMethod(){
		System.out.println("static method in A class");
	}*/
/*	
 * int method(int x) {
		System.out.println();
		return x;
	}*/
}

class B extends A{
	int x = 20 ; 
	public void method(){
		System.out.println("method in B class");
	}
	static void staticMethod(){
		System.out.println("static method in B class");
	}
	void extraMethodinB(){
		System.out.println("Extra method in B");
	}
}
public class PolymorphismTest {
	public static void main(String[] args) {
		A a = new B();
		System.out.println(a.x);
		a.method();
		((B) a).staticMethod(); // in case of static methods it will check only left side class and call that one...  
		// Note : 
//		a.extraMethodinB();  // type  cast required if we want to call method which is not present in base S
		
		
/*		String s1 = "abc";
		String s2 = "abc";
		System.out.println("S1==s1" + (s1==s2));
		*/
		
	}
}
