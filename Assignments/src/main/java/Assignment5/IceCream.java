package Assignment5;

public class IceCream extends DessertItem {

    double cost;

    public IceCream(String name, double cost){
        this.name = name;
        this.cost = cost;
    }


    @Override
    public int getCost() {
        return (int) Math.round(cost);
    }
}
