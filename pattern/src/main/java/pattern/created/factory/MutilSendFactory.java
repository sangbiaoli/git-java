package pattern.created.factory;

import pattern.created.factory.sender.MailSender;
import pattern.created.factory.sender.Sender;
import pattern.created.factory.sender.SmsSender;

public class MutilSendFactory {  
      
    public Sender produceMail(){  
        return new MailSender();  
    }  
      
    public Sender produceSms(){  
        return new SmsSender();  
    }  
}  