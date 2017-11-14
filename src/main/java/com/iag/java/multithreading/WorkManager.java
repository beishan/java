package com.iag.java.multithreading;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WorkManager {
    private final String WORK_ID_PRE = "work_";
    private int workNum = 0;

    private List<Work> works = new ArrayList<Work>();

    public void init(Ipwork [] ipworks){
        System.out.println("work manager init...");
        for (int i = 0; i < ipworks.length; i++) {
            this.add(ipworks[i]);
        }
    }

    public void work(String workId, String command){
        for(Work work : works){
            if(work.getId().equals(workId)){
                work.work(command);
                break;
            }
        }
    }

    public void add(Ipwork ipwork){
        String id = WORK_ID_PRE + workNum;
        workNum ++;
        Work work = new Work(id, ipwork);
        works.add(work);
        System.out.println("add---work: id=" + id + ", ipwork:" + ipwork.toString());
    }

    public void remove(String workId){
        for(Work work : works){
            if(work.getId().equals(workId)){
                works.remove(work);
                break;
            }
        }
        System.out.println("remove: " + workId);
    }

    public void show(){
        System.out.println("show me-------------------");
        for(Work work : works){
            System.out.println(work.toString());
        }
    }
}
