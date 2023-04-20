package main.java.edu.neu.csye7374.Strategy;

public class NoDiscount implements DiscountAPI{
    @Override
    public double apply(double price) {
        return price;
    }
}
