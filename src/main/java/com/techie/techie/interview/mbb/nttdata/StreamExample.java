package com.techie.techie.interview.mbb.nttdata;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class StreamExample {
    public static void main(String [] args){
        List<Integer> numList = Arrays.asList(3,4,2,7,8,1);
        int min = Collections.min(numList);
        int max = Collections.max(numList);

        System.out.println("Min Value " + min);
        System.out.println("Max Value " + max);

        System.out.println("Another example using IntStream of java 8");
        List<Integer> list = Arrays.asList(4, 2, 8, 1, 6, 9, 3, 5, 7);
        int listMin = list.stream().mapToInt(Integer::intValue).min().getAsInt();
        int listMax = list.stream().mapToInt(Integer::intValue).max().getAsInt();

        System.out.println("Min Value from list : " + listMin + "\n" +
                "Max Value from list " + listMax);

        int [] arr1 = {3,4,2,7,8,1};
        int [] arr2 = {13,4,12,6,9,2};
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int mergedArray [] = Arrays.copyOf(arr1,arr1.length+arr2.length);

        System.arraycopy(arr2,0,mergedArray,arr1.length,arr2.length);
        Arrays.sort(mergedArray);
        System.out.println(Arrays.toString(mergedArray));

    }
}
