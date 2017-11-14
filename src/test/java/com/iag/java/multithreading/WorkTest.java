package com.iag.java.multithreading;

import org.junit.Test;

import java.util.Scanner;

/**
 * @author weixueshan
 * @date 2017/11/13 11:20
 */
public class WorkTest {

    @Test
    public void test2(){
        Scanner scanner = new Scanner(System.in);

        System.out.println(scanner.nextLine());
    }
    @Test
    public void test1(){
        WorkManager workManager = new WorkManager();
        Ipwork [] ipworks = new Ipwork[3];
        ipworks[0] = new Ipwork("192.168.0.1", "ipwork-1");
        ipworks[1] = new Ipwork("192.168.0.2", "ipwork-2");
        ipworks[2] = new Ipwork("192.168.0.3", "ipwork-3");

        workManager.init(ipworks);

        workManager.show();
        Scanner sc = new Scanner(System.in);
        boolean shutdown = false;
        int command = 0;

        while (shutdown == false){
            System.out.println("input:");
            command = sc.nextInt();
            if(command > 2){
                shutdown = true;
            }else {
                String id = "work_" + command;
                workManager.work(id, "command-" + command);
            }
        }

    }
}
