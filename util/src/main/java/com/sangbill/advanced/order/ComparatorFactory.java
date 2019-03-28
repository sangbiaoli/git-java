package com.sangbill.advanced.order;
import java.util.Comparator;

public class ComparatorFactory<T> {
	public Comparator<? super T> createComparator(String propertyName, String order) {
		return new TComparator(propertyName, order);
	}

	public class TComparator implements Comparator<T> {
		private String propertyName;
		private String order;

		public TComparator(String propertyName, String order) {
			this.propertyName = propertyName;
			this.order = order;
		}

		public int compare(T o1, T o2) {
			int result = 0;
			try {		
				result = LangUtils.TCompareTo(RefUtils.invokeGetterMethod(o1, propertyName).toString(), 
											  RefUtils.invokeGetterMethod(o2, propertyName).toString(),
											  o1.getClass().getDeclaredField(propertyName).getType());
			} catch (Exception e) {
				e.printStackTrace();
			}
			result = "asc".equals(order) ? result : -result;
			return result;
		}
	}
}
