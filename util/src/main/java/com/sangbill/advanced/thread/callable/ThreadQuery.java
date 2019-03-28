package com.sangbill.advanced.thread.callable;

import java.util.List;
import java.util.concurrent.Callable;

/**
 * Created by df on 2018/9/20.
 */
public class ThreadQuery implements Callable<List> {

	SqlHadle sqlHadle = new SqlHadle();

	private String search;// 查询条件 根据条件来定义该类的属性

	private int index;// 当前页数

	private int num;// 每页查询多少条

	private String table;// 要查询的表名，也可以写死，也可以从前面传

	private List page;// 每次分页查出来的数据

	public ThreadQuery(int index, int num, String table) {
		this.index = index;
		this.num = num;
		this.table = table;	
	}

	public List call() throws Exception {
		long t1 = System.currentTimeMillis();
		page = sqlHadle.query(index, num, table);
		long t2 = System.currentTimeMillis();
		System.out.println(String.format("index:%s,cost:%s ms", index,(t2-t1)));
		return page;
	}
}