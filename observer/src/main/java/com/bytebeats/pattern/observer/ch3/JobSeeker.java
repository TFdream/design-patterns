package com.bytebeats.pattern.observer.ch3;

/**
 * 求职者
 *
 * @author Ricky Fung
 * @create 2017-03-26 13:52
 */
public class JobSeeker implements Observer {
    private String name;

    public JobSeeker(String name) {
        this.name = name;
    }

    @Override
    public void update(Subject subject) {

        Headhunter headhunter = (Headhunter) subject;
        System.out.println(name+" received jobs:"+headhunter.getJobs()+" from headhunter:"+headhunter.getName());
    }
}
