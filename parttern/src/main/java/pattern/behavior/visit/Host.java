package pattern.behavior.visit;
public interface Host {  
    public void accept(Visitor visitor);  
    public String getSubject();  
}  