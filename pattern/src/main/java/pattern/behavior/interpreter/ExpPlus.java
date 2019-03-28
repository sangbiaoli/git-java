package pattern.behavior.interpreter;
public class ExpPlus implements Expression {  
  
    @Override  
    public int interpret(ExpContext context) {  
        return context.getNum1()+context.getNum2();  
    }  
}  