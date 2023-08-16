package Main;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import Ships.*;
import Containers.*;
import Ports.*;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Scanner in_1 = new Scanner(System.in).useDelimiter("\n");
		ArrayList<Customer> Guest = new ArrayList<Customer>(); 
		List<Ports> port =portcreation();
		List<Container> contlist = new ArrayList<Container>() ;
		List<String> visit_port = new ArrayList<String>();
		List<Integer> order_port = new ArrayList<Integer>();
		int start_int=Integer.MIN_VALUE;
		int end_int=Integer.MIN_VALUE;
		System.out.println("Welcome to our shipping services");
		System.out.println("Initial Interaction");
////////////////// INITIAL INTERACTION////////////////////////////////////
		int flag =0;
		while(flag==0) {
			
			System.out.println("Use System as 1.Customer // 3.EXIT INITIAL INTERACTION");
			int choice = in.nextInt();
			
			if(choice ==1) {
				int innerflag =0;
				while(innerflag==0) {
					System.out.println("1.Create Customer");
					System.out.println("2.Load Container");
					System.out.println("3.Select Route");
					System.out.println("4.Go back");
					int inner_choice=in.nextInt();
					if(inner_choice==1) {
						System.out.println("Enter Your Name,Address and phone number and ID proof in that exact order");
						String name = in.next();
						String Address= in_1.next();
						String number = in_1.next();
						String proof = in_1.next();
						Customer customer  = new Customer(name, Address, number, proof);
						Guest.add(customer);
					}
					else if (inner_choice==2) {
						contlist = Ports.ContainerCreation();
					}
					else if (inner_choice==3) {
						System.out.println("Select one of the following route");
						System.out.println("1.kochi ->Goa ->Mumbai ->Dubai");
						System.out.println("2.Chennai ->Vizag ->Kolkata ->Malaysia");
						System.out.println("Enter source port");
						String start = in.next();
						System.out.println("Enter destination port");
						String end = in.next();
						
						for(int i=0;i<port.size();i++) {
							if(start.equals(port.get(i).name)) {
								start_int=i;
							}	
						}
						for(int i=0;i<port.size();i++) {
							if(end.equals(port.get(i).name)) {
								end_int=i;
							}	
						}
						if(start_int==Integer.MIN_VALUE || end_int == Integer.MIN_VALUE)
						{
							System.out.println("Enter the spelling of the port correctly");
						}
						
					
					}
					else if (inner_choice==4) {
						break;
					}
					
				}
			}			
			else if (choice==3) {
				flag=1;
			}
		}
		
		System.out.println("The ship has started sailing");
////////////////////////INITIAL INTERACTION IS OVER/////////////////////////////////
/////////////////////PORT INTERACTION///////////////////////////////////////////////
		Ship.shiphis.add("You Ship has started sail  " + Guest.get(0).name);
	for(int i=start_int+1,order=1;i<=end_int;i++,order++) {
		port.get(i).histor(Ship.shipid, order);
		String namehis = "Your Package is now at port " + port.get(i).name + "  " + Guest.get(0).name;
		Ship.shiphis.add(namehis);
		System.out.println("You are now at port  " + port.get(i).name);
		visit_port.add(port.get(i).name);
		order_port.add(order);
		for(int j=0;j<contlist.size();j++) {
				contlist.get(j).ContainerBill();
		}
		flag =0;
		while(flag==0) {
			
			System.out.println("Use System as 1.Customer //  2.ADMIN // 3.TRAVEL TO NEXT PORT");
			int choice = in.nextInt();
			if(choice ==1) {
				int innerflag =0;
				while(innerflag==0) {
//					System.out.println("1.Create Customer");
//					System.out.println("2.Load Container");
					System.out.println("1.View Status of package");
					System.out.println("2.Generate Bill");
					System.out.println("3.Go back");
					int inner_choice=in.nextInt();
//					if(inner_choice==1) {
//						System.out.println("Enter Your Name,Address and phone number and ID proof in that exact order");
//						String name = in_1.next();
//						String Address= in_1.next();
//						String number = in_1.next();
//						String proof = in_1.next();
//						Customer customer  = new Customer(name, Address, number, proof);
//						Guest.add(customer);
//					}
//					else if (inner_choice==2) {
//						contlist = Ports.ContainerCreation();
//					}
					
					if(inner_choice==1){
						Ship.getShiphis();
						
					}
					else if (inner_choice ==2) {
						try {

				            FileWriter Mywrite = new FileWriter("C:/Users/pethachi.pr/Desktop/log.txt") ;

				            Mywrite.write("***********************LOG**********************\n");

				            Mywrite.write("Customer Name: "+ Guest.get(0).name+ "\n");

				            Mywrite.write("Ship id: "+ Ship.shipid+"\n");
				            Mywrite.write("Ports Visited: " +visit_port +"\n");

				            Mywrite.write("Order Visited: " +order_port+ "\n");

//				            Mywrite.write("Containers loaded: " + contOut );
				            
				            Mywrite.write("Total amount to be paid   " + Customer.fin_Bill + "\n");

//				                Mywrite.wait("Current ship location: " + )

				            Mywrite.close();

				            

				        }

				        catch (IOException e) {

				            // TODO: handle exception

				            System.out.println("error occured");

				            e.printStackTrace();
				        }
						
						
					}
					else if (inner_choice==3) {
						break;
					}
					
				}
			}
			
			else if (choice==2) {
				int innerflag =0;
				while(innerflag==0) {
				System.out.println("1.UnLoad Container in port");
				System.out.println("2.Load Container in port");
				System.out.println("3.all Port history");
				System.out.println("4.Ship History");
				System.out.println("5.Go back");
				int inner_choice=in.nextInt();
				if(inner_choice==1) {
		 			contlist = Ports.unload(contlist);
				}
				else if (inner_choice==2) {

		 			contlist = Ports.loadContMiddle(contlist);
		 				
				}
				else if (inner_choice==3) {
					for(int j=0;j<port.size();j++) {
						port.get(j).displayhistor();
					}
					
				}
				else if (inner_choice==4) {
					Ship.getShiphis();
					
				}
				else if(inner_choice==5) {
					break;
				}
			}
		}
			
			else if (choice==3) {
				break;
			}
		
	}
	}
		
			
//		System.out.println(Container.totalWeight);
	}

private static List<Ports> portcreation() {
		// TODO Auto-generated method stub
	List<Ports> port = new ArrayList<Ports>();
////////////FOR CREATION OF PORTS//////////////////
	String[] ports = {"Kochi","Goa","Mumbai","Dubai","Chennai","Vizag","Kolkata","Malaysia"};
	int [] portnum = {1,2,3,4,5,6,7,8,};
	
	for(int i=0;i<ports.length;i++) {

		Ports n = new Ports(portnum[i],ports[i]);
		port.add(n);		
	}
	return port;
	
 }     

}




///////REFER THIS FOR CREATION//////////////
//
//int flag =0;
//while(flag==0) {
//	
//	System.out.println("Use System as 1.Customer //  2.ADMIN // 3.EXIT SYSTEM");
//	int choice = in.nextInt();
//	
//	if(choice ==1) {
//		int innerflag =0;
//		while(innerflag==0) {
//			System.out.println("1.Create Customer");
//			System.out.println("2.Load Container");
//			System.out.println("3.Select Route");
//			System.out.println("4.View Status");
//			System.out.println("5.Generate Bill");
//			System.out.println("6.Go back");
//			int inner_choice=in.nextInt();
//			if(inner_choice==1) {
//				System.out.println("Enter Your Name,Address and phone number and ID proof in that exact order");
//				String name = in_1.next();
//				String Address= in_1.next();
//				String number = in_1.next();
//				String proof = in_1.next();
//				Customer customer  = new Customer(name, Address, number, proof);
//				Guest.add(customer);
//			}
//			else if (inner_choice==2) {
//				contlist = Ports.ContainerCreation();
//			}
//			else if (inner_choice==3) {
//				System.out.println("Select one of the following route");
//				System.out.println("1.kochi ->Goa ->Mumbai ->Dubai");
//				System.out.println("2.Chennai ->vizag ->Kolkata ->Malaysia");
//				String start = in.next();
//				String end = in.next();
//				
//				for(int i=0;i<port.size();i++) {
//					if(start.equals(port.get(i).name)) {
//						start_int=i;
//					}	
//				}
//				for(int i=0;i<port.size();i++) {
//					if(end.equals(port.get(i).name)) {
//						end_int=i;
//					}	
//				}
//				if(start_int==Integer.MIN_VALUE || end_int == Integer.MIN_VALUE)
//				{
//					System.out.println("Enter the spelling of the port correctly");
//				}
//				
//			
//			}
//			else if(inner_choice==4){
//				
//				
//			}
//			else if (inner_choice ==5) {
//				
//				
//			}
//			else if (inner_choice==6) {
//				break;
//			}
//			
//		}
//	}
//	
//	else if (choice==2) {
//		int innerflag =0;
//		while(innerflag==0) {
//		System.out.println("1.UnLoad Container in port");
//		System.out.println("2.Load Container in port");
//		System.out.println("3.all Port history");
//		System.out.println("4.Ship History");
//		System.out.println("5.Go back");
//		int inner_choice=in.nextInt();
//		if(inner_choice==1) {
// 			contlist = Ports.unload(contlist);
//		}
//		else if (inner_choice==2) {
//
// 			contlist = Ports.loadContMiddle(contlist);
// 				
//		}
//		else if (inner_choice==3) {
//			for(int i=0;i<port.size();i++) {
//				port.get(i).displayhistor();
//			}
//			
//		}
//		else if (inner_choice==4) {
//			
//		}
//		else if(inner_choice==5) {
//			break;
//		}
//	}
//}
//	
//	else if (choice==3) {
//		break;
//	}
////}
//
//
