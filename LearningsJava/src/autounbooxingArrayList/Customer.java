package autounbooxingArrayList;

import java.util.ArrayList;

public class Customer {
	
	private String customerName;
	private ArrayList<Double> custTransactions;
	
	public Customer(String name, double intialAmount) {
		this.customerName = name;
		this.custTransactions = new ArrayList<Double>();
		addTransaction(intialAmount);
	}
	
	public String getcustomerName() {
		return customerName;
	}
	
	public ArrayList<Double> getTransactions() {
		return custTransactions;
	}
	
	public void addTransaction(double transactionAmount) {
		this.custTransactions.add(transactionAmount);
	}
}
