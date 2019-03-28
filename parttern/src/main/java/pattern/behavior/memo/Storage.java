package pattern.behavior.memo;
/**
 * Storage类是存储备忘录的类，持有Memento类的实例
 * @author liqiangbiao
 * 2017年11月23日
 */
public class Storage {  
      
    private Memento memento;  
      
    public Storage(Memento memento) {  
        this.memento = memento;  
    }  
  
    public Memento getMemento() {  
        return memento;  
    }  
  
    public void setMemento(Memento memento) {  
        this.memento = memento;  
    }  
}  