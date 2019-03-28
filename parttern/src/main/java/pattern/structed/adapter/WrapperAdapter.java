package pattern.structed.adapter;

import pattern.structed.adapter.target.Holder;
import pattern.structed.adapter.target.Targetable;

/**
 * 对象适配器：内置对象
 * @author liqiangbiao
 * 2017年11月21日
 */
public class WrapperAdapter implements Targetable {  
  
    private Holder source;  
      
    public WrapperAdapter(Holder source){  
        super();  
        this.source = source;  
    }

	@Override
	public void reservedMethod() {
		source.reservedMethod();
	}

	@Override
	public void adapterMethod() {
        System.out.println("this is the targetable method!");  
	}  
    
}  