package com.sangbill.advanced.collections;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
/**
 * The following are some methods of collections,by order:
 * 1.sort method:sort all the elements
 * 2.sort by descended order:sort all the elements by descended order
 * 3.BinarySearch method:search an element in binarySearch method
 * 4.Reverse method:Rever all the elements
 * 5.Shuffle method:get a random order list of all elements
 * 6.Copy method:elements of src cover elements of des
 * 7.max or min methods:return the max or min element of list 
 * 7.disJoin method:if two lists contain  the same elements return false,else return true
 * 8.frequency method:count an element of list times
 * @author sangbilllee
 *
 */
public class TestAsList {
	public static void main(String[] args) {
		Collection<String> collection = Arrays.asList("red","cyan","red");
		System.out.println(collection.toString());
		/*asListSort();
		asListDescendOrder();
		asListBinarySearch();
		asListReverse();
		asListShuffle();
		asListCopy();
		asListMaxAndMin();
		asListDisjoin();
		asListFrequency();*/
	}

	private static void asListFrequency() {
		Collection<String> collection = Arrays.asList("red","cyan","red");
		System.out.println(Collections.frequency(collection, "red"));
		System.out.println(Collections.frequency(collection, "cyan"));
	}

	private static void asListDisjoin() {
		Collection<String> collection1 = Arrays.asList("red","cyan");
		Collection<String> collection2 = Arrays.asList("red","blue");
		Collection<String> collection3 = Arrays.asList("pink","tan");
		System.out.println(Collections.disjoint(collection1, collection2));
		System.out.println(Collections.disjoint(collection1, collection3));

	}

	private static void asListMaxAndMin() {
		Collection<String> collection = Arrays.asList("red","green","blue");
		System.out.println(Collections.max(collection));
		System.out.println(Collections.min(collection));
	}

	private static void asListCopy() {
		List<String> list1 = Arrays.asList("yellow","green","red","blue");
		List<String> list2 = Arrays.asList("white","black");
		Collections.copy(list1, list2);
		System.out.println(list1);
	}

	private static void asListShuffle() {
		List<String> list = Arrays.asList("yellow","green","red","blue");
		Collections.shuffle(list);
		System.out.println(list);
	}

	private static void asListReverse() {
		List<String> list = Arrays.asList("yellow","green","red","blue");
		Collections.reverse(list);
		System.out.println(list);
	}

	private static void asListBinarySearch() {
		List<Integer> list1 = Arrays.asList(2,4,7,10,11,45,50,59,60,66);
		System.out.println("(1) Index: "+Collections.binarySearch(list1, 7));
		System.out.println("(2) Index: "+Collections.binarySearch(list1, 9));
		
		List<String> list2 = Arrays.asList("blue","green","red");
		System.out.println("(3) Index: "+Collections.binarySearch(list2, "red"));
		System.out.println("(4) Index: "+Collections.binarySearch(list2, "cyan"));
	}

	private static void asListDescendOrder() {
		List<String> list = Arrays.asList("green","red","yellow","blue");
		Collections.sort(list,Collections.reverseOrder());
		System.out.println(list);
	}
	
	private static void asListSort() {
		List<String> list = Arrays.asList("red","green","blue");
		Collections.sort(list);
		System.out.println(list);
	}
}
