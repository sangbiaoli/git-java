package com.sangbill.advanced.candle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.sangbill.util.DateUtil;

public class CandleNodeUtil {
	private static final int FLOW = 20;
	private static final int UNIT = 100;
	private static Random r = new Random();
	public static final int RISE = 1;
	public static final int FALL = 0;
	/**
	 * 获取随机数值
	 * @author liqiangbiao
	 * 2017年4月15日
	 *  @return
	 * int
	 */
	private static int getRandom() {
		return UNIT * r.nextInt(FLOW);
	}
	/**
	 * 创建第一个节点
	 * @author liqiangbiao
	 * 2017年4月16日
	 *  @param base
	 *  @param startDate
	 *  @return
	 * List<Ts>
	 */
	public static List<Ts> creatFirst(int base, Date startDate) {
		List<Ts> list = new ArrayList<Ts>(1);
		startDate = DateUtil.addDate(startDate, 1);
		int open = base + getRandom();
		int close = base + getRandom();
		int low = Math.min(open, close) - getRandom() / 2;
		int high = Math.max(open, close) + getRandom() / 2;
		Ts vo = new Ts(startDate, open, close, high, low);
		list.add(vo);
		return list;
	}
	/**
	 * 创建上升趋势蜡烛节点
	 * @author liqiangbiao
	 * 2017年4月15日
	 *  @param base
	 *  @param startDate
	 *  @param count
	 *  @return
	 * List<Ts>
	 */
	
	public static List<Ts> createRaise(Ts last, int count) {
		Date startDate = last.getDate();
		Ts pre = null;
		int base = 0;
		int low = 0;
		int open = 0;
		int close = 0;
		int high = 0;
		List<Ts> list = new ArrayList<Ts>(count);
		for (int i = 0; i < count; i++) {
			pre = (i == 0)?last:list.get(i - 1);
			startDate = DateUtil.addDate(startDate, 1);
			base = Math.max(pre.getOpen(), pre.getClose());
			open = base + getRandom();
			close = base + getRandom();
			low = Math.min(open, close) - getRandom() / 2;
			high = Math.max(open, close) + getRandom() / 2;
			Ts vo = new Ts(startDate, open, close, high, low);
			list.add(vo);
		}
		return list;
	}
	/**
	 * 创建下降趋势蜡烛节点
	 * @author liqiangbiao
	 * 2017年4月15日
	 *  @param base
	 *  @param startDate
	 *  @param count
	 *  @return
	 * List<Ts>
	 */
	public static List<Ts> createFall(Ts last, int count) {
		Date startDate = last.getDate();
		Ts pre = null;
		int base = 0;
		int low = 0;
		int open = 0;
		int close = 0;
		int high = 0;
		List<Ts> list = new ArrayList<Ts>(count);
		for (int i = 0; i < count; i++) {
			pre = (i == 0)?last:list.get(i - 1);
			startDate = DateUtil.addDate(startDate, 1);
			base = Math.min(pre.getOpen(), pre.getClose());
			open = base - getRandom();
			close = base - getRandom();
			low = Math.min(open, close) - getRandom() / 2;
			high = Math.max(open, close) + getRandom() / 2;
			Ts vo = new Ts(startDate, open, close, high, low);
			list.add(vo);
		}
		return list;
	}
	/**
	 * 创建上吊先或锤子线   ：它们下影线较长，而实体较小并且在其全天价格区里，实体处在顶端的位置。
	 * @author liqiangbiao
	 * 2017年4月15日
	 * @param state 
	 *  @param base
	 *  @param startDate
	 *  @return
	 * Ts
	 */
	public static Ts createHammer(Ts last, int state) {
		int base = (state == RISE)?last.getHigh():last.getLow();
		Date startDate = last.getDate();
		
		startDate = DateUtil.addDate(startDate, 1);
		int open = base + getRandom();
		int close = base + getRandom();
		int high = Math.max(open, close);
		int low = Math.min(open, close) - Math.abs(close - open)*2;
		Ts vo = new Ts(startDate, open, close, high, low);
		return vo;
	}
	/**
	 *创建吞没蜡烛节点：两根颜色相反的蜡烛线实体，后一根实体吞没前一根
	 */
	public static List<Ts> createSwallow(Ts last,int state) {
		int base = (state == RISE)?last.getHigh():last.getLow();
		Date startDate = last.getDate();
		
		int low = 0;
		int open = 0;
		int close = 0;
		int high = 0;
		int min = 0;
		int max = 0;
		List<Ts> list = new ArrayList<Ts>(2);
		//小实体
		startDate = DateUtil.addDate(startDate, 1);
		open = base + getRandom()/2;
		close = base - getRandom()/2;
		low = Math.min(open, close) - getRandom() / 2;
		high = Math.max(open, close) + getRandom() / 2;
		min = Math.min(open, close);
		max = Math.max(open, close);
		Ts nodeFst = (state == FALL)?new Ts(startDate, max, min, high, low):new Ts(startDate, min, max, high, low);
		//大实体
		startDate = DateUtil.addDate(startDate, 1);
		min = min - getRandom();
		max = max + getRandom();
		low = min - getRandom() / 2;
		high = max + getRandom() / 2;
		Ts nodeSed = (state == RISE)?new Ts(startDate, max, min, high, low):new Ts(startDate, min, max, high, low);
		
		list.add(nodeFst);
		list.add(nodeSed);
		return list;
	}
	/**
	 *创建乌云线形态或刺进形态蜡烛节点
	 */
	public static List<Ts> createCloud(Ts last,int state) {
		int base = (state == RISE)?last.getHigh():last.getLow();
		Date startDate = last.getDate();
		
		int low = 0;
		int open = 0;
		int close = 0;
		int high = 0;
		int min = 0;
		int max = 0;
		List<Ts> list = new ArrayList<Ts>(2);
		//前实体
		startDate = DateUtil.addDate(startDate, 1);
		open = base + getRandom();
		close = base - getRandom();
		low = Math.min(open, close) - getRandom() / 2;
		high = Math.max(open, close) + getRandom() / 2;
		min = Math.min(open, close);
		max = Math.max(open, close);
		Ts nodeFst = (state == FALL)?new Ts(startDate, max, min, high, low):new Ts(startDate, min, max, high, low);
		//后实体
		startDate = DateUtil.addDate(startDate, 1);
		if(state == RISE){
			max = high + getRandom();
			high = max + getRandom() / 2;
			min = (nodeFst.getOpen()+nodeFst.getClose())/2;
			low = min - getRandom() / 2;
		}else{			
			min = min - getRandom();
			low = min - getRandom() / 2;
			max = (nodeFst.getOpen()+nodeFst.getClose())/2;
			high = max + getRandom() / 2;
		}
		Ts nodeSed = (state == RISE)?new Ts(startDate, max, min, high, low):new Ts(startDate, min, max, high, low);
		
		list.add(nodeFst);
		list.add(nodeSed);
		return list;
	}
	/**
	 * 星蜡烛线（简称星线）：蜡烛实体较小，并且在它的实体与它前面的较大的蜡烛线的实体之间形成了价格跳空
	 * @author liqiangbiao
	 * 2017年4月15日
	 * @param isCross 
	 *  @param high
	 *  @param date
	 *  @param rise2
	 *  @return
	 * List<Ts>
	 */
	public static List<Ts> createStart(Ts last,int state, boolean isCross) {
		int base = (state == RISE)?last.getHigh():last.getLow();
		Date startDate = last.getDate();
		
		int low = 0;
		int open = 0;
		int close = 0;
		int high = 0;
		int min = 0;
		int max = 0;
		List<Ts> list = new ArrayList<Ts>(2);
		//前实体
		startDate = DateUtil.addDate(startDate, 1);
		open = base + getRandom();
		close = base - getRandom();
		low = Math.min(open, close) - getRandom();
		high = Math.max(open, close) + getRandom()/2;
		min = Math.min(open, close);
		max = Math.max(open, close);
		Ts nodeFst = (state == FALL)?new Ts(startDate, max, min, high, low):new Ts(startDate, min, max, high, low);
		//后实体
		startDate = DateUtil.addDate(startDate, 1);
		if(state == RISE){
			min = max + getRandom();
			if(isCross){				
				max = min;
			}else{
				max = min + getRandom()/5;
			}		
		}else{	
			max = min - getRandom();
			if(isCross){
				min = max;
			}else{				
				min = max + getRandom()/5;
			}		
		}
		high = max + getRandom();
		low = min - getRandom();
		Ts nodeSed = (state == RISE)?new Ts(startDate, max, min, high, low):new Ts(startDate, min, max, high, low);
		
		list.add(nodeFst);
		list.add(nodeSed);
		return list;
	}
	/**
	 * 创建启明星或黄昏星
	 * 启明星：先是一根长长的黑色(绿色)实体，随后是一根小小的实体，并且在这两个实体之间形成了一个向下跳空（这两条蜡烛线组成了基本的星线形态）。第三天是一根白色(红色)实体
	 * 黄昏星：先是一根长长的白色(红色)实体，随后是一根小小的实体，并且在这两个实体之间形成了一个向上跳空（这两条蜡烛线组成了基本的星线形态）。第三天是一根黑色(绿色)实体
	 * @author liqiangbiao
	 * 2017年4月16日
	 * @param isCross 
	 *  @param high
	 *  @param date
	 *  @param rise2
	 *  @param b
	 *  @return
	 * List<Ts>
	 */
	public static List<Ts> createPhosphor(Ts last,int state, boolean isCross) {
		List<Ts> list =  createStart(last, state, isCross);//形成基本的星线
		last = list.get(1);
		Date startDate = DateUtil.addDate(last.getDate(), 1);
		
		int high = 0;
		int low = 0;
		int min = Math.min(last.getOpen(), last.getClose());
		int max = Math.max(last.getOpen(), last.getClose()); 
		int candleLen = Math.abs(list.get(0).getOpen() - list.get(0).getClose());
		if(state == RISE){	//上升，形成黄昏星，此时生成一个黑色(绿色)实体，最好向下跳空
			max = min - getRandom();
			min = max - candleLen;		
		}else{				//上升，形成启明星，此时生成一个白色(红色)实体，最好向上跳空
			min = max + getRandom();
			max = min + candleLen;
		}
		high = max + getRandom();
		low = min - getRandom();
		Ts nodeThd = (state == RISE)?new Ts(startDate, max, min, high, low):new Ts(startDate, min, max, high, low);
		list.add(nodeThd);
		return list;
	}
	/**
	 * 弃婴状态
	 * 顶部：如果市场上出现了一根向上跳空的十字里线（就是说，该十字星线的下影线与前一根蜡烛线的上影线没有任何重压之处），
	 * 		 它的后面再跟着一条向下跳空的黑色蜡烛线，并且在这根黑色蜡烛线的上影线与十字星线的下影线之间也形成了价格跳空、
	 * 底部相反
	 * @author liqiangbiao
	 * 2017年4月16日
	 *  @param last
	 *  @param rise2
	 *  @return
	 * List<Ts>
	 */
	public static List<Ts> creatFoundling(Ts last, int state) {
		int base = (state == RISE)?last.getHigh():last.getLow();
		Date startDate = last.getDate();
		
		int low = 0;
		int open = 0;
		int close = 0;
		int high = 0;
		int min = 0;
		int max = 0;
		List<Ts> list = new ArrayList<Ts>(2);
		//第一根蜡烛
		startDate = DateUtil.addDate(startDate, 1);
		open = base + getRandom();
		close = base - getRandom();
		low = Math.min(open, close) - getRandom();
		high = Math.max(open, close) + getRandom();
		min = Math.min(open, close);
		max = Math.max(open, close);
		Ts nodeFst = (state == FALL)?new Ts(startDate, max, min, high, low):new Ts(startDate, min, max, high, low);
		list.add(nodeFst);
		//第二根蜡烛
		if(state == RISE){	//上升
			low = max + getRandom();	//第二根的最低价高于第一根的最高价
			open = low + getRandom();
			close = open;
			high = open + getRandom();
		}else{
			high = min - getRandom();	//第二根的最高价低于第一根的最低价
			open = high - getRandom();
			close = open;
			low = open - getRandom();
		}
		startDate = DateUtil.addDate(startDate, 1);
		Ts nodeSed = new Ts(startDate, open, close, high, low);
		list.add(nodeSed);

		//另第三个和第一个相同，但是颜色相反
		startDate = DateUtil.addDate(startDate, 1);
		Ts nodeTrd = new Ts(startDate, nodeFst.getClose(), nodeFst.getOpen(), nodeFst.getHigh(), nodeFst.getLow());
		list.add(nodeTrd);
		return list;
	}
	/**
	 * 流星形态或倒锤子形态
	 * @author liqiangbiao
	 * 2017年4月26日
	 *  @param last
	 *  @param rise2
	 *  @return
	 * List<Ts>
	 */
	public static Ts creatMeteor(Ts last, int state) {
		int low = 0;
		int open = 0;
		int close = 0;
		int high = 0;
		int min = Math.min(last.getOpen(), last.getClose());
		int max = Math.max(last.getOpen(), last.getClose());
		if(state == RISE){	//实体高于前一实体，并跳空
			low = max + getRandom();
			open = low + getRandom();
			close = low;
			high = Math.max(open, close) + Math.abs(close - open)*2;
		}else{			//实体低于于前一实体，并跳空
			open = max - getRandom();
			low = open - getRandom();
			close = low;
			high = Math.max(open, close) + Math.abs(close - open)*2;
		}
		Date startDate = last.getDate();
		startDate = DateUtil.addDate(startDate, 1);
		Ts vo = new Ts(startDate, open, close, high, low);
		return vo;
	}
	
	public static List<Ts> createPregnant(Ts last, int state) {
		int base = (state == RISE)?last.getHigh():last.getLow();
		Date startDate = last.getDate();
		
		int low = 0;
		int open = 0;
		int close = 0;
		int high = 0;
		int min = 0;
		int max = 0;
		List<Ts> list = new ArrayList<Ts>(2);
		//大实体
		startDate = DateUtil.addDate(startDate, 1);
		min = min - getRandom();
		max = max + getRandom();
		low = min - getRandom() / 2;
		high = max + getRandom() / 2;
		Ts nodeFst = (state == RISE)?new Ts(startDate, max, min, high, low):new Ts(startDate, min, max, high, low);
		
		//小实体
		startDate = DateUtil.addDate(startDate, 1);
		open = base + getRandom()/2;
		close = base - getRandom()/2;
		low = Math.min(open, close) - getRandom() / 2;
		high = Math.max(open, close) + getRandom() / 2;
		min = Math.min(open, close);
		max = Math.max(open, close);
		Ts nodeSed = (state == FALL)?new Ts(startDate, max, min, high, low):new Ts(startDate, min, max, high, low);
		list.add(nodeFst);
		list.add(nodeSed);
		return list;
	}
	
	
	
	
	
}
