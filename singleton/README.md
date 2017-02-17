## singleton pattern (单例模式)
## 1.模式定义
确保一个类仅有一个实例，并且提供一个访问它的全局访问点。
<br>
## 2.代码示例

### 示例1
单例模式-饿汉式
```
public class Singleton {
    private static final Singleton INSTANCE = new Singleton();

    private Singleton(){
        System.out.println("new Singleton instance");
    }

    public static Singleton getInstance(){
        return INSTANCE;
    }
}
```

### 示例2
单例模式-懒汉式(非线程安全)
```
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
```

### 示例3
单例模式-懒汉式(线程安全)
```
public class Singleton {
    private volatile static Singleton instance;

    private Singleton(){
        System.out.println("new Singleton instance");
    }

    //double-check
    public static Singleton getInstance(){
        if(instance==null){
            synchronized (Singleton.class){
                if(instance==null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
```

### 示例4
单例模式-懒汉式
```
public class Singleton {

    private Singleton(){
        System.out.println("new Singleton instance");
    }

    public static Singleton getInstance(){
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder{
        public static final Singleton INSTANCE = new Singleton();
    }
}
```

### 示例5
单例模式-枚举
```
public enum Singleton {
    INSTANCE("singleton");

    private String value;
    Singleton(String value){
        this.value = value;
    }

    public void doSomeAction(){
        System.out.println("doSomeAction");
    }
}
```

call:
```
Singleton singleton = Singleton.INSTANCE;
singleton.doSomeAction();
```





