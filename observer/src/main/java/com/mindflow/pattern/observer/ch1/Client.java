package com.mindflow.pattern.observer.ch1;

import com.mindflow.pattern.observer.ch1.impl.ConcreteObserver1;
import com.mindflow.pattern.observer.ch1.impl.ConcreteObserver2;
import com.mindflow.pattern.observer.ch1.impl.ConcreteSubject;

public class Client {

	public static void main(String[] args) {

		Subject subject = new ConcreteSubject();
		
		Observer observer1 = new ConcreteObserver1();
		subject.attach(observer1);
		
		Observer observer2 = new ConcreteObserver2();
		subject.attach(observer2);
		
		subject.notifyObservers("Hello World!");
	}

}
