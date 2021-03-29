package overView;

import java.util.*;

public class Theatre {
	private final String theatreName;
	private List<Seat> seats;
	private int rowNum;
	private int seatsPerRow;
	private static int searchCounter = 0;
	
	public Theatre(String theatreName, int rowNum, int seatsPerRow, double basePrice) {
		this.theatreName = theatreName;
		this.seats = new ArrayList<>();
		this.rowNum = rowNum;
		this.seatsPerRow = seatsPerRow;
		
		int lastRow = 'A' + (this.rowNum - 1);
		
		for(char row = 'A'; row<=lastRow; row++) {
			double price = basePrice;
			for(int seatNum = 1; seatNum<=this.seatsPerRow; seatNum++) {
				if((row <= 'G') && (row>= 'E') && ((seatNum>=4) && (seatNum<=8))) {
					price = basePrice + 7;
					Seat seat = new Seat(row + String.format("%02d", seatNum), price);
					seats.add(seat);
				} else if(row>= 'F') {
					price = basePrice+5;
					Seat seat = new Seat(row + String.format("%02d", seatNum), price);
					seats.add(seat);
				} else {
					Seat seat = new Seat(row + String.format("%02d", seatNum), price);
					seats.add(seat);
				}
			}
		}
	}
	
	protected final Comparator<Seat> priceOrder = new Comparator<Seat>() {

		@Override
		public int compare(Seat s1, Seat s2) {
			if(s1.getPrice() < s2.getPrice()) {
				return -1;
			} else if (s1.getPrice() > s2.getPrice()) {
				return 1;
			} else {
				return 0;
			}
		}
		
	};
	
//	protected final Comparator<Seat> PRICE_ORDER;
//	
//	static {
//		PRICE_ORDER = new Comparator<Seat>() {
//		
//		@Override
//		public int compare(Seat s1, Seat s2) {
//			if(s1.getPrice() < s2.getPrice()) {
//				return -1;
//			} else if (s1.getPrice() > s2.getPrice()) {
//				return 1;
//			} else {
//				return 0;
//			}
//		}
//		};
//	}
	
	public boolean reserveSeat(String seatNumber) {
		Seat requestedSeat = findSeat(seatNumber);
		
		if(requestedSeat != null) {
			if(!requestedSeat.reserved) {
				requestedSeat.reserved = true;
				System.out.println(Theatre.searchCounter);
				return true;
			}
			else {
				System.out.println(Theatre.searchCounter);
				return false;
			}
		}
		else {
			System.out.println(Theatre.searchCounter);
			System.out.println("No such seat in the theatre");
			return false;
		}
	}
	
	public Seat findSeat(String seatNumber) {
		Seat requestedSeat = new Seat(seatNumber, 0);
		
		int foundSeatNumber = Collections.binarySearch(seats, requestedSeat, null);
		
		if(foundSeatNumber >= 0) {
			return seats.get(foundSeatNumber);
		}
		else {
			return null;
		}
		
//		Seat requestedSeat = null;
//		
//		for(Seat seat : seats) {
//			searchCounter++;
//			if(seat.getSeatNumber().equalsIgnoreCase(seatNumber)) {
//				 requestedSeat = seat;
//				 break;
//			}
//		}
//		System.out.println();
//		System.out.println(searchCounter);
//		return requestedSeat;
	}
	
	public boolean cancelSeat(String seatNumber) {
		Seat requestedSeat = findSeat(seatNumber);
		
		if(requestedSeat.reserved) {
			requestedSeat.reserved = false;
			return true;
		} else {
			System.out.println("Seat " + requestedSeat.seatNumber + " is not currently reserved");
			return false;
		}
	}
	
	public void printSeats() {
		System.out.println("Below is the seat structure for " + this.theatreName + " theatre");
		
		for(Seat seat : seats) {
			System.out.print(seat.getSeatNumber() + " (" + seat.getPrice() + ")\t");
		}
		
		//Starting Actual theatre structure
		
//		for(int i = 0; i<this.rowNum; i++) {
//			for(int j = 0; j<this.seatsPerRow; j++) {
//				System.out.print(seats.get(i).getSeatNumber() + " (" + seats.get(i).getPrice() + ")\t");
//			}
//			System.out.println();
//		}
		
		//Completing Actual theatre strucutre
	}
	
	public Collection<Seat> getSeats() {
		return seats;
	}

	protected class Seat implements Comparable<Seat>{
		private final String seatNumber;
		private boolean reserved = false;
		private double price;
		
		public Seat(String seatNumber, double price) {
			this.seatNumber = seatNumber;
			this.price = price;
		}

		public boolean isReserved() {
			return reserved;
		}

		public void reserveSeat(boolean reserved) {
			this.reserved = reserved;
		}
		
		public double getPrice() {
			return price;
		}

		public String getSeatNumber() {
			return seatNumber;
		}

		@Override
		public int compareTo(Seat seat) {
			Theatre.searchCounter++;
			return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
		}
	}
	
}
