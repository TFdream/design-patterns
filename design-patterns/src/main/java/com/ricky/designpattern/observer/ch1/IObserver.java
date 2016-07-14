package com.ricky.designpattern.observer.ch1;

/**
 * 观察者接口
 *
 * @author Ricky Fung
 * @create 2016-07-14 23:01
 */
public interface IObserver {

	public void update(Object msg);
//	public void update(ISubject subject, Object msg);
}
