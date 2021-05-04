package com.company;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum4 {

    public int combinationSum4(int[] nums, int target) {
        int[] targets = new int[target+1];
        targets[0] = 0;
        int c =  helper(nums, targets, target);
        System.out.println(targets.toString());
        return targets[target];
    }


    public int helper(int[] nums, int[] targets, int remain) {

        if(remain == 0) return 0;
        if(remain < 0) return -1;
        int currentCount = 0;

        for (int num: nums) {

            int rem = remain-num;
            //case 1 coin num considered

                int cnt = helper(nums, targets, rem);
                if(cnt == -1) continue;
                if(cnt == 0) currentCount = currentCount +1;
            }
            targets[remain] = currentCount;

          return  currentCount;
        }


    }


//    public int helper(int[] nums, int remain, List<Integer> count) {
//
//        if(remain == 0) return 0;
//        if(remain < 0) return -1;
//        //1,2,3   //4 // 0
//        for(int num: nums) {
//            int cnt = helper(nums, remain-num, count);
//
//            if(cnt == 0) {
//                int curr = count.get(0);
//                count.remove(0);
//                count.add(curr+1);
//            }
//        }
//        return count.get(0);
//    }




