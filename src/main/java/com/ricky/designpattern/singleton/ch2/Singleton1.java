package com.ricky.designpattern.singleton.ch2;

/**
 * 单例模式-懒汉式
 *
 * @author Ricky Fung
 * @create 2016-07-13 16:12
 */
public class Singleton1 {
	private static Singleton1 instance;
	private Singleton1() {
		System.out.println("call Singleton1 constructor");
	}

	//非线程安全
	public static Singleton1 getInstance() {
		if (instance == null) {
			instance = new Singleton1();
		}
		return instance;
	}
}
