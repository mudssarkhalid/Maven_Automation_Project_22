package methods;

public class reusableMethods {

    //create a void method to add two numbers
    public static void addTwoNumbers(int num1, int num2){

        System.out.println("The result of two numbers is " + (num1+num2));
    }//end of add return method

    // create a static int subtractTwoNumbers(int a, int b)
    public static int subtractTwoNumbers(int a, int b){

            int result = a-b;
            System.out.println("The result of int b subtracted from int a is " + result);

            return result;
    }//end of subtract return method

}
