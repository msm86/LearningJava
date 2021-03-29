package autounbooxingArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {


	public static void main(String[] args) {
		
		Bank bank = new Bank("State Bank of India");
		
		bank.addBranch("Manjalpur");
		
		bank.addBrnCustomer("Manjalpur", "Mital Majmundar", 100000);
		bank.addBrnCustomer("Manjalpur", "Aarohi Majmundar", 200000);
		bank.addBrnCustomer("Manjalpur", "Varun Majmundar", 50000);
		bank.addBrnCustomer("Manjalpur", "Khushboo Majmundar", 5000);
		
		bank.addCustTxns("Manjalpur", "Mital Majmundar", 500);
		bank.addCustTxns("Manjalpur", "Mital Majmundar", 1000);
		
		bank.addCustTxns("Manjalpur", "Aarohi Majmundar", 450);
		bank.addCustTxns("Manjalpur", "Aarohi Majmundar", 150);
		
		bank.addCustTxns("Manjalpur", "Varun Majmundar", 2500);
		bank.addCustTxns("Manjalpur", "Varun Majmundar", 1500);
		
		bank.addCustTxns("Manjalpur", "Khushboo Majmundar", 200);
		bank.addCustTxns("Manjalpur", "Khushboo Majmundar", 300);	
		
		
		Bank bank2 = new Bank("Bank of Baroda");
		
		bank2.addBranch("Makarpura");
		
		bank2.addBrnCustomer("Makarpura", "Ramesh Shah", 500000);
		bank2.addBrnCustomer("Makarpura", "Bela Shah", 1000000);
		bank2.addBrnCustomer("Makarpura", "Sheela Shah", 20000);
		bank2.addBrnCustomer("Makarpura", "Ila Shah", 200000);
		
		bank2.addCustTxns("Makarpura", "Ramesh Shah", 500);
		bank2.addCustTxns("Makarpura", "Ramesh Shah", 1000);
		
		bank2.addCustTxns("Makarpura", "Bela Shah", 450);
		bank2.addCustTxns("Makarpura", "Bela Shah", 150);
		
		bank2.addCustTxns("Makarpura", "Sheela Shah", 2500);
		bank2.addCustTxns("Makarpura", "Sheela Shah", 1500);
		
		bank2.addCustTxns("Makarpura", "Ila Shah", 200);
		bank2.addCustTxns("Makarpura", "Ila Shah", 300);
		
		bank.listCustomers("Manjalpur", true);
		bank2.listCustomers("Makarpura", true);
		
	}

}
