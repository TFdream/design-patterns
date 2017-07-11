package com.mindflow.pattern.observer.ch2;

import java.util.Observable;

/**
 * 目标对象
 *
 */
public class MySubject extends Observable {
	private String data;
	
	public MySubject(String data) {
		this.data = data;
	}
	
	public String getData() {
		return data;
	}
	
	public void changeInstate(String data) {
		if (this.data!=null && !this.data.equals(data)) {
			this.data = data;
			//setChanged() 后 notifyObservers() 才生效
			setChanged();
		}
		notifyObservers(getData());
	}	
}
