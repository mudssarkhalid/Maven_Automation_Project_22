package Day3_043022;

import methods.reusableMethods;

public class testingMethods {

    public static void main(String[] args) {


//call the addTwoNumbers method and execute it

        reusableMethods.addTwoNumbers(20, 30);

//call the return method and store it in a variable to perform something else
        int finalResult = reusableMethods.subtractTwoNumbers(100,13);
        int newResult = finalResult + 10;
        System.out.println("new result is " + (newResult));
    }
}//end of java class
