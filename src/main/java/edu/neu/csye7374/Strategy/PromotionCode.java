package main.java.edu.neu.csye7374.Strategy;

public class PromotionCode implements DiscountAPI{
    @Override
    public double apply(double price) {
        return price * 0.15;
    }
}
