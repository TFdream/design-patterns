package com.mindflow.pattern.builder.ch6;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @create 2016-07-15 13:47
 */
public class ApplePCBuilder extends Builder {

    private AppleComputer appleComputer = new AppleComputer();

    @Override
    public void buildCPU(String cpu) {
        appleComputer.setCpu(cpu);
    }

    @Override
    public void buildRAM(String ram) {
        appleComputer.setRam(ram);
    }

    @Override
    public void buildDisk(String disk) {
        appleComputer.setDisk(disk);
    }

    @Override
    public void buildOs(String os) {
        appleComputer.setOs(os);
    }

    @Override
    public Computer create() {
        return appleComputer;
    }
}
