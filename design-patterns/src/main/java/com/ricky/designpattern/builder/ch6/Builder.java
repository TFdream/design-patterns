package com.ricky.designpattern.builder.ch6;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @create 2016-07-15 13:46
 */
public abstract class Builder {
    // 设置CPU
    public abstract void buildCPU(String cpu);

    // 设置内存
    public abstract void buildRAM(String ram);

    // 设置硬盘
    public abstract void buildDisk(String disk);

    // 设置操作系统
    public abstract void buildOs(String os);

    public abstract Computer create();
}
