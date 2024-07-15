
package application;

import java.time.LocalDate;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Room number: ");
		int roomNumber = sc.nextInt();
		System.out.print("Check-in date (yyyy-MM-dd): ");
		sc.nextLine();
		LocalDate checkin = LocalDate.parse(sc.next());
		System.out.print("Check-out date (yyyy-MM-dd): ");
		LocalDate checkout = LocalDate.parse(sc.next());
		if (checkin.isAfter(checkout)) {
			System.out.println("Room number: " + roomNumber);
			System.out.println("Check-in date (yyyy-MM-dd): " + checkin.toString());
			System.out.println("Check-out date (yyyy-MM-dd): " + checkout.toString());
			System.out.println("Error in reservation: Check-out date must be after check-in date!");
		} else {
			Reservation reservation = new Reservation(roomNumber, checkin, checkout);
			System.out.println("Reservation: " + reservation);

			System.out.println();
			System.out.println("Enter date to update the reservation: ");
			System.out.print("Check-in date (yyyy-MM-dd): ");
			checkin = LocalDate.parse(sc.next());
			System.out.print("Check-out date (yyyy-MM-dd): ");
			checkout = LocalDate.parse(sc.next());
			if (checkin.isBefore(LocalDate.now()) || checkout.isBefore(LocalDate.now())) {
				System.out.println("Room number: " + roomNumber);
				System.out.println("Check-in date (yyyy-MM-dd): " + checkin.toString());
				System.out.println("Check-out date (yyyy-MM-dd): " + checkout.toString());
				System.out.println("Error in reservation: Reservation dates for updates must be for future dates!");
			} else if (checkin.isAfter(checkout)) {
				System.out.println("Room number: " + roomNumber);
				System.out.println("Check-in date (yyyy-MM-dd): " + checkin.toString());
				System.out.println("Check-out date (yyyy-MM-dd): " + checkout.toString());
				System.out.println("Error in reservation: Check-out date must be after check-in date!");
			} else {
				reservation.UpdateDates(checkin, checkout);
				System.out.println("Reservation: " + reservation);
			}
			sc.close();

		}

	}
}
