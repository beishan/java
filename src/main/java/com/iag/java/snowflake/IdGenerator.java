package com.iag.java.snowflake;

/**
 * @author weixueshan
 * @date 2017/11/14 14:29
 */
public class IdGenerator {
    private static final long START_STMP =      1507183711229L;

    /**
     * 每部分占用的位数
     */

    private static final long IDCENTER_BIT =    5L;
    private static final long BIZ_BIT =         5L;
    private static final long SEQUENCE_BIT =    12L;

    private static final long MAX_IDCENTER =    -1L ^ (-1L << IDCENTER_BIT);
    private static final long MAX_BIZ =         -1L ^ (-1L << BIZ_BIT);
    private static final long MAX_SEQUENCE =    -1L ^ (-1L << SEQUENCE_BIT);

    private static final long BIZ_LEFT =        SEQUENCE_BIT;
    private static final long IDCENTER_LEFT =   SEQUENCE_BIT + BIZ_BIT;
    private static final long TIMESTMP_LEFT =   SEQUENCE_BIT + BIZ_BIT + IDCENTER_BIT;


    private long idcenterid;    // 数据中心ID
    private long bizid;         // 业务ID
    private long sequence = 0L; // 序列号
    private long lastStmp = -1L;// 上一次的时间戳

    public IdGenerator(long idcenterid, long bizid){
        if(idcenterid > MAX_IDCENTER || idcenterid < 0){
            throw new IllegalArgumentException("idwork instance error, illegal idcenterid");
        }
        if(bizid > MAX_BIZ || bizid < 0){
            throw new IllegalArgumentException("idwork instance error, illegal bizid");
        }
        this.idcenterid = idcenterid;
        this.bizid = bizid;
    }

    /**
     * 得到下次
     * @return
     */
    public synchronized long nextId(){
        long currStmp = getNewstmp();

        if(currStmp < lastStmp){
            // 机器时钟错误
            throw new RuntimeException("[idcenter error] Clock moved backwards");
        }

        if(currStmp == lastStmp){
            sequence = (sequence + 1) & MAX_SEQUENCE;

            if(sequence == 0L){
                currStmp = getNextMill();
            }
        }else {
            sequence = 0L;
        }

        lastStmp = currStmp;

        return (currStmp - START_STMP) << TIMESTMP_LEFT
                | idcenterid << IDCENTER_LEFT
                | bizid << BIZ_LEFT
                | sequence;
    }

    private long getNextMill(){
        long currMill = getNewstmp();
        while (currMill <= lastStmp){
            currMill = getNewstmp();
        }
        return currMill;
    }

    private long getNewstmp(){
        return System.currentTimeMillis();
    }
}
