package com.iag.java.randomnum;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author weixueshan
 * @date 2017/11/14 18:08
 */
public class RandomNumTest {

    @Test
    public void test(){
        int [] arr = RandomNum.generateRandomNoRepeatNums(2, 10);
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    @Test
    public void test1(){
        int [] nums = RandomNum.generateRandomNoRepeatFixedDigits(7);
    }
    @Test
    public void testGenerateRandomNoRepeatNums() throws Exception{
        int [] begNums = {0, 20};
        int [] endNums = {1000, 1000};
        int [][] result = new int [2][];
        for (int i = 0; i < begNums.length; i++) {
            result[i] = RandomNum.generateRandomNoRepeatNums(begNums[i], endNums[i]);
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
}
