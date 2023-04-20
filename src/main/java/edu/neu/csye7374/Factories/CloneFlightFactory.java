package main.java.edu.neu.csye7374.Factories;

import main.java.edu.neu.csye7374.FlightAPI;

import java.util.HashMap;
import java.util.Map;

public class CloneFlightFactory implements CloneFlightFacotryAPI{

    private Map<Integer, FlightAPI> prototypeList = new HashMap<>();
    private static CloneFlightFacotryAPI instance = new CloneFlightFactory();

    private CloneFlightFactory() {}

    public static CloneFlightFacotryAPI getInstance() {
        return instance;
    }

    @Override
    public void load(int id, FlightAPI prototype) {
        prototypeList.put(id, prototype);
    }

    @Override
    public FlightAPI getObject(int id) {
        FlightAPI prototype = prototypeList.get(id);
        try {
            return (FlightAPI) prototype.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
