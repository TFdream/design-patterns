# observer pattern (观察者模式)
## 模式定义
> 定义对象间的一种一对多的依赖关系。当一个对象的状态发生改变时，所有依赖于它的对象都得到通知并被自动更新。

## 模式结构
* Subject：主抽象主题角色。通常具有如下功能：
  + 一个主题可以有任意数量的观察者。
  + 抽象主题角色提供观察者注册和退订接口。
  + 当主题内部状态改变时，负责通知所有已注册的、有效的观察者。
* Observer：抽象观察者角色。定义主题通知对应的更新接口。
* ConcreteSubject：具体主题角色
* ConcreteObserver：具体观察者角色
<br>
![GitHub](http://www.ibm.com/developerworks/cn/java/j-lo-design-pattern-extention/img001.png "GitHub,Social Coding")
<br>

## 代码示例
### 示例1
标准观察者模式
```
public interface Observer {

	void update(Object msg);
}
```

```
public class ConcreteObserver1 implements Observer {

	@Override
	public void update(Object msg) {
		System.out.println("观察者1 received:"+msg);
	}

}
```

```
public class ConcreteObserver2 implements Observer {

	@Override
	public void update(Object msg) {
		System.out.println("观察者2 received:"+msg);
	}

}
```

主题(目标)
```
public interface Subject {

	void attach(Observer observer);

	void detach(Observer observer);

	void notifyObservers(Object msg);
}
```

```
public class ConcreteSubject implements Subject {

	private List<Observer> observers = new ArrayList<>();

	@Override
	public void attach(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void detach(Observer observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObservers(Object msg) {
		System.out.println("主题发生变化, 通知所有观察者");
		for (Observer observer : observers) {
			observer.update(msg);
		}
	}

}
```

client:
```
public class Client {

	public static void main(String[] args) {

		Subject subject = new ConcreteSubject();

		Observer observer1 = new ConcreteObserver1();
		subject.attach(observer1);

		Observer observer2 = new ConcreteObserver2();
		subject.attach(observer2);

		subject.notifyObservers("Hello World!");
	}

}
```

### 示例2
JDK内置接口和类实现观察者模式<br>

观察者：
```
import java.util.Observable;
import java.util.Observer;

public class Observer1 implements Observer {

	public void update(Observable observer, Object msg) {
		System.out.println("Observer1 Received data has changed to" + observer + " msg:"+msg);
	}

}
```

```
import java.util.Observable;
import java.util.Observer;

public class Observer2 implements Observer {

	public void update(Observable observer, Object msg) {
		System.out.println("Observer2 Received data has changed to" + observer + " msg:"+msg);
	}

}
```

主题：
```
import java.util.Observable;

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
```

client:
```

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
```


