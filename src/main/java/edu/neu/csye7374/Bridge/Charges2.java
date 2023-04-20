package main.java.edu.neu.csye7374.Bridge;

public class Charges2 extends Charges1 implements ChargesAPI2{
    @Override
    public double addTaxes(double price) {
        return price + (price*0.18);
    }
}
