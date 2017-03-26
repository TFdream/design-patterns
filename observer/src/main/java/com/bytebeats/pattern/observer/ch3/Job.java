package com.bytebeats.pattern.observer.ch3;

/**
 * 职位信息
 *
 * @author Ricky Fung
 * @create 2017-03-26 14:12
 */
public class Job {
    private String title;
    private String location;
    private double salary;

    public Job(String title, String location, double salary) {
        this.title = title;
        this.location = location;
        this.salary = salary;
    }

    public String getTitle() {
        return title;
    }

    public String getLocation() {
        return location;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Job{" +
                "title='" + title + '\'' +
                ", location='" + location + '\'' +
                ", salary=" + salary +
                '}';
    }
}
