package com.techie.techie.interview.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/* Find no of times a word/number got repeated
* input : 5,3,4,1,3,7,2,9,9,4
* output: 1-1,2-1,3-2,4-2,5-1,7-1,9-2
*
* input:"Amanda", "Rob", "Rob","Ammanda","Roy"
* output: Amanda-2,Roy-1,Rob-2
* */
public class FindDuplicatesUsingStreams {
    public static void main(String [] args){
        String str = "aaabbbbccccddddd";
        List<Integer> numList = Arrays.asList(5,4,3,1,3,7,2,9,9,4);
        List<String> strList = Arrays.asList("Amanda","Rob","Amanda","Rob","Roy");
        /*Print repeated integer in a integer array with count*/
        numList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).forEach((key,value)->{
            System.out.println(key + " - " + value);
        });

        /*Print repeated string in a string array with count*/
        Map<String, Long> printData = strList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        printData.forEach((key,value)->{
            System.out.println(key + " - " + value);
        });
        /*Print repeated character in a string with count*/
        List<Character> chList = str.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        Map<Character, Long> printDuplicateCharacter = chList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        printDuplicateCharacter.forEach((key,value)->{
            System.out.println(key + " - " + value);
        });
    }
}
