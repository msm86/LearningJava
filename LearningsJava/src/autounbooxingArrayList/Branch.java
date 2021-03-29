package autounbooxingArrayList;

import java.util.ArrayList;

public class Branch {
	
	private String branchName;
	private ArrayList<Customer> customer;
	
	public Branch(String branchName) {
		this.branchName = branchName;
		this.customer = new ArrayList<Customer>();
	}
	
	public String getBranchName() {
		return branchName;
	}
	public ArrayList<Customer> getCustomer() {
		return customer;
	}	
	
	public boolean addCustomer(String name, double initialAmount) {
			int index = searchCustomer(name);
			if(index > 0)
				return false;
			
			customer.add(new Customer(name, initialAmount));
			return true;
	}
	
	public int searchCustomer(String name) {
		for(int i=0; i<customer.size(); i++) {
			if(customer.get(i).getcustomerName().equalsIgnoreCase(name))
				return i;
		}
		
		return -1;
	}
	
	public boolean addTransacion(String customerName, Double txnAmount)
	{
		int index = searchCustomer(customerName);
		if(index<0)
			return false;
		
		customer.get(index).addTransaction(txnAmount);
		return true;
	}
	
	public void listCustomersOnly() {
		System.out.println(this.branchName + " has " + this.customer.size() + " customers.");
		System.out.println();
		for(int i =0; i<customer.size(); i++) {
			System.out.println("\t" + (i+1) + ". " + customer.get(i).getcustomerName());
		}
	}
	
	public void listCustomerswithTxns() {
		System.out.println(this.branchName + " has " + this.customer.size() + " customers.");
		System.out.println();
		for(int i=0; i<customer.size(); i++) {
			System.out.println("\t" + (i+1) + " . " + customer.get(i).getcustomerName());
			
			for(int j=0; j<customer.get(j).getTransactions().size(); j++) {
				System.out.println("\t\t" + (j+1) + " - " + customer.get(i).getTransactions().get(j));
			}
		}
	}	
}
