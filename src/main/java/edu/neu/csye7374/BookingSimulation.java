package main.java.edu.neu.csye7374;

import main.java.edu.neu.csye7374.Adapter.TicketAPI;
import main.java.edu.neu.csye7374.Bridge.Charges1;
import main.java.edu.neu.csye7374.Bridge.FinalPrice1;
import main.java.edu.neu.csye7374.Bridge.FinalPriceAPI1;
import main.java.edu.neu.csye7374.Builder.FlightBuilder;
import main.java.edu.neu.csye7374.Builder.TicketBuilder;
import main.java.edu.neu.csye7374.Command.ChangeFlight;
import main.java.edu.neu.csye7374.Command.CommandAPI;
import main.java.edu.neu.csye7374.Command.UpdateTicket;
import main.java.edu.neu.csye7374.Decorator.Meal;
import main.java.edu.neu.csye7374.Facade.BookingType;
import main.java.edu.neu.csye7374.Facade.FlightBooking;
import main.java.edu.neu.csye7374.Facade.FlightBookingAPI;
import main.java.edu.neu.csye7374.Factories.FlightFactoryAPI;
import main.java.edu.neu.csye7374.Factories.FlightFactoryLazy;
import main.java.edu.neu.csye7374.Factories.TicketFactoryAPI;
import main.java.edu.neu.csye7374.Factories.TicketFactoryLazy;
import main.java.edu.neu.csye7374.Strategy.MemberDiscount;
import main.java.edu.neu.csye7374.Strategy.NoDiscount;
import main.java.edu.neu.csye7374.Strategy.StudentDiscount;

public class BookingSimulation {

    public static void demo() {

        //Builder Pattern and getting object of Builder using Factory and Singleton Pattern
        System.out.println("***************************************************************************************");
        System.out.println("Demonstrating of Builder pattern. Delegating the responsibilty of creating Flight objects " +
                "to FLight Builder which implements build method and builds flight object for us");
        System.out.println("Using Factory and singleton pattern to get only single instance of Flight object");

        System.out.println("\n");
        FlightFactoryAPI flightFactory = FlightFactoryLazy.getInstance();
        FlightBuilder builder = new FlightBuilder();
        builder.setName("BOS to SFO");
        builder.setDescription("Flight from Boston to San Fransisco");
        builder.setPrice(220.00);
        FlightAPI flight1 = flightFactory.getObject(builder);
        System.out.println(flight1);

        System.out.println("\n");
        builder = new FlightBuilder();
        builder.setName("BOS to IAD");
        builder.setDescription("Flight from Boston to Virginia");
        builder.setPrice(80.00);
        builder.setSeatsOccupied(100);
        FlightAPI flight2 = flightFactory.getObject(builder);
        System.out.println(flight2);

        //Prototype Pattern to clone the object of flight
        System.out.println("\n***************************************************************************************");
        System.out.println("Demonstrating of prototype pattern to clone the object of Flight");

        System.out.println("\n");
        Flight flight3 = flight1.clone();
        flight3.setName("BOS to DFW");
        flight3.setPrice(150.00);
        flight3.setSeatsOccupied(50);
        flight3.setDescription("Flight from Boston to Dallas");
        System.out.println(flight3);

        System.out.println("\n***************************************************************************************");
        System.out.println("Demonstrating of Adapter pattern to adapt TicketAPI legacy class with FlightAPI Interface");

        System.out.println("\n");
        TicketFactoryAPI ticketFactory = TicketFactoryLazy.getInstance();
        TicketBuilder tBuilder = new TicketBuilder();
        tBuilder.setFlight(flight1);
        tBuilder.setName("Urvang");
        TicketAPI ticket1 = ticketFactory.getObject(tBuilder);
        System.out.println(ticket1);


        System.out.println("\n");
        tBuilder = new TicketBuilder();
        tBuilder.setFlight(flight2);
        tBuilder.setName("Patel");
        TicketAPI ticket2 = ticketFactory.getObject(tBuilder);
        System.out.println(ticket2);

        System.out.println("\n***************************************************************************************");
        System.out.println("Demonstrating of Decorator pattern to decorate the TicketAPI");

        System.out.println("\n");
        ticket1 = new Meal(ticket1);
        System.out.println(ticket1);

        //Demonstration of facade pattern, State pattern and Observer Pattern
        System.out.println("\n***************************************************************************************");
        System.out.println("Demonstration of Facade pattern to make the ticket booking");
        System.out.println("Demonstration of Strategy pattern to select the booking type");
        System.out.println("Demonstration of State pattern, to change the state of ticket booking from pending to confirmed or canceled");
        System.out.println("Demonstration of Observer pattern, to confirm ticket based on seat availability");

        System.out.println("\n");
        FlightBooking flightBooking1 = new FlightBooking(ticket1, BookingType.getBookingType("direct"), new MemberDiscount());
        flightBooking1.book();
        System.out.println(flightBooking1);

        System.out.println("\n");
        FlightBooking flightBooking2 = new FlightBooking(ticket2, BookingType.getBookingType("thirdparty"), new NoDiscount());
        flightBooking2.book();
        System.out.println(flightBooking2);

        //Demonstration of Bridge Pattern
        System.out.println("\n***************************************************************************************");
        System.out.println("Demonstration of Bridge pattern to calculate final price for the ticket");
        flightBooking1.calculateFinalPrice();
        System.out.println(flightBooking1);
        System.out.println("\n");
        flightBooking2.calculateFinalPrice();
        System.out.println(flightBooking2);

        //Demonstration of Command Pattern
        System.out.println("\n***************************************************************************************");
        System.out.println("Demonstration of Command pattern to update the booked ticket");

        System.out.println("\n");
        flightBooking1.changeBooking(flight3);
        System.out.println(flightBooking1);
        System.out.println("\n");
        flightBooking2.cancelBooking();
        System.out.println(flightBooking2);

    }
}
