package main.java.edu.neu.csye7374.Command;

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
