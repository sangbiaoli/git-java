package pattern.behavior.observer;
/**
 * 观察者1行为实现
 * @author liqiangbiao
 * 2017年11月22日
 */
public class Observer2 implements Observer {  
  
    @Override  
    public void update() {  
        System.out.println("observer2 has received!");  
    }  
  
}  