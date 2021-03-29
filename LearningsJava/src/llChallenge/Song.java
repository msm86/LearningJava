package llChallenge;

public class Song {
	
	private String songName;
	private double songDuration;

	public String getSongName() {
	 return songName;
	}
	public double getSongDuration() {
	 return songDuration;
	}

	public Song(String songName, double songDuration) {
	 this.songName = songName;
	 this.songDuration = songDuration;
	}

	@Override
	public String toString() {
	 // TODO Auto-generated method stub
	 return this.songName + " (" + this.songDuration + ")";
	}

}
