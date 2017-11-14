package com.iag.java.snowflake;

import org.junit.Test;

/**
 * @author weixueshan
 * @date 2017/11/14 14:31
 */
public class IdGeneratorTest {

    @Test
    public void test(){
        IdGenerator idGenerator = new IdGenerator(15L, 15L);

        for (int i = 0; i < 1000; i++) {
            System.out.println(idGenerator.nextId());
        }
    }


    @Test
    public void reflect(){
        long id = 14502246777548808L;
        long sequenceB = (~(1L << 12)) << 52;
        System.out.println(Long.toBinaryString(sequenceB));
        System.out.println(Long.toBinaryString(sequenceB >>> 52));
        System.out.println(Long.toBinaryString(sequenceB >>> (52 - 12)));
        int length = 3;
        int position = 6;
        long template = (~(1L << length)) << (64 - length) >>> (64 - length - position);

        System.out.println(Long.toBinaryString(template));
        //long sequence = id
        System.out.println(re(12, 0, id));
        System.out.println(Long.toBinaryString(re(5, 12, id)));
        System.out.println(Long.toBinaryString(re(41, 22, id)));
        System.out.println(re(41, 22, id));
    }

    public long re(int length, int position, long source){
        long template = (~(1L << length)) << (64 - length) >>> (64 - length - position);
        long result = template & source;
        return result >> position;
    }


    @Test
    public void test1(){
        System.out.println(Long.toBinaryString(-1L << 12));
    }
}
