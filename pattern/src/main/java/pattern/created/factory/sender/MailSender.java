package pattern.created.factory.sender;
public class MailSender implements Sender {  
    @Override  
    public void send() {  
        System.out.println("this is mailsender!");  
    }  
}  