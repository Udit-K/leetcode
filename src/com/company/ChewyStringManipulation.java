package com.company;

import java.util.*;

public class ChewyStringManipulation {

    /*
    Question, what kind of bear is best?
    That's a ridiculous question!
    False.
    Black bear.
     */
    /*
    a: {1:2}
    bear: {2:1,4}
    best: {1:1}
    black:{1:4}
    false:{1:3}
    is:{1:1}
    kind:{1:1}
    of:{1:1}
    question:{2:1,2}
    ridiculous:{1:2}
    that's:{1:2}
    what:{1:1}
    number of occurrences along with line they occur
     */

    public static void main(String[] args) {
        List<String> input = new ArrayList<>();
        input.add("Question, what kind of bear is best?");
        input.add("That's a ridiculous question!");
        input.add("False.");
        input.add("Black bear.");

        printThis(input);

    }

    public static void printThis(List<String> input) {
        Map<String, List<Integer>> inputMap = new HashMap<>();

        for(int i=0; i<input.size(); i++) {
            String[] wordArray = input.get(i).split(" ");

            for(int j=0; j<wordArray.length; j++) {
             String word = wordArray[j].toLowerCase();
             //check if word has a special character at the end
             if(!Character.isLetter(word.charAt(word.length()-1))) {
                 word = word.substring(0, word.length()-1);
             }
             if(!inputMap.containsKey(word)) {
                 inputMap.put(word, new ArrayList<>(Arrays.asList(i+1)));
             }else {
                 inputMap.get(word).add(i+1);
              }
            }
        }

        for(Map.Entry<String, List<Integer>> wor: inputMap.entrySet()) {
            String stringOccur = Set.copyOf(wor.getValue()).toString();
            stringOccur = stringOccur.substring(1, stringOccur.length()-1);
            System.out.println(wor.getKey() + ": " + "{" + wor.getValue().size() + ":" + stringOccur + "}");
        }

    }


}
