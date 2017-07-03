package my_code;

import java.util.ArrayList;
import java.util.List;

public class ListConvert {
	
	public static void main(String[] args) {
		A a1 = new A("a1","b1","c1");
		A a2 = new A("a2","b2","c2");
		A a3 = new A("a3","b3","c3");
		List<A> listA = new ArrayList<A>();
		listA.add(a1);
		listA.add(a2);
		listA.add(a3);
		System.out.println(listA.toString());
		List<B> listB = new ArrayList<B>();
		
		listA.forEach(
			a -> {
				B b = new B(a.getA(),a.getB());
				listB.add(b);
			}
		
		);
		System.out.println(listB.toString());
	}
}
class A{
	private String a;
	private String b;
	private String c;
	public String getA() {
		return a;
	}
	public void setA(String a) {
		this.a = a;
	}
	public String getB() {
		return b;
	}
	public void setB(String b) {
		this.b = b;
	}
	public String getC() {
		return c;
	}
	public void setC(String c) {
		this.c = c;
	}
	public A(String a, String b, String c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}
}

class B{
	private String a;
	private String b;
	public String getA() {
		return a;
	}
	public void setA(String a) {
		this.a = a;
	}
	public String getB() {
		return b;
	}
	public void setB(String b) {
		this.b = b;
	}
public B(String a, String b) {
	super();
	this.a = a;
	this.b = b;
}
	
	
}
