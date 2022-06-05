package actionItems;

import java.util.ArrayList;

public class actionItem_forLoop_arrayList {
    public static void main(String[] args) {


        //create an arrayList for countries
        ArrayList<String> country = new ArrayList<>();
        country.add("USA");
        country.add("CA");
        country.add("MEX");
        country.add("UK");

        //create an arrayList for country codes
        ArrayList<Integer> countryCode = new ArrayList<Integer>();
        countryCode.add(1);
        countryCode.add(2);
        countryCode.add(3);
        countryCode.add(4);

        //iterate and print each country and code
        for (int i = 0; i < country.size(); i++) {

            System.out.println("My country is " + country.get(i) + " and my country code is " + countryCode.get(i));
        } //end of for loop

    }//end of main

}//end of java class
