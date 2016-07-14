package com.ricky.designpattern.observer;

import com.ricky.designpattern.observer.ch1.IObserver;
import com.ricky.designpattern.observer.ch1.ISubject;
import com.ricky.designpattern.observer.ch1.impl.ConcreteObserver;
import com.ricky.designpattern.observer.ch1.impl.ConcreteSubject;

public class StandardObserverDemo {

	public static void main(String[] args) {
		
		ISubject subject = new ConcreteSubject();
		
		IObserver observer1 = new ConcreteObserver();		
		subject.attach(observer1);
		
		IObserver observer2 = new ConcreteObserver();		
		subject.attach(observer2);
		
		IObserver observer3 = new ConcreteObserver();		
		subject.attach(observer3);
		
		subject.notifyObservers("Hello World!");
	}

}
