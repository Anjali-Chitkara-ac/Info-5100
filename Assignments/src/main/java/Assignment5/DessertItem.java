package Assignment5;

public abstract class DessertItem {
    protected String name;

    public DessertItem(){

    }

    public DessertItem(String name){
        this.name = name;
    }

    public String getName(){
        if(name.length()>DessertShoppe.MAX_SIZE_OF_ITEM_NAME){
            return name.substring(0,DessertShoppe.MAX_SIZE_OF_ITEM_NAME);
        }
        return name;
    }

    public abstract int getCost();

}
