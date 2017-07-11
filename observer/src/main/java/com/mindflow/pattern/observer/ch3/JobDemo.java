package com.mindflow.pattern.observer.ch3;

import java.util.ArrayList;
import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @create 2017-03-26 14:20
 */
public class JobDemo {

    public static void main(String[] args) {

        Headhunter headhunter = new Headhunter("mike");

        headhunter.attach(new JobSeeker("coco"));
        headhunter.attach(new JobSeeker("emily"));
        headhunter.attach(new JobSeeker("jane"));

        List<Job> jobs = new ArrayList<>();
        jobs.add(new Job("Java高级工程师", "北京", 18000d));
        jobs.add(new Job("Golang高级工程师", "杭州", 15000d));
        jobs.add(new Job("公司前台", "北京", 5000d));

        headhunter.updateJobs(jobs);
    }
}
