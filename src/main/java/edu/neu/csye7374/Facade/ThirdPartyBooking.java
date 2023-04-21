package main.java.edu.neu.csye7374.Facade;

import main.java.edu.neu.csye7374.Adapter.TicketAPI;
import main.java.edu.neu.csye7374.Bridge.*;
import main.java.edu.neu.csye7374.Command.CancelFlight;
import main.java.edu.neu.csye7374.Command.ChangeFlight;
import main.java.edu.neu.csye7374.Command.UpdateTicket;
import main.java.edu.neu.csye7374.FlightAPI;
import main.java.edu.neu.csye7374.Observer.Booking;
import main.java.edu.neu.csye7374.Strategy.DiscountAPI;
import main.java.edu.neu.csye7374.Strategy.MemberDiscount;
import main.java.edu.neu.csye7374.Strategy.StudentDiscount;

public class ThirdPartyBooking implements FlightBookingAPI{

    Booking booking;

    @Override
    public void bookFlightTickets(TicketAPI ticket) {
        System.out.println("Booking flight using third party applications!!!");
        booking = new Booking(ticket);
    }

    @Override
    public void change(FlightAPI fl) {
        new ChangeFlight(new UpdateTicket(this.booking, fl)).execute();
    }

    @Override
    public void cancel() {
        new CancelFlight((new UpdateTicket(this.booking, null))).execute();
    }

    public void calculateFinalPrice(DiscountAPI discount) {
        FinalPrice2 finalprice = new FinalPrice2(new Charges2());
        finalprice.setStrategy(discount);
        booking.getTicket().setPrice(finalprice.finalPrice(booking.getTicket().getPrice()));
        booking.getTicket().setPrice(finalprice.finalTaxedPrice(booking.getTicket().getPrice()));
    }

    @Override
    public String toString() {
        return "Booking details are: \nTicket details:" + booking.getTicket().toString() + "\nFlight Details:" +
                booking.getTicket().getFlight().toString();
    }

}
