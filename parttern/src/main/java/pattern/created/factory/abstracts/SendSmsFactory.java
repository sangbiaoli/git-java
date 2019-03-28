package pattern.created.factory.abstracts;

import pattern.created.factory.sender.Sender;
import pattern.created.factory.sender.SmsSender;

public class SendSmsFactory implements Provider{  
  
    @Override  
    public Sender produce() {  
        return new SmsSender();  
    }  
}  