package main.java.edu.neu.csye7374;

public interface FlightFactoryAPI {
    FlightAPI getObject();
    public FlightAPI getObject(Flight.FlightBuilder b);
}
