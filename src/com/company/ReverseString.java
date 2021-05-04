package com.company;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ReverseString {
    /*
    Reverse words in a string but keep the punctuation marks in the same order.
     "Hello, world!"would end up being "world, Hello!"
     */
    /*
    Put each word in string array
    read words with punctuations
    store punctuation with index for word in word array
    replace punctuations with "" in each word and store reverse string
    put punctuation back at the end of each word as per index of reversed string
    return string
     */

    public String reverse(String input) {
        if(input == "") return "";
        int index = 0;
        Map<Integer, String> punctuationMap = new HashMap<>();
        String[] wordArray = input.split(" ");

        for(String word: wordArray) {
            char[] charArr = word.toCharArray();

            for(int i=0; i<charArr.length; i++) {
                if(!Character.isLetter(charArr[i])) {
                    punctuationMap.put( index, String.valueOf(charArr[i]));
                }
            }
           index++;
        }
        input = input.replaceAll("\\p{Punct}", "");

        String[] newWordArray = input.split(" ");
          String revString = "";
        for(int i=newWordArray.length-1; i>=0; i--) {
            revString += newWordArray[i];
            if(i>0) {
                revString += " ";
            }
        }
        StringBuilder result = new StringBuilder();
        newWordArray = revString.split(" ");
        for (int i=0; i< newWordArray.length; i++) {
            result.append(newWordArray[i]).append(punctuationMap.getOrDefault(i, ""));
            if(i != wordArray.length -1){
                result.append(" ");
            }
        }
        return result.toString();
    }

}
