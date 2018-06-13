package com.team11.cab.service;

import java.util.ArrayList;
import com.team11.cab.model.Booking;

public interface BookingService {
	ArrayList<Booking> findAllBookings();
	boolean isBookingValid(Booking newBooking);
	Booking makeBooking(Booking newBooking);
	boolean validateBookings(int id);
	Booking findBookingByID(int id);
}
