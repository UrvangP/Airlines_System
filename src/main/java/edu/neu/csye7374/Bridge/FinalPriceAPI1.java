package main.java.edu.neu.csye7374.Bridge;

import main.java.edu.neu.csye7374.Strategy.DiscountAPI;

public interface FinalPriceAPI1 {
    double finalPrice(double price);
    void setStrategy(DiscountAPI s);
    double getSum();
}
