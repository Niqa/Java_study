package com.company;

import java.util.Arrays;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
  /*
        Exercise 3:
        Given an array of ints, print to console true if the sequence of numbers 1, 2, 3
        appears in the array somewhere.
                Example:
        int[] array = {3,2,14,1,2,3,6};

        should print true

    */
        String temp = "";

        int[] array = {3, 2, 2, 1, 2,3,1};

        int index=0;
        for ( int i=0; i< array.length; i++) {
            if(array[i] == 1) {
                index = i;
                if(checkContains(array, index)) {
                    System.out.println("True");
                    break;
                }
            }
        }
    }

    private static boolean checkContains(int[] array, int index) {
        if(array.length - index > 2 && array[index] == 1 && array[index+1] ==2 && array[index+2] ==3) {
            return true;
        }
        return false;
    }
}
