package com.bytebeats.pattern.observer.ch3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 猎头
 *
 * @author Ricky Fung
 * @create 2017-03-26 13:53
 */
public class Headhunter implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private String name;
    private List<Job> jobs;

    public Headhunter(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /**更新职位列表**/
    public void updateJobs(List<Job> jobs) {
        this.jobs = jobs;
        notifyObservers();
    }

    public List<Job> getJobs() {
        return Collections.unmodifiableList(this.jobs);
    }

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {

        for (Observer observer : observers){
            observer.update(this);
        }
    }
}
