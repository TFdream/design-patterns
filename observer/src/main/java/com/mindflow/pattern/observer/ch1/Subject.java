package com.mindflow.pattern.observer.ch1;

/**
 * 目标对象接口
 *
 * @author Ricky Fung
 * @create 2016-07-14 23:00
 */
public interface Subject {

	void attach(Observer observer);
	
	void detach(Observer observer);
	
	void notifyObservers(Object msg);
}
