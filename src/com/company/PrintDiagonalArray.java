package com.company;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


// Input
// 1 2 3 3
// 4 5 6 4
// 7 8 9 6
// 5 7 8 9

//0,0
//0,1 -> 1,0
//0,2 -> 1, 1 -> 2,0
//0,3 -> 1,2 -> 2,1 -> 3,0


public class PrintDiagonalArray {

       public static void printArray(int[][] arr) {
           Map<Integer, List<Integer>> output = new HashMap<>();
           for(int row = 0; row< arr.length; row++) {
               for(int col = 0; col< arr[row].length; col++) {
                   if(!output.containsKey(row+col)) {
                       output.put(row+col, new ArrayList<>(Arrays.asList(arr[row][col])));
                   }else {
                       output.get(row+col).add(arr[row][col]);
                   }
               }
           }
          int leftBound = -(arr.length-1);
           int rightBound = arr.length-1;
           int depth = arr.length-1 + arr[0].length-1;
           int cnt = 0;
           while(cnt<=depth) {
               List<Integer> curr = output.get(depth);
               for(int i =0; i<curr.size(); i++) {
                   System.out.print(curr.get(i)+ " ");
               }
               cnt++;
           }
       }

        public static void main(String[] args) {
            int M[][] = {
                    { 1, 2, 3 },
                    { 4, 5, 6 },
                    { 7, 8, 9 }
            };
            printArray(M);
        }
    }


