package pattern.created.factory.abstracts;

import pattern.created.factory.sender.Sender;

public interface Provider {  
    public Sender produce();  
}  