package pattern.behavior.observer;

import java.util.Enumeration;
import java.util.Vector;
/**
 * 通过抽象类实现观察者的操作：移除，添加，通知观察者
 * @author liqiangbiao
 * 2017年11月22日
 */
public abstract class AbstractSubject implements Subject {  
  
    private Vector<Observer> vector = new Vector<Observer>();  
    @Override  
    public void add(Observer observer) {  
        vector.add(observer);  
    }  
  
    @Override  
    public void del(Observer observer) {  
        vector.remove(observer);  
    }  
  
    @Override  
    public void notifyObservers() {  
        Enumeration<Observer> enumo = vector.elements();  
        while(enumo.hasMoreElements()){  
            enumo.nextElement().update();  
        }  
    }  
}  