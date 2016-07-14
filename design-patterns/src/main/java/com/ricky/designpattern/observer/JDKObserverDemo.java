package com.ricky.designpattern.observer;

import com.ricky.designpattern.observer.ch2.SimpleObservable;
import com.ricky.designpattern.observer.ch2.SimpleObserver;

public class JDKObserverDemo {

	public static void main(String[] args) {

		SimpleObservable so = new SimpleObservable("Hello Java");
		
		SimpleObserver view = new SimpleObserver();
		so.addObserver(view);
		
		so.changeInstate("Hello Scala");
	}

}
