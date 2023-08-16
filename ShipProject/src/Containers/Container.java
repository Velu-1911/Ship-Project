package Containers;

import Main.Customer;

public abstract class Container {
	
	static public int totalWeight=0;
	public static int getTotalWeight() {
		return totalWeight;
	}
	public Container(int iD2) {
		// TODO Auto-generated constructor stub
		this.ID = iD2;
		
	}

	public int ID;


	public static void setTotalWeight(int totalWeight) {
		Container.totalWeight = totalWeight;
	}
	public abstract int getweight();
	public abstract void getdetails();
	public abstract void ContainerBill();
	
}
