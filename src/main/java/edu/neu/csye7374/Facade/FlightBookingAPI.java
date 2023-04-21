package main.java.edu.neu.csye7374.Facade;

import main.java.edu.neu.csye7374.Adapter.TicketAPI;
import main.java.edu.neu.csye7374.FlightAPI;
import main.java.edu.neu.csye7374.Observer.Booking;
import main.java.edu.neu.csye7374.Strategy.DiscountAPI;

public interface FlightBookingAPI{
    public void bookFlightTickets(TicketAPI ticket);

    public void change(FlightAPI fl);

    public void cancel();

    public void calculateFinalPrice(DiscountAPI discount);
}
