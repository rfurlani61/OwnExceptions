package model.entities;

import java.time.Duration;
import java.time.LocalDate;

public class Reservation {
	Integer roomNumber;
	LocalDate checkin;
	LocalDate checkout;

	public Integer duration() {
		return (int) Duration.between(checkin.atStartOfDay(), checkout.atStartOfDay()).toDays();
	}

	public void UpdateDates(LocalDate checkin, LocalDate checkout) {
		if (checkin.isAfter(this.checkin)) {
			if (checkout.isAfter(checkin)) {
				this.checkin = checkin;
				this.checkout = checkout;
			}
		}
	}

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

