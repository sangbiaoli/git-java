package com.sangbill.advanced.order;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Test {

	public static void main(String[] args) throws SecurityException, NoSuchMethodException {
		int size = 5;
		String[] properties = {"Id","age","count","point","isMember","name","passwd"};
		String order = "asc";
		ComparatorFactory<User> factory = new ComparatorFactory<User>();
		List<User> userList = getUserList(size);
		print(null,userList,null);
		/*for (int i = 0; i < properties.length; i++) {			
			Collections.sort(userList,factory.createComparator(properties[i], order));
			print(properties[i],userList,order);
		}		*/
		Collections.sort(userList,factory.createComparator(properties[1], order));
		print(null,userList,null);
		Collections.sort(userList,factory.createComparator(properties[2], order));
		print(null,userList,null);

		/*SortByMethod<User> sort = new SortByMethod<User>();
		sort.sortByMethod(userList, "getName", false);
		print(null,userList,null);
		sort.sortByMethod(userList, "getPasswd", false);*/
	}
	
	private static void print(String properties, List<User> userList,String order) {
		System.out.println("order by "+properties+" "+order);
		for (User user : userList) {
			System.out.println(String.format("Id:%-20d ,age:%-2d, count:%-5f, point:%-5f, isMenber:%-5b, name:%-10s, passwd:%-10s",
										 user.getId(),user.getAge(),user.getCount(),user.getPoint(),user.getIsMember(),user.getName(),user.getPasswd()));
		}
		System.out.println("\n\n");
	}

	/**
	 * get random userList
	 * @param size
	 * @return
	 */
	private static List<User> getUserList(int size) {
		List<User> userList = new ArrayList<User>();
		for (int i = 0; i < size; i++) {
			User u = getUser();			
			userList.add(u);
		}
		return userList;
	}
	/**
	 * get random user
	 * @return
	 */
	private static User getUser() {
		User u = new User();
		Random r = new Random();
		boolean[] results = {true,false}; 
		u.setId(r.nextLong());
		u.setAge(r.nextInt(100));
		u.setCount(r.nextFloat());
		u.setPoint(r.nextDouble());
		u.setMember(results[r.nextInt(2)]);
		u.setName(getString());		
		u.setPasswd(getString());
		return u;
	}
	/**
	 * get random String
	 * @return
	 */
	private static String getString(){
		String s = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random r = new Random();
		int length = r.nextInt(10)+1;
		int sLength = s.length();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			sb.append(s.charAt(r.nextInt(sLength)));
		}	
		return sb.toString();		
	}

}