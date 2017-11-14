package com.iag.java.multithreading;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ${user}
 * @date ${date}-${time}
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Work {
    private String              id;
    private Ipwork              ipwork;

    public void work(String command){
        ipwork.work(command);
    }
}
