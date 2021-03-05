package io.bitmuse.designpatterns.singleton.lazy;

/**
 * 单例模式-懒汉式【非线程安全】
 * @author Ricky Fung
 */
public class LazySingleton {
	private static LazySingleton instance;
	private LazySingleton() {
		System.out.println("new Singleton instance");
	}

	//非线程安全
	public static LazySingleton getInstance() {
		if (instance == null) {
			instance = new LazySingleton();
		}
		return instance;
	}
}
