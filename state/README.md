# state pattern (状态模式)
在很多情况下，一个对象的行为取决于一个或多个动态变化的属性，这样的属性叫做状态，这样的对象叫做有状态的(stateful)对象，这样的对象状态是从事先定义好的一系列值中取出的。
当一个这样的对象与外部事件产生互动时，其内部状态就会改变，从而使得系统的行为也随之发生变化。

## 模式定义
> 允许一个对象在其内部状态改变时改变它的行为，对象看起来似乎修改了它的类。其别名为状态对象(Objects for States)，状态模式是一种对象行为型模式。

用一句话来表述，状态模式把所研究的对象的行为包装在不同的状态对象里，每一个状态对象都属于一个抽象状态类的一个子类。
状态模式的意图是让一个对象在其内部状态改变的时候，其行为也随之改变。

## 角色
状态模式所涉及到的角色有：

* 环境(Context)角色，也成上下文：定义客户端所感兴趣的接口，并且保留一个具体状态类的实例。这个具体状态类的实例给出此环境对象的现有状态。

* 抽象状态(State)角色：定义一个接口，用以封装环境（Context）对象的一个特定的状态所对应的行为。

* 具体状态(ConcreteState)角色：每一个具体状态类都实现了环境（Context）的一个状态所对应的行为。

## 示例代码
### 示例1
上下文环境类:
```
public class Context {
    private State state;//持有一个State类型的对象实例

    public void setState(State state) {
        this.state = state;
    }

    public void request(String param) {
        //转调state来处理
        state.handle(param);
    }
}
```

抽象状态类:
```
public interface State {

    void handle(String param);
}
```

具体状态类:
```
public class ConcreteState1 implements State {

    @Override
    public void handle(String param) {
        System.out.println("ConcreteState1 handle param:" + param);
    }
}
```

客户端类:
```
public class Client {

    public static void main(String[] args) {

        //创建状态
        State state = new ConcreteState1();
        //创建环境
        Context context = new Context();
        //将状态设置到环境中
        context.setState(state);
        //请求
        context.request("test");
    }
}
```

### 示例2




