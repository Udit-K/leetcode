//package com.company;
//
//import javax.swing.tree.TreeNode;
//import java.util.Queue;
//
//public class ReverseInteger {
//    public int reverse(int x) {
//        String result = "";
//        int index = 0;
//        String parsedInt = String.valueOf(x);
//        char[] charArray = parsedInt.toCharArray();
//        if(charArray[0] == '-') {
//            result = result + "-";
//            index++;
//        }
//        int len = charArray.length;
//        for(int i = len; i> index; i--) {
//            result += charArray[i-1];
//        }
//        return Integer.parseInt(result);
//
//
//    }
//}
