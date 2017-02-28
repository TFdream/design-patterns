package com.bytebeats.pattern.observer.ch1.impl;

import com.bytebeats.pattern.observer.ch1.Observer;

public class ConcreteObserver1 implements Observer {

	@Override
	public void update(Object msg) {
		System.out.println("观察者1 received:"+msg);
	}

}
