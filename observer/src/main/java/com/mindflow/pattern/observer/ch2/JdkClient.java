package com.mindflow.pattern.observer.ch2;

public class JdkClient {

	public static void main(String[] args) {

		MySubject subject = new MySubject("Hello Java");
		
		Observer1 observer1 = new Observer1();
		subject.addObserver(observer1);

		Observer2 observer2 = new Observer2();
		subject.addObserver(observer2);

		subject.changeInstate("Hello Scala");
	}

}
