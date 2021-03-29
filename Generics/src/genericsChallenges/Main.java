package genericsChallenges;

import genericsDemo.CricketPlayer;
import genericsDemo.Team;

public class Main {

	public static void main(String[] args) {
		
		Team<CricketPlayer> CSK = new Team<>("Chennai Super Kings");
		Team<CricketPlayer> RCB = new Team<>("Royal Challengers Bangalore");		
		Team<CricketPlayer> MI = new Team<>("Mumbai Indians");
		
		
		League<Team<CricketPlayer>> IPL = new League<>("Indian Premier League");
	}

}
