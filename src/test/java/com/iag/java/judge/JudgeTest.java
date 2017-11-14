package com.iag.java.judge;

import org.junit.Test;

public class JudgeTest {

    @Test
    public void test1() throws Exception{
        boolean flag1 = false;
        boolean flag2 = true;
        boolean flag3 = false;

        if(flag1 || flag2 && flag3){
            System.out.println("111111");
        }else {
            System.out.println("222222");
        }
    }
}
