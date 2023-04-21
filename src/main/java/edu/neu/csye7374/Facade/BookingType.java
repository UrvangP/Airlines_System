package main.java.edu.neu.csye7374.Facade;

public enum BookingType {
    Direct,
    ThirdParty;

    public static BookingType getBookingType(String s) {

        switch(s.toLowerCase()){
            case "direct":
                System.out.println("Direct booking strategy selected");
                return Direct;
            case "thirdparty":
                System.out.println("Third party booking strategy selected");
                return ThirdParty;
            default:
                System.out.println("Direct booking strategy selected");
                return Direct;
        }
    }
}