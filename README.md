# Design-patterns
Design patterns written in java
## Singleton
### 模式定义

## Builder
### 模式定义
造者模式(Builder Pattern)：将一个复杂对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示。
建造者模式是一步一步创建一个复杂的对象，它允许用户只通过指定复杂对象的类型和内容就可以构建它们，用户不需要知道内部的具体构建细节。建造者模式属于对象创建型模式。根据中文翻译的不同，建造者模式又可以称为生成器模式。

### 模式结构
建造者模式包含如下角色：<br>
* Builder：抽象建造者
* ConcreteBuilder：具体建造者
* Director：指挥者
* Product：产品角色

###代码示例
[示例1](src/main/java/com/ricky/designpattern/builder/PersonBuilderDemo.java)
[示例2](src/main/java/com/ricky/designpattern/builder/CarDemo.java)
[示例3](src/main/java/com/ricky/designpattern/builder/MessageDemo.java)
[示例4](src/main/java/com/ricky/designpattern/builder/MessageDemo.java)
<br>
### 优缺点
#### 优点
* 在建造者模式中， 客户端不必知道产品内部组成的细节，将产品本身与产品的创建过程解耦，使得相同的创建过程可以创建不同的产品对象。

#### 缺点
* 使用Builder模式是肯定会增加代码量的。此外，尽管客户端的代码可读性明显改善，但随之而来的客户端代码变得更加冗长。
* Builder会增加个类代码，这也意味着开发者在给类增加属性时有时会忘记给该属性添加支持的builder。

### 适用场景
在以下情况下可以使用建造者模式：<br>
* 需要生成的产品对象有复杂的内部结构，这些产品对象通常包含多个成员属性。
* 需要生成的产品对象的属性相互依赖，需要指定其生成顺序。

### 与工厂模式的区别
