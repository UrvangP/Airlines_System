package main.java.edu.neu.csye7374.State;

import main.java.edu.neu.csye7374.Observer.Booking;

public class BookingConfirmed implements BookingStatusAPI{
    private Booking booking;

    public BookingConfirmed(Booking book) {
        this.booking = book;
    }

    @Override
    public void pending() {
        System.out.println("Booking already confirmed!!");
    }

    @Override
    public void confirmed() {
        System.out.println("Booking already confirmed!!");
    }

    @Override
    public void canceled() {
        booking.setState(booking.getCanceled());
        System.out.println("Booking Canceled!!");
    }

    @Override
    public String toString() {
        return "Booking is in Confirmed State";
    }
}
