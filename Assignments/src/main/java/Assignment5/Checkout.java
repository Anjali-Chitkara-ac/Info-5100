package Assignment5;

import java.util.*;

public class Checkout {

   private List<DessertItem> list;

    public Checkout(){
        list = new ArrayList<DessertItem>();
    }

    public void enterItem(DessertItem item){
        list.add(item);
    }

    public void clear(){
        list.clear();
    }

    public int numberOfItems(){
        return list.size();
    }

    public int totalCost(){
        //without tax
        double total = 0;
        for(DessertItem i : list){
            total  += i.getCost();
        }
        return (int) Math.round(total);
    }

    public int totalTax(){
        //rounded to nearest cent
        return (int) Math.round(totalCost() * DessertShoppe.TAX_RATE *0.01);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (DessertItem i : list){
            String price = DessertShoppe.cents2dollarsAndCents(i.getCost());
            if(price.length()>DessertShoppe.WIDTH_OF_TEXT_FOR_COST_OF_ITEMS){
                price = price.substring(0,DessertShoppe.WIDTH_OF_TEXT_FOR_COST_OF_ITEMS);
            }
            if(i instanceof Candy) {
                sb.append("\n"+((Candy) i).getWeight() + "lbs. @ " + ((Candy) i).getPricePerPound()*0.01 + "/lb.");
            }
            if(i instanceof Sundae){
                sb.append("\n"+((Sundae) i).getToppingName() + " Sundae with");
            }
            if(i instanceof Cookie){
                sb.append("\n"+ ((Cookie) i).getNumber() + " @ " + ((Cookie) i).getPricePerDozen()*0.01 + " /dz.");
            }

           sb.append("\n"+i.getName() + "\t" + price);
        }
        sb.append("\nTax" + "\t" + DessertShoppe.cents2dollarsAndCents(totalTax()));
        sb.append("\nTotal Cost" + "\t" + DessertShoppe.cents2dollarsAndCents(totalCost()+totalTax()));
        sb.append("\n--------X--------X--------X--------");
        return sb.toString();
    }
}
