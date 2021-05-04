package com.company;

public class atoi {


    public int myAtoi(String s) {
        boolean minusFlag = false;
        boolean plusFlag = false;
        int white = 0;
        long sum = 0;
        int len = s.length();

        //base case
        if (len == 0) return 0;

        //ignore characters with whitespaces
        while(s.charAt(white) == ' ') {
            white++;
        }

        //set minus flag
        if(s.charAt(white) == '-')  minusFlag = true;
        //set plus plag
        if(s.charAt(white) == '+') plusFlag = true;
        //return 0 if starts with a letter
        if(s.charAt(white) >= '0' || s.charAt(white) < '9') return 0;


        //start from the index of white after removing whitespaces
        //white remains 0 if no whitespaces found
        for(int i=white; i< s.length(); i++) {
            //if either flag was set, skip character
            if(minusFlag == true || plusFlag == true) continue;

            try {
                sum = sum + s.charAt(i)*10^len;
            }catch(Exception e) {
                if(minusFlag) {
                    return -2147483648;
                }else {
                    return 2147483647;
                }
            }
            len--;
        }
        return (int) sum;
    }

}
