package main.java.edu.neu.csye7374.Facade;

import main.java.edu.neu.csye7374.Adapter.TicketAPI;
import main.java.edu.neu.csye7374.Bridge.Charges1;
import main.java.edu.neu.csye7374.Bridge.FinalPrice1;
import main.java.edu.neu.csye7374.Bridge.FinalPriceAPI1;
import main.java.edu.neu.csye7374.Command.CancelFlight;
import main.java.edu.neu.csye7374.Command.ChangeFlight;
import main.java.edu.neu.csye7374.Command.UpdateTicket;
import main.java.edu.neu.csye7374.FlightAPI;
import main.java.edu.neu.csye7374.Observer.Booking;
import main.java.edu.neu.csye7374.Strategy.DiscountAPI;
import main.java.edu.neu.csye7374.Strategy.StudentDiscount;

public class DirectBooking implements FlightBookingAPI{

    Booking booking;

    @Override
    public void bookFlightTickets(TicketAPI ticket) {
        System.out.println("Booking flight direct from the vendor!!!");
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

    @Override
    public String toString() {
        return "Booking details are: \nTicket details:" + booking.getTicket().toString() + "\nFlight Details:" +
                booking.getTicket().getFlight().toString();
    }

    public void calculateFinalPrice(DiscountAPI discount) {
        FinalPriceAPI1 finalprice = new FinalPrice1(new Charges1());
        finalprice.setStrategy(discount);
        booking.getTicket().setPrice(finalprice.finalPrice(booking.getTicket().getPrice()));
    }

}
