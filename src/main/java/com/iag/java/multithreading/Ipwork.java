package com.iag.java.multithreading;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author weixueshan
 * @date 2017/11/13 11:04
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ipwork implements Runnable{
    private String              ip;
    private String              name;

    public void work(String command){
        System.out.println("ipwork: " + ip + ", name: " + name + "-> " + command);
    }

    public void run() {

    }
}
