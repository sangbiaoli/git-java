package pattern.structed.decorator;
/**
 * 被装饰者
 * @author liqiangbiao
 * 2017年11月21日
 */
public class Decorator implements Decoratorable {  
	//被装饰者
    private Decoratorable decoration;  
      
    public Decorator(Decoratorable source){  
        super();  
        this.decoration = source;  
    }  
    
    @Override  
    public void method() {  
        System.out.println("before decorator!");  
        decoration.method();  
        System.out.println("after decorator!");  
    }  
} 