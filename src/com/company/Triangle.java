package com.company;

import java.util.Arrays;
import java.util.List;

public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        int sum = 0;

        for(List<Integer> eachList: triangle) {
            sum += findmin(eachList);
        }
        return sum;
    }


    public int findmin(List<Integer> intList) {
        return intList.stream().mapToInt(v -> v).min().getAsInt();
}
}
