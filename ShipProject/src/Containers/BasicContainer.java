package Containers;

import Main.Customer;

public class BasicContainer extends Container{
	
	private int Base_cost=10000;
	protected int weight;

	public BasicContainer(int iD,int weight) {
		
		super(iD);
		this.weight= weight;
		totalWeight+=weight;
		System.out.println("Basic is created");
	}

	@Override
	public void getdetails() {
		System.out.println(ID);
		System.out.println(weight);
		
	}

	@Override
	public int getweight() {
		// TODO Auto-generated method stub
		return weight;
	}

	@Override
	public void ContainerBill() {
		// TODO Auto-generated method stub
		Customer.fin_Bill+=Base_cost;
	}
	
	

}
