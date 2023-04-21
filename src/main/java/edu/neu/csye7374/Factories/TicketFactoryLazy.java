package main.java.edu.neu.csye7374.Factories;

import main.java.edu.neu.csye7374.Adapter.TicketAPI;
import main.java.edu.neu.csye7374.Builder.TicketBuilder;

public class TicketFactoryLazy implements TicketFactoryAPI{

    private static TicketFactoryAPI instance;

    private TicketFactoryLazy() {
    }

    public static synchronized TicketFactoryAPI getInstance() {
        if (instance == null) {
            instance = new TicketFactoryLazy();
        }

        return instance;
    }

    @Override
    public TicketAPI getObject() {
        return new TicketBuilder().getItem();
    }

    @Override
    public TicketAPI getObject(TicketBuilder b) {
        return b.getItem();
    }
}
