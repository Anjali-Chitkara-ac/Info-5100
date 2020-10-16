package Assignment5;

public class Sundae extends IceCream {

    String toppingName;
    double costOfTopping;

    public Sundae(String name, double cost, String toppingName, double costOfTopping) {
        super(name, cost);
        this.toppingName = toppingName;
        this.costOfTopping = costOfTopping;
    }

    public String getToppingName() {
        return toppingName;
    }

    public int getCost(){
        //cost of IceCream + cost of topping
        return super.getCost() + (int) Math.round(costOfTopping);
    }

}
