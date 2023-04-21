package main.java.edu.neu.csye7374.Observer;

import main.java.edu.neu.csye7374.Adapter.TicketAPI;
import main.java.edu.neu.csye7374.State.BookingCanceled;
import main.java.edu.neu.csye7374.State.BookingConfirmed;
import main.java.edu.neu.csye7374.State.BookingPending;
import main.java.edu.neu.csye7374.State.BookingStatusAPI;

import java.util.ArrayList;
import java.util.List;

public class Booking implements BookingStatusAPI {

    private TicketAPI ticket;
    private List<BookingObserverAPI> observer;
    private BookingStatusAPI bookingPending;
    private BookingStatusAPI bookingConfirmed;
    private BookingStatusAPI bookingCanceled;
    private BookingStatusAPI currentState;

    public Booking(TicketAPI ticket) {
        this.ticket = ticket;
        bookingPending = new BookingPending(this);
        bookingConfirmed = new BookingConfirmed(this);
        bookingCanceled = new BookingCanceled(this);
        currentState = bookingPending;
        observer = new ArrayList<>();
        observer.add(new QuantityObserver());
        bookFlight();
    }

    public void bookFlight() {
        observer.forEach(o->o.update(this));
    }

    public void setState(BookingStatusAPI status) {
        currentState = status;
    }

    public BookingStatusAPI getConfirmed() {
        return bookingConfirmed;
    }

    public BookingStatusAPI getCanceled() {
        return bookingCanceled;
    }

    @Override
    public void pending() {
        currentState.pending();
    }

    @Override
    public void confirmed() {
        currentState.confirmed();
    }

    @Override
    public void canceled() {
        currentState.canceled();
    }

    public TicketAPI getTicket() {
        return ticket;
    }

    public void setTicket(TicketAPI ticket) {
        this.ticket = ticket;
    }
}
