package com.company;

import java.util.Arrays;

public class ProductSign {

    public int arraySign(int[] nums) {
        return Arrays.stream(nums).anyMatch(n -> n==0) ? 0: ((int) Arrays.stream(nums).filter(n -> n < 0).count() %2 == 0? 1: -1);

    }
}
