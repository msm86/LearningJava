package mapsAdventureGame;

import java.util.HashMap;
import java.util.Map;
	
public class Location {
	
	private final int locationID;
	private final String locDesc;
	private final Map<String, Integer> exits;
	
	public Location(int locationID, String locDesc, Map<String, Integer> exits) {
		this.locationID = locationID;
		this.locDesc = locDesc;
		if (exits != null) {
			this.exits = new HashMap<String, Integer>(exits);
		} else {
			this.exits = new HashMap<String, Integer>();
		}
		this.exits.put("Q", 0);
	}

	public int getLocationID() {
		return locationID;
	}

	public String getLocDesc() {
		return locDesc;
	}

	public Map<String, Integer> getExits() {
		return new HashMap<String, Integer>(exits);
	}
	
	public boolean addExits(String direction, int location) {
		if(!(exits.containsKey(direction))) {
			exits.put(direction, location);
			return true;
		} else {
			return false;
		}
	}	
}