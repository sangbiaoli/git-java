package pattern.structed.decorator;
/**
 *  被装饰者
 * @author liqiangbiao
 * 2017年11月21日
 */
public class Decoration implements Decoratorable {  
  
    @Override  
    public void method() {  
        System.out.println("the original method!");  
    }  
} 