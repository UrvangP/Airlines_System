package main.java.edu.neu.csye7374.Observer;

import main.java.edu.neu.csye7374.Adapter.TicketAPI;
import main.java.edu.neu.csye7374.FlightAPI;

public class QuantityObserver implements BookingObserverAPI{
    @Override
    public void update(Booking booking) {
        TicketAPI ticket = booking.getTicket();
        FlightAPI flight = ticket.getFlight();
        if (flight.getSeatsOccupied() > 100) {
            System.out.println("All the seats in the Flight are booked");
            booking.setState(booking.getCanceled());
        }
        else{
            booking.setState(booking.getConfirmed());
            flight.setSeatsOccupied(flight.getSeatsOccupied()+1);
        }
    }
}
