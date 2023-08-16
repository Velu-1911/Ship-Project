package Ports;
import java.util.*;
import Main.*;
import Ships.Ship;
import Containers.*;

public class Ports {
	
	public int ID;
	public Container c1;
	Scanner in = new Scanner(System.in);
	public String name;
	public ArrayList<Integer> history = new ArrayList<>();
	public ArrayList<Integer> visitport = new ArrayList<>();
	
	public Ports(int ID,String name) {
		this.ID = ID;
		this.name= name;
	}
	public void display() {
		System.out.println("History is created ");
	}
	public void histor(int shipid,int order) {
		history.add(shipid);
		visitport.add(order);
	}
	
	public void displayhistor() {
		System.out.print(this.name);
		System.out.print(history);
		System.out.print(visitport);
		System.out.println();
	}
	
	public static List<Container> ContainerCreation() {
		
		Scanner in = new Scanner(System.in);
		System.out.println("Remaining Capacity:-" + (Ship.capacity-Container.totalWeight));
		List<Container> contlist = new ArrayList<Container>();
		System.out.println("Enter the number of conatiners you want to create");
		int n;
		n=in.nextInt();
		
		for(int i=0;i<n;i++)
		{
		
			System.out.println("Enter the weight of the container");
			int p = in.nextInt();
			if((p+Container.totalWeight)>Ship.capacity) {
				System.out.println("Sorry This container can't be added,Capacity is not available.");
				
				continue;
			}
			if(p<300) {
				System.out.println("Enter the container ID ");
				int ContID = in.nextInt();
				Container cont;
				cont= new BasicContainer(ContID,p);
				contlist.add(cont);
				System.out.println(cont.totalWeight);
				System.out.println();
			}
			else {
				System.out.println("Enter the container ID ");
				int ContID = in.nextInt();
				System.out.println("Enter  R or r for Refrigerated heavy container");
				System.out.println("Enter L or l for Liquidated heavy container");
				System.out.println("Enter D or d for default heavy container");
				char a = in.next().charAt(0);
				if(a=='R' || a=='r') {
					Container cont;
					cont = new RefrigContainer(ContID,p);
					contlist.add(cont);
					System.out.println(cont.totalWeight);
				
				}
				else if(a=='L' || a=='l') {
					Container cont;
					cont = new LiquiContainer(ContID,p);
					contlist.add(cont);
					System.out.println(cont.totalWeight);
				
				}
				else if (a=='D' || a=='d'){
					Container cont;
					cont = new HeavyContainer(ContID,p);
					contlist.add(cont);
					System.out.println(cont.totalWeight);					
				}
			}
		
			System.out.println("Remaining Capacity:-" + (Ship.capacity-Container.totalWeight));
		}
	
		
		return contlist;	
	}

	public static List<Container> loadContMiddle(List<Container> contlist) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int count=0;
		System.out.println("Remaining Capacity:-" + (Ship.capacity-Container.totalWeight));
		System.out.println("Enter the number of conatiners you want to create");
		int n;
		n=in.nextInt();
		for(int i=0;i<n;i++)
		{
			System.out.println("Remaining Capacity:-" + (Ship.capacity-Container.totalWeight));
			System.out.println("Enter the weight of the container");
			int p = in.nextInt();
			if((p+Container.totalWeight)>Ship.capacity) {
				System.out.println("Sorry This container can't be added,Capacity is not available.");
				continue;
			}
			if(p<300) {
				System.out.println("Enter the container ID ");
				int ContID = in.nextInt();
				Container cont;
				cont= new BasicContainer(ContID,p);
				contlist.add(cont);
				System.out.println(cont.totalWeight);
				count++;
			}
			else {
				System.out.println("Enter the container ID ");
				int ContID = in.nextInt();
				System.out.println("Enter  R or r for Refrigerated heavy container");
				System.out.println("Enter L or l for Liquidated heavy container");
				System.out.println("Enter D or d for default heavy container");
				char a = in.next().charAt(0);
				if(a=='R' || a=='r') {
					Container cont;
					cont = new RefrigContainer(ContID,p);
					contlist.add(cont);
					System.out.println(cont.totalWeight);
					count++;
				}
				else if(a=='L' || a=='l') {
					Container cont;
					cont = new LiquiContainer(ContID,p);
					contlist.add(cont);
					System.out.println(cont.totalWeight);
					count++;
				}
				else if (a=='D' || a=='d'){
					Container cont;
					cont = new HeavyContainer(ContID,p);
					contlist.add(cont);
					System.out.println(cont.totalWeight);
					count++;					
				}
				System.out.println("Remaining Capacity:-" + (Ship.capacity-Container.totalWeight));
				
			}
			
		
	}
		String loadhis = count + " Containers have been added in Port Chennai";
		Ship.shiphis.add(loadhis);
		Ship.shiphis.add("///////////////////////////////");
	return contlist;
	}
	
	
	public static List<Container> unload(List<Container> contlist) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("enter the number of containers to be unloaded");
		int n=in.nextInt();
		int count=0;
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter the id of the container to be unloaded");
			int rmid = in.nextInt();
			int flag=1;
			for(int j=0;j<contlist.size();j++) {
				if(rmid == (contlist.get(j).ID)) {
					int rm = j;
					int minu = contlist.get(j).getweight();
					Container.totalWeight -=minu;
					contlist.remove(rm);
					flag=0;
					System.out.println(Container.totalWeight);
					count++;
				}	
			}
			
			if(flag==1) {
				System.out.println("Container id is not present");
			}
		
		}
		
		String loadhis = count + " Containers have been unloaded in Port Chennai";
		Ship.shiphis.add(loadhis);
		Ship.shiphis.add("///////////////////////////////");
		
			
		return contlist;
	}

}
