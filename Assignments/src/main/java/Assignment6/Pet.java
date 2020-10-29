package Assignment6;

import java.util.*;

//Part C
public class Pet {
    private String petName;
    private String ownerName;
    private String color;
    protected int sex;
    public static final int MALE = 0;
    public static final int FEMALE = 1;
    public static final int SPAYED = 2;
    public static final int NEUTERED = 3;

    private static final Map<Integer, String> map = new HashMap<>();

    public Pet(String petName, String ownerName, String color) {
        this.petName = petName;
        this.ownerName = ownerName;
        this.color = color;

        initializeMap();
    }

    private static void initializeMap() {
        map.put(MALE, "MALE");
        map.put(FEMALE, "FEMALE");
        map.put(SPAYED, "SPAYED");
        map.put(NEUTERED, "NEUTERED");
    }

    public String getPetName() {
        return petName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getColor() {
        return color;
    }

    public void setSex(int sexID) {
        if(sexID == 1)
            this.sex = MALE;
        else if(sexID == 2)
            this.sex = FEMALE;
        else if(sexID == 3)
            this.sex = SPAYED;
        else if(sexID == 4)
            this.sex = NEUTERED;
    }

    public String getSex() {
        return map.get(this.sex);
    }

    public String toString(){
        return getPetName() + " owned by " + getOwnerName() + "\n" + "Color: " + getColor() +
                "\n" + "Gender: " + getSex();
    }
}
