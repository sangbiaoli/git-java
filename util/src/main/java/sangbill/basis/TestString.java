package com.sangbill.basis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestString {
	public static void main(String[] args) {
		int a = 10;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < a; i++) {
			sb.append("?,");
		}
		if(sb.length() > 0 ){
			sb.deleteCharAt(sb.length()-1);
		}
		System.out.println(sb);
		/*System.out.println(findsubString("pa", "abfd"));

		printGetChars();

		int number = 23;
		System.out.println(number);
		System.out.println(String.valueOf(number));
		System.out.println(Integer.parseInt(String.valueOf(number)));
		System.out.println("企业工程&amp;".replaceAll("&amp;", "&"));*/
		//parseTrap();
		//System.out.println("Pre-instantiating singletons in org.springframework.beans.factory.support.DefaultListableBeanFactory@3709a: defining beans [mainDataSource,mainSqlSessionFactory,org.mybatis.spring.mapper.MapperScannerConfigurer#0,com.hnisi.e3itm.base.BaseExample#0,_messageBrokerHandlerAdapter,_messageBrokerDefaultHandlerMapping,_jsonConfigMapEditorConfigurer,_messageBrokerMessagingProcessor,_messageBrokerRemotingProcessor,_flexRemotingAnnotationPostProcessor,_hibernateSerializationConfigPostProcessor,org.springframework.flex.core.ExceptionTranslationAdvice#0,org.springframework.flex.core.EndpointServiceMessagePointcutAdvisor#0,org.springframework.flex.core.MessageInterceptionAdvice#0,org.springframework.flex.core.EndpointServiceMessagePointcutAdvisor#1,_messageBrokerEndpointProcessor,_messageBroker,org.springframework.flex.servlet.MessageBrokerHandlerAdapter#0,org.springframework.flex.remoting.RemotingDestinationExporter#0,businessViewManager,org.springframework.flex.remoting.RemotingDestinationExporter#1,networkManager,freemarkerConfigurer,freemarkerservice,updateCacheInterceptor,org.springframework.aop.config.internalAutoProxyCreator,org.springframework.aop.support.DefaultBeanFactoryPointcutAdvisor#0,org.springframework.beans.factory.config.PropertyPlaceholderConfigurer#0,senderImpl,smtpAuthenticator,mailSession,message,mailSender,smsSender,org.apache.activemq.xbean.XBeanBrokerService#0,jmsConnectionFactory,destination,singleConnectionFactory,jmsTemplate,uniMessageConverter,uniMessageProducer,uniMessageConsumer,uniMessageListener,listenerContainer,propertyConfigurer,initAlarmRuleJob,initAlarmRuleTrigger,alarmBufferPoolJob,alarmBufferPoolTrigger,closeStatisticsAlarmJob,closeStatisticsAlarmTrigger,alarmAutoUpgradeJob,alarmAutoUpgradeTrigger,businessHealthGradeJob,businessHealthGradeTrigger,alarmHandleThreadManager,alarmHandleMgr,schedulerFactory,cxf,org.apache.cxf.bus.spring.BusWiringBeanFactoryPostProcessor,org.apache.cxf.bus.spring.Jsr250BeanPostProcessor,org.apache.cxf.bus.spring.BusExtensionPostProcessor,alarm,baseManager,dataRuleManager,userEntityManager,jsonDateSerializer,reportMainDao,alarmClosedDao,alarmTrendFFDao,windowsDetailInfoDao,alarmCacheManager,alarmHandleManager,alarmLevelManager,alarmListManager,alarmMaskManager,alarmPrimitiveManager,alarmQuartzManager,alarmRuleManager,alarmSolutionManager,alarmStrategyManager,alarmThresholdManager,alarmTypeManager,notifyLogManager,businessCiManager,businessCiTypeManager,businessHealthGradeManager,businessHealthManager,businessSysDownManager,commandManager,configGroupManager,indexManager,plugingManager,plugingParmManager,proxyManager,serviceManager,typeManager,alarmHandleImpl,notifyManager,MJAlarmManager,MJDeviceManager,treeObjManager,perfDataManager,jasperPrintHandle,jasperReportExporter,reportService,localReportManager,hostManager,instanceManager,jfPerfdataSynManager,modelManager,netMonitorManager,resGroupManager,resourceManager,structureManager,DBConnection,ossSycItm,authorityManager,departManager,dictManager,helpManager,logManager,logRegistrationManager,menuManager,monitorManager,paramManager,reportManager,roleManager,sysLogManager,userManager,userViewletManager,viewletManager,departmentServiceImpl,userServiceImpl,org.springframework.context.annotation.internalConfigurationAnnotationProcessor,org.springframework.context.annotation.internalAutowiredAnnotationProcessor,org.springframework.context.annotation.internalRequiredAnnotationProcessor,org.springframework.context.annotation.internalCommonAnnotationProcessor,com.hnisi.e3itm.base.AppContext#0,transactionManager,org.springframework.transaction.annotation.AnnotationTransactionAttributeSource#0,org.springframework.transaction.interceptor.TransactionInterceptor#0,org.springframework.transaction.config.internalTransactionAdvisor,alarmBufferPoolDao,alarmConditionStrategyDao,alarmDao,alarmLevelDao,alarmMaskDao,alarmPersonStrategyDao,alarmPrimitiveDao,alarmResourceStrategyDao,alarmRuleDao,alarmSolutionDao,alarmThresholdDao,alarmTimeStrategyConditionDao,alarmTimeStrategyDao,alarmTypeDao,notifyLogDao,businessCiDao,businessCiTypeDao,businessGradeStandardDao,businessGraphConfigDao,businessHealthDao,businessHealthHistoryDao,businessObjectWeightDao,businessSysDownDao,resourceInstanceDao,resourceRelationDao,commandDao,configGroupDao,indexDao,instanceTypeDao,perfDataShowDao,plugingDao,plugingParmDao,proxyDao,serviceDao,typeDao,perfDataDao,IReport,checkItemInstDao,hostDao,instanceDao,networkDao,resGroupDao,resourceDao,authorityDao,dataRuleDao,departDao,dictDao,helpDao,logDao,loginLogDao,logRegistrationDao,menuDao,paramDao,reportDao,roleDao,roleInstDao,roleMenuDao,roleUserDao,sychronDepartDao,sychronUserDao,userDao,userViewletDao,viewletDao,org.springframework.context.annotation.ConfigurationClassPostProcessor$ImportAwareBeanPostProcessor#0]; root of factory hierarchy".length());
		/*String[] vars = {"vmwVmConfigFilePath","vmwVmID"};
		getData("vmwVmID:abc vmwVmConfigFilePath:de",":",vars);*/
//		System.out.println(chineseLength("你好a"));
//		StringBuffer sb = new StringBuffer();
	/*	sb.append("1,2,34,4,");
		sb.deleteCharAt(sb.length()-1).insert(0, "(").append(")");
		System.out.println(sb);*/
		
		/*sb = new StringBuffer();
		sb.append("ab{}");
		System.out.println(sb.substring("ab".length(), sb.length()));*/
	/*	Object a = 1;
		Long  b = Long.parseLong((String)a.toString());
		System.out.println(b);*/
		/*String a = "a/b/c/c";
		while(a.indexOf("/")>0){			
			int index  = a.lastIndexOf("/");
			a = a.substring(0,index);
			System.out.println(a);
		}*/
//		test();
//		test1();
	}
	private static void test1() {
		/*boolean a = "weblogic无法联通".indexOf("java")==-1 ;
		a  = a && !"status".equals("status");
		System.out.println(a);*/
		String a = "[{\"IP\" : \"192.168.0.4\",\"starttime\" : \"2015-05-01 00:06:35\",\"endtime\" : \"N/A\",\"wifiup\" : \"285690\",\"wifidown\" : \"293710\",\"3Gup\" : \"183585\",\"3Gdown\" : \"111965\",\"day_id\" : \"20150501\"},{\"IP\" : \"192.168.0.3\",\"starttime\" : \"2015-05-01 00:06:35\",\"endtime\" : \"N/A\",\"wifiup\" : \"285690\",\"wifidown\" : \"293710\",\"3Gup\" : \"183585\",\"3Gdown\" : \"111965\",\"day_id\" : \"20150501\"}]";
		System.out.println();
	}
	private static void test() {
		String ipdata = "HOST##$HOSTADDRESS$###HOSTPERFDATA##{HOSTSTATE}##$_HOSTITM_HOST_ID$";
		String resData = "RESOURCE##$HOSTADDRESS$###$HOSTNAME$##$SERVICEDESC$##$SERVICESTATE$##$SERVICEPERFDATA$##$SERVICEOUTPUT$##$_SERVICEIS_ITM_CREATE$##$_SERVICEITM_CMD_ID$##$_SERVICEITM_TYPE_ID$##$_SERVICEITM_SERVICE_ID$##$_SERVICEITM_RESOURCE_ID$";
		String[] strs = resData.split("###");
		System.out.println(strs[0]+"->"+strs[1]);
	}
	/** 
     * 获取字符串的长度，如果有中文，则每个中文字符计为2位 
     * 
     * @param value 
     *            指定的字符串 
     * @return 字符串的长度 
     */  
    public static int chineseLength(String value) {  
        int valueLength = 0;  
        String chinese = "[\u0391-\uFFE5]";  
        /* 获取字段值的长度，如果含中文字符，则每个中文字符长度为2，否则为1 */  
        for (int i = 0; i < value.length(); i++) {  
            /* 获取一个字符 */  
            String temp = value.substring(i, i + 1);  
            /* 判断是否为中文字符 */  
            if (temp.matches(chinese)) {  
                /* 中文字符长度为2 */  
                valueLength += 2;  
            } else {  
                /* 其他字符长度为1 */  
                valueLength += 1;  
            }  
        }  
        return valueLength;  
    }  

	/**
	 * 根据data，分隔符，变量数组获取每个变量的值
	 * @param data
	 * @param separator
	 * @param vars
	 * @return
	 */
	private static Map<String, String> getData(String data, String separator, String[] vars) {
		Map<Integer, String> varMap  = new HashMap<Integer,String>();
		Map<String, String> dataMap = new HashMap<String,String>();
		List<Integer> indexArray = new ArrayList<Integer>();
		for (int i = 0; i < vars.length; i++) {
			int index = data.indexOf(vars[i]+separator);
			if(index > -1 ){
				varMap.put(index, vars[i]);
				indexArray.add(index);
			}
		}
		Collections.sort(indexArray);
		for (int i = 0; i < vars.length; i++) {
			int index = data.indexOf(vars[i]+separator);
			if(index > -1 ){
				int vIndex = indexArray.indexOf(index);
				int beginIndex = index+(vars[i]+separator).length();
				if(vIndex < indexArray.size()-1){
					String value = data.substring(beginIndex, indexArray.get(vIndex+1)-1);
					dataMap.put(varMap.get(index), value);
				}else{
					String value = data.substring(beginIndex);
					dataMap.put(varMap.get(index), value);
				}
			}
		}
		System.out.println(dataMap);
		return dataMap;
	}

	private static void parseTrap() {
		String data = "vmwVpxdTargetObjType.0:vm vmwVpxdOldStatus.0:红色 vmwVpxdNewStatus.0:黄色 vmwVpxdObjValue.0:alarm.VmMemoryUsageAlarm - 衡量指标 内存 使用情况 = 19% vmwVpxdTargetObj.0:dzzw-app-34(18.47)";
		String temp = data.replaceAll("vmwVpx", ";vmwVpx");
		Map<String, String> map = new HashMap<String, String>();
		map.put("vmwVpxdTargetObjType.0", "目标对象类型");
		map.put("vmwVpxdOldStatus.0", "旧的状态");
		map.put("vmwVpxdNewStatus.0", "新的状态");
		map.put("vmwVpxdObjValue.0", "对象当前值");
		map.put("vmwVpxdTargetObj.0", "对象名称");
		Map<String, String> valMap = new HashMap<String, String>();
		String[] attrs = temp.split(";");
		for (int i = 0; i < attrs.length; i++) {
			String[] attr = attrs[i].split(":");
			if(map.containsKey(attr[0])){
				valMap.put(map.get(attr[0]), attr[1]);
			}
		}       
		System.out.println(valMap);
	}

	/**
	 * get srcSub of src from src[2] to src[6-1]:3720 
	 * get dstSub of dst from dst[5] to src[5+srcSub.length(0]:"301q" 
	 * replace dstSub with srcSub
	 */
	private static void printGetChars() {
		char[] dst = { 'J', 'A', 'V', 'A', '1', '3', '0', '1', 'q' };
		String src = "CS3720";
		print(dst);
		src.getChars(2, 6, dst, 5);
		print(dst);
	}

	private static void print(char[] dst) {
		for (char c : dst) {
			System.out.print(c + " ");
		}
		System.out.println();
	}

	private static int findsubString(String string, String subString) {
		if (string.length() < subString.length()) {
			return -1;
		}
		int i = 0, subLength = subString.length();
		String tempSubString = null;
		for (; i < subLength; i++) {
			tempSubString = string.substring(i, i + subLength);
			if (tempSubString.equals(subString)) {
				return i;
			}
		}
		return -1;
	}

}
