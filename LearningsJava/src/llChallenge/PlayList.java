package llChallenge;

import java.util.LinkedList;

public class PlayList {
	
	private String listName;
	private LinkedList<Song> playList;
	private static Album playListAlbum;

	public String getListName() {
	 return listName;
	}
	public LinkedList<Song> getPlayLists() {
	 return playList;
	}
	public PlayList(String listName) {
	 this.listName = listName;
	 this.playList = new LinkedList<Song>();
	 playListAlbum = new Album("playList");
	}

	public boolean add2PlayList(Song song){
	 this.playList.add(song);
	 return true;
	}

	public boolean removeSongfromPlaylist(String songName){
	 Song song = playListAlbum.searchSong(songName);
	 
	 if(song != null){
	  playList.remove(song);
	  return true;
	 }
	 
	 return false;
	}

}
