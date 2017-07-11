package com.mindflow.pattern.singleton.ch2;

/**
 * 单例模式-懒汉式
 *
 * @author Ricky Fung
 * @create 2016-07-13 16:12
 */
public class Singleton {
	private static Singleton instance;
	private Singleton() {
		System.out.println("new Singleton instance");
	}

	//非线程安全
	public static Singleton getInstance() {
		if (instance == null) {
			instance = new Singleton();
		}
		return instance;
	}
}
