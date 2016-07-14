package com.ricky.designpattern.observer.ch1.impl;

import java.util.ArrayList;
import java.util.List;

import com.ricky.designpattern.observer.ch1.IObserver;
import com.ricky.designpattern.observer.ch1.ISubject;

/**
 * 目标对象具体实现
 *
 * @author Ricky Fung
 * @create 2016-07-14 23:03
 */
public class ConcreteSubject implements ISubject {

	private List<IObserver> observers = new ArrayList<IObserver>();
	
	public void attach(IObserver observer) {
		observers.add(observer);
	}

	public void detach(IObserver observer) {
		observers.remove(observer);
	}

	public void notifyObservers(Object msg) {
		for (IObserver observer : observers) {
			observer.update(msg);
		}
	}

}
