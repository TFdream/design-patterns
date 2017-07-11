package com.mindflow.pattern.observer.ch1.impl;

import com.mindflow.pattern.observer.ch1.Observer;

public class ConcreteObserver2 implements Observer {

	@Override
	public void update(Object msg) {
		System.out.println("观察者2 received:"+msg);
	}

}
