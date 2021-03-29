package arrayListChallenge;

public class Contact {
	private String contactName;
	private String contactNumber;
	
	public String getContactName() {
		return contactName;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public Contact(String contactName, String contactNumber) {
		this.contactName = contactName;
		this.contactNumber = contactNumber;
	}
	
	public static Contact createContact(String name, String number) {
		return new Contact(name, number);
	}
}
