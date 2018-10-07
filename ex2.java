package com.company;

public class Main {

    public static void main(String[] args) {
        /*
        Exercise 2:
        Given 3 int values, a b c, print to console their sum.
        However, if one of the values is 13 then it does not
        count towards the sum and values to its right do not count.
        So for example, if b is 13, then both b and c do not count.
        Example:
        int a = 1;
        int b = 13;
        int c = 2;

        should print 1
        */
        int a = 1;
        int b = 14;
        int c = 2;
        int sum = 0;
        if(a == 13) {
            sum = 0;
        } else if(b == 13) {
            sum = a;
        } else if(c == 13) {
            sum = a+b;
        } else {
            sum = a+b+c;
        }

        System.out.println(sum);

    }
}
