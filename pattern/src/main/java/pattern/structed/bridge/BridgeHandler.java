package pattern.structed.bridge;
/**
 * 桥接处理器
 * @author liqiangbiao
 * 2017年11月21日
 */
public abstract class BridgeHandler {  
    private Bridge source;  
  
    public void method(){  
        source.method();  
    }  
      
    public Bridge getSource() {  
        return source;  
    }  
  
    public void setSource(Bridge source) {  
        this.source = source;  
    }  
} 