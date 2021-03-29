package llChallenge;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class MusicClub {
	
	private String mClubName;
	private ArrayList<Album> albums;
	private ArrayList<PlayList> playLists;
	static boolean goingForward = true;

	public MusicClub(String mClubName) {
	 this.mClubName = mClubName;
	 this.albums = new ArrayList<Album>();
	 this.playLists = new ArrayList<PlayList>();
	}

	public String getmClubName() {
	 return mClubName;
	}

	public ArrayList<Album> getAlbums() {
	 return albums;
	}

	public ArrayList<PlayList> getPlayLists() {
	 return playLists;
	}

	public boolean createNewPlayList(String playlistName){
	 playLists.add(new PlayList(playlistName));
	 return true;
	}

	public boolean createNewAlbum(String albumName){
	 Album searchedAlbum = searchAlbum(albumName);
	 
	 if(searchedAlbum == null){
	  albums.add(new Album(albumName));
	  return true;
	 }
	 
	 return false;
	}

	public boolean addsong2PlayList(String songName, String playListName){
	 PlayList searchedPlaylist = searchPlayList(playListName);
	 Song searchedSong = searchSong(songName);
	 
	 if(searchedPlaylist != null){
	  if(searchedSong != null){
	   searchedPlaylist.add2PlayList(searchedSong);
	   return true;
	  }
	 }
	 return false;
	}

	public boolean removesongfromPlayList(String songName, String playListName){
	 PlayList searchedPlaylist = searchPlayList(playListName);
	 Song searchedSong = searchSong(songName);
	 
	 if(searchedPlaylist != null){
	  if(searchedSong != null){
	   searchedPlaylist.removeSongfromPlaylist(songName);
	   return true;
	  }
	 }
	 return false;
	}

	public PlayList searchPlayList(String playlistName){
	 if(playLists.isEmpty())
	  return null;
	 
	 for(PlayList currentplaylist : playLists){
	  String tempPlayListname = currentplaylist.getListName();
	  if(tempPlayListname.equalsIgnoreCase(playlistName)){
	   return currentplaylist;
	  }
	 }
	 return null;
	}

	public boolean addsong2PlayList(String songName, LinkedList<Song> playlist){
	 Song searchedSong = searchSong(songName);
	 
	 if(searchedSong != null){
	  playlist.add(searchedSong);
	  return true;
	 }
	 
	 return false;
	}

	public boolean addsong2Album(String songName, double songDuration, String albumName){
	 Album searchedAlbum = searchAlbum(albumName);
	 
	 if(searchedAlbum != null){
	  if(searchedAlbum.addSong2Album(songName, songDuration))
	   return true;
	  else
	   return false;
	 }
	 
	 return false;
	}

	public boolean addAlbum2PlayList(String albumName, LinkedList<Song> playList){
	 Album searchedAlbum = searchAlbum(albumName);
	 if(searchedAlbum != null){
	  for(Song currentSong : searchedAlbum.getSongs()){
	   playList.add(currentSong);
	  }
	 
	  return true;
	 }
	 
	 return false;
	}

	public Song searchSong(String songName){  
	 for(int i =0; i<albums.size(); i++){
	  ArrayList<Song> currentAlbumSongList = albums.get(i).getSongs();
	  for(int j=0; j<currentAlbumSongList.size(); j++){
	   Song tempSong = currentAlbumSongList.get(j);
	   if(tempSong.getSongName().equalsIgnoreCase(songName)){
	    return tempSong;
	   }
	  }
	 }
	 return null;
	}

	public Album searchAlbum(String albumName){
	 for(int i=0; i<albums.size(); i++){
	  String currentAlbumName = albums.get(i).getAlbumName();
	  if(currentAlbumName.equalsIgnoreCase(albumName))
	   return albums.get(i);
	 }
	 
	 return null;
	}

	public void displayAlbumsOnly(){
	 if (!(albums.isEmpty())) {
	  for (Album currentAlbum : albums) {
	   System.out.println(currentAlbum.getAlbumName() + " has " + currentAlbum.getSongs().size() + " songs.");
	  }
	 }
	 else
	  System.out.println("No albums created to be displayed");
	}

	public void displayAlbumswithSongs(){
	 for(Album currentAlbum : albums){
	  System.out.println(currentAlbum.getAlbumName() + " has " + currentAlbum.getSongs().size() + " songs.");
	  for(Song currentSong : currentAlbum.getSongs())
	   System.out.println("\t-->" + currentSong);
	 }
	}

	public void displayPlayListsOnly(){
	 if (!playLists.isEmpty()) {
	  System.out.println("There are " + playLists.size() + " currently defined for " + mClubName);
	  for (PlayList currentPlaylist : playLists) {
	   System.out.println("\t" + currentPlaylist.getListName() + " has "
	     + currentPlaylist.getPlayLists().size() + " songs.");
	  }
	 }
	 else
	  System.out.println("No playlists created to display.");
	}

	public void displayPlayListswithSongs(){
	 System.out.println("There are " + playLists.size() + " playlist currently created for " + mClubName);
	 for(PlayList currentPlaylist : playLists){
	  System.out.println("\t" + currentPlaylist.getListName() + " has " + currentPlaylist.getPlayLists().size() + " songs.");
	  for(Song currentSong : currentPlaylist.getPlayLists()){
	   System.out.println("\t\t" + currentSong.toString());
	  }
	 }
	}

	public Song playListNextSong(String playlistName){
	 PlayList searchedPlayList = searchPlayList(playlistName);  
	 if(searchedPlayList != null){
	  ListIterator<Song> listIterator = searchedPlayList.getPlayLists().listIterator();
	  if(listIterator.hasNext()){
	   if(!goingForward){
	    listIterator.next();
	    return listIterator.next();
	   }
	   else{
	    return listIterator.next();
	   }
	  }
	 }
	 return null;
	}

	public Song playListPreviousSong(String playlistName){
	 PlayList searchedPlayList = searchPlayList(playlistName);
	 
	 if(searchedPlayList != null){
	  ListIterator<Song> listIterator = searchedPlayList.getPlayLists().listIterator();
	  if(listIterator.hasPrevious()){
	   if(goingForward){
	    listIterator.previous();
	    return listIterator.previous();
	   }
	  }
	 }
	 return null;
	}

}
