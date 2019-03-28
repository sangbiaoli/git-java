package pattern.structed.proxy;
/**
 * 代理请用专业类，处理专业的事
 * @author liqiangbiao
 * 2017年11月21日
 */
public class Proxy implements Proxyable {  
  
    private Major source;  
    public Proxy(){  
        super();  
        this.source = new Major();  
    }  
    @Override  
    public void method() {  
        before();  
        source.method();  
        atfer();  
    }  
    private void atfer() {  
        System.out.println("after proxy!");  
    }  
    private void before() {  
        System.out.println("before proxy!");  
    }  
}  