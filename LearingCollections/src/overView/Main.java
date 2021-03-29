package overView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		Theatre theatre = new Theatre("Apsara", 10, 10, 7);
		
		theatre.getSeats();
		
		List<Theatre.Seat> priceSeats = new ArrayList<>(theatre.getSeats());
		
		Collections.sort(priceSeats, theatre.priceOrder);
		
		System.out.println("Printing price sorted seats");
		printList(priceSeats);
		//Checking if the seatCopy is shallow copy or deep copy
//		seatCopy.get(1).reserveSeat(true);
//		if(theatre.reserveSeat("A02")) {
//			System.out.println("Seat reserved. Please pay");
//		}
//		else {
//			System.out.println("Sorry..seat is already reserved.");
//		}
		
		//reversing the seatCopy list
//		Collections.reverse(seatCopy);
//		System.out.println("Printing reversed seatCopy");
//		printList(seatCopy);
//		System.out.println("Printing theatre.seat");
//		printList(theatre.seats);
		
		//shuffling the seats
//		Collections.shuffle(seatCopy);
//		System.out.println("Printing shuffled seatCopy");
//		printList(seatCopy);
//		System.out.println("Printing theatre.seat");
//		printList(theatre.seats);
		
		//Min and Max seat; sorting based on the natural sort order, in other words the order which compareTo method does.
//		Collections.shuffle(seatCopy);
//		Theatre.Seat minSeat = Collections.min(seatCopy);
//		Theatre.Seat maxSeat = Collections.max(seatCopy);
//		System.out.println("Minimum seat is: " + minSeat.getSeatNumber());
//		System.out.println("Maximum seat is: " + maxSeat.getSeatNumber());
		
//		if(theatre.reserveSeat("D007"))
//			System.out.println("Seat reserved. Please pay.");
//		else
//			System.out.println("Sorry there was an error reserving seat.");
	}
	
	public static void printList(List<Theatre.Seat> seats) {
		for(Theatre.Seat seat : seats) {
			System.out.print(seat.getSeatNumber() + " (" + seat.getPrice() + ")\t");
		}
		System.out.println();
		System.out.println("====================================================================================");
	}
//	
//	public static void sortList(List<Theatre.Seat> list) {
//		for(int i = 0; i<list.size() -1; i++) {
//			for(int j = i+1; j<list.size(); j++) {
//				if((list.get(i).compareTo(list.get(j))) > 0) {
//					Collections.swap(list, i, j);
//				}
//			}
//		}
//	}
//	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}