package actionItems;

import java.util.ArrayList;

public class actionItem_whileLoop_arrayList {
    public static void main(String[] args) {
        //create string array for states
        String[] state = new String[]{"NY", "NJ","CT", "RI"};
        //print each state
        System.out.println("My first state is " + state[0] + ", my second state is " + state[1] + ", my third state is " + state[2] + ", and my last state is " + state[3] + ".");


        //create an ArrayList for states
        ArrayList<String> stateList = new ArrayList<>();
        stateList.add("NY");
        stateList.add("NJ");
        stateList.add("CT");
        stateList.add("RI");
        //print each state
        System.out.println("My first state is " + stateList.get(0) + ", my second state is " + stateList.get(1) + ", my third state is " + stateList.get(2) + ", and my last state is " + stateList.get(3) + ".");



        //set the variables and conditions for the while loop
        int i = 0;
        while(i<= 3){

            //create an arrayList for countries
            ArrayList<String> region = new ArrayList<>();
            region.add("USA");
            region.add("CA");
            region.add("MEX");
            region.add("UK");

            //create an arrayList for region codes
            ArrayList<String> areaCode = new ArrayList<>();
            areaCode.add("1");
            areaCode.add("2");
            areaCode.add("3");
            areaCode.add("4");

            //iterate and print each region and area code
            System.out.println("My region is " + region.get(i) + " and my region code is " + areaCode.get(i) );
            i = i + 1;
        }

    } //end of main method
} //end of class
