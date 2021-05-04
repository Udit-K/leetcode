//package com.company;
//
//import java.util.*;
//
//public class AlienLanguage {
//    /*
//    ["wordw","world","row"], order = "worldabcefghijkmnpqstuvxyz"
//     */
//
//    public boolean isAlienSorted(String[] words, String order) {
//        //Put order into a map with alphabet and index
//        //Read each word into a char array and store each character with index into a MultiMap
//        //
//
//
//        Map<String, Integer> orderMap = new HashMap<>();
//        char[] orderArray = order.toCharArray();
//        Map<Integer, Map<String, int[]>> indexToWordCharMap = new HashMap<>();
//        Map<String, Integer> indexMap;
//
//        for(int i=0; i<orderArray.length; i++) {
//            orderMap.put(String.valueOf(orderArray[i]), i);
//        }
//
//        for(int i=0; i<words.length; i++) {
//            char[] wordArray = new char[words[i].length()];
//            int[] indexes = new int[wordArray.length];
//            for(int j = 0; j<wordArray.length; j++) {
//                indexMap = new HashMap<>();
//                indexes[j] = j;
//                indexMap.put(String.valueOf(wordArray[j]), orderMap.get(String.valueOf(wordArray[j])));
//            }
//
//            indexToWordCharMap.put(i, indexMap);
//        }
//
//        for(String word: words) {
//           char[] wordArray = new char[word.length()];
//           wordArray = word.toCharArray();
//           indexToWordCharMap.put()
//
//        }
//        return true;
//    }
//
//}
