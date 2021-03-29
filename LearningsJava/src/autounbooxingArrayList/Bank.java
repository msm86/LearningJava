package autounbooxingArrayList;

import java.util.ArrayList;

public class Bank {
	private String name;
	private ArrayList<Branch> branch;
	
	public Bank(String name) {
		this.name = name;
		this.branch = new ArrayList<Branch>();
	}
	
	public boolean addBranch(String branchName) {
		int index = searchBranch(branchName);
		
		if(index>=0)
			return false;
		
		branch.add(new Branch(branchName));
		return true;
	}
	
	public boolean addBrnCustomer(String brnName, String custName, double txnAmount) {
		int brnIndex = searchBranch(brnName);
		if(brnIndex >= 0) {
			return branch.get(brnIndex).addCustomer(custName, txnAmount);
		}
		return false;
	}
	
	public int searchBranch(String brnName) {
		for(int i=0; i<this.branch.size(); i++) {
			if(brnName.equalsIgnoreCase(branch.get(i).getBranchName()))
				return i;
		}
		
		return -1;
	}
	
	public boolean addCustTxns(String brnName, String custName, double txnAmount) {
		int brnIndex = searchBranch(brnName);
		if(brnIndex >= 0) {
			return branch.get(brnIndex).addTransacion(custName, txnAmount);
		}
		return false;
	}
	
	public boolean listCustomers(String brnName, boolean showCustomerTxns) {
		int index = searchBranch(brnName);
		
		if(index>=0) {
			System.out.println("Below is the list of branches and customers for " + this.name + " bank.");
			System.out.println();
			if(showCustomerTxns)
				branch.get(index).listCustomerswithTxns();
			else
				branch.get(index).listCustomersOnly();
		}
		
		return false;
	}
}
