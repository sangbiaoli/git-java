package pattern.behavior.visit;
public class MyVisitor implements Visitor {  
  
    @Override  
    public void visit(Host sub) {  
        System.out.println("visit the subject："+sub.getSubject());  
    }  
}  