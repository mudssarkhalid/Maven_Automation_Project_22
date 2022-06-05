package Day2_042422;

import java.util.ArrayList;

public class ArrayListExample {
    public static void main(String[] args) {
        //create an ArrayList for countries
        ArrayList<String> countries = new ArrayList<>();
        countries.add("USA");
        countries.add("Bangladesh");
        countries.add("India");
        countries.add("Spain");
        countries.add("Pakistan");


        //I want to print the 4th value from the Array List
        System.out.println("My last country is " + countries.get(4) + " and my third country is " + countries.get(2));



    } //end of main method


} //end of class
