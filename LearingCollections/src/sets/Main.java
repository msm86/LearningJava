package sets;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
	
	private static Map<String, HeavenlyBody> solarSystem = new HashMap<>();
	private static Set<HeavenlyBody> planets = new HashSet<>();

	public static void main(String[] args) {
		HeavenlyBody tempBody = new HeavenlyBody("Mercury", 88);
		solarSystem.put(tempBody.getName(), tempBody);
		planets.add(tempBody);
		
		tempBody = new HeavenlyBody("Venus", 277);
		solarSystem.put(tempBody.getName(), tempBody);
		planets.add(tempBody);
		
		tempBody = new HeavenlyBody("Earth", 365);
		solarSystem.put(tempBody.getName(), tempBody);
		planets.add(tempBody);
		
		HeavenlyBody tempMoon = new HeavenlyBody("Moon", 27);
		solarSystem.put(tempMoon.getName(), tempMoon);
		tempBody.addSatellite(tempMoon);
		
		tempBody = new HeavenlyBody("Mars", 687);
		solarSystem.put(tempBody.getName(), tempBody);
		planets.add(tempBody);
		tempMoon = new HeavenlyBody("Deimos", 1.3);
		solarSystem.put(tempMoon.getName(), tempMoon);
		tempBody.addSatellite(tempMoon);
		tempMoon = new HeavenlyBody("Phobos", 2.5);
		solarSystem.put(tempMoon.getName(), tempMoon);
		tempBody.addSatellite(tempMoon);
		
		tempBody = new HeavenlyBody("Jupiter", 4332);
		solarSystem.put(tempBody.getName(), tempBody);
		planets.add(tempBody);
		tempMoon = new HeavenlyBody("Io", 1.8);
		solarSystem.put(tempMoon.getName(), tempMoon);
		tempBody.addSatellite(tempMoon);
		tempMoon = new HeavenlyBody("Europa", 3.5);
		solarSystem.put(tempMoon.getName(), tempMoon);
		tempBody.addSatellite(tempMoon);
		tempMoon = new HeavenlyBody("Ganymede", 7.1);
		solarSystem.put(tempMoon.getName(), tempMoon);
		tempBody.addSatellite(tempMoon);
		tempMoon = new HeavenlyBody("Callisto", 16.7);
		solarSystem.put(tempMoon.getName(), tempMoon);
		tempBody.addSatellite(tempMoon);
		
		tempBody = new HeavenlyBody("Saturn", 10598);
		solarSystem.put(tempBody.getName(), tempBody);
		planets.add(tempBody);
		
		tempBody = new HeavenlyBody("Uranus", 30660);
		solarSystem.put(tempBody.getName(), tempBody);
		planets.add(tempBody);
		
		tempBody = new HeavenlyBody("Neptune", 60225);
		solarSystem.put(tempBody.getName(), tempBody);
		planets.add(tempBody);
		
		tempBody = new HeavenlyBody("Pluto", 248);
		solarSystem.put(tempBody.getName(), tempBody);
		planets.add(tempBody);
		
		System.out.println("Planets: ");
		for(HeavenlyBody planet : planets) {
			System.out.println("\t" + planet.getName());
		}
		
//		HeavenlyBody temp = solarSystem.get("Jupiter");
//		System.out.println(temp.getName() + "'s Satellites are: ");
//		for(HeavenlyBody satellites : temp.getSatellites()) {
//			System.out.println("\t" + satellites.getName());
//		}
		
		Set<HeavenlyBody> moons = new HashSet<>();
		for(HeavenlyBody planet : planets) {
			moons.addAll(planet.getSatellites());
		}
		
		System.out.println("All moons");
		for(HeavenlyBody moon : moons) {
			System.out.println("\t" + moon.getName());
		}
		
		HeavenlyBody pluto = new HeavenlyBody("Pluto", 248);
		planets.add(pluto);
		
		String name = "Pluto";
		
		System.out.println(name.hashCode());
		
		for(HeavenlyBody planet : planets) {
			System.out.println(planet.getName() + " : " + planet.getOrbitalPeriod());
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
