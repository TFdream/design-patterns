package com.bytebeats.pattern.observer.ch1.impl;

import com.bytebeats.pattern.observer.ch1.Observer;
import com.bytebeats.pattern.observer.ch1.Subject;

import java.util.ArrayList;
import java.util.List;

public class ConcreteSubject implements Subject {

	private List<Observer> observers = new ArrayList<>();

	@Override
	public void attach(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void detach(Observer observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObservers(Object msg) {
		System.out.println("主题发生变化, 通知所有观察者");
		for (Observer observer : observers) {
			observer.update(msg);
		}
	}

}
