package pattern.structed.proxy;
/**
 * 专业处理的类
 * @author liqiangbiao
 * 2017年11月21日
 */
public class Major implements Proxyable {  
  
    @Override  
    public void method() {  
        System.out.println("the original method!");  
    }  
}  