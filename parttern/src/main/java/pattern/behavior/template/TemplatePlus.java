package pattern.behavior.template;
/**
 * 用模板的方法分解，重写模板抽象方法达到正真的计算
 * @author liqiangbiao
 * 2017年11月22日
 */
public class TemplatePlus extends TemplateCalculator {  
  
    @Override  
    public int calculate(int num1,int num2) {  
        return num1 + num2;  
    }  
}