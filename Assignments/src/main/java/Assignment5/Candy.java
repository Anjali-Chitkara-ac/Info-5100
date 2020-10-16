package Assignment5;

public class Candy extends DessertItem {

    private double weight;
    private double pricePerPound;

    public Candy(){
    }

    public double getWeight() {
        return weight;
    }

    public double getPricePerPound() {
        return pricePerPound;
    }

    public Candy(String name, double weight, double pricePerPound){
        this.name = name;
        this.weight = weight;
        this.pricePerPound = pricePerPound;
    }

    @Override
    public int getCost() {
        return (int) Math.round(weight*pricePerPound);
    }
}
