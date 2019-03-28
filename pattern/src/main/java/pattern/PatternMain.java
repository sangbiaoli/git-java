package pattern;

import pattern.behavior.chain.MyHandler;
import pattern.behavior.command.Command;
import pattern.behavior.command.Invoker;
import pattern.behavior.command.MyCommand;
import pattern.behavior.command.Receiver;
import pattern.behavior.interpreter.ExpContext;
import pattern.behavior.interpreter.ExpMinus;
import pattern.behavior.interpreter.ExpPlus;
import pattern.behavior.iterator.Collection;
import pattern.behavior.iterator.Iterator;
import pattern.behavior.iterator.MyCollection;
import pattern.behavior.mediator.Mediator;
import pattern.behavior.mediator.MyMediator;
import pattern.behavior.memo.Original;
import pattern.behavior.memo.Storage;
import pattern.behavior.observer.MySubject;
import pattern.behavior.observer.Observer1;
import pattern.behavior.observer.Observer2;
import pattern.behavior.observer.Subject;
import pattern.behavior.state.Context;
import pattern.behavior.state.State;
import pattern.behavior.strategy.ICalculator;
import pattern.behavior.strategy.Plus;
import pattern.behavior.template.TemplateCalculator;
import pattern.behavior.template.TemplatePlus;
import pattern.behavior.visit.Host;
import pattern.behavior.visit.MyHost;
import pattern.behavior.visit.MyVisitor;
import pattern.behavior.visit.Visitor;
import pattern.created.builder.Builder;
import pattern.created.factory.MutilSendFactory;
import pattern.created.factory.NormalSendFactory;
import pattern.created.factory.StaticSendFactory;
import pattern.created.factory.abstracts.SendMailFactory;
import pattern.created.factory.abstracts.SendSmsFactory;
import pattern.created.factory.sender.Sender;
import pattern.created.singleton.Singleton;
import pattern.structed.adapter.ClassAdapter;
import pattern.structed.adapter.WrapperAdapter;
import pattern.structed.adapter.interfaces.Adapter1;
import pattern.structed.adapter.interfaces.Adapter2;
import pattern.structed.adapter.interfaces.Adapterable;
import pattern.structed.adapter.targets.Holder;
import pattern.structed.adapter.targets.Targetable;
import pattern.structed.bridge.Bridge;
import pattern.structed.bridge.Bridge1;
import pattern.structed.bridge.Bridge2;
import pattern.structed.bridge.BridgeHandler;
import pattern.structed.bridge.MyBridgeHandler;
import pattern.structed.composite.Tree;
import pattern.structed.composite.TreeNode;
import pattern.structed.decorator.Decoration;
import pattern.structed.decorator.Decorator;
import pattern.structed.decorator.Decoratorable;
import pattern.structed.facade.Computer;
import pattern.structed.proxy.Proxy;
import pattern.structed.proxy.Proxyable;

public class PatternMain {
	public static void main(String[] args) {
		//1.1 普通工厂模式
		NormalSendFactory normalSendFactory = new NormalSendFactory();  
        Sender sender = normalSendFactory.produce("sms");  
        sender.send();  
        //1.2 多工厂模式
        MutilSendFactory mutilSendFactory = new MutilSendFactory();
        sender = mutilSendFactory.produceMail();
        sender.send();
        //1.3 静态工厂模式
        sender = StaticSendFactory.produceSms();
        sender.send();
        //2 抽象工厂模式
        Sender mailSender = new SendMailFactory().produce();
        Sender smSender = new SendSmsFactory().produce();
        mailSender.send();
        smSender.send();
        //3 单例模式
        System.out.println(Singleton.getInstance().toString());
        //4 建造者模式
        Builder builder = new Builder();
        builder.produceMailSender(10);
        builder.produceSmsSender(10);
        //6.1 类适配器
        Targetable target = new ClassAdapter();  
        target.reservedMethod();
        target.adapterMethod(); 
        //6.2 对象适配器
        target = new WrapperAdapter(new Holder());
        target.reservedMethod();
        target.adapterMethod(); 
        //6.3 接口适配器
        Adapterable adapter1 = new Adapter1();  
        Adapterable adapter2 = new Adapter2();  
        adapter1.method1();  
        adapter1.method2();  
        adapter2.method1();  
        adapter2.method2();  
        //7 装饰者模式
        Decoratorable source = new Decoration();  
        Decoratorable obj = new Decorator(source);  
        obj.method();
        //8 代理模式
        Proxyable proxy = new Proxy();  
        proxy.method();
        //9 外观模式
        Computer computer = new Computer();  
        computer.startup();  
        computer.shutdown();  
        //10 桥接模式
        BridgeHandler bridgeHandler = new MyBridgeHandler();  
        /*调用第一个对象*/  
        Bridge bridge1 = new Bridge1();  
        bridgeHandler.setSource(bridge1);  
        bridgeHandler.method();  
        /*调用第二个对象*/  
        Bridge bridge2 = new Bridge2();  
        bridgeHandler.setSource(bridge2);  
        bridgeHandler.method(); 
        
        //11 组合模式
        Tree tree = new Tree("A");  
        TreeNode nodeB = new TreeNode("B");  
        TreeNode nodeC = new TreeNode("C");  
          
        nodeB.add(nodeC);  
        tree.getRoot().add(nodeB);  
        System.out.println("build the tree finished!");  
        //12 享元模式
//        ConnectionPool pool = ConnectionPool.getInstance();
//        pool.getConnection();
        //13 策略模式
        String exp = "2+8";  
        ICalculator cal = new Plus();  
        int result = cal.calculate(exp);  
        System.out.println(result); 
        //14 模板模式
        TemplateCalculator temp = new TemplatePlus();  
        result = temp.calculate(exp, "\\+");
        System.out.println(result);
        //15 观察者模式
        Subject sub = new MySubject();  
        sub.add(new Observer1());  
        sub.add(new Observer2());  
        sub.operation(); 
        //16 迭代模式
        Collection collection = new MyCollection();  
        Iterator it = collection.iterator();  
          
        while(it.hasNext()){  
            System.out.println(it.next());  
        }  
        //17 责任链
        MyHandler h1 = new MyHandler("h1");  
        MyHandler h2 = new MyHandler("h2");  
        MyHandler h3 = new MyHandler("h3");  
        h1.setHandler(h2);  
        h2.setHandler(h3);  
        h1.operator();  
        //18 命令模式：
        Receiver receiver = new Receiver();  
        Command cmd = new MyCommand(receiver);  
        Invoker invoker = new Invoker(cmd);  
        invoker.action();  
        //19 备忘录模式：A创建备忘录B，同时B交由备忘录储存C打理，A随意改动都，可以从C回复过来
        Original origi = new Original("egg");  
        // 创建备忘录  
        Storage storage = new Storage(origi.createMemento());  
        // 修改原始类的状态  
        System.out.println("初始化状态为：" + origi.getValue());  
        origi.setValue("niu");  
        System.out.println("修改后的状态为：" + origi.getValue());  
        // 回复原始类的状态  
        origi.restoreMemento(storage.getMemento());  
        System.out.println("恢复后的状态为：" + origi.getValue()); 
        //20 状态模式：A有n种状态，不同状态执行不同方法
        State state = new State();  
        Context context = new Context(state);  
        //设置第一种状态  
        state.setValue("state1");  
        context.method();  
        //设置第二种状态  
        state.setValue("state2");  
        context.method();  
        //21 访问者模式:A接受B，B调用A的方法实现接受方法
        Visitor visitor = new MyVisitor();  
        Host host = new MyHost();  
        host.accept(visitor); 
        //22 中介者模式：一项工作有须由A,B两人完成，为了防止相互持有，有中介者C统一协调A,B，由它安排工作开展
        Mediator mediator = new MyMediator();  
        mediator.createMediator();  
        mediator.workAll(); 
        //23 解释器模式：每个的解析都跟上下文有关
        result = new ExpMinus().interpret((new ExpContext(new ExpPlus().interpret(new ExpContext(9, 2)), 8)));  
        System.out.println(result);  
	}
}
