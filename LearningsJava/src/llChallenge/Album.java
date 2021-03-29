package llChallenge;

import java.util.ArrayList;

public class Album {
	
	private ArrayList<Song> songs;
	private String albumName;

	public ArrayList<Song> getSongs() {
	 return songs;
	}
	public String getAlbumName() {
	 return albumName;
	}
	public Album(String albumName) {
	 this.songs = new ArrayList<Song>();
	 this.albumName = albumName;
	}

	public boolean addSong2Album(String songName, double songDuration){
	 Song tempSong = searchSong(songName);
	 
	 if(tempSong == null){
	  songs.add(new Song(songName, songDuration));
	  return true;
	 }
	 return false;
	}

	public boolean removeSongfromAlbum(String songName){  
	 Song tempSong = searchSong(songName);
	 
	 if(tempSong != null){
	  songs.remove(tempSong);
	  return true;
	 }
	 return false;
	}

	public Song searchSong(String songName){
	 
	 for(int i =0; i<songs.size(); i++){
	  Song tempSong = this.songs.get(i);
	  if(tempSong.getSongName().equalsIgnoreCase(songName)){
	   return tempSong;
	  }
	 }
	 return null;
	}

	public void displayAlbumSongs(){
	 System.out.println("=============" + this.albumName + " contains " + this.songs.size() + " songs" + "=============");
	 
	 for(int i = 0; i<this.songs.size(); i++){
	  System.out.println("\t" + this.songs.get(i).getSongName() + "(" + this.songs.get(i).getSongDuration() + ")");
	 }
	}
}
