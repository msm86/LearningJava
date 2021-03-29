package mapsOverview;

import java.util.HashMap;
import java.util.Map;

public class MapOverview {
	
	public static void main(String[] args) {
		Map<String, String> phoneBook = new HashMap<>();
		phoneBook.put("Mital", "1");
		phoneBook.put("Aarohi", "2");
		phoneBook.put("Dhruvit", "0");
		
//		if(phoneBook.containsKey("Mital")) {
//			System.out.println("Mital is already on the Map");
//		} else {
//			phoneBook.put("Mital", "3");
//		}
//		
//		System.out.println(phoneBook.put("Mital", "01"));
//		
//		if(phoneBook.remove("Varun", "3")) {
//			System.out.println("Varun was removed from the Map");
//		} else {
//			System.out.println("Varun is not on the Map");
//		}
		
		printMapContents(phoneBook);
	}
	
	public static void printMapContents(Map<String, String> map) {
		for(String key : map.keySet()) {
			System.out.println(key + " : " + map.get(key));
		}
	}

}
