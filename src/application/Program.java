
package application;

import java.time.LocalDate;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		try {
			System.out.print("Room number: ");
			int roomNumber = sc.nextInt();
			System.out.print("Check-in date (yyyy-MM-dd): ");
			sc.nextLine();
			LocalDate checkin = LocalDate.parse(sc.next());
			System.out.print("Check-out date (yyyy-MM-dd): ");
			LocalDate checkout = LocalDate.parse(sc.next());
			Reservation reservation = new Reservation(roomNumber, checkin, checkout);
			System.out.println("Reservation: " + reservation);
			System.out.println();
			System.out.println("Enter date to update the reservation: ");
			System.out.print("Check-in date (yyyy-MM-dd): ");
			checkin = LocalDate.parse(sc.next());
			System.out.print("Check-out date (yyyy-MM-dd): ");
			checkout = LocalDate.parse(sc.next());
			reservation.UpdateDates(checkin, checkout);
			System.out.println("Reservation: " + reservation);
			sc.close();
		} catch (DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Unexpected Error!");
		}
	}
}
