package main.java.edu.neu.csye7374.Facade;

public class ThirdPartyBooking implements FlightBookingAPI{
    @Override
    public void bookFlightTickets() {
        System.out.println("Booking flight using third party applications!!!");
    }
}
