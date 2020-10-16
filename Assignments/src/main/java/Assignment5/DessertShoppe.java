package Assignment5;

public class DessertShoppe {

    static final double TAX_RATE = 6.5;
    static final String STORE_NAME = "M & M DESSERT SHOPPE";
    static final int MAX_SIZE_OF_ITEM_NAME = 20;
    static final int WIDTH_OF_TEXT_FOR_COST_OF_ITEMS = 5;

    public static String cents2dollarsAndCents(int cents){
        double toDollars = cents * 0.01;
        return String.valueOf(toDollars);
    }

}
