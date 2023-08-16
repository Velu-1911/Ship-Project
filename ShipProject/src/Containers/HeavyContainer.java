package Containers;

import Main.Customer;

public class HeavyContainer extends Container {
	
	protected int weight;
	private int Defa_cost=15000;
	
	public HeavyContainer(int iD,int weight) {
		super(iD);
		this.weight= weight;
		totalWeight+=weight;
		System.out.println("Heavy is created");
		
	}

	@Override
	public void  getdetails() {
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
		Customer.fin_Bill+=Defa_cost;
		
	}

}
