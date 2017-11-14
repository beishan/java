package com.iag.java.map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {

    public static void main(String[] args) {
        Map map = new HashMap();

        Node node = Node.builder().name("test").build();

        map.put("key", node);
        map.put("key", node);

        System.out.println(map.size());

        String key = "key";
        System.out.println("key: " + key.hashCode());
    }
}
@Data
@AllArgsConstructor
@Builder
class Node{
    private String name;
}
