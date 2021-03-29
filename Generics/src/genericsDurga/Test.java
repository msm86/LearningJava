package genericsDurga;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		ArrayList l = new ArrayList<String>();
		l.add("Mital");
		l.add(10);
		l.add(10.5);
		
//		m1(l);
		
		System.out.println(l);
	}
	
	public static void m1(ArrayList temp) {
		temp.add(10);
		temp.add(10.5);
	}

}
