package genericsChallenges;

import java.util.ArrayList;
import java.util.Collections;

public class League<T extends Team> {
	
	private String leagueName;
	private ArrayList<League> teams = new ArrayList<>();
	
	public League(String leagueName) {
		this.leagueName = leagueName;
	}
	
	public boolean addTeam(T Team) {
		if(teams.contains(Team)) {
			return false;
		} else {
			teams.add(Team);
			return true;
		}
	}
	
	public void leagueTable() {
		Collections.sort(teams);
		for(T team : teams) {
			System.out.println(team.getTeamName() + " : " + team.ranking());
		}
	}
	
}
