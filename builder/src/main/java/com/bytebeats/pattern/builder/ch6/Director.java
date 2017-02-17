package com.bytebeats.pattern.builder.ch6;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @create 2016-07-15 13:53
 */
public class Director {
    private Builder mBuilder;

    public Director(Builder builder) {
        mBuilder = builder;
    }

    public void construct(String cpu, String ram, String disk, String os) {
        mBuilder.buildCPU(cpu);
        mBuilder.buildRAM(ram);
        mBuilder.buildDisk(disk);
        mBuilder.buildOs(os);
    }
}
