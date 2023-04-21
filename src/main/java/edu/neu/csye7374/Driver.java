package main.java.edu.neu.csye7374;

/**
 * Project Overview:
 * The airport management project is designed to handle various operations that are carried out at an airport,
 * such as managing flights, passengers, and airport staff. The system has different functionalities for different
 * roles, such as an administrator who manages the airport's operations, a customer who wants to book flights,
 * and staff who assist passengers.
 * <p>
 * Design Patterns:
 * <p>
 * Singleton Pattern - This pattern is used to ensure that only one instance of the Airport class is created at runtime.
 * This is important as we want to avoid multiple instances of the Airport class being created, as it may lead to
 * inconsistencies and errors.
 * <p>
 * Factory Pattern - The Factory pattern is used to create objects of different types of flights, such as domestic,
 * international, and cargo flights. This pattern helps to encapsulate the object creation logic and simplifies the
 * creation of objects of different types.
 * <p>
 * Strategy Pattern - The Strategy pattern is used to select a specific algorithm at runtime from a set of algorithms
 * that perform the same task differently. For example, calculating the ticket price for different types of flights
 * can be done using different algorithms. The Strategy pattern allows us to choose the appropriate algorithm based
 * on the flight type.
 * <p>
 * Adapter Pattern - The Adapter pattern is used to convert the interface of a class into another interface that the
 * client expects. In our airport management project, we can use the Adapter pattern to adapt the payment gateway to
 * different payment methods.
 * <p>
 * Decorator Pattern - The Decorator pattern is used to dynamically add functionality to an object without changing
 * its behavior. In our airport management project, we can use the Decorator pattern to add additional features to the
 * flight booking process, such as adding meals or extra luggage.
 * <p>
 * Builder Pattern - The Builder pattern is used to create complex objects step by step. In our airport management
 * project, we can use the Builder pattern to create a flight booking system that allows customers to choose different
 * options for their flights, such as seat selection and meal preferences.
 * <p>
 * Bridge Pattern - The Bridge pattern is used to decouple an abstraction from its implementation so that both can
 * vary independently. In our airport management project, we can use the Bridge pattern to decouple the payment
 * processing system from the booking system.
 * <p>
 * Prototype Pattern - The Prototype pattern is used to create a new object by cloning an existing object. In our
 * airport management project, we can use the Prototype pattern to create a copy of a flight booking and modify it
 * to make a new booking.
 * <p>
 * State Pattern - The State pattern is used to change the behavior of an object based on its internal state. In our
 * airport management project, we can use the State pattern to change the behavior of the flight booking system based
 * on the booking status, such as confirmed or cancelled.
 * <p>
 * Command Pattern - The Command pattern is used to encapsulate a request as an object, thereby allowing us to
 * parameterize clients with different requests, queue or log requests, and support undoable operations. In our
 * airport management project, we can use the Command pattern to handle different types of user requests, such as
 * cancelling a booking or changing a flight.
 * <p>
 * Facade Pattern - The Facade pattern is used to provide a simplified interface to a complex system. In our airport
 * management project, we can use the Facade pattern to provide a simplified interface for the flight booking system
 * to the customers.
 * <p>
 * Observer Pattern - The Observer pattern is used to define a one-to-many dependency between objects, so that when
 * one object changes state, all its dependents are notified and updated automatically. In our airport management
 * project, we can use the Observer pattern to notify the passengers about any changes in their flight status.
 */

public class Driver {
    public static void main(String[] args) {
        System.out.println("============Main Execution Start===================\n\n");

        //Add your code in between these two print statements
        FlightBooking.demo();

        System.out.println("\n\n============Main Execution End===================");
    }
}
