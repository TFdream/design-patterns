package com.bytebeats.pattern.observer.ch1;

/**
 * 观察者具体实现对象
 *
 * @author Ricky Fung
 * @create 2016-07-14 23:05
 */
public class ConcreteObserver implements IObserver {

	public void update(Object msg) {
		System.out.println(msg);
	}

}
