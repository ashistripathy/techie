package com.techie.techie.interview.stream;

import java.util.Arrays;
import java.util.List;

public class AverageOfAllNumbers {
    public static void main(String [] args){
        List<Integer> list = Arrays.asList(1,2,3,4,500);

        /*Average of number*/
        double avg = list.stream().mapToInt(e -> e).average().getAsDouble();
        System.out.println("avg is : "+ avg);

        /*Square of each and every no*/
        double printAvg = list.stream().map(e -> e * e).filter(e -> e > 100).mapToInt(e -> e).average().getAsDouble();
        System.out.println("avg is : "+ printAvg);
    }
}
