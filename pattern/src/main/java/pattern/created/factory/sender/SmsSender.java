package pattern.created.factory.sender;

public class SmsSender implements Sender {  
  
    @Override  
    public void send() {  
        System.out.println("this is sms sender!");  
    }  
} 