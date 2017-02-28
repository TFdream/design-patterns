# command pattern (命令模式)
在软件设计中，我们经常需要向某些对象发送请求，但是并不知道请求的接收者是谁，也不知道被请求的操作是哪个，我们只需在程序运行时指定具体的请求接收者即可。
此时，可以使用命令模式来进行设计，使得请求发送者与请求接收者消除彼此之间的耦合，让对象之间的调用关系更加灵活。

命令模式可以对发送者和接收者完全解耦，发送者与接收者之间没有直接引用关系，发送请求的对象只需要知道如何发送请求，而不必知道如何完成请求。这就是命令模式的模式动机。

## 模式定义
> 将一个请求封装为一个对象，从而使我们可用不同的请求对客户进行参数化；对请求排队或者记录请求日志，以及支持可撤销的操作。
> 命令模式是一种对象行为型模式，其别名为动作(Action)模式或事务(Transaction)模式。

## 角色
命令模式包含如下角色：

* 命令(Command)角色：声明了一个给所有具体命令类的抽象接口。

* 具体命令(ConcreteCommand)角色：定义一个接收者和行为之间的弱耦合；实现execute()方法，负责调用接收者的相应操作。execute()方法通常叫做执行方法。

* 请求者(Invoker)角色：负责调用命令对象执行请求，相关的方法叫做行动方法。

* 接收者(Receiver)角色：负责具体实施和执行一个请求。任何一个类都可以成为接收者，实施和执行请求的方法叫做行动方法。

* 客户端(Client)角色：创建一个具体命令(ConcreteCommand)对象并确定其接收者。

## 代理示例
### 示例1
接收者角色类:
```
public class Receiver {

    /**
     * 真正执行命令相应的操作
     */
    public void action(){
        System.out.println("Receiver action");
    }
}
```

抽象命令角色类:
```
public interface Command {

    void execute();
}
```

具体命令角色类:
```
public class ConcreteCommand implements Command {
    //持有相应的接收者对象
    private Receiver receiver;
    /**
     * 构造方法
     */
    public ConcreteCommand(Receiver receiver){
        this.receiver = receiver;
    }
    @Override
    public void execute() {
        //通常会转调接收者对象的相应方法，让接收者来真正执行功能
        receiver.action();
    }

}
```

请求者角色类:
```
public class Invoker {
    private Command command;

    public Invoker(Command command){
        this.command = command;
    }

    public void call(){
        command.execute();
    }
}
```

客户端角色类:
```
public class Client {

    public static void main(String[] args) {

        //创建接收者
        Receiver receiver = new Receiver();
        //创建命令对象，设定它的接收者
        Command command = new ConcreteCommand(receiver);
        //创建请求者，把命令对象设置进去
        Invoker invoker = new Invoker(command);

        //执行方法
        invoker.call();
    }
}
```

### 示例2
小女孩茱丽(Julia)有一个盒式录音机，此录音机有播音(Play)、倒带(Rewind)和停止(Stop)功能，录音机的键盘便是请求者(Invoker)角色；茱丽(Julia)是客户端角色，而录音机便是接收者角色。Command类扮演抽象命令角色，而PlayCommand、StopCommand和RewindCommand便是具体命令类。茱丽(Julia)不需要知道播音(play)、倒带(rewind)和停止(stop)功能是怎么具体执行的，这些命令执行的细节全都由键盘(Keypad)具体实施。茱丽(Julia)只需要在键盘上按下相应的键便可以了。

录音机是典型的命令模式。录音机按键把客户端与录音机的操作细节分割开来。


1.接收者角色，由录音机类扮演:
```
public class AudioPlayer {

    public void play(){
        System.out.println("播放...");
    }

    public void rewind(){
        System.out.println("倒带...");
    }

    public void stop(){
        System.out.println("停止...");
    }
}

```

2.抽象命令角色类:
```
public interface Command {

    void execute();
}
```

3.具体命令角色类:
```
public class PlayCommand implements Command {
    private AudioPlayer audioPlayer;

    public PlayCommand(AudioPlayer audioPlayer){
        this.audioPlayer = audioPlayer;
    }

    @Override
    public void execute() {
        this.audioPlayer.play();
    }
}
```

```
public class RewindCommand implements Command {
    private AudioPlayer audioPlayer;

    public RewindCommand(AudioPlayer audioPlayer){
        this.audioPlayer = audioPlayer;
    }

    @Override
    public void execute() {
        this.audioPlayer.rewind();
    }
}
```

```
public class StopCommand implements Command {
    private AudioPlayer audioPlayer;

    public StopCommand(AudioPlayer audioPlayer){
        this.audioPlayer = audioPlayer;
    }

    @Override
    public void execute() {
        this.audioPlayer.stop();
    }
}
```

4.请求者角色，由键盘类扮演:
```
public class Keypad {
    private Command playCommand;
    private Command rewindCommand;
    private Command stopCommand;

    public Keypad(Command playCommand, Command rewindCommand, Command stopCommand) {
        this.playCommand = playCommand;
        this.rewindCommand = rewindCommand;
        this.stopCommand = stopCommand;
    }

    /**
     * 执行播放方法
     */
    public void play(){
        playCommand.execute();
    }

    /**
     * 执行倒带方法
     */
    public void rewind(){
        rewindCommand.execute();
    }

    /**
     * 执行播放方法
     */
    public void stop(){
        stopCommand.execute();
    }
}
```

5.客户端角色，由茱丽小女孩扮演:
```
public class Julia {

    public static void main(String[] args) {

        //创建接收者对象
        AudioPlayer audioPlayer = new AudioPlayer();

        //创建命令对象
        Command playCommand = new PlayCommand(audioPlayer);
        Command rewindCommand = new RewindCommand(audioPlayer);
        Command stopCommand = new StopCommand(audioPlayer);

        //创建请求者对象
        Keypad keypad = new Keypad(playCommand, rewindCommand, stopCommand);

        //测试
        keypad.play();
        keypad.rewind();
        keypad.stop();
        keypad.play();
        keypad.stop();
    }
}
```


## 优点
命令模式的优点:

* 降低系统的耦合度。
* 新的命令可以很容易地加入到系统中。
* 可以比较容易地设计一个命令队列和宏命令（组合命令）。
* 可以方便地实现对请求的Undo和Redo。

## 缺点
命令模式的缺点:

使用命令模式可能会导致某些系统有过多的具体命令类。因为针对每一个命令都需要设计一个具体命令类，因此某些系统可能需要大量具体命令类，这将影响命令模式的使用。
