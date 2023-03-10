package com.techie.techie.interview.stream;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class CountEmptyStringsInArray {
    public static void main(String [] args){
        List<String> stringList = Arrays.asList("avc","","bcd","","def","jk");
        //count no of empty string
        long count = stringList.stream().filter(x -> x.isEmpty()).count();
        System.out.println(count);

        List<String> stringList1 = Arrays.asList("abc","de","ashis","tapu");
        //count no of string which length is greater than 3
        long count1 = stringList1.stream().filter(x->x.length()>3).count();
        System.out.println(count1);

        //count no of string which starts with letter a
        System.out.println(stringList.stream().filter(x->x.startsWith("a")).count());

        //remove all the empty strings from the list
        List<String> listA = Arrays.asList("","abc","","","tapu");
        listA.stream().filter(x->!x.isEmpty()).collect(Collectors.toList()).forEach(System.out::println);

        //create a list of string with more than two character
        List<String> chList = Arrays.asList("Ashis","Sonali","lucky","tapu","kk","ck");
        chList.stream().filter(x->x.length() > 2).collect(Collectors.toList()).forEach(System.out::println);

        //convert a string to uppercase and separate them by comma
        List<String> country = Arrays.asList("India","USA","UK","China","Canada");
        String countryName = country.stream().map(x -> x.toUpperCase(Locale.ROOT)).collect(Collectors.joining(", "));
        System.out.println(countryName);

        //Create a List of the square of all distinct numbers
        List<Integer> numList = Arrays.asList(3,4,6,7,8,9,9,4,3,2);
        numList.stream().map(x->x*x).distinct().collect(Collectors.toList()).forEach(System.out::println);

        //Java 8 Statistics Example: Get count, min, max, sum, and the average for numbers
        List<Integer> primes = Arrays.asList(2,3,5,7,11,13,17,19,23,29);
        IntSummaryStatistics result = primes.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println(result);
    }
}
