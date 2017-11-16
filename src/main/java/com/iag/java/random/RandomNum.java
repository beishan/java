package com.iag.java.random;

import java.util.*;

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

    /**
     * generate random num with fixed digit & valid digit
     * @param digit 位数
     * @param firstOrLast 校验位的位置 true : 第一位， false : 最后一位
     * @return
     */
    public static List<String> generateRandomNumsWithValid(int digit, boolean firstOrLast){
        int [] nums = generateRandomNoRepeatFixedDigits(digit - 1);
        List<String> result = new ArrayList<String>(nums.length);
        StringBuilder stringBuilder = null;
        for (int i = 0; i < nums.length; i++) {
            int valid = nums[i] % 10;
            stringBuilder = new StringBuilder();
            if(firstOrLast == true){
                stringBuilder.append(valid).append(String.valueOf(nums[i]));
            }else {
                stringBuilder.append(String.valueOf(nums[i])).append(valid);
            }
            result.add(stringBuilder.toString());
        }
        return result;
    }

    public static List<String> generateRandomNumsWithNoFiexdValid(int digit, boolean firstOrLast){
        int [] nums = generateRandomNoRepeatFixedDigits(digit - 2);
        List<String> result = new ArrayList<String>(nums.length);
        StringBuilder stringBuilder = null;
        for (int i = 0; i < nums.length; i++) {
            int valid = nums[i] % 10;
            int validLocation = nums[i] % (digit - 2);
            stringBuilder = new StringBuilder();
            if(firstOrLast == true){
                stringBuilder.append(nums[i]).insert(validLocation, valid).insert(0, validLocation);
            }else {
                stringBuilder.append(nums[i]);
                stringBuilder.insert(validLocation, valid);
                stringBuilder.append(validLocation);
            }
            result.add(stringBuilder.toString());
        }
        return result;
    }

    public static boolean validRandom(String validStr, boolean firstOrLast){
        int validLocation;
        int valid;
        int validNum;
        if(firstOrLast == true){
            validLocation = Integer.valueOf(String.valueOf(validStr.charAt(0))).intValue();
            if(validLocation >= validStr.length() - 2){
                return false;
            }
            valid = Integer.valueOf(String.valueOf(validStr.charAt(1 + validLocation)));
            String str = validStr.substring(1, validStr.length());
            String validString = removeIndex(str, validLocation);
            validNum = Integer.valueOf(validString);
        }else {
            validLocation = Integer.valueOf(String.valueOf(validStr.charAt(validStr.length() - 1))).intValue();
            if(validLocation >= validStr.length() - 2){
                return false;
            }
            valid = Integer.valueOf(String.valueOf(validStr.charAt(validLocation)));
            String str = validStr.substring(0, validStr.length() - 1);
            String validString = removeIndex(str, validLocation);
            validNum = Integer.valueOf(validString);
        }
        if(validNum % 10 == valid && validNum % (validStr.length() - 2) == validLocation){
            return true;
        }
        return false;
    }

    public static String removeIndex(String str, int index){
        if(str == null || index < 0 || index > str.length() - 1){
            throw new IllegalArgumentException("illegal argument");
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if(i != index){
                stringBuilder.append(str.charAt(i));
            }
        }

        return stringBuilder.toString();
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
