package com.ricky.designpattern.observer.ch2;

import java.util.Observable;

/**
 * 目标对象
 * @author Ricky
 *
 */
public class SimpleObservable extends Observable {
	private String inState;
	
	public SimpleObservable(String inState) {
		this.inState = inState;
	}
	
	public String getState() {
		return inState;
	}
	
	public void changeInstate(String newState) {
		if (!newState.equals(inState)) {
			this.inState = newState;
			//setChanged() 后 notifyObservers() 才生效
			setChanged();
		}
		notifyObservers();
	}	
}
