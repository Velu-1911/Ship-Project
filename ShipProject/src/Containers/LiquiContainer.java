package Containers;

import Main.Customer;

public class LiquiContainer extends HeavyContainer{
	
	private int liqui_cost = 17500;

	public LiquiContainer(int iD, int weight) {
		super(iD, weight);
		System.out.println("Liquid is created");
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void ContainerBill() {
		// TODO Auto-generated method stub
		Customer.fin_Bill+=liqui_cost;
	}
}
