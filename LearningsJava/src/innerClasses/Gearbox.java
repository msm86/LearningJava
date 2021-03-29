package innerClasses;

import java.util.ArrayList;

public class Gearbox {
	private ArrayList<Gear> gears;
	private int currentGear = 0;
	private int maxGears;
	private boolean clutchIsIn;
	
	public Gearbox(int maxGears) {
		this.gears = new ArrayList<Gear>();		
		this.maxGears = maxGears;
		Gear neutral = new Gear(0, 0.0);
		this.gears.add(neutral);
		}
	
	public void operateClutch(boolean in) {
		this.clutchIsIn = in;
	}
	
	public boolean addGear(int gearNumber, double ratio) {
		if(gearNumber > 0 && gearNumber < this.maxGears && findGearNumber(gearNumber) == null) {
			this.gears.add(new Gear(gearNumber, ratio));
			return true;
		}
		return false;
	}
	
	private Gear findGearNumber(int gearNumber) {
		for(Gear currentGear : gears) {
			if(currentGear.gearNumber == gearNumber){
				return currentGear;
			}
		}
		return null;
	}
	
	public void changeGear(int gearNumber) {
		if(gearNumber < gears.size() && this.clutchIsIn) {
			this.currentGear = gearNumber;
			System.out.println("Gear changed to " + this.currentGear);
		}
		else
			System.out.println("Grind...");
	}

	public double driveSpeed(int revs) {
		if(this.clutchIsIn) {
			System.out.println("Scream...");
			return 0.0;
		}
		else {
			return revs * (gears.get(currentGear).ratio);
		}
	}
	
	private class Gear{
		private int gearNumber;
		private double ratio;
		
		public Gear(int gearNumber, double ratio) {
			this.gearNumber = gearNumber;
			this.ratio = ratio;
		}
		
	}
}