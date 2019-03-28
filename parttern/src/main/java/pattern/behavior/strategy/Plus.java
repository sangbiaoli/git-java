package pattern.behavior.strategy;
/**
 * 用公共的抽象类的方法，再实现接口
 * @author liqiangbiao
 * 2017年11月22日
 */
public class Plus extends AbstractCalculator implements ICalculator {  
  
    @Override  
    public int calculate(String exp) {  
        int arrayInt[] = split(exp,"\\+");  
        return arrayInt[0]+arrayInt[1];  
    }  
} 