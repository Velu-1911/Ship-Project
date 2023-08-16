package Main;
import Ships.*;

import java.io.ObjectInputStream.GetField;
import java.util.Scanner;

import Ships.Ship;

public class Customer {
	static public int fin_Bill=0;
	Scanner in = new Scanner(System.in);
	String name;
	public  String getName() {
		return name;
	}

	public String Address;
	String number;
	private String proof;
	public Customer(String name, String address, String number, String proof) {
		super();
		this.name = name;
		this.Address = address;
		this.number = number;
		this.proof = proof;
		System.out.println("Enter shipid");
		int id = in.nextInt();
		Ship s  = new Ship(id,"atlantis");
		
	}
	
	public void getdetails()
	{
		System.out.print(name);
		System.out.print(number);
		System.out.print(proof);
		System.out.print(Address);
	}
	
	
	

}
