/*
Assignment 2
Using array, loop & conditions with the following array values
Cities = Brooklyn, queens, manhattan, staten;
Using array inside a for or while loop, print me only when city is Brooklyn or city is manhattan;
Use either of the loop (for or while)
 */

package actionItems;

import java.util.ArrayList;

public class actionItem_2_assignment_2 {

    public static void main(String[] args) {
        ArrayList<String>cities = new ArrayList<>();
        cities.add("Brooklyn");
        cities.add("Queens");
        cities.add("Manhattan");
        cities.add("Staten Island");
        for (int i = 0; i < cities.size(); i++){
            if(cities.get(i) == "Brooklyn" || cities.get(i) == "Manhattan"){
                System.out.println("My city is " + cities.get(i));
            } //end of conditions
        }//end of for loop



    }//end of main method
}//end of class
