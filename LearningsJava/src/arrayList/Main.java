package arrayList;

import java.util.Scanner;

public class Main {

	private static GroceryList groceryList = new GroceryList();
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		
		int flag = 0;
		
		printOptions();
		
		while (flag != 6) {
			System.out.println("Enter your choice");
			int input = scanner.nextInt();
			scanner.nextLine();
			switch(input) {
			case 1:
				addItem();
				break;
			case 2:
				removeItem();
				break;
			case 3:
				searchItem();
				break;
			case 4:
				printgroceryList();
				break;
			case 5:
				printOptions();
				break;
			case 6:
				modifyItem();
				break;
			case 7:
				flag=6;
				break;
			}
		}
		
	}
	
	public static void addItem() {
		System.out.println("Enter the item you want to add");
		String name = scanner.nextLine();
		if(groceryList.addItem(name) == 0)
			System.out.println("The item coulnt be added");
		else
			System.out.println("Item added successfully.");
	}
	
	public static void removeItem() {
		System.out.println("Ënter the item you want to remove from the list");
		String name = scanner.nextLine();
		groceryList.removeItem(name);
	}
	
	public static void searchItem() {
		System.out.println("Enter the item to be search in the list");
		String name = scanner.nextLine();
		groceryList.searchItem(name);
	}
	
	public static void modifyItem() {
		System.out.println("Enter the item to be modified.");
		String name = scanner.nextLine();
		System.out.println("Ënter the item that you want "+ name + " to be modified with");
		String modifiedItem = scanner.nextLine();
		groceryList.modifyItem(name, modifiedItem);
	}
	
	public static void printgroceryList() {
		groceryList.printGroceryList();
	}
	
	public static void printOptions() {
		System.out.println("1. To add an item");
		System.out.println("2. To remove an item");
		System.out.println("3. To search an item");
		System.out.println("4. To print the list");
		System.out.println("5. To print choice options");
		System.out.println("6. To modify an Item");
		System.out.println("7. To quit application");
	}

}
