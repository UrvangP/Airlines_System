package main.java.edu.neu.csye7374.Command;

import main.java.edu.neu.csye7374.Adapter.Booking;
import main.java.edu.neu.csye7374.TicketAPI;

public class BookTicket implements PaymentAPI{

    TicketAPI booking = new Booking();

    @Override
    public void creditCard() {

    }

    @Override
    public void applePay() {

    }

    @Override
    public void googlePay() {

    }
}
