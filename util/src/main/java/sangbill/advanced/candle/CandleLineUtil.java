package com.sangbill.advanced.candle;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.sangbill.util.DateUtil;

public class CandleLineUtil {
	public static final int BASE = 5000;
	public static final int TREND_COUNT = 7;
	public static final int END_COUNT = 4;


	public static void main(String[] args) {
		/*createTrend();
		creatHammmer();
		createSwallow();
		createCloud();
		createStart();
		createPhosphor();
		creatFoundling();
		createMeteor();*/
		createPregnant();
	}
	/**
	 * 孕线，跟吞没相反，但是不一定要两种颜色相反
	 * @author liqiangbiao
	 * 2017年8月20日
	 * void
	 */
	private static void createPregnant() {
		try{			
			Ts last = null;
			List<Ts> tempNodes = null;
			Date startDate = DateUtil.sdf.parse("2013-01-31");
			List<Ts> nodes = CandleNodeUtil.creatFirst(BASE,startDate);
			//上升
			last = nodes.get(nodes.size()-1);
			tempNodes = CandleNodeUtil.createRaise(last,TREND_COUNT - 1);
			nodes.addAll(tempNodes);
			
			//创建上升孕线
			last = nodes.get(nodes.size()-1);
			tempNodes =  CandleNodeUtil.createPregnant(last,CandleNodeUtil.RISE);
			nodes.addAll(tempNodes);
			
			//下降
			last = nodes.get(nodes.size()-1);
			tempNodes = CandleNodeUtil.createFall(last,TREND_COUNT);
			nodes.addAll(tempNodes);
			
			//创建下降孕线
			last = nodes.get(nodes.size()-1);
			tempNodes =  CandleNodeUtil.createPregnant(last,CandleNodeUtil.FALL);
			nodes.addAll(tempNodes);

			
			//上升
			last = nodes.get(nodes.size()-1);
			tempNodes = CandleNodeUtil.createRaise(last,END_COUNT);
			nodes.addAll(tempNodes);
			
			printData(nodes);
		}catch(Exception e){
			
		}
		
	}
	/**
	 * 流星形态或倒锤子形态
	 * @author liqiangbiao
	 * 2017年4月26日
	 * void
	 */
	private static void createMeteor() {
		try{			
			Ts last = null;
			Ts tempNode = null;
			List<Ts> tempNodes = null;
			Date startDate = DateUtil.sdf.parse("2013-01-31");
			List<Ts> nodes = CandleNodeUtil.creatFirst(BASE,startDate);
			//上升
			last = nodes.get(nodes.size()-1);
			tempNodes = CandleNodeUtil.createRaise(last,TREND_COUNT - 1);
			nodes.addAll(tempNodes);
			
			//创建流星形态-顶部
			last = nodes.get(nodes.size()-1);
			tempNode =  CandleNodeUtil.creatMeteor(last,CandleNodeUtil.RISE);
			nodes.add(tempNode);
			
			//下降
			last = nodes.get(nodes.size()-1);
			tempNodes = CandleNodeUtil.createFall(last,TREND_COUNT);
			nodes.addAll(tempNodes);
			
			//创建倒锤子形态-底部
			last = nodes.get(nodes.size()-1);
			tempNode =  CandleNodeUtil.creatMeteor(last,CandleNodeUtil.FALL);
			nodes.add(tempNode);
			
			//上升
			last = nodes.get(nodes.size()-1);
			tempNodes = CandleNodeUtil.createRaise(last,END_COUNT);
			nodes.addAll(tempNodes);
			
			printData(nodes);
		}catch(Exception e){
			
		}
		
	}
	/**
	 * 弃婴形态
	 * @author liqiangbiao
	 * 2017年4月16日
	 * void
	 */
	private static void creatFoundling() {
		try{			
			Ts last = null;
			List<Ts> tempNodes = null;
			Date startDate = DateUtil.sdf.parse("2013-01-31");
			List<Ts> nodes = CandleNodeUtil.creatFirst(BASE,startDate);
			//上升
			last = nodes.get(nodes.size()-1);
			tempNodes = CandleNodeUtil.createRaise(last,TREND_COUNT - 1);
			nodes.addAll(tempNodes);
			
			//创建弃婴顶部
			last = nodes.get(nodes.size()-1);
			tempNodes =  CandleNodeUtil.creatFoundling(last,CandleNodeUtil.RISE);
			nodes.addAll(tempNodes);
			
			//下降
			last = nodes.get(nodes.size()-1);
			tempNodes = CandleNodeUtil.createFall(last,TREND_COUNT);
			nodes.addAll(tempNodes);
			
			//创建弃婴底部
			last = nodes.get(nodes.size()-1);
			tempNodes =  CandleNodeUtil.creatFoundling(last,CandleNodeUtil.FALL);
			nodes.addAll(tempNodes);
			
			//上升
			last = nodes.get(nodes.size()-1);
			tempNodes = CandleNodeUtil.createRaise(last,END_COUNT);
			nodes.addAll(tempNodes);
			
			printData(nodes);
		}catch(Exception e){
			
		}
		
	}
	/**
	 * 启明星或黄昏星
	 * @author liqiangbiao
	 * 2017年4月16日
	 * void
	 */
	private static void createPhosphor() {
		try{			
			Ts last = null;
			List<Ts> tempNodes = null;
			Date startDate = DateUtil.sdf.parse("2013-01-31");
			List<Ts> nodes = CandleNodeUtil.creatFirst(BASE,startDate);
			//上升
			last = nodes.get(nodes.size()-1);
			tempNodes = CandleNodeUtil.createRaise(last,TREND_COUNT - 1);
			nodes.addAll(tempNodes);
			
			//创建普通黄昏星
			last = nodes.get(nodes.size()-1);
			tempNodes =  CandleNodeUtil.createPhosphor(last,CandleNodeUtil.RISE,false);
			nodes.addAll(tempNodes);
			
			//下降
			last = nodes.get(nodes.size()-1);
			tempNodes = CandleNodeUtil.createFall(last,TREND_COUNT);
			nodes.addAll(tempNodes);
			
			//创建普通启明星
			last = nodes.get(nodes.size()-1);
			tempNodes =  CandleNodeUtil.createPhosphor(last,CandleNodeUtil.FALL,false);
			nodes.addAll(tempNodes);
			
			//上升
			last = nodes.get(nodes.size()-1);
			tempNodes = CandleNodeUtil.createRaise(last,TREND_COUNT);
			nodes.addAll(tempNodes);
			
			//创建十字星黄昏星
			last = nodes.get(nodes.size()-1);
			tempNodes =  CandleNodeUtil.createPhosphor(last,CandleNodeUtil.RISE,true);
			nodes.addAll(tempNodes);
			
			//下降
			last = nodes.get(nodes.size()-1);
			tempNodes = CandleNodeUtil.createFall(last,TREND_COUNT);
			nodes.addAll(tempNodes);
			
			//创建十字星启明星
			last = nodes.get(nodes.size()-1);
			tempNodes =  CandleNodeUtil.createPhosphor(last,CandleNodeUtil.FALL,true);
			nodes.addAll(tempNodes);
			
			//上升
			last = nodes.get(nodes.size()-1);
			tempNodes = CandleNodeUtil.createRaise(last,END_COUNT);
			nodes.addAll(tempNodes);
			
			printData(nodes);
		}catch(Exception e){
			
		}
		
	}
	/**
	 * 星线
	 * @author liqiangbiao
	 * 2017年4月15日
	 * void
	 */
	private static void createStart() {
		try{			
			Ts last = null;
			List<Ts> tempNodes = null;
			Date startDate = DateUtil.sdf.parse("2013-01-31");
			List<Ts> nodes = CandleNodeUtil.creatFirst(BASE,startDate);
			//上升
			last = nodes.get(nodes.size()-1);
			tempNodes = CandleNodeUtil.createRaise(last,TREND_COUNT - 1);
			nodes.addAll(tempNodes);
			
			//创建简单的星
			last = nodes.get(nodes.size()-1);
			tempNodes =  CandleNodeUtil.createStart(last,CandleNodeUtil.RISE,false);
			nodes.addAll(tempNodes);
			
			//下降
			last = nodes.get(nodes.size()-1);
			tempNodes = CandleNodeUtil.createFall(last,TREND_COUNT);
			nodes.addAll(tempNodes);
			
			//创建简单的星
			last = nodes.get(nodes.size()-1);
			tempNodes =  CandleNodeUtil.createStart(last,CandleNodeUtil.FALL,false);
			nodes.addAll(tempNodes);

			/////////////////////////////////////////////////////////
			//上升
			last = nodes.get(nodes.size()-1);
			tempNodes = CandleNodeUtil.createRaise(last,TREND_COUNT);
			nodes.addAll(tempNodes);
			
			//创建十字星
			last = nodes.get(nodes.size()-1);
			tempNodes =  CandleNodeUtil.createStart(last,CandleNodeUtil.RISE,true);
			nodes.addAll(tempNodes);
			
			//下降
			last = nodes.get(nodes.size()-1);
			tempNodes = CandleNodeUtil.createFall(last,TREND_COUNT);
			nodes.addAll(tempNodes);
			
			//创建十字星
			last = nodes.get(nodes.size()-1);
			tempNodes =  CandleNodeUtil.createStart(last,CandleNodeUtil.FALL,true);
			nodes.addAll(tempNodes);
			
			//上升
			last = nodes.get(nodes.size()-1);
			tempNodes = CandleNodeUtil.createRaise(last,END_COUNT);
			nodes.addAll(tempNodes);
			
			printData(nodes);
		}catch(Exception e){
			
		}
		
	}
	
	/**
	 * 乌云压顶
	 * @author liqiangbiao
	 * 2017年4月15日
	 * void
	 */
	private static void createCloud() {
		try{			
			Ts last = null;
			List<Ts> tempNodes = null;
			Date startDate = DateUtil.sdf.parse("2013-01-31");
			List<Ts> nodes = CandleNodeUtil.creatFirst(BASE,startDate);
			//上升
			last = nodes.get(nodes.size()-1);
			tempNodes = CandleNodeUtil.createRaise(last,TREND_COUNT - 1);
			nodes.addAll(tempNodes);
			
			//创建上升吞没
			last = nodes.get(nodes.size()-1);
			tempNodes =  CandleNodeUtil.createCloud(last,CandleNodeUtil.RISE);
			nodes.addAll(tempNodes);
			
			//下降
			last = nodes.get(nodes.size()-1);
			tempNodes = CandleNodeUtil.createFall(last,TREND_COUNT);
			nodes.addAll(tempNodes);
			
			//创建下降吞没
			last = nodes.get(nodes.size()-1);
			tempNodes =  CandleNodeUtil.createCloud(last,CandleNodeUtil.FALL);
			nodes.addAll(tempNodes);

			
			//上升
			last = nodes.get(nodes.size()-1);
			tempNodes = CandleNodeUtil.createRaise(last,END_COUNT);
			nodes.addAll(tempNodes);
			
			printData(nodes);
		}catch(Exception e){
			
		}
	}
	
	/**
	 * 吞没
	 * @author liqiangbiao
	 * 2017年4月15日
	 * void
	 */
	private static void createSwallow() {
		try{			
			Ts last = null;
			List<Ts> tempNodes = null;
			Date startDate = DateUtil.sdf.parse("2013-01-31");
			List<Ts> nodes = CandleNodeUtil.creatFirst(BASE,startDate);
			//上升
			last = nodes.get(nodes.size()-1);
			tempNodes = CandleNodeUtil.createRaise(last,TREND_COUNT - 1);
			nodes.addAll(tempNodes);
			
			//创建上升吞没
			last = nodes.get(nodes.size()-1);
			tempNodes =  CandleNodeUtil.createSwallow(last,CandleNodeUtil.RISE);
			nodes.addAll(tempNodes);
			
			//下降
			last = nodes.get(nodes.size()-1);
			tempNodes = CandleNodeUtil.createFall(last,TREND_COUNT);
			nodes.addAll(tempNodes);
			
			//创建下降吞没
			last = nodes.get(nodes.size()-1);
			tempNodes =  CandleNodeUtil.createSwallow(last,CandleNodeUtil.FALL);
			nodes.addAll(tempNodes);

			
			//上升
			last = nodes.get(nodes.size()-1);
			tempNodes = CandleNodeUtil.createRaise(last,END_COUNT);
			nodes.addAll(tempNodes);
			
			printData(nodes);
		}catch(Exception e){
			
		}
		
	}
	

	/**
	 * 创建锤子数据
	 * @author liqiangbiao
	 * 2017年4月14日
	 * void
	 */
	private static void creatHammmer() {
		try{			
			Ts last = null;
			Ts tempNode = null;
			List<Ts> tempNodes = null;
			Date startDate = DateUtil.sdf.parse("2013-01-31");
			List<Ts> nodes = CandleNodeUtil.creatFirst(BASE,startDate);
			//上升
			last = nodes.get(nodes.size()-1);
			tempNodes = CandleNodeUtil.createRaise(last,TREND_COUNT - 1);
			nodes.addAll(tempNodes);
			
			//创建上吊
			last = nodes.get(nodes.size()-1);
			tempNode =  CandleNodeUtil.createHammer(last,CandleNodeUtil.RISE);
			nodes.add(tempNode);
			
			//下降
			last = nodes.get(nodes.size()-1);
			tempNodes = CandleNodeUtil.createFall(last,TREND_COUNT);
			nodes.addAll(tempNodes);
			
			//创建锤子
			last = nodes.get(nodes.size()-1);
			tempNode =  CandleNodeUtil.createHammer(last,CandleNodeUtil.FALL);
			nodes.add(tempNode);

			
			//上升
			last = nodes.get(nodes.size()-1);
			tempNodes = CandleNodeUtil.createRaise(last,END_COUNT);
			nodes.addAll(tempNodes);
			
			printData(nodes);
		}catch(Exception e){
			
		}
		
	}
	
	/**
	 * 创建趋势的数据
	 * @author liqiangbiao
	 * 2017年4月14日
	 *  @throws ParseException
	 * void
	 */
	public static void createTrend(){
		try{			
			Ts last = null;
			List<Ts> tempNodes = null;
			Date startDate = DateUtil.sdf.parse("2013-01-31");
			List<Ts> nodes = CandleNodeUtil.creatFirst(BASE,startDate);
			//上升
			last = nodes.get(nodes.size()-1);
			tempNodes = CandleNodeUtil.createRaise(last,TREND_COUNT - 1);
			nodes.addAll(tempNodes);
			
			//下降
			last = nodes.get(nodes.size()-1);
			tempNodes = CandleNodeUtil.createFall(last,TREND_COUNT);
			nodes.addAll(tempNodes);
			
			printData(nodes);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	
	
	
	
	private static void printData(List<Ts> nodes) {
		StringBuffer dateContent = new StringBuffer();
		for (int i = 0; i < nodes.size(); i++) {
			Ts vo = nodes.get(i);
			if(i != nodes.size() - 1){		
				dateContent.append("\""+DateUtil.sdf.format(vo.getDate())+"\",\n");
			}else{
				dateContent.append("\""+DateUtil.sdf.format(vo.getDate())+"\"\n");
			}
		}
		System.out.println(dateContent);
		
		StringBuffer dataContent = new StringBuffer();
		for (int i = 0; i < nodes.size(); i++) {
			Ts vo = nodes.get(i);
			if(i != nodes.size() - 1){		
				dataContent.append(String.format("[%s,%s,%s,%s],\n",vo.getOpen(),vo.getClose(),vo.getLow(),vo.getHigh()));
			}else{
				dataContent.append(String.format("[%s,%s,%s,%s]\n",vo.getOpen(),vo.getClose(),vo.getLow(),vo.getHigh()));
			}
		}
		System.out.println(dataContent);
	}
	
}
