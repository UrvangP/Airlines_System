package main.java.edu.neu.csye7374.Command;

public class CancelFlight implements CommandAPI {

    private ReceiverAPI receiver;

    public CancelFlight(ReceiverAPI rec) {
        this.receiver = rec;
    }

    @Override
    public void execute() {
        receiver.cancelTicket();
    }
}
