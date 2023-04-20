package main.java.edu.neu.csye7374.Strategy;

public class StudentDiscount implements DiscountAPI{
    @Override
    public double apply(double price) {
        return price * 0.10;
    }
}
