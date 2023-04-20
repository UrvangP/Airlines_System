package main.java.edu.neu.csye7374.Bridge;

public class Charges1 implements ChargesAPI1{
    @Override
    public double addServiceCharge(double price) {
        return price + (price*0.15);
    }
}
