package com.bytebeats.pattern.observer.ch2;

import java.util.Observable;
import java.util.Observer;

/**
 * 观察者
 * @author Ricky
 *
 */
public class SimpleObserver implements Observer {
	
	public void update(Observable observer, Object msg) {
		System.out.println("Data has changed to" + observer + " msg:"+msg);
	}
	
}