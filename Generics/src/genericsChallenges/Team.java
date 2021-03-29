package genericsChallenges;

import java.util.ArrayList;

public class Team<U extends Player> implements Comparable<Team<U>>{
	
	private ArrayList<U> teamMembers;
	
	private String teamName;
	private int won;
	private int lost;
	private int tied;
	private int matchesPlayed;

	public String getTeamName() {
		return teamName;
	}

	public Team(String teamName) {
		this.teamName = teamName;
		this.won = 0;
		this.lost = 0;
		this.tied = 0;
		this.matchesPlayed = 0;
		this.teamMembers = new ArrayList<>(); 
	}

	@Override
	public int compareTo(Team<U> team) {
		if(this.ranking() > team.ranking()) {
			return -1;
		} else if(this.ranking() < team.ranking()) {
			return 1;
		}else {
		return 0;
		}
	}

	public boolean addPlayer(U player) {
		if(teamMembers.contains(player)) {
			System.out.println(((Player) player).getName() + " is already on the " + this.teamName);
			return false;
		}
		
		teamMembers.add(player);
		System.out.println(((Player)player).getName() + " picked for team " + this.teamName);
		return true;
	}
	
	public int teamSize() {
		return this.teamMembers.size();
	}
	
	public void winner(Team<U> opponentTeam, int ourScore, int theirScore) {
		String message;
		if(ourScore > theirScore) {
			won++;
			message = " won against ";
		} else if (ourScore < theirScore) {
			lost++;
			message = " lost against ";
		} else {
			tied++;
			message = "Scores tied";
		}
		this.matchesPlayed++;
		
		if(opponentTeam != null) {
			System.out.println(this.teamName + message + opponentTeam.getTeamName()) ;
			opponentTeam.winner(null, ourScore, theirScore);
		}
	}
	
	public int ranking() {
		return (this.won * 2) + this.tied;
	}	
}
