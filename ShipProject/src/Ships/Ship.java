package Ships;

import java.util.ArrayList;


public class Ship {
	public static int shipid;
	public static void getShiphis() {
		for(int i=0;i<shiphis.size();i++) {
			System.out.println(shiphis.get(i));
	
		}
	}


	public static int capacity = 3000;
	public String name;
	public static ArrayList<String> shiphis = new ArrayList<String>();
	
	public Ship(int shipid, String name) {
		super();
		this.shipid = shipid;
		this.name = name;
		System.out.println("Ship is created");
	}
 		
	
}
