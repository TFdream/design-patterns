package com.bytebeats.pattern.observer.ch2;

import com.bytebeats.pattern.observer.ch2.SimpleObservable;
import com.bytebeats.pattern.observer.ch2.SimpleObserver;

public class JdkObserverDemo {

	public static void main(String[] args) {

		SimpleObservable so = new SimpleObservable("Hello Java");
		
		SimpleObserver view = new SimpleObserver();
		so.addObserver(view);
		
		so.changeInstate("Hello Scala");
	}

}
