package main.java.edu.neu.csye7374;


//Builder Pattern

public class Flight implements FlightAPI{

    private String name;
    private double price;
    private String description;

    public Flight(String name, double price, String desc) {
        this.name = name;
        this.price = price;
        this.description = desc;
    }

    @Override
    public double getPrice() {
        return 0;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getDescription() {
        return null;
    }

    public static class FlightBuilder {

        private double price;
        private String name;
        private String description;

        public FlightBuilder() {
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setDescription(String desc) { this.description = desc; }

        public FlightAPI getItem() {
            return new Flight(name, price, description);
        }
    }
}
