package com.bytebeats.pattern.builder.ch6;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @create 2016-07-15 13:36
 */
public abstract class Computer {
    protected String cpu;   //cpu
    protected String ram;   //内存
    protected String disk;//硬盘
    protected String os;    //操作系统

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public void setDisk(String disk) {
        this.disk = disk;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public abstract void start();

    @Override
    public String toString() {
        return "Computer{" +
                "cpu='" + cpu + '\'' +
                ", ram='" + ram + '\'' +
                ", disk='" + disk + '\'' +
                ", os='" + os + '\'' +
                '}';
    }
}
