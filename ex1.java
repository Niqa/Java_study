package com.company;

public class Main {

    public static void main(String[] args) {
     /*   Exercise 1:
        We'll say that a number is "teen" if it is in the range 13..19 inclusive.
        Given 2 int values, print to console true if one or the other is teen, but not both.
        Example:
        int a = 1;
        int b = 13;

        if a or b is "teen" print "teen"
    */

     int a = 1;
     int b = 13;

     int cmp = Integer.compare(a, b);
     if (cmp == -1){
         if(a >= 13 && b < 13 || a < 13 && b >= 13){
             if(a <= 19 && b <= 19){
                 System.out.println("TEEN");
             }
         }
     }

    }
}
