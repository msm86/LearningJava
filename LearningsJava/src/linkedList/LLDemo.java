package linkedList;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class LLDemo {
	
	public static void main(String[] args) {
		LinkedList<String> placestoVisit = new LinkedList<String>();
		
		addinOrder(placestoVisit, "Sydney");
		addinOrder(placestoVisit, "Brisbane");
		addinOrder(placestoVisit, "Darwin");
		addinOrder(placestoVisit, "Adelaide");
		addinOrder(placestoVisit, "Canberra");
		addinOrder(placestoVisit, "Alice Springs");
		addinOrder(placestoVisit, "Perth");
		
		printList(placestoVisit);
		
		visit(placestoVisit);
	}
	
	public static void printList(LinkedList<String> cities) {
		Iterator<String> i = cities.iterator();
		
		while(i.hasNext())
		{
			System.out.println("Now visiting.....    " + i.next());
		}
		
		System.out.println("============================================");
	}

	public static boolean addinOrder(LinkedList<String> cities, String newCity) {
		ListIterator<String> cityIterator = cities.listIterator();
		
		while(cityIterator.hasNext()) {
			int comparision = cityIterator.next().compareTo(newCity);
			
			if(comparision == 0) {
				System.out.println("List already contains " + newCity);
				return false;
			}
			else if(comparision > 0) {
				cityIterator.previous();
				cityIterator.add(newCity);
				System.out.println("Added "+ newCity + " successfully.");
				return true;
			}
			else if(comparision < 0) {

			}
		}
		cityIterator.add(newCity);
		return false;
	}
	
	public static void visit(LinkedList<String> cities) {
		boolean quit = false;
		boolean goingForward = true;
		
		Scanner scanner = new Scanner(System.in);
		
		ListIterator<String> listIterator = cities.listIterator();
		
		if(cities.isEmpty())
			System.out.println("No cities in the itenerary currently.");
		else {
			System.out.println("Now visiting " + listIterator.next());
		}
		
		printMenu();
		
		System.out.println("Input your choice");
		
		while(!quit) {
			int option = scanner.nextInt();
			scanner.nextLine();
			switch(option) {
			case 0:
				System.out.println("Vacation over. Get back to work.");
				quit = true;
				break;
			case 1:
				if(!goingForward) {
					if(listIterator.hasNext()) {
						listIterator.next();
						goingForward = true;
					}
				}
				if(listIterator.hasNext()) {
					System.out.println("Visiting " + listIterator.next());
				}
				else
					System.out.println("Already on the last city in the list");
				break;
			case 2:
				if(goingForward) {
					if(listIterator.hasPrevious()) {
						listIterator.previous();
						goingForward = false;
					}
				}				
				if(listIterator.hasPrevious()) {
					System.out.println("Visiting " + listIterator.previous());
				}
				else
					System.out.println("At the start of your journey no previous cities currently.");
				break;
			case 3:
				printMenu();
				break;
			}
		}
		scanner.close();
	}
	
	public static void printMenu() {
		System.out.println("Available actions:\npress ");
        System.out.println("0 - to quit\n" +
                "1 - go to next city\n" +
                "2 - go to previous city\n" +
                "3 - print menu options");
	}
}
