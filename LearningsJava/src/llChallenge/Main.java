package llChallenge;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
	
	static ArrayList<PlayList> playLists = new ArrayList<PlayList>();
	static ArrayList<Album> albums = new ArrayList<Album>();
	static ArrayList<MusicClub> clubs = new ArrayList<MusicClub>();

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
	 
	 clubs.add(new MusicClub("mClub"));
	 
	 clubs.get(0).createNewAlbum("Mohra");
	 if(clubs.get(0).addsong2Album("Tip Tip Barsa pani", 5.5, "Mohra"))
	  System.out.println("Song added successsfully");
	 if(clubs.get(0).addsong2Album("Tu cheez badi he mast mast", 5.5, "Mohra"))
	  System.out.println("Song added successsfully");
	 if(clubs.get(0).addsong2Album("Ae kash kahi aisa hota", 5.5, "Mohra"))
	  System.out.println("Song added successsfully");
	 clubs.get(0).createNewAlbum("Tridev");
	 if(clubs.get(0).addsong2Album("Gali Gali mein", 5.5, "Tridev"))
	  System.out.println("Song added successsfully");
	 if(clubs.get(0).addsong2Album("Gazar ne kiya he ishara", 5.5, "Tridev"))
	  System.out.println("Song added successsfully");
	 if(clubs.get(0).addsong2Album("Raat bhar jam se", 5.5, "Tridev"))
	  System.out.println("Song added successsfully");
	 if(clubs.get(0).addsong2Album("Mein teri mohabbat mein", 5.5, "Tridev"))
	  System.out.println("Song added successsfully");
	 
	 clubs.get(0).createNewPlayList("mplay");
	 
	 clubs.get(0).addsong2PlayList("Tip Tip Barsa pani", "mplay");
	 clubs.get(0).addsong2PlayList("Tu cheez badi he mast mast", "mplay");
	 clubs.get(0).addsong2PlayList("Ae kash kahi aisa hota", "mplay");
	 clubs.get(0).addsong2PlayList("Gali Gali mein", "mplay");
	 
	 boolean quit = false;
	 
	 printMenu();
	 
	 while(!quit){
	 
	  int input = scanner.nextInt();
	  scanner.nextLine();
	 
	  switch(input){
	  case 0:
	   printMenu();
	   break;
	  case 1:
	   createPlayList();
	   break;
	  case 2:
	   addsong2PlayList();
	   break;
	  case 3:
	   removesongfromPlayList();
	   break;
	  case 4:
	   createAlbum();
	   break;
	  case 5:
	   addsong2Album();
	   break;
	  case 6:
	   clubs.get(0).displayAlbumsOnly();
	   break;
	  case 7:
	   clubs.get(0).displayAlbumswithSongs();
	   break;
	  case 8:
	   clubs.get(0).displayPlayListsOnly();
	   break;
	  case 9:
	   clubs.get(0).displayPlayListswithSongs();
	   break;
	  case 10:
	   play();
	   break;
	  case 11:
	   quit = true;
	   break;
	  }
	 }
	}

	private static void createPlayList(){
	 System.out.println("Enter the name of playlist you want to create");
	 String  name = scanner.nextLine();
	 
	 if(clubs.get(0).createNewPlayList(name))
	  System.out.println("Created " + name + " successfully");
	 else
	  System.out.println("Error creating playlist.");
	}

	private static void addsong2PlayList(){
	 if (clubs.get(0).getPlayLists().size() != 0) {
	  System.out.println("Enter the song you want to add.");
	  String song = scanner.nextLine();
	  System.out.println("Enter the playlist in which you want to add this song.");
	  String playlist = scanner.nextLine();
	  if (clubs.get(0).addsong2PlayList(song, playlist))
	   System.out.println("Song " + song + " added successfully in playlist " + playlist);

	  else
	   System.out.println("Error adding song to playlist");
	 }
	 else{
	  System.out.println("No plyalist currently to add song to. Want to create one (y/n)");
	  String input = scanner.nextLine();
	 
	  if(input.equalsIgnoreCase("y"))
	   createPlayList();
	 }
	}

	private static void removesongfromPlayList(){
	 if (clubs.get(0).getPlayLists().size() != 0) {
	  System.out.println("Enter the song you want to remove");
	  String song = scanner.nextLine();
	  System.out.println("Enter the playlist from which you want to remove this song");
	  String playlist = scanner.nextLine();
	  if (clubs.get(0).removesongfromPlayList(song, playlist))
	   System.out.println("Song " + song + " removed from the playlist " + playlist);
	  else
	   System.out.println("Error removing song from playlist");
	 }
	 else{
	  System.out.println("No plyalist currently to add song to. Want to create one (y/n)");
	  String input = scanner.nextLine();
	 
	  if(input.equalsIgnoreCase("y"))
	   createPlayList();
	 }
	}

	private static void createAlbum(){
	 System.out.println("Enter the album name");
	 String albumName = scanner.nextLine();
	 if(clubs.get(0).createNewAlbum(albumName))
	  System.out.println(albumName + " created successfully");
	 else
	  System.out.println("Error creating the album "+ albumName);
	}

	private static void addsong2Album(){
	 if (clubs.get(0).getAlbums().size() != 0) {
	  System.out.println("Enter the song name");
	  String songName = scanner.nextLine();
	  System.out.println("Enter the song duration");
	  double songduration = scanner.nextDouble();
	  scanner.nextLine();
	  System.out.println("Enter the album name");
	  String albumName = scanner.nextLine();
	  if (clubs.get(0).addsong2Album(songName, songduration, albumName))
	   System.out.println(songName + " added successfully to " + albumName);
	  else
	   System.out.println("Error adding song to album");
	 }
	 else{
	  System.out.println("No albums currently to add song to. Want to create one (y/n)");
	  String input = scanner.nextLine();
	 
	  if(input.equalsIgnoreCase("y"))
	   createAlbum();
	 }
	}

	private static void printMenu(){
	 System.out.println("0. Print the menu options again"
	      + "\n1. Create a PlayList"
	      + "\n2. Add a song to playlist"
	      + "\n3. Remove a song from playlist"
	      + "\n4. Create an album"
	      + "\n5. Add song to album"
	      + "\n6. List albums only"
	      + "\n7. List albums with songs"
	      + "\n8. List playlists only"
	      + "\n9. List playlists with songs"
	      + "\n10. Start a playlist"
	      + "\n11. Exit the club");
	}

	public static void playlistmenu(){
	 System.out.println("0. Quit playlist menu"
	     +  "\n1. Play next song"
	     +  "\n2. Play previous song"
	     +  "\n3. Repeat song"
	     +  "\n4. Remove current song");
	}

	private static void play(){
	 if (!(clubs.get(0).getPlayLists().isEmpty())) {
	  System.out.println();
	  boolean goingForward = true;
	  clubs.get(0).displayPlayListsOnly();
	  System.out.println("Enter the playlist which you want to start");
	  String selectedPlayList = scanner.nextLine();
	  PlayList currentPlayList = clubs.get(0).searchPlayList(selectedPlayList);
	  LinkedList<Song> currentLL = currentPlayList.getPlayLists();
	  ListIterator<Song> listIterator = currentLL.listIterator();
	  if (currentPlayList != null) {
	   System.out.println("==========================Welcome to your playList============================");
	   System.out.println();

	   playlistmenu();

	   boolean quit = false;

	   while (!quit) {

	    int input = scanner.nextInt();
	    scanner.nextLine();

	    switch (input) {
	    case 0:  //quit playlist menu
	     quit = true;
	     break;
	    case 1:  //Play next song in playlist
	     if (listIterator.hasNext()) {
	      if (!goingForward) {
	       listIterator.next();
	       System.out.println("Now playing -->  " + listIterator.next());
	       goingForward = true;
	      } else {
	       System.out.println("Now playing -->  " + listIterator.next());
	      }
	     } else {
	      System.out.println("At the end of the playlist");
	      goingForward = false;
	     }
	     break;
	    case 2:  //Play previous song in list
	     if (listIterator.hasPrevious()) {
	      if (goingForward) {
	       listIterator.previous();
	       System.out.println("Now playing -->  " + listIterator.previous());
	       goingForward = false;
	      } else {
	       System.out.println("Now playing -->  " + listIterator.previous());
	      }
	     } else {
	      System.out.println("At the start of playlist");
	      goingForward = true;
	     }
	     break;
	    case 3:  //Repeat the last played song
	     if(goingForward){
	      if(listIterator.hasPrevious())
	       System.out.println("Now playing --> " + listIterator.previous());
	      else
	       System.out.println("No current song");
	     
	      goingForward = false;
	     }
	     else if(!goingForward){
	      if(listIterator.hasNext())
	       System.out.println("Now playing --> " + listIterator.next());
	      else
	       System.out.println("No current song");
	     
	      goingForward = true;
	     }
	     break;
	    case 4:  //Remove song from the list
	     /*if (listIterator.) {
	      if (goingForward) {
	       if (listIterator.hasPrevious()) {
	        String removedSong = listIterator.previous().getSongName();
	        listIterator.remove();
	        System.out.println("Removed --> " + removedSong);
	       } else
	        System.out.println("No current song");

	       goingForward = false;
	      } else if (!goingForward) {
	       if (listIterator.hasNext()) {
	        String removedSong = listIterator.next().getSongName();
	        listIterator.remove();
	        System.out.println("Removed --> " + removedSong);
	       } else
	        System.out.println("No current song");

	       goingForward = true;
	      }
	     }*/
	     break;
	    }
	   }
	  }
	 }
	 else
	  System.out.println("No playlist currently to start");
	}

}
