package main.java.edu.neu.csye7374.Facade;

public class FlightBooking {

    private FlightBookingAPI direct;
    private FlightBookingAPI thidrPaty;

    public FlightBooking() {
        direct = new DirectBooking();
        thidrPaty = new ThirdPartyBooking();
    }

    public void bookDirect() {
        direct.bookFlightTickets();
    }

    public void bookThirdParty() {
        thidrPaty.bookFlightTickets();
    }
}
