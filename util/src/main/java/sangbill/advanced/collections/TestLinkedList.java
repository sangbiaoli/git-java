package com.sangbill.advanced.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class TestLinkedList {

	public static void main(String[] args) {
		testBasicList();
		testRetainAll();
	}
	//get the common element of a1 and a2
	private static void testRetainAll() {
		ArrayList<Integer> a1 = new ArrayList<Integer>(Arrays.asList(1, 2, 3,4, 5, 6));
		ArrayList<Integer> a2 = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4));
		ArrayList<Integer> a3 = new ArrayList<Integer>();
		a3.addAll(a1);
		a3.retainAll(a2);
		System.out.println(a3);
	}
	//for basic ArrayList and LinkedList insert and delete
	private static void testBasicList() {
		List<Integer> arrayList = new ArrayList<Integer>();
		arrayList.add(1);
		arrayList.add(2);
		arrayList.add(3);
		arrayList.add(1);
		arrayList.add(4);
		arrayList.add(0, 10);
		arrayList.add(3, 30);

		System.out.println("A list of integers in the array list:");
		System.out.println(arrayList);

		LinkedList<Object> linkedList = new LinkedList<Object>(arrayList);
		linkedList.add(1, "red");
		linkedList.removeLast();
		linkedList.addFirst("green");

		System.out.println("Display the linked list forward:");
		ListIterator<Object> listIterator = linkedList.listIterator();
		while (listIterator.hasNext()) {
			System.out.print(listIterator.next() + " ");
		}
		System.out.println();

		System.out.println("Display the linked list backward:");
		listIterator = linkedList.listIterator(linkedList.size());
		while (listIterator.hasPrevious()) {
			System.out.print(listIterator.previous() + " ");
		}
		System.out.println();
	}

}
