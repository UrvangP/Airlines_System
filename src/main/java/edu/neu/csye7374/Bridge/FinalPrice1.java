package main.java.edu.neu.csye7374.Bridge;

import main.java.edu.neu.csye7374.Strategy.DiscountAPI;
import main.java.edu.neu.csye7374.Strategy.NoDiscount;
import main.java.edu.neu.csye7374.Strategy.StudentDiscount;

public class FinalPrice1 implements FinalPriceAPI1{

    private ChargesAPI1 charges;
    private double price = 0;
    private DiscountAPI strategy;

    public FinalPrice1(ChargesAPI1 charge) {
        charges = charge;
        strategy = new NoDiscount();
    }

    @Override
    public double finalPrice(double price) {
        this.price = charges.addServiceCharge(price);
        return this.price;
    }

    @Override
    public void setStrategy(DiscountAPI s) {
        this.strategy = s;
    }

    @Override
    public double getSum() {
        return this.price;
    }
}
