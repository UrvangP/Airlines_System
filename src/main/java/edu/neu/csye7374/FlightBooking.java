package main.java.edu.neu.csye7374;

import main.java.edu.neu.csye7374.Adapter.TicketAPI;
import main.java.edu.neu.csye7374.Builder.FlightBuilder;
import main.java.edu.neu.csye7374.Builder.TicketBuilder;
import main.java.edu.neu.csye7374.Factories.FlightFactoryAPI;
import main.java.edu.neu.csye7374.Factories.FlightFactoryLazy;
import main.java.edu.neu.csye7374.Factories.TicketFactoryAPI;
import main.java.edu.neu.csye7374.Factories.TicketFactoryLazy;

import java.awt.desktop.SystemEventListener;

public class FlightBooking {

    public static void demo() {

        //Builder Pattern and getting object of Builder using Factory and Singleton Pattern
        System.out.println("***************************************************************************************");
        System.out.println("Demonstrating of Builder pattern. Delegating the responsibilty of creating Flight objects " +
                "to FLight Builder which implements build method and builds flight object for us");
        System.out.println("Using Factory and singleton pattern to get only single instance of Flight object");
        FlightFactoryAPI flightFactory = FlightFactoryLazy.getInstance();
        FlightBuilder builder = new FlightBuilder();
        builder.setName("BOS to SFO");
        builder.setDescription("Flight from Boston to San Fransisco");
        builder.setPrice(220.00);
        FlightAPI flight1 = flightFactory.getObject(builder);
        System.out.println(flight1);

        builder = new FlightBuilder();
        builder.setName("BOS to IAD");
        builder.setDescription("Flight from Boston to Virginia");
        builder.setPrice(80.00);
        builder.setSeatsOccupied(99);
        FlightAPI flight2 = flightFactory.getObject(builder);
        System.out.println(flight2);

        //Prototype Pattern to clone the object of flight
        System.out.println("***************************************************************************************");
        System.out.println("Demonstrating of prototype pattern to clone the object of Flight");
        Flight flight3 = flight1.clone();
        flight3.setName("BOS to DFW");
        flight3.setPrice(150.00);
        flight3.setSeatsOccupied(50);
        flight3.setDescription("Flight from Boston to Dallas");
        System.out.println(flight3);

        System.out.println("***************************************************************************************");
        System.out.println("Demonstrating of Adapter pattern to adapt TicketAPI legacy class with FlightAPI Interface");
        TicketFactoryAPI ticketFactory = TicketFactoryLazy.getInstance();
        TicketBuilder tBuilder = new TicketBuilder();
        tBuilder.setFlight(flight1);
        tBuilder.setName("Urvang");
        TicketAPI ticket1 = ticketFactory.getObject(tBuilder);
        System.out.println(ticket1);





    }
}
