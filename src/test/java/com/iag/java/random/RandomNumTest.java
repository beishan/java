package com.iag.java.random;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.iag.java.random.RandomNum.*;

/**
 * @author weixueshan
 * @date 2017/11/14 18:08
 */
public class RandomNumTest {

    @Test
    public void test(){
        int [] arr = generateRandomNoRepeatNums(2, 10);
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    @Test
    public void test1(){
        int [] nums = generateRandomNoRepeatFixedDigits(7);
    }
    @Test
    public void testGenerateRandomNoRepeatNums() throws Exception{
        int [] begNums = {0, 20};
        int [] endNums = {1000, 1000};
        int [][] result = new int [2][];
        for (int i = 0; i < begNums.length; i++) {
            result[i] = generateRandomNoRepeatNums(begNums[i], endNums[i]);
        }
        Arrays.sort(result[0]);
        for (int i = 0; i < result[0].length; i++) {
            System.out.println(result[0][i]);
        }

        boolean [] valid = {true, true};

        for (int i = 0; i < result.length; i++) {
            int resultNum =  endNums[i] - begNums[i] + 1;
            Set set = new HashSet();
            for (int j = 0; j < resultNum; j++) {
                if(result[i][j] <= endNums[i] && result[i][j] >= begNums[i]){
                    set.add(result[i][j]);
                }else {
                    valid[i] = false;
                    break;
                }
            }
            System.out.println(set.size());
            if(valid[i] != true || set.size() != resultNum){
                valid[i] = false;
            }
        }
        boolean [] expected = {true, true};
        Assert.assertArrayEquals(expected, valid);

    }


    @Test
    public void test2(){
        boolean firstOrLast = false;
        List<String> list = generateRandomNumsWithNoFiexdValid(6, firstOrLast);
        Set set = new HashSet();
        for(String str : list){
            set.add(str);
            System.out.println(str);
            if(!validRandom(str, firstOrLast)){
                System.out.println("fail: " + str);
            }
        }
        if(set.size() == list.size()){
            System.out.println("success");
        }
    }


    @Test
    public void test3(){
        boolean valid = validRandom("43345765", false);
        System.out.println(valid);

        int [] nums = generateRandomNoRepeatFixedDigits(8);
        int success = 0, fail = 0;
        int total = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if(validRandom(String.valueOf(nums[i]), false)){
                success ++;
            }else {
                fail ++;
            }
        }

        System.out.println("success: " + success);
        System.out.println("fail:" + fail);
        System.out.println("total:" + total);
    }


    @Test
    public void test4(){
        int k = 0x80;
        int c = 'X';
        System.out.println(k + " " + c);
        System.out.println(c/k);
    }
}
