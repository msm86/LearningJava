package genericsDemo;

public class Main {

	public static void main(String[] args) {
		CricketPlayer cPlayer01 = new CricketPlayer("Dhoni");
		CricketPlayer cPlayer02 = new CricketPlayer("Jasprit");
		CricketPlayer cPlayer03 = new CricketPlayer("Virat");
		CricketPlayer cPlayer04 = new CricketPlayer("Shami");
		
//		KabbadiPlayer kplayer01 = new KabbadiPlayer("Pawan");
		
		HockeyPlayer hPlayer = new HockeyPlayer("Satbir");
		
		Team<CricketPlayer> CSK = new Team<>("Chennai Super Kings");
		CSK.addPlayer(cPlayer01);
		CSK.addPlayer(cPlayer02);
		
		Team<CricketPlayer> RCB = new Team<>("Royal Challengers Bangalore");
		RCB.addPlayer(cPlayer03);
		RCB.addPlayer(cPlayer04);
		
		Team<CricketPlayer> MI = new Team<>("Mumbai Indians");
		
		System.out.println();
		System.out.println();
		
		CSK.winner(RCB, 12, 32);
		CSK.winner(MI, 45, 23);
		RCB.winner(MI, 45, 23);
		RCB.winner(CSK, 67, 34);
		MI.winner(CSK, 54, 74);
		MI.winner(RCB, 21, 43);
		
		System.out.println();
		System.out.println();
		
		Team<HockeyPlayer> hTeam = new Team<>("Hockey Team");
		hTeam.addPlayer(hPlayer);
		
		System.out.println("Team Rankings:");
		System.out.println("\t" + CSK.getTeamName() + " : " + CSK.ranking());
		System.out.println("\t" + RCB.getTeamName() + " : " + RCB.ranking());
		System.out.println("\t" + MI.getTeamName() + " : " + MI.ranking());
	}

}
