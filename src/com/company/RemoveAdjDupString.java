package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class RemoveAdjDupString {

    public String removeDuplicates(String s, int k) {
        Stack<HashMap<String,Integer>> stack = new Stack<>();
        for(int i=0; i< s.length(); i++) {
            HashMap<String, Integer> map = new HashMap<>();
            String curr = String.valueOf(s.charAt(i));
            if(stack.isEmpty() || !stack.peek().containsKey(curr)) {
                map.put(curr, 1);
                stack.push(map);
            }else {
                int currCount =  stack.peek().get(curr);
                if(currCount < k) {
                    map.put(curr, currCount+1);
                    stack.pop();
                    stack.push(map);
                }
                if(stack.peek().get(curr) == k) {
                    stack.pop();
                }
            }
        }
        Stack<HashMap<String,Integer>> tempStack = new Stack<>();
        String res = "";
        while (!stack.isEmpty()) {
            tempStack.push(stack.pop());
        }
        while (!tempStack.isEmpty()) {
            HashMap<String, Integer> map = tempStack.pop();
            for(Map.Entry<String, Integer> entry: map.entrySet()) {
                for(int i=0; i<entry.getValue(); i++) {
                    res += entry.getKey();
                }
            }

        }

        return res;
    }





//    public String removeDuplicates(String s, int k) {
//        //1.Start from the zero index of string and go till k-1 index
//        //2.if all characters are equal, mark k values found and remove substring
//        //3.reset start and end
//        //4.start step 1 again.
//
//        int len = s.length();
//        int start = 0;
//        int end = start + 1;
//        int cnt = 1;
//        boolean found = true;
//        //ddbbcccbdaa
//        while(found) {
//            found = false;
//
//            while(cnt != k && end<s.length()) {
//
//                if(s.charAt(start) == s.charAt(end)) {
//                    cnt++;
//                    end++;
//                }else {
//                    cnt = 1;
//                    start = end;
//                    end = start + 1;
//                }
//            }
//            if(cnt == k) {
//                found = true;
//                s = s.substring(0, start) + s.substring(end, s.length());
//                System.out.println(s);
//                cnt = 1;
//                start = 0;
//                end = start + 1;
//            }
//        }
//        return s;
//    }
}
