package com.mindflow.pattern.observer.ch2;

import java.util.Observable;
import java.util.Observer;

public class Observer2 implements Observer {
	
	public void update(Observable observer, Object msg) {
		System.out.println("Observer2 Received data has changed to" + observer + " msg:"+msg);
	}
	
}