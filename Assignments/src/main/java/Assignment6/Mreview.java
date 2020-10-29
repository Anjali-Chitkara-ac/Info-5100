package Assignment6;

import java.util.*;
import java.text.DecimalFormat;
//Part A
public class Mreview implements Comparable<Mreview>{

    // instance variables
    private String title;   // title of the movie
    private ArrayList<Integer> ratings; // list of ratings stored in a Store object

    public Mreview(){
        title = "";
        ratings = new ArrayList<>();
    }

    public Mreview(String title) {
        this.title = title;
        ratings = new ArrayList<>();
    }

    public Mreview(String title, ArrayList<Integer> ratings) {
        this.title = title;
        this.ratings = ratings;
    }

    public void addRating(int r){
        ratings.add(r);
    }

    public double avgRating(){
        int sum = 0;
        for(int i : ratings){
            sum +=i;
        }
        double avg =  (double) sum/numRatings();
        DecimalFormat df = new DecimalFormat("#.##");
        return Double.parseDouble(df.format(avg));
    }

    @Override
    public boolean equals(java.lang.Object obj){
        Mreview mr = (Mreview) obj;
        if(this.title.equals(mr.title)) return true;
        else return false;
    }

    public String getTitle() {
        return title;
    }

    public int numRatings(){
        return ratings.size();
    }

    @Override
    public int compareTo(Mreview o) {
        return this.title.compareTo(o.title);
    }

    public String toString(){
        String allRatings = "";
        for(int i : ratings){
            allRatings += i + ", ";
        }
        return "Title: " + getTitle() + ", Ratings: " + allRatings;
    }

    public static void main(String[] args) {
        Mreview mr  = new Mreview("Hoo Boo");
        mr.addRating(3);
        mr.addRating(2);
        mr.addRating(5);
        System.out.println(mr.toString());
        System.out.println("Average rating: "+ mr.avgRating());
    }

}

