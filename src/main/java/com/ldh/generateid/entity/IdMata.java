package com.ldh.generateid.entity;

/**
 * @author Ln
 * @create 2018-09-14:11:08 AM
 * <p>
 **/
public class IdMata {

    private int sequenceBit;
    private int sequenceLeft;
    /**
     * 机器号位
     */
    private int machineBit;
    private int machineLeft;
    /**
     * 时间戳位
     */
    private int timeStampBit;
    private int timeStampLeft;
    /**
     * 版本位
     */
    private int versionBit;
    private int versionLeft;

    private final int length = 63;

    public IdMata(int sequenceBit, int machineBit, int timeStampBit, int versionBit) {
        int len = sequenceBit + machineBit + timeStampBit + versionBit;
        if (len != this.length) {
            throw new IllegalArgumentException("长度必须等于 " + this.length);
        }
        this.sequenceBit = sequenceBit;
        this.machineBit = machineBit;
        this.timeStampBit = timeStampBit;
        this.versionBit = versionBit;

        this.versionLeft = this.length - this.versionBit;
        this.timeStampLeft = this.versionLeft - this.timeStampBit;
        this.machineLeft = this.timeStampLeft - this.machineBit;
        this.sequenceLeft = this.machineLeft - this.sequenceBit;
    }

    public int getSequenceLeft() {
        return sequenceLeft;
    }

    public void setSequenceLeft(int sequenceLeft) {
        this.sequenceLeft = sequenceLeft;
    }

    public int getMachineLeft() {
        return machineLeft;
    }

    public void setMachineLeft(int machineLeft) {
        this.machineLeft = machineLeft;
    }

    public int getTimeStampLeft() {
        return timeStampLeft;
    }

    public void setTimeStampLeft(int timeStampLeft) {
        this.timeStampLeft = timeStampLeft;
    }

    public int getVersionLeft() {
        return versionLeft;
    }

    public void setVersionLeft(int versionLeft) {
        this.versionLeft = versionLeft;
    }

    public int getLength() {
        return length;
    }


    public int getSequenceBit() {
        return sequenceBit;
    }

    public void setSequenceBit(int sequenceBit) {
        this.sequenceBit = sequenceBit;
    }

    public int getVersionBit() {
        return versionBit;
    }

    public void setVersionBit(int versionBit) {
        this.versionBit = versionBit;
    }

    public int getTimeStampBit() {
        return timeStampBit;
    }

    public void setTimeStampBit(int timeStampBit) {
        this.timeStampBit = timeStampBit;
    }

    public int getMachineBit() {
        return machineBit;
    }

    public void setMachineBit(int machineBit) {
        this.machineBit = machineBit;
    }
}
