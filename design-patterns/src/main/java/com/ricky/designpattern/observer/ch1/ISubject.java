package com.ricky.designpattern.observer.ch1;

/**
 * 目标对象接口
 *
 * @author Ricky Fung
 * @create 2016-07-14 23:00
 */
public interface ISubject {

	public void attach(IObserver observer);
	
	public void detach(IObserver observer);
	
	public void notifyObservers(Object msg);
}
