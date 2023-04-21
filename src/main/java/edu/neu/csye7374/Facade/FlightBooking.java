package main.java.edu.neu.csye7374.Facade;

import main.java.edu.neu.csye7374.Adapter.TicketAPI;
import main.java.edu.neu.csye7374.FlightAPI;
import main.java.edu.neu.csye7374.Observer.Booking;
import main.java.edu.neu.csye7374.Strategy.DiscountAPI;
import main.java.edu.neu.csye7374.Strategy.NoDiscount;

import java.io.StringReader;

public class FlightBooking {

    private FlightBookingAPI bookingObj;
    private TicketAPI ticket;
    private BookingType type;
    private DiscountAPI discount;

    public FlightBooking(TicketAPI ticket, BookingType type, DiscountAPI discount) {
        this.ticket = ticket;
        this.type = type;

        if(type == BookingType.Direct)
            bookingObj = new DirectBooking();
        else
            bookingObj = new ThirdPartyBooking();

        this.discount = discount;
    }

    public void book() {
        bookingObj.bookFlightTickets(ticket);
    }

    public void changeBooking(FlightAPI fl) {
        bookingObj.change(fl);
    }

    public void cancelBooking() {
        bookingObj.cancel();
    }

    @Override
    public String toString() {
        return bookingObj.toString();
    }

    public void calculateFinalPrice() {
        bookingObj.calculateFinalPrice(discount);
    }
}
