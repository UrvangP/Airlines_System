package main.java.edu.neu.csye7374.State;

import main.java.edu.neu.csye7374.Observer.Booking;

public class BookingPending implements BookingStatusAPI{

    private Booking booking;

    public BookingPending(Booking book) {
        this.booking = book;
    }

    @Override
    public void pending() {
        System.out.println("Booking already in pending state!!");
    }

    @Override
    public void confirmed() {
        booking.setState(booking.getConfirmed());
        System.out.println("Booking confirmed!!");
    }

    @Override
    public void canceled() {
        System.out.println("Booking not confirmed yet!!");
    }

    @Override
    public String toString() {
        return "Booking is in Pending State";
    }
}
