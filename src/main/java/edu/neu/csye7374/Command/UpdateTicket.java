package main.java.edu.neu.csye7374.Command;

import main.java.edu.neu.csye7374.Prototype.FlightAPI;
import main.java.edu.neu.csye7374.Observer.Booking;

public class UpdateTicket implements ReceiverAPI {

    Booking booking;
    FlightAPI flight;

    public UpdateTicket(Booking book, FlightAPI fl) {
        this.booking = book;
        this.flight = fl;
    }

    @Override
    public void changeTicket() {
        double prevFlightPrice = booking.getTicket().getFlight().getPrice();
        double newFlightPrice = flight.getPrice();
        booking.getTicket().setFlight(flight);
        System.out.println(booking.getTicket().getPrice() - prevFlightPrice + newFlightPrice);
        booking.getTicket().setPrice(booking.getTicket().getPrice() - prevFlightPrice + newFlightPrice);
    }

    @Override
    public void cancelTicket() {
        booking.setState(booking.getCanceled());
    }

    @Override
    public String toString() {
        return "Updated Booking for ticket id: " + booking.getTicket().getId() + " , flight: " + booking.getTicket().getFlight().getName();
    }
}
