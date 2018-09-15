package com.ldh.generateid.service;


import com.ldh.generateid.entity.IdMata;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ln
 * @description 一共64(第一位为符号),
 */
@Component
public class GenerateIdService implements Generate, Decode {

    /**
     * 2018-09-14 12 点
     */
    private long relativeTime = 1536899629198L;
    /**
     * 元数据
     */
    private IdMata idMata = new IdMata(10, 10, 40, 3);
    /**
     * 版本
     */
    private long version = 1;
    /**
     * 机器编号
     */
    private long machineId = 2;
    /**
     * 列号，递增
     */
    private AtomicInteger sequence = new AtomicInteger(1);

    @Override
    public long nextId() {
        long now = System.currentTimeMillis() - relativeTime;
        if(now <= 0){
            throw new IllegalArgumentException("relativeTime 必须在当前时间之前");
        }
        long id = version << idMata.getVersionLeft();
        now = now << idMata.getTimeStampLeft();
        long machine = machineId << idMata.getMachineLeft();
        long next = nextSequence();
        next = next << idMata.getSequenceLeft();
        id = id | now | machine | next;
        return id;
    }

    private long nextSequence() {
        int sequenceBit = this.idMata.getSequenceBit();
        int max = 2 << (sequenceBit - 1);
        synchronized (this) {
            int next = sequence.getAndIncrement();
            if (next > (max-1)) {
                sequence.set(1);
                return sequence.getAndIncrement();
            }
            return next;
        }
    }


    @Override
    public Date getDate(long id) {
        //去掉版本号
        id = id << (this.idMata.getVersionBit() + 1);
        id = id >> (this.idMata.getVersionBit() + 1);
        //去掉 序列号+ 机器号
        id = id >> 20;
        long realTimeStamp = id + relativeTime;
        return new Date(realTimeStamp);
    }

    @Override
    public long getMachine(long id) {
        id = id << (this.idMata.getVersionBit() + this.idMata.getTimeStampBit() + 1);
        id = id >> (this.idMata.getVersionBit() + this.idMata.getTimeStampBit() + 1);
        long mach = id >> (this.idMata.getSequenceBit());
        return mach;
    }

    @Override
    public long getVersion(long id) {
        long ver = id >> this.idMata.getVersionLeft();
        return ver;
    }

    @Override
    public long getsequence(long id) {
        id = id << (this.idMata.getVersionBit() + this.idMata.getTimeStampBit() + this.idMata.getMachineBit() + 1);
        id = id >>> (this.idMata.getVersionBit() + this.idMata.getTimeStampBit() + this.idMata.getMachineBit() + 1);
        return id;
    }
}
