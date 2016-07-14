# Design-patterns
## Observer Pattern
### 1.模式定义
定义对象间的一种一对多的依赖关系。当一个对象的状态发生改变时，所有依赖于它的对象都得到通知并被自动更新。
<br>

### 2.模式结构
Subject：主抽象主题角色。通常具有如下功能：
一个主题可以有任意数量的观察者。
抽象主题角色提供观察者注册和退订接口。
当题内部状态改变时，负责通知所有已注册的、有效的观察者。
Observer：抽象观察者角色。定义主题通知对应的更新接口。
ConcreteSubject：具体主题角色
ConcreteObserver：具体观察者角色
<br>

### 3.代码示例
[示例1:标准观察者模式](src/main/java/com/ricky/designpattern/observer/StandardObserverDemo.java)<br>
[示例2:JDK内置接口和类实现观察者模式](src/main/java/com/ricky/designpattern/observer/JDKObserverDemo.java)<br>
<br>




