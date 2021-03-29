package arrayListChallenge;

import java.util.ArrayList;

public class MobilePhone {
	
	private String name;
	private ArrayList<Contact> myContacts;
	public String getName() {
		return name;
	}
	public ArrayList<Contact> getContact() {
		return myContacts;
	}
	public MobilePhone(String name) {
		this.name = name;
		this.myContacts = new ArrayList<Contact>();
	}
	
	public int addNewCotact(Contact contact) {
		int index = searchContact(contact);
		if(index < 0) {
			this.myContacts.add(contact);
			return -1;
		}

		return index;
	}
	
	public int modifyContact(Contact oldContact, Contact newContact) {
		int indexPosition = searchContact(oldContact);
		
		if(indexPosition >= 0) {
			myContacts.set(indexPosition, newContact);
			return indexPosition;
		}

		return -1;
	}
	
	public int removeContact(Contact contact) {
		int indexPosition = searchContact(contact);
		if(indexPosition < 0)
			return -1;
		
		myContacts.remove(indexPosition);
		return indexPosition;
	}
	
	public Contact searchContact(String name) {
		for(int i=0; i<myContacts.size(); i++) {
			if(myContacts.get(i).getContactName().equalsIgnoreCase(name))
				return myContacts.get(i);
		}
		
		return null;
	}
	
	private int searchContact(Contact contact) {
		return this.myContacts.indexOf(contact);
	}
	
	public void printContacts() {
		System.out.println("You have "+ myContacts.size() + " contacts in your list");
		System.out.println("#\tName\tNumber");
		for(int i=0; i<myContacts.size(); i++) {
			System.out.println((i+1) + "\t" + myContacts.get(i).getContactName() + "\t" + myContacts.get(i).getContactNumber());
		}
	}	
}
