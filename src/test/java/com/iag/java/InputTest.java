package com.iag.java;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

/**
 * @author weixueshan
 * @date 2017/11/13 14:04
 */
public class InputTest {

    /**
     * it's will out put the MyInput string
     * it's also haven't work
     */
    @Test
    public void test(){
        ByteArrayInputStream is = new ByteArrayInputStream("MyInput".getBytes());
        System.setIn(is);

        Scanner scanner = new Scanner(System.in);
        //System.out.println(scanner.nextLine());
        System.setIn(System.in);


    }
}
