package main.java.edu.neu.csye7374.Factories;

import main.java.edu.neu.csye7374.FlightAPI;

public interface CloneFlightFacotryAPI {


    public void load(int id, FlightAPI prototype);

    public FlightAPI getObject(int id);

}
