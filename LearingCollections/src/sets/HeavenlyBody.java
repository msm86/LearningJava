package sets;

import java.util.HashSet;
import java.util.Set;

public class HeavenlyBody {
	private final String name;
	private final double orbitalPeriod;
	private final Set<HeavenlyBody> satellites;
	
	public HeavenlyBody(String name, double orbitalPeriod) {
		this.name = name;
		this.orbitalPeriod = orbitalPeriod;
		this.satellites = new HashSet<>();
	}

	public String getName() {
		return name;
	}

	public double getOrbitalPeriod() {
		return orbitalPeriod;
	}

	public Set<HeavenlyBody> getSatellites() {
		return new HashSet<>(this.satellites);
	}
	
	public boolean addSatellite(HeavenlyBody satName) {
		return satellites.add(satName);
	}

	@Override
	public boolean equals(Object obj) {
		System.out.println("Equals method called");
		if(this == obj) {
			System.out.println("Calling Object found same as passed object");
			return true;
		}
		
		if((obj != null) && (this.getClass() == obj.getClass())) {
			String objName = ((HeavenlyBody) obj).getName();
			return objName.equals(this.getName());
		}
		
		return false;
	}

	@Override
	public int hashCode() {
		System.out.println("HashCode Called.." + this + "\t" + (this.name.hashCode()+57));
		return this.name.hashCode() + 57;
	}

	@Override
	public String toString() {
		return this.name + ":\t" + this.orbitalPeriod ;
	}
}
