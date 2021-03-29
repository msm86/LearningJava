package arrayListChallenge;

import java.util.Scanner;

public class Main {

	private static MobilePhone myIphone = new MobilePhone("iPhone");
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		
		boolean flag = true;
		
		printOptions();
		
		System.out.println("Enter your choice");
		
		while (flag) {
			int input = scanner.nextInt();
			scanner.nextLine();
			switch(input) {
			case 1:
				addContact();
				break;
			case 2:
				removeContact();
				break;
			case 3:
				searchContact();
				break;
			case 4:
				myIphone.printContacts();
				break;
			case 5:
				printOptions();
				break;
			case 6:
				modifyContact();
				break;
			case 7:
				flag=false;
				break;
			default:
				System.out.println("Response invalid! Please choose options from the menu above.");
				printOptions();
				break;
			}
		}
	}
	
	public static void modifyContact() {
		if(myIphone.getContact().size() > 0) {
			System.out.println("Ënter the name of contact you want to modify");
			String name = scanner.nextLine();
			
			Contact contact = myIphone.searchContact(name);
			if(contact == null)
				System.out.println("No such contact found in the list");
			else {
				System.out.println("Enter the new name of the contact");
				String newName = scanner.nextLine();
				
				System.out.println("ENter number of the new contact");
				String newNumber = scanner.nextLine();
				Contact newContact = Contact.createContact(newName, newNumber);
				if(myIphone.modifyContact(contact, newContact) > 0)
					System.out.println(contact.getContactName() + " replaced successfully by " + newContact.getContactName());
				else
					System.out.println("Ërror");
			}
		}
		else
			System.out.println("No entries in the contact list to modify!");
	}
	
	public static void searchContact() {
		if(myIphone.getContact().size() > 0) {
			System.out.println("Enter the name of contact you want to search");
			String name = scanner.nextLine();
			
			Contact contact = myIphone.searchContact(name);
			if(contact == null)
				System.out.println("No such contact found in the list");
			else
				System.out.println("Found " + contact.getContactName() + " in the list. Phone number: " + contact.getContactNumber());
		}
		else
			System.out.println("Contact list empty currently!");
	}
	
	public static void removeContact() {
		if(myIphone.getContact().size() > 0) {
			System.out.println("Enter the name of contact you want to remove");
			String name = scanner.nextLine();
			
			Contact contact = myIphone.searchContact(name);
			if(contact == null)
				System.out.println("No such contact found in the list");
			
			if(myIphone.removeContact(contact) < 0)
				System.out.println("Contact could not be removed at this moment. Please try again.");
			else
				System.out.println("Contact " + name + " removed successfully.");
		}
		else
			System.out.println("No entries in the contact list to remove!");
	}
	
	public static void addContact() {
		System.out.println("Enter the name of the contact");
		String name = scanner.nextLine();
		System.out.println("Enter number for "+ name);
		String number = scanner.nextLine();
		
		if(myIphone.addNewCotact(new Contact(name, number)) < 0)
			System.out.println("Contact "+ name + " added successfully.");
		else
			System.out.println("Contact " + name + " is already on the list");
	}
	
	public static void printOptions() {
		System.out.println("1.\tTo add contact.");
		System.out.println("2.\tTo remove contact.");
		System.out.println("3.\tTo search contact.");
		System.out.println("4.\tTo print contact list.");
		System.out.println("5.\tTo print choice options.");
		System.out.println("6.\tTo modify a contact");
		System.out.println("7.\tTo quit application");
	}

}
