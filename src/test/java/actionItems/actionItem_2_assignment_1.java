package actionItems;
/*
Assignment 1
Using conditional statements I want you to create a numeric variable with name as grade with some value
Using that variable I want to change the variable each time with conditions
As when grade range is from 90 to 100 print grade as A,
 when grade range is from 80 to less than 90 print grade as B,
 when grade range is from 70 to less than 80 print grade as C,
 when grade range is from 60 to less than 70 print grade as D,
 anything below 60 is F.
For instance, I am showing the first portion on if condition for you
Int grade = 90;
If(grade >= 90 && grade <=100){
print grade is a
} else if…continue

 */

public class actionItem_2_assignment_1 {
    public static void main(String[] args) {
        int grade = 54;

        if(grade >= 90 && grade <=100) {
            System.out.println("Grade is A");
        }else if(grade >= 80 && grade <90) {
            System.out.println("Grade is B");
        }else if(grade >= 70 && grade <80) {
            System.out.println("Grade is C");
        }else if(grade >=60 && grade <70){
            System.out.println("Grade is D");
        } else {
            System.out.println("Grade is F");
        }

    } //end of main method

} //end of class
