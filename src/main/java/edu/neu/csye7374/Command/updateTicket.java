package main.java.edu.neu.csye7374.Command;

import main.java.edu.neu.csye7374.FlightAPI;
import main.java.edu.neu.csye7374.Observer.Booking;

public class updateTicket implements ReceiverAPI {

    Booking booking;
    FlightAPI flight;

    public updateTicket(Booking book, FlightAPI fl) {
        this.booking = book;
        this.flight = fl;
    }

    @Override
    public void changeTicket() {
        booking.getTicket().setFlight(flight);
    }

    @Override
    public void cancelTicket() {
        booking.setState(booking.getCanceled());
    }
}
