package pattern.structed.adapter;

import pattern.structed.adapter.target.Holder;
import pattern.structed.adapter.target.Targetable;

/**
 * 类适配器：继承对象
 * @author liqiangbiao
 * 2017年11月21日
 */
public class ClassAdapter extends Holder implements Targetable {  
  
    @Override  
    public void adapterMethod() { 
        System.out.println("this is the targetable method!");  
    }  
}