package model.entities;

import java.time.Duration;
import java.time.LocalDate;

public class Reservation {
	Integer roomNumber;
	LocalDate checkin;
	LocalDate checkout;

	public Reservation(Integer roomNumber, LocalDate checkin, LocalDate checkout) {
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public LocalDate getCheckin() {
		return checkin;
	}


	public LocalDate getCheckout() {
		return checkout;
	}

	public Integer duration() {
		return (int) Duration.between(checkin.atStartOfDay(), checkout.atStartOfDay()).toDays();
	}

	public String UpdateDates(LocalDate checkin, LocalDate checkout) {
		if (checkin.isBefore(LocalDate.now()) || checkout.isBefore(LocalDate.now())) {
			return "Reservation dates for updates must be for future dates!";
		}
		else if (checkin.isAfter(checkout)) {
			return "Error in reservation: Check-out date must be after check-in date!";
		}
		this.checkin = checkin;
		this.checkout = checkout;
		return null;
	}
	
	@Override
	public String toString() {
		StringBuilder arg = new StringBuilder();
		arg.append("Rooom number: " + roomNumber + "\n");
		arg.append("Check-in date (dd/MM/yyyy): ");
		arg.append(checkin + "\n");
		arg.append("Check-out date (dd/MM/yyyy): ");
		arg.append(checkout + "\n");
		arg.append("Reservation room: Room " + roomNumber);
		arg.append(", check-in: " );
		arg.append(checkin);
		arg.append(", check-out: ");
		arg.append(duration() + " nights");
		return arg.toString();
	}
}

