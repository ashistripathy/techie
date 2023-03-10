package com.techie.techie.interview.stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class SecondLowestHighestNumber {
    public static void main(String [] args){
        List<Integer> list = Arrays.asList(0,3,10,20,30,15,1,13,1,2,2,10,40,19,3,40);

        //sec highest
        Optional<Integer> secH = list.stream().sorted(Collections.reverseOrder()).distinct().limit(2).skip(1).findFirst();
        System.out.println(secH.get());

        //sec lowest
        Optional<Integer> lowH = list.stream().skip(1).findFirst();
        System.out.println(lowH.get());
    }
}
