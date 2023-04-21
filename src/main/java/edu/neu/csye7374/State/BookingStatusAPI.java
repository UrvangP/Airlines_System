package main.java.edu.neu.csye7374.State;

public interface BookingStatusAPI {
    public void pending();

    public void confirmed();

    public void canceled();
}
