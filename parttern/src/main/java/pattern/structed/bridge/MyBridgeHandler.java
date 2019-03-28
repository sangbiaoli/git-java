package pattern.structed.bridge;
public class MyBridgeHandler extends BridgeHandler {  
    public void method(){  
        getSource().method();  
    }  
}