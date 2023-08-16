package Containers;

import Main.Customer;

public class RefrigContainer extends HeavyContainer{
	
	private int refrig_cost =20000;

	public RefrigContainer(int iD, int weight) {
		super(iD, weight);
		System.out.println("Refrig is created");
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void ContainerBill() {
		// TODO Auto-generated method stub
		Customer.fin_Bill+=refrig_cost;
		
	}

}
