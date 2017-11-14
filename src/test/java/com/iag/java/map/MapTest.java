package com.iag.java.map;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapTest {

    @Test
    public void testListAddMap() throws Exception{
        long startMills = System.currentTimeMillis();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        List<String> list = null;
        for (int i = 0; i < 1000000; i++) {
            list = map.get("list");

            if(list == null){
                list = new ArrayList<String>();
            }
            String item = "item_" + i;
            list.add(item);

            map.put("list", list);
        }
        long endMills = System.currentTimeMillis();
        System.out.println("用时: " + (endMills - startMills));
        //System.out.println(map.toString());
    }

    @Test
    public void testListAddMap2() throws Exception{
        long startMills = System.currentTimeMillis();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 1000000; i++) {
            String item = "item_" + i;
            list.add(item);
        }
        map.put("list", list);
        long endMills = System.currentTimeMillis();
        System.out.println("用时: " + (endMills - startMills));
        //System.out.println(map.toString());
    }
}


