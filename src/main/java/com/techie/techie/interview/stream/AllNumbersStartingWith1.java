package com.techie.techie.interview.stream;

import java.util.Arrays;
import java.util.List;

public class AllNumbersStartingWith1 {
    public static void main(String [] args){

        /*All numbers starting with 1*/
        List<Integer> numList = Arrays.asList(10,1,3,5,7,8,9,111);
        numList.stream().map(s->s+"").filter(s->s.startsWith("1")).forEach(System.out::println);
    }
}
