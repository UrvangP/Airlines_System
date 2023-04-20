package main.java.edu.neu.csye7374.Bridge;

public class FinalPrice2 extends FinalPrice1 implements FinalPriceAPI2{

    private ChargesAPI2 charges;
    private double price = 0;

    public FinalPrice2(ChargesAPI2 charge) {
        super(new Charges1());
        charges = charge;
    }


    @Override
    public double finalTaxedPrice(double price) {
        this.price = charges.addTaxes(price);
        return this.price;
    }
}
