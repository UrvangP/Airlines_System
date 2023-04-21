package main.java.edu.neu.csye7374.Factories;

import main.java.edu.neu.csye7374.Adapter.TicketAPI;
import main.java.edu.neu.csye7374.Builder.TicketBuilder;

public interface TicketFactoryAPI {
    TicketAPI getObject();
    public TicketAPI getObject(TicketBuilder b);
}
