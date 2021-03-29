package arrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class GroceryList {
	
	private ArrayList<String> groceryList = new ArrayList<String>();
	private Scanner scanner = new Scanner(System.in);

	public ArrayList<String> getGroceryList() {
		return groceryList;
	}
	
	private int searchItemIndex(String name) {
		return groceryList.indexOf(name);
	}
	
	public int addItem(String name) {
		if(searchItemIndex(name) == -1) {
			groceryList.add(name);
			return 1;
		}
		else {
			System.out.println("Item already exists in the list. Would you like to add the same item twice? Y/N");
			String input = scanner.nextLine();
			if(input.equalsIgnoreCase("y")) {
				groceryList.add(name);
				return 1;
			}
			else
				return 0;
		}
	}
	
	public int modifyItem(String name, String modifiedName) {
		int index = groceryList.indexOf(name);
		if(index == -1) {
			System.out.println("The list does not contain " + name + ". Would you like to add the same to list? (Y/N)");
			String input = scanner.nextLine();
			if(input.equalsIgnoreCase("y")) {
				groceryList.add(name);
			}
			return 1;
		}
		else {
			if(searchItemIndex(modifiedName) == -1) {
				groceryList.set(index, modifiedName);
				return 1;
			}
			else {
				System.out.println(modifiedName + " already exists in the list. Would you like to add the same item twice? Y/N");
				String input = scanner.nextLine();
				if(input.equalsIgnoreCase("y")) {
					groceryList.add(name);
					return 1;
				}
			}
			return 1;
		}
	}
	
	public int removeItem(String name) {
		int index = searchItemIndex(name);
		if(index > 0) {
			groceryList.remove(index);
			return 1;
		}
		else
			System.out.println("Item does not exists in the grocery list.");
		
		return 0;
	}
	
	public void searchItem(String name) {
		int index = searchItemIndex(name);
		if(index == -1) {
			System.out.println("Item is not on the list. Would you like to add? (Y/N)");
			String input = scanner.nextLine();
			if(input.equalsIgnoreCase("y")) {
				groceryList.add(name);
			}
		}
		else {
			System.out.println("Ïtem found in the list");
		}
	}
	
	public void printGroceryList() {
		System.out.println("You have " + groceryList.size() + " items in your list.");
		for(int i=0; i<groceryList.size(); i++) {
			System.out.println((i+1) + ". "+ groceryList.get(i));
		}
	}
}