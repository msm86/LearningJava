package mapsAdventureGame;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	private static Map<Integer, Location> locations = new HashMap<>();
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		Map<String, Integer> tempExits = new HashMap<String, Integer>();
		locations.put(0, new Location(0, "At home learning java", null));
				
		tempExits = new HashMap<String, Integer>();
		tempExits.put("N", 5);
		tempExits.put("S", 4);
		tempExits.put("E", 3);
		tempExits.put("W", 2);
		locations.put(1, new Location(1, "On the road", tempExits));
		
		tempExits = new HashMap<String, Integer>();
		tempExits.put("N", 5);
		locations.put(2, new Location(2, "On the Hill", tempExits));
		
		tempExits = new HashMap<String, Integer>();
		tempExits.put("W", 1);
		locations.put(3, new Location(3, "In the building", tempExits));
		
		tempExits = new HashMap<String, Integer>();
		tempExits.put("N", 1);
		tempExits.put("W", 2);
		locations.put(4, new Location(4, "In a Valley", tempExits));
		
		tempExits = new HashMap<String, Integer>();
		tempExits.put("S", 1);
		tempExits.put("W", 2);
		locations.put(5, new Location(5, "In a Forrest", tempExits));
		
		int loc = 1;
		
		while(true) {
			System.out.println(locations.get(loc).getLocDesc());
			tempExits.remove("S");
			if(loc == 0) {
				break;
			}
			
			Map<String, Integer> exits = locations.get(loc).getExits();
		
			System.out.println("Possible exits are: ");
			
			for(String key : exits.keySet()) {
				System.out.print(key + " ");
			}
			
			//Directory maintained for filtering possible words
			Map<String, String> directory = new HashMap<String, String>();
			directory.put("QUIT", "Q");
			directory.put("QUITTING", "Q");
			directory.put("HOME", "Q");
			directory.put("NORTH", "N");
			directory.put("EAST", "E");
			directory.put("SOUTH", "S");
			directory.put("WEST", "W");
			////Directory maintained for filtering possible words
			
			String direction = scanner.nextLine().toUpperCase();
			
			
			//Check if see if the input is a sentence or a single word
			if (direction.length() > 1) {
				//If the input is a sentence, proceed with check if any of the word of the sentence exists in possible options of directory. 
				String[] directionArray = stringSplit(direction);
				for (String keyWord : directionArray) {
					
					if(directory.containsKey(keyWord)) {
						direction = directory.get(keyWord);
					}
					
					//if block doing the same as above
					
//					if ((d.equalsIgnoreCase("North")) || (d.equalsIgnoreCase("n"))) {
//						direction = "n";
//					} else if ((d.equalsIgnoreCase("south")) || (d.equalsIgnoreCase("s"))) {
//						direction = "s";
//					} else if ((d.equalsIgnoreCase("east")) || (d.equalsIgnoreCase("e"))) {
//						direction = "e";
//					} else if ((d.equalsIgnoreCase("west")) || (d.equalsIgnoreCase("w"))) {
//						direction = "w";
//					} else if ((d.equalsIgnoreCase("quit")) || (d.equalsIgnoreCase("q"))
//							|| (d.equalsIgnoreCase("quitting"))) {
//						direction = "q";
//					} else {
//						direction = d;
//					}
				} 
			}
			if(exits.containsKey(direction.toUpperCase())) {
				loc = exits.get(direction.toUpperCase());
			} else {
				System.out.println("Sorry..wrong direction!");
			}
		}
	}
	
	public static String[] stringSplit(String direction) {
		return direction.split(" ");
	}

}
