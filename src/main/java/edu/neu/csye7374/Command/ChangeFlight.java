package main.java.edu.neu.csye7374.Command;

import main.java.edu.neu.csye7374.FlightAPI;
import main.java.edu.neu.csye7374.Observer.Booking;

public class ChangeFlight implements  CommandAPI{
    private ReceiverAPI receiver;

    public ChangeFlight(ReceiverAPI rec) {
        this.receiver = rec;
    }

    @Override
    public void execute() {
        receiver.changeTicket();
    }
}
