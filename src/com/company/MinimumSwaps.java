package com.company;

public class MinimumSwaps {

    public int minSwaps(int[] data) {
        int oneCount = 0;

        for(int i=0; i<data.length; i++) {
            if(data[i] == 1) {
                oneCount++;
            }
        }
        if(oneCount == 1) return 0;

        int start = 0;
        int end = oneCount;
        int min = Integer.MAX_VALUE;

        while (end < data.length+1) {
            int swaps = countHelper(start, end, data);
            min = swaps < min ? swaps: min;
            end++;
            start++;
        }
        return  min;

    }

    public int countHelper(int start, int end, int[] data) {
        int temp = 0;
        for(int i=start; i<end; i++) {
            if (data[i] == 0) {
                temp++;
            }

        }
        return temp;
    }


    

}
