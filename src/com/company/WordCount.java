package com.company;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WordCount {

    public static void main(String[] args) {
        String para = "The Sun is the star at the center of the Solar System. It is a nearly perfect sphere of hot plasma, with internal convective motion that generates a magnetic field via a dynamo process. It is, by far, the most important source of energy for life on Earth.";

        Solution solution = new Solution();
     solution.count(para);
    }

 static class Solution {
     public void count(String para) {

         para = para.replace(",", " ");
         para = para.replace(".", " ");

         String[] wordArray = para.split(" ");

         Map<String, Long> wordCountMap = Arrays.stream(wordArray).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
         int total = 0;
         String repeatedWords = "";
         for(Map.Entry<String, Long> word: wordCountMap.entrySet()) {

             if(word.getValue() > 1) {
                 int count = word.getValue().intValue();
                 System.out.println(word.getKey() + " is seen " + count +" times (i.e. " + (count-1) + "repetitions");
                 total += count-1;
             }
         }
         System.out.println("Total repeated word count = " + total);


     }
 }

}
