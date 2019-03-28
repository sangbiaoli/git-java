package pattern.created.factory.abstracts;

import pattern.created.factory.sender.MailSender;
import pattern.created.factory.sender.Sender;

public class SendMailFactory implements Provider {  
      
    @Override  
    public Sender produce(){  
        return new MailSender();  
    }  
}  
