package pattern.behavior.memo;
/**
 * Memento类是备忘录类
 * @author liqiangbiao
 * 2017年11月23日
 */
public class Memento {  
      
    private String value;  
  
    public Memento(String value) {  
        this.value = value;  
    }  
  
    public String getValue() {  
        return value;  
    }  
  
    public void setValue(String value) {  
        this.value = value;  
    }
}
   