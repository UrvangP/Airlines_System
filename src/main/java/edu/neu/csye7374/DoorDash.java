package main.java.edu.neu.csye7374;

import java.util.*;

/**
 * Project Overview:
 * The airport management project is designed to handle various operations that are carried out at an airport,
 * such as managing flights, passengers, and airport staff. The system has different functionalities for different
 * roles, such as an administrator who manages the airport's operations, a customer who wants to book flights,
 * and staff who assist passengers.
 * <p>
 * Design Patterns:
 * <p>
 * Singleton Pattern - This pattern is used to ensure that only one instance of the Airport class is created at runtime.
 * This is important as we want to avoid multiple instances of the Airport class being created, as it may lead to
 * inconsistencies and errors.
 * <p>
 * Factory Pattern - The Factory pattern is used to create objects of different types of flights, such as domestic,
 * international, and cargo flights. This pattern helps to encapsulate the object creation logic and simplifies the
 * creation of objects of different types.
 * <p>
 * Strategy Pattern - The Strategy pattern is used to select a specific algorithm at runtime from a set of algorithms
 * that perform the same task differently. For example, calculating the ticket price for different types of flights
 * can be done using different algorithms. The Strategy pattern allows us to choose the appropriate algorithm based
 * on the flight type.
 * <p>
 * Adapter Pattern - The Adapter pattern is used to convert the interface of a class into another interface that the
 * client expects. In our airport management project, we can use the Adapter pattern to adapt the payment gateway to
 * different payment methods.
 * <p>
 * Decorator Pattern - The Decorator pattern is used to dynamically add functionality to an object without changing
 * its behavior. In our airport management project, we can use the Decorator pattern to add additional features to the
 * flight booking process, such as adding meals or extra luggage.
 * <p>
 * Builder Pattern - The Builder pattern is used to create complex objects step by step. In our airport management
 * project, we can use the Builder pattern to create a flight booking system that allows customers to choose different
 * options for their flights, such as seat selection and meal preferences.
 * <p>
 * Bridge Pattern - The Bridge pattern is used to decouple an abstraction from its implementation so that both can
 * vary independently. In our airport management project, we can use the Bridge pattern to decouple the payment
 * processing system from the booking system.
 * <p>
 * Prototype Pattern - The Prototype pattern is used to create a new object by cloning an existing object. In our
 * airport management project, we can use the Prototype pattern to create a copy of a flight booking and modify it
 * to make a new booking.
 * <p>
 * State Pattern - The State pattern is used to change the behavior of an object based on its internal state. In our
 * airport management project, we can use the State pattern to change the behavior of the flight booking system based
 * on the booking status, such as confirmed or cancelled.
 * <p>
 * Command Pattern - The Command pattern is used to encapsulate a request as an object, thereby allowing us to
 * parameterize clients with different requests, queue or log requests, and support undoable operations. In our
 * airport management project, we can use the Command pattern to handle different types of user requests, such as
 * cancelling a booking or changing a flight.
 * <p>
 * Facade Pattern - The Facade pattern is used to provide a simplified interface to a complex system. In our airport
 * management project, we can use the Facade pattern to provide a simplified interface for the flight booking system
 * to the customers.
 * <p>
 * Observer Pattern - The Observer pattern is used to define a one-to-many dependency between objects, so that when
 * one object changes state, all its dependents are notified and updated automatically. In our airport management
 * project, we can use the Observer pattern to notify the passengers about any changes in their flight status.
 */
public class DoorDash {

    /**
     * ItemAPI implemented by all Item objects for sale
     *
     * @author dpeters
     */
    private interface ItemAPI {
        double getPrice();

        String getName();
    }

    /**
     * OrderAPI implemented by all Order objects for customer orders
     *
     * @author dpeters
     */
    private interface OrderAPI {
        int getId();

        double getPrice();

        String getName();

        String getDescription();
    }


    /**
     * Student ToDO:
     * Adapter Design Pattern:
     * <p>
     * 4. Develop inner class OrderAdapter using Adapter design pattern,
     * to adapt Order to use an ItemAPI object
     */
    public static class OrderAdapter implements OrderAPI {

        private ItemAPI item;
        int id;
        String description;

        public OrderAdapter(ItemAPI item, int id, String desc) {
            this.item = item;
            this.id = id;
            this.description = desc;
        }

        @Override
        public int getId() {
            return id;
        }

        @Override
        public double getPrice() {
            return item.getPrice();
        }

        @Override
        public String getName() {
            return item.getName();
        }

        @Override
        public String getDescription() {
            return description;
        }
    }


    /**
     * Student ToDO:
     * Builder Design Pattern:
     * <p>
     * Using Builder design pattern, develop inner class ItemBuilder
     * to custom configure an Item object
     */

    public static class Item implements ItemAPI {

        private double price;
        private String name;

        public Item(String name, double price) {
            this.name = name;
            this.price = price;
        }

        @Override
        public double getPrice() {
            return price;
        }

        @Override
        public String getName() {
            return name;
        }

        public static class ItemBuilder {

            private double price;
            private String name;

            public ItemBuilder() {
            }

            public void setPrice(double price) {
                this.price = price;
            }

            public void setName(String name) {
                this.name = name;
            }

            public ItemAPI getItem() {
                return new Item(name, price);
            }
        }
    }

    public static class FrenchFries {

        public ItemAPI buildItem() {
            ItemFactoryLazySingleton instance = ItemFactoryLazySingleton.getInstance();
            Item.ItemBuilder builder = new Item.ItemBuilder();
            builder.setName("French Fries");
            builder.setPrice(0.99);
            return instance.getObject(builder);
        }
    }

    public static class MediumDark {

        public ItemAPI buildItem() {
            ItemFactoryEagerSingleton instance = ItemFactoryEagerSingleton.getInstance();
            Item.ItemBuilder builder = new Item.ItemBuilder();
            builder.setName("Medium Dark");
            builder.setPrice(1.29);
            return instance.getObject(builder);
        }
    }

    public static class Hamburger {

        public ItemAPI buildItem() {
            ItemFactoryEnumSingleton instance = ItemFactoryEnumSingleton.INSTANCE;
            Item.ItemBuilder builder = new Item.ItemBuilder();
            builder.setName("Hamburger");
            builder.setPrice(3.49);
            return instance.getObject(builder);
        }
    }

    public static class Hotdog {

        public ItemAPI buildItem() {
            ItemFactoryLazySingleton instance = ItemFactoryLazySingleton.getInstance();
            Item.ItemBuilder builder = new Item.ItemBuilder();
            builder.setName("Hotdog");
            builder.setPrice(1.49);
            return instance.getObject(builder);
        }
    }

    public static class Cheeseburger {

        public ItemAPI buildItem() {
            ItemFactoryEagerSingleton instance = ItemFactoryEagerSingleton.getInstance();
            Item.ItemBuilder builder = new Item.ItemBuilder();
            builder.setName("Cheeseburger");
            builder.setPrice(3.79);
            return instance.getObject(builder);
        }
    }

    public static class Buffalowings {

        public ItemAPI buildItem() {
            ItemFactoryEnumSingleton instance = ItemFactoryEnumSingleton.INSTANCE;
            Item.ItemBuilder builder = new Item.ItemBuilder();
            builder.setName("Buffalo Wings");
            builder.setPrice(4.49);
            return instance.getObject(builder);
        }
    }

    public static class Salad {

        public ItemAPI buildItem() {
            ItemFactoryLazySingleton instance = ItemFactoryLazySingleton.getInstance();
            Item.ItemBuilder builder = new Item.ItemBuilder();
            builder.setName("Salad");
            builder.setPrice(2.49);
            return instance.getObject(builder);
        }
    }

    public static class Pizza {

        public ItemAPI buildItem() {
            ItemFactoryEagerSingleton instance = ItemFactoryEagerSingleton.getInstance();
            Item.ItemBuilder builder = new Item.ItemBuilder();
            builder.setName("Pizza");
            builder.setPrice(5.49);
            return instance.getObject(builder);
        }
    }


    /**
     * Student ToDO:
     * Composite Design Pattern:
     * <p>
     * Using Composite and Builder design pattern,
     * develop inner classes:
     * <p>
     * Order, IndividualOrder, IndividualOrderBuilder,
     * ComboOrder and ComboOrderBuilder
     */

    public interface OrderComponentAPI {
        public void addItem(String ord);

        public List<OrderAPI> getOrder();
    }

    public interface OrderBuilderAPI {
        public OrderComponentAPI getOrder();
    }


    public static class IndividaulOrder implements OrderComponentAPI {
        private List<OrderAPI> orders = new ArrayList<>();

        int id;

        String description;

        public IndividaulOrder(int id, String desc) {
            this.id = id;
            this.description = desc;
        }

        @Override
        public List<OrderAPI> getOrder() {
            return orders;
        }

        @Override
        public void addItem(String ord) {
            if (ord.equalsIgnoreCase("French Fries")) {
                orders.add(new OrderAdapter(new FrenchFries().buildItem(), this.id, this.description));
            } else if (ord.equalsIgnoreCase("Medium Drink")) {
                orders.add(new OrderAdapter(new MediumDark().buildItem(), this.id, this.description));
            } else if (ord.equalsIgnoreCase("Hamburger")) {
                orders.add(new OrderAdapter(new Hamburger().buildItem(), this.id, this.description));
            } else if (ord.equalsIgnoreCase("Hot Dog")) {
                orders.add(new OrderAdapter(new Hotdog().buildItem(), this.id, this.description));
            } else if (ord.equalsIgnoreCase("Cheeseburger")) {
                orders.add(new OrderAdapter(new Cheeseburger().buildItem(), this.id, this.description));
            } else if (ord.equalsIgnoreCase("Buffalo Wings")) {
                orders.add(new OrderAdapter(new Buffalowings().buildItem(), this.id, this.description));
            } else if (ord.equalsIgnoreCase("Salad")) {
                orders.add(new OrderAdapter(new Salad().buildItem(), this.id, this.description));
            } else if (ord.equalsIgnoreCase("Pizza")) {
                orders.add(new OrderAdapter(new Pizza().buildItem(), this.id, this.description));
            }
        }

        public static class IndividualOrderbuilder implements OrderBuilderAPI {

            int id;

            String description;

            List<String> itemName;

            public IndividualOrderbuilder() {
            }

            public void setId(int id) {
                this.id = id;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public void setItemName(List<String> itemName) {
                this.itemName = itemName;
            }

            public OrderComponentAPI getOrder() {
                OrderComponentAPI order = new IndividaulOrder(this.id, this.description);
                for (String item : itemName) {
                    order.addItem(item);
                }
                return order;
            }
        }

    }

    public static class ComboOrder implements OrderComponentAPI {
        private List<OrderAPI> orders = new ArrayList<>();

        int id;

        String description;

        public ComboOrder(int id, String desc) {
            this.id = id;
            this.description = desc;
        }

        @Override
        public List<OrderAPI> getOrder() {
            return orders;
        }

        @Override
        public void addItem(String ord) {
            if (ord.equalsIgnoreCase("French Fries")) {
                orders.add(new OrderAdapter(new FrenchFries().buildItem(), this.id, this.description));
            } else if (ord.equalsIgnoreCase("Medium Drink")) {
                orders.add(new OrderAdapter(new MediumDark().buildItem(), this.id, this.description));
            } else if (ord.equalsIgnoreCase("Hamburger")) {
                orders.add(new OrderAdapter(new Hamburger().buildItem(), this.id, this.description));
            } else if (ord.equalsIgnoreCase("Hot Dog")) {
                orders.add(new OrderAdapter(new Hotdog().buildItem(), this.id, this.description));
            } else if (ord.equalsIgnoreCase("Cheeseburger")) {
                orders.add(new OrderAdapter(new Cheeseburger().buildItem(), this.id, this.description));
            } else if (ord.equalsIgnoreCase("Buffalo Wings")) {
                orders.add(new OrderAdapter(new Buffalowings().buildItem(), this.id, this.description));
            } else if (ord.equalsIgnoreCase("Salad")) {
                orders.add(new OrderAdapter(new Salad().buildItem(), this.id, this.description));
            } else if (ord.equalsIgnoreCase("Pizza")) {
                orders.add(new OrderAdapter(new Pizza().buildItem(), this.id, this.description));
            }
        }

        public static class ComboOrderBuilder implements OrderBuilderAPI {

            int id;

            String description;

            List<String> itemName;

            public ComboOrderBuilder() {
            }

            public void setId(int id) {
                this.id = id;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public void setItemName(List<String> itemName) {
                this.itemName = itemName;
            }

            public OrderComponentAPI getOrder() {
                OrderComponentAPI order = new ComboOrder(this.id, this.description);
                for (String item : itemName) {
                    order.addItem(item);
                }
                return order;
            }
        }
    }


    public static class Order {
        List<OrderComponentAPI> orders = new ArrayList<>();

        public List<OrderComponentAPI> getOrders() {
            return orders;
        }

        public void placeOrders() {
            //Dan's Order
            IndividualOrderComponentFactoryEagerSingleton instance = IndividualOrderComponentFactoryEagerSingleton.getInstance();
            IndividaulOrder.IndividualOrderbuilder builder = new IndividaulOrder.IndividualOrderbuilder();
            builder.setId(1);
            builder.setDescription("Dan's Customer Door Dash Order ID #1 Hamburger, Medium Drink");
            List<String> items = new ArrayList<>();
            items.add("Hamburger");
            items.add("Medium Drink");
            builder.setItemName(items);
            orders.add(instance.getObject(builder));

            //Pam's Order
            ComboOrderComponentFactoryEagerSingleton instance1 = ComboOrderComponentFactoryEagerSingleton.getInstance();
            ComboOrder.ComboOrderBuilder builder1 = new ComboOrder.ComboOrderBuilder();
            builder1.setId(2);
            builder1.setDescription("Pam's Customer Door Dash Order ID #2 HotDogCombo (HotDog, French Fries, Medium Drink)");
            List<String> itemNames = new ArrayList<>();
            itemNames.add("Hot Dog");
            itemNames.add("French Fries");
            itemNames.add("Medium Drink");
            builder1.setItemName(itemNames);
            orders.add(instance1.getObject(builder1));

            //Jim's Order
            ComboOrderComponentFactoryLazySingleton instance2 = ComboOrderComponentFactoryLazySingleton.getInstance();
            ComboOrder.ComboOrderBuilder builder2 = new ComboOrder.ComboOrderBuilder();
            builder2.setId(3);
            builder2.setDescription("Jim's Customer Door Dash Order ID #3 BurgerCombo (Hamburger, French Fries, Medium Drink)");
            List<String> itemNames1 = new ArrayList<>();
            itemNames1.add("Hamburger");
            itemNames1.add("French Fries");
            itemNames1.add("Medium Drink");
            builder2.setItemName(itemNames1);
            orders.add(instance2.getObject(builder2));

            //Jen's Customer Door Dash Order ID #4 Cheeseburger, French Fries
            IndividualOrderComponentFactoryLazySingleton instance3 = IndividualOrderComponentFactoryLazySingleton.getInstance();
            IndividaulOrder.IndividualOrderbuilder builder3 = new IndividaulOrder.IndividualOrderbuilder();
            builder3.setId(4);
            builder3.setDescription("Jen's Customer Door Dash Order ID #4 Cheeseburger, French Fries");
            List<String> items1 = new ArrayList<>();
            items1.add("Hamburger");
            items1.add("Medium Drink");
            builder3.setItemName(items1);
            orders.add(instance3.getObject(builder3));

            //Len's Order
            ComboOrderComponentFactoryLazySingleton instance4 = ComboOrderComponentFactoryLazySingleton.getInstance();
            ComboOrder.ComboOrderBuilder builder4 = new ComboOrder.ComboOrderBuilder();
            builder4.setId(5);
            builder4.setDescription("Len's Customer Door Dash Order ID #5 WingCombo (Buffalo Wings, Medium Drink, Salad)");
            List<String> itemNames3 = new ArrayList<>();
            itemNames3.add("Buffalo Wings");
            itemNames3.add("Medium Drink");
            itemNames3.add("Salad");
            builder4.setItemName(itemNames3);
            orders.add(instance4.getObject(builder4));

            //Sam's Order
            ComboOrderComponentFactoryEnumSingleton instance5 = ComboOrderComponentFactoryEnumSingleton.INSTANCE;
            ComboOrder.ComboOrderBuilder builder5 = new ComboOrder.ComboOrderBuilder();
            builder5.setId(6);
            builder5.setDescription("Sam's Customer Door Dash Order ID #6 PizzaCombo (Buffalo Wings, French Fries, Salad, Medium Drink, Pizza)");
            List<String> itemNames4 = new ArrayList<>();
            itemNames4.add("Buffalo Wings");
            itemNames4.add("Medium Drink");
            itemNames4.add("French Fries");
            itemNames4.add("Salad");
            itemNames4.add("Pizza");
            builder5.setItemName(itemNames4);
            orders.add(instance5.getObject(builder5));
        }
    }


    /**
     * Student ToDO:
     * Decorator Design Pattern:
     * <p>
     * Using Decorator design pattern,
     * develop inner classes:
     * <p>
     * ItemDecoratorAPI, and others as needed for all ItemAPI options
     */
    public static abstract class ItemDecoratorAPI implements ItemAPI {
        @Override
        public double getPrice() {
            return 0.0;
        }

        @Override
        public String getName() {
            return "";
        }
    }

    public static class Cheese extends ItemDecoratorAPI {

        private ItemAPI item;

        public Cheese(ItemAPI item) {
            this.item = item;
        }

        @Override
        public double getPrice() {
            return item.getPrice() + 1;
        }

        @Override
        public String getName() {
            return item.getName() + " Cheese";
        }

    }

    public static class Mushroom extends ItemDecoratorAPI {

        private ItemAPI item;

        public Mushroom(ItemAPI item) {
            this.item = item;
        }

        @Override
        public double getPrice() {
            return item.getPrice() + 1;
        }

        @Override
        public String getName() {
            return item.getName() + " Mushroom";
        }

    }

    public static class Onion extends ItemDecoratorAPI {

        private ItemAPI item;

        public Onion(ItemAPI item) {
            this.item = item;
        }

        @Override
        public double getPrice() {
            return item.getPrice() + 1;
        }

        @Override
        public String getName() {
            return item.getName() + " Onion";
        }

    }

    public static class Pepperoni extends ItemDecoratorAPI {

        private ItemAPI item;

        public Pepperoni(ItemAPI item) {
            this.item = item;
        }

        @Override
        public double getPrice() {
            return item.getPrice() + 1;
        }

        @Override
        public String getName() {
            return item.getName() + " Pepperoni";
        }

    }

    public static class Sausage extends ItemDecoratorAPI {

        private ItemAPI item;

        public Sausage(ItemAPI item) {
            this.item = item;
        }

        @Override
        public double getPrice() {
            return item.getPrice() + 1;
        }

        @Override
        public String getName() {
            return item.getName() + " Sausage";
        }

    }


    /**
     * Student ToDO:
     * Factory Design Pattern:
     *
     * Using Factory design pattern and supplied ItemFactoryAPI,
     * develop inner classes:
     *
     * ItemFactory, ItemFactoryEnumSingleton,
     * ItemFactoryEagerSingleton and ItemFactoryLazySingleton
     *
     * Using Factory design pattern and supplied OrderComponentFactoryAPI,
     * develop inner classes:
     *
     * IndividualOrderComponentFactory, IndividualOrderComponentFactoryEnumSingleton,
     * IndividualOrderComponentFactoryEagerSingleton and IndividualOrderComponentFactoryLazySingleton
     *
     * ComboOrderComponentFactory, ComboOrderComponentFactoryEnumSingleton,
     * ComboOrderComponentFactoryEagerSingleton and ComboOrderComponentFactoryLazySingleton
     */

    /**
     * ItemFactoryAPI for Factory method design pattern
     *
     * @author dpeters
     */
    private interface ItemFactoryAPI {
        ItemAPI getObject();

        ItemAPI getObject(Item.ItemBuilder b);
    }

    public static class ItemFactory implements ItemFactoryAPI {

        @Override
        public ItemAPI getObject() {
            return new Item.ItemBuilder().getItem();
        }

        @Override
        public ItemAPI getObject(Item.ItemBuilder b) {
            return b.getItem();
        }
    }

    public static class ItemFactoryEagerSingleton implements ItemFactoryAPI {
        private static ItemFactoryEagerSingleton instance = new ItemFactoryEagerSingleton();

        private ItemFactoryEagerSingleton() {
        }

        public static ItemFactoryEagerSingleton getInstance() {
            return instance;
        }

        @Override
        public ItemAPI getObject() {
            return new Item.ItemBuilder().getItem();
        }

        @Override
        public ItemAPI getObject(Item.ItemBuilder b) {
            return b.getItem();
        }

    }

    public static class ItemFactoryLazySingleton implements ItemFactoryAPI {

        private static ItemFactoryLazySingleton instance;

        private ItemFactoryLazySingleton() {
        }

        public static synchronized ItemFactoryLazySingleton getInstance() {
            if (instance == null) {
                instance = new ItemFactoryLazySingleton();
            }

            return instance;
        }

        @Override
        public ItemAPI getObject() {
            return new Item.ItemBuilder().getItem();
        }

        @Override
        public ItemAPI getObject(Item.ItemBuilder b) {
            return b.getItem();
        }
    }

    public static enum ItemFactoryEnumSingleton implements ItemFactoryAPI {
        INSTANCE;

        @Override
        public ItemAPI getObject() {
            return new Item.ItemBuilder().getItem();
        }

        @Override
        public ItemAPI getObject(Item.ItemBuilder b) {
            return b.getItem();
        }
    }


    /**
     * OrderComponentFactoryAPI for Factory method design pattern
     *
     * @author dpeters
     */
    private interface OrderComponentFactoryAPI {
        OrderComponentAPI getObject();

        OrderComponentAPI getObject(OrderBuilderAPI b);
    }

//	public static class OrderComponent implements OrderComponentAPI {}

    public static class IndividualOrderComponentFactory implements OrderComponentFactoryAPI {

        @Override
        public OrderComponentAPI getObject() {
            return new IndividaulOrder.IndividualOrderbuilder().getOrder();
        }

        @Override
        public OrderComponentAPI getObject(OrderBuilderAPI b) {
            return b.getOrder();
        }
    }

    public static class IndividualOrderComponentFactoryEagerSingleton implements OrderComponentFactoryAPI {
        private static IndividualOrderComponentFactoryEagerSingleton instance = new IndividualOrderComponentFactoryEagerSingleton();

        private IndividualOrderComponentFactoryEagerSingleton() {
        }

        public static IndividualOrderComponentFactoryEagerSingleton getInstance() {
            return instance;
        }

        @Override
        public OrderComponentAPI getObject() {
            return new IndividaulOrder.IndividualOrderbuilder().getOrder();
        }

        @Override
        public OrderComponentAPI getObject(OrderBuilderAPI b) {
            return b.getOrder();
        }
    }

    public static class IndividualOrderComponentFactoryLazySingleton implements OrderComponentFactoryAPI {

        private static IndividualOrderComponentFactoryLazySingleton instance;

        private IndividualOrderComponentFactoryLazySingleton() {
        }

        public static synchronized IndividualOrderComponentFactoryLazySingleton getInstance() {
            if (instance == null) {
                instance = new IndividualOrderComponentFactoryLazySingleton();
            }

            return instance;
        }

        @Override
        public OrderComponentAPI getObject() {
            return new IndividaulOrder.IndividualOrderbuilder().getOrder();
        }

        @Override
        public OrderComponentAPI getObject(OrderBuilderAPI b) {
            return b.getOrder();
        }

    }

    public static enum IndividualOrderComponentFactoryEnumSingleton implements OrderComponentFactoryAPI {
        INSTANCE;

        @Override
        public OrderComponentAPI getObject() {
            return new IndividaulOrder.IndividualOrderbuilder().getOrder();
        }

        @Override
        public OrderComponentAPI getObject(OrderBuilderAPI b) {
            return b.getOrder();
        }
    }


    public static class ComboOrderComponentFactory implements OrderComponentFactoryAPI {

        @Override
        public OrderComponentAPI getObject() {
            return new ComboOrder.ComboOrderBuilder().getOrder();
        }

        @Override
        public OrderComponentAPI getObject(OrderBuilderAPI b) {
            return b.getOrder();
        }
    }

    public static class ComboOrderComponentFactoryEagerSingleton implements OrderComponentFactoryAPI {
        private static ComboOrderComponentFactoryEagerSingleton instance = new ComboOrderComponentFactoryEagerSingleton();

        private ComboOrderComponentFactoryEagerSingleton() {
        }

        public static ComboOrderComponentFactoryEagerSingleton getInstance() {
            return instance;
        }

        @Override
        public OrderComponentAPI getObject() {
            return new ComboOrder.ComboOrderBuilder().getOrder();
        }

        @Override
        public OrderComponentAPI getObject(OrderBuilderAPI b) {
            return b.getOrder();
        }
    }

    public static class ComboOrderComponentFactoryLazySingleton implements OrderComponentFactoryAPI {

        private static ComboOrderComponentFactoryLazySingleton instance;

        private ComboOrderComponentFactoryLazySingleton() {
        }

        public static synchronized ComboOrderComponentFactoryLazySingleton getInstance() {
            if (instance == null) {
                instance = new ComboOrderComponentFactoryLazySingleton();
            }

            return instance;
        }

        @Override
        public OrderComponentAPI getObject() {
            return new ComboOrder.ComboOrderBuilder().getOrder();
        }

        @Override
        public OrderComponentAPI getObject(OrderBuilderAPI b) {
            return b.getOrder();
        }

    }

    public static enum ComboOrderComponentFactoryEnumSingleton implements OrderComponentFactoryAPI {
        INSTANCE;

        @Override
        public OrderComponentAPI getObject() {
            return new ComboOrder.ComboOrderBuilder().getOrder();
        }

        @Override
        public OrderComponentAPI getObject(OrderBuilderAPI b) {
            return b.getOrder();
        }
    }


    /**
     * Student ToDO:
     * Strategy Design Pattern:
     * <p>
     * Using Strategy design pattern to change retail prices:
     * NormalDiscount (0% decrease), MemberDiscount (10% decrease),
     * SpecialDiscount (20% discount), SuperBowlDiscount (20% increase)
     */

    public interface PriceStrategyAPI {
        public double applyDiscount(double price);
    }

    public static class NormalDiscount implements PriceStrategyAPI {

        @Override
        public double applyDiscount(double price) {
            return price;
        }
    }

    public static class MemberDiscount implements PriceStrategyAPI {

        @Override
        public double applyDiscount(double price) {
            return price * 0.9;
        }
    }

    public static class SpecialDiscount implements PriceStrategyAPI {

        @Override
        public double applyDiscount(double price) {
            return price * 0.8;
        }
    }

    public static class SuperBowlDiscount implements PriceStrategyAPI {

        @Override
        public double applyDiscount(double price) {
            return price * 1.2;
        }
    }


    /**
     * Student ToDO:
     * Bridge Design Pattern:
     * <p>
     * Develop TWO Point of Sale APIs for Order purchases with DISCOUNTS (to change prices):
     * Using Bridge design pattern to in TWO design phases
     * developing inner interfaces PosAPI1, PosAPI2, CalculatorAPI1, CalculatorAPI2 and
     * developing inner classes Pos1, Pos2, Calculator1 and Calculator2
     */
    public interface PosAPI1 {
        double sumTotal(List<Double> itemList); // add customer total

        void setStrategy(PriceStrategyAPI s);    // set strategy for price adjustments

        double getSum();    // return sum total

        String toStringSumTotal();    // return String representation of sum total
    }

    public interface PosAPI2 {
        double getChange(double cash);        // accept cash, return change

        String toStringCash();        // return String representation of customer cash submitted

        String toStringChange();    // return String representation of customer change received
    }

    public interface CalculatorAPI1 {
        double add(double a, double b);
    }

    public interface CalculatorAPI2 {
        double sub(double a, double b);

        double mult(double a, double b);

        double div(double a, double b);
    }

    public static class Pos1 implements PosAPI1 {

        private CalculatorAPI1 calculator;
        private double oSum = 0;
        private PriceStrategyAPI strategy;

        public Pos1(CalculatorAPI1 cal) {
            calculator = cal;
            strategy = new NormalDiscount();
        }

        @Override
        public double sumTotal(List<Double> value) {
            oSum = 0;
            for (double d : value) {
                oSum = calculator.add(oSum, d);
            }

            oSum = strategy.applyDiscount(oSum);

            return oSum;
        }

        @Override
        public void setStrategy(PriceStrategyAPI s) {
            this.strategy = s;
        }

        @Override
        public double getSum() {
            return oSum;
        }

        @Override
        public String toStringSumTotal() {
            return String.valueOf(oSum);
        }

        @Override
        public String toString() {
            return "Price: " + this.toStringSumTotal();
        }

    }

    public static class Pos2 extends Pos1 implements PosAPI2 {

        private CalculatorAPI2 calculator;
        private double cash = 0;
        private double change = 0;

        public Pos2(CalculatorAPI2 cal) {
            super(new Calculator1());
            calculator = cal;
        }

        @Override
        public double getChange(double cash) {
            this.cash = cash;
            this.change = calculator.sub(cash, this.getSum());
            return this.change;
        }

        @Override
        public String toStringCash() {
            return String.valueOf(cash);
        }

        @Override
        public String toStringChange() {
            return String.valueOf(change);
        }

        @Override
        public String toString() {
            return "Cash: " + toStringCash() + " ,Price: " + toStringSumTotal() + " ,Change: " + toStringChange();
        }
    }

    public static class Calculator1 implements CalculatorAPI1 {

        @Override
        public double add(double a, double b) {
            return a + b;
        }
    }

    public static class Calculator2 extends Calculator1 implements CalculatorAPI2 {

        @Override
        public double sub(double a, double b) {
            return a - b;
        }

        @Override
        public double mult(double a, double b) {
            return a * b;
        }

        @Override
        public double div(double a, double b) {
            return a / b;
        }
    }


    /**
     * Testing Code for DoorDash class
     */


    /**
     * test Point of Sale (POS) Bridge Abstraction Phase I Pos1 (Calculator1) and Phase II Pos2 (Calculator2)
     */
    public static void demoPos(Double... a) {
        System.out.println("\n\t" + DoorDash.class.getName() + ".demoPos()...");
        {
            System.out.println("TESTING Pos1 (sumTotal(" + a[0] + ", " + a[1] + ", " + a[2] + "):...");

            Pos1 obj = new Pos1(new Calculator1());

            obj.sumTotal(Arrays.asList(a));
            System.out.println(obj);

            System.out.println("applying 0% Normal Discount");
            obj.setStrategy(new NormalDiscount());
            obj.sumTotal(Arrays.asList(a));
            System.out.println(obj);

            System.out.println("applying 10% Member Discount");
            obj.setStrategy(new MemberDiscount());
            obj.sumTotal(Arrays.asList(a));
            System.out.println(obj);

            System.out.println("applying 20% Special Discount");
            obj.setStrategy(new SpecialDiscount());
            obj.sumTotal(Arrays.asList(a));
            System.out.println(obj);

            System.out.println("applying 20% SuperBowl MarkUp");
            obj.setStrategy(new SuperBowlDiscount());
            obj.sumTotal(Arrays.asList(a));
            System.out.println(obj);
        }
        {
            System.out.println("TESTING Pos2 (sumTotal(" + a[0] + ", " + a[1] + ", " + a[2] + "):...");

            Pos2 obj = new Pos2(new Calculator2());

            obj.sumTotal(Arrays.asList(a));
            obj.getChange(20.0d);
            System.out.println(obj);

            System.out.println("applying 0% Normal Discount");
            obj.setStrategy(new NormalDiscount());
            obj.sumTotal(Arrays.asList(a));
            obj.getChange(20.0d);
            System.out.println(obj);

            System.out.println("applying 10% Member Discount");
            obj.setStrategy(new MemberDiscount());
            obj.sumTotal(Arrays.asList(a));
            obj.getChange(20.0d);
            System.out.println(obj);

            System.out.println("applying 20% Special Discount");
            obj.setStrategy(new SpecialDiscount());
            obj.sumTotal(Arrays.asList(a));
            obj.getChange(20.0d);
            System.out.println(obj);

            System.out.println("applying 20% SuperBowl MarkUp");
            obj.setStrategy(new SuperBowlDiscount());
            obj.sumTotal(Arrays.asList(a));
            obj.getChange(20.0d);
            System.out.println(obj);
        }
        System.out.println("\n\t" + DoorDash.class.getName() + ".demoPos()... done!");
    }

    /**
     * test the Point of Sale (POS) Bridge Abstraction
     */
    public static void testPos() {
        System.out.println("\n\t" + DoorDash.class.getName() + ".testPos()...");

        /*
         * Using:	1.1,2.2,3.1
         * Test Pos1: sumTotal
         * Test Pos2: getChange
         */
        Double array[] = {1.1, 2.2, 3.3};

        DoorDash.demoPos(array);

        System.out.println("\n\t" + DoorDash.class.getName() + ".testPos()... done!");
    }

    /**
     * test Point of Sale (POS) Bridge Implementor
     */
    public static void testCalculator() {
        System.out.println("\n\t" + DoorDash.class.getName() + ".testCalculator()...");

        /*
         * Using:	a = 4.2, b = 2.1
         * Test Calculator1: add
         * Test Calculator2: sub, mult, div
         */
        double a = 4.2;
        double b = 2.1;
        DoorDash.demoCalculator(a, b);

        System.out.println("\n\t" + DoorDash.class.getName() + ".testCalculator()... done!");
    }

    /**
     * test Point of Sale Bridge (POS) Implementor Phase I Calculator1 and Phase II Calculator2
     */
    public static void demoCalculator(double a, double b) {
        System.out.println("\n\t" + DoorDash.class.getName() + ".demoCalculator()...");
        {
            System.out.println("TESTING Calculator1 (add " + a + "," + b + "):...");
            Calculator1 obj = new Calculator1();
            obj.add(a, b);
            System.out.println(obj);
        }
        {
            System.out.println("TESTING Calculator2 (add,sub,mult,div " + a + "," + b + "):...");
            Calculator2 obj = new Calculator2();
            obj.add(a, b);
            System.out.println(obj);
            obj.sub(a, b);
            System.out.println(obj);
            obj.mult(a, b);
            System.out.println(obj);
            obj.div(a, b);
            System.out.println(obj);
        }
        System.out.println("\n\t" + DoorDash.class.getName() + ".demoCalculator()... done!");
    }

    /**
     * demonstrate the use of class DoorDash
     */
    public static void demo() {
        System.out.println("\n\t" + DoorDash.class.getName() + "demo()...");

        /**
         * test Calculator
         */
        DoorDash.testCalculator();

        /**
         * test Point of Sale (PoS)
         */
        DoorDash.testPos();

        //Test decorator
        DoorDash.DecoratorDemo();

        /**
         * Student ToDO:
         * use Point of Sale (PoS) to total all orders with all discounts
         */
        Order orders = new Order();
        orders.placeOrders();
        Pos1 obj = new Pos1(new Calculator1());
        obj.setStrategy(new MemberDiscount());

        Map<Integer, Double> prices = new HashMap<>();

        for (OrderComponentAPI component : orders.getOrders()) {
            List<Double> values = new ArrayList<>();
            int id = 0;
            for (OrderAPI ord : component.getOrder()) {
                id = ord.getId();
                values.add(ord.getPrice());
            }
            prices.put(id, obj.sumTotal(values));
        }

        System.out.println("Order totals are as follow:");
        for (int key : prices.keySet()) {
            System.out.print("Order id: ");
            System.out.println(key);
            System.out.print("Order Total: ");
            System.out.println(prices.get(key));
        }


        System.out.println("\n\t" + DoorDash.class.getName() + "demo()... done!");
    }

    public static void DecoratorDemo() {

        //Decorator Demo
        ItemFactoryEagerSingleton instance = ItemFactoryEagerSingleton.getInstance();
        Item.ItemBuilder builder = new Item.ItemBuilder();
        builder.setName("Pizza");
        builder.setPrice(5.49);
        ItemAPI item = instance.getObject(builder);

        item = new Cheese(item);
        item = new Onion(item);
    }
}
