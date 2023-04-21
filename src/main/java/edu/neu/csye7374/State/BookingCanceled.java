package main.java.edu.neu.csye7374.State;

import main.java.edu.neu.csye7374.Observer.Booking;

public class BookingCanceled implements BookingStatusAPI{
    private Booking booking;

    public BookingCanceled(Booking book) {
        this.booking = book;
    }

    @Override
    public void pending() {
        System.out.println("Booking already canceled!!");
    }

    @Override
    public void confirmed() {
        System.out.println("Booking already canceled!!");
    }

    @Override
    public void canceled() {
        System.out.println("Booking already canceled!!");
    }

    @Override
    public String toString() {
        return "Booking is in Canceled State";
    }
}
