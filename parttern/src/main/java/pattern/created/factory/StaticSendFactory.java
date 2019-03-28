package pattern.created.factory;

import pattern.created.factory.sender.MailSender;
import pattern.created.factory.sender.Sender;
import pattern.created.factory.sender.SmsSender;

public class StaticSendFactory {  
      
    public static Sender produceMail(){  
        return new MailSender();  
    }  
      
    public static Sender produceSms(){  
        return new SmsSender();  
    }  
}  