package com.iag.java.randomnum;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * @author weixueshan
 * @date 2017/11/14 17:35
 */
public class RandomNum {
    /**
     * generate a random & no repeat array between begNum & endNum
     * @param begNum begin num
     * @param endNum end num
     * @return a aim array
     */
    public static int [] generateRandomNoRepeatNums(int begNum, int endNum){
        if(begNum >= endNum || begNum < 0 || endNum < 0){
            throw new IllegalArgumentException("illegal arguments, begNum & endNum can't be equal , & < 0");
        }
        int numsLength = endNum - begNum + 1;
        int [] nums = new int [numsLength];
        /**
         * init nums between begNum ~ endNum
         */
        int numsInitIndex = 0;
        for (int i = begNum; i < endNum + 1; i++) {
            nums[numsInitIndex ++] = i;
        }

        int [] aims = new int [numsLength];
        int aimsIndex = 0, begIndex = 0;
        int endIndex = aims.length - 1;
        Random random = new Random(System.currentTimeMillis());
        while (begIndex <= endIndex){
            int randomNum = random.nextInt(endIndex + 1);
            aims[aimsIndex ++] = nums[randomNum];
            nums[randomNum] = nums[endIndex];
            endIndex --;
        }
        return aims;
    }

    public static int [] generateRandomNoRepeatFixedDigits(int digit){
        if(digit <= 0){
            throw new IllegalArgumentException("illegal argument, digit must be > 0");
        }
        double x = digit;
        double y = 10d;
        int begNum = (int)Math.pow(y, (x - 1d));
        int endNum = (int)Math.pow(y, x) - 1;
        return generateRandomNoRepeatNums(begNum, endNum);
    }

    public static void main(String[] args) {
        int [] nums = new int [100];
        // init nums
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i + 1;
        }
        int [] aims = new int [100];
        int begIndex = 0;
        int endIndex = nums.length - 1;
        Random random = new Random(System.currentTimeMillis());
        int aimsIndex = 0;
        while (begIndex <= endIndex){
            int n = random.nextInt(endIndex + 1);
            System.out.println(nums[n]);
            aims[aimsIndex ++] = nums[n];
            nums[n] = nums[endIndex];
            endIndex --;
        }

        Set set = new HashSet();
        for (int i = 0; i < aims.length; i++) {
            set.add(aims[i]);
        }
        System.out.println("size:" + set.size());
    }
}
