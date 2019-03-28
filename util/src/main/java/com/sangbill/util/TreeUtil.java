package com.sangbill.util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sangbill.entity.Tree;

public class TreeUtil {
	public static void main(String[] args) {
		List<Tree> list = new ArrayList<Tree>();
		list.add(new Tree("1", "0", "根节点"));
		list.add(new Tree("01", "1", "01"));
		list.add(new Tree("010201", "0102", "010201"));
		list.add(new Tree("0101", "01", "0101"));
		list.add(new Tree("0102", "01", "0102"));
		list.add(new Tree("02", "1", "02"));
		list.add(new Tree("03", "1", "03"));
		list.add(new Tree("0201", "02", "0201"));

		Map<String, List<Tree>> treeListMap = toMapList(list);
		Map<String,Tree> treeMap = toMap(list);
		List<Tree> treeList = recTree("1",treeMap,treeListMap);
		
		for (int i = 0; i < treeList.size(); i++) {
			Tree tree = treeList.get(i);
			System.out.println(String.format("id:%s,pid:%s,name:%s", tree.getId(),tree.getParentId(),tree.getName()));
		}
	}

	private static List<Tree> recTree(String id, Map<String, Tree> treeMap, Map<String, List<Tree>> treeListMap) {
		List<Tree> list = new ArrayList<Tree>();
		Tree tree = treeMap.get(id);
		if(tree != null){
			list.add(tree);
			String parentId = tree.getId();
			if(treeListMap.containsKey(parentId)){
				List<Tree> children = treeListMap.get(parentId);
				for (int i = 0; i < children.size(); i++) {
					list.addAll(recTree(children.get(i).getId(), treeMap, treeListMap));
				}
			}
		}
		return list;
	}


	private static Map<String,Tree> toMap(List<Tree> list) {
		Map<String,Tree> map = new HashMap<String,Tree>();
		for (Tree tree : list) {
			map.put(tree.getId(), tree);
		}
		return map;
	}

	private static Map<String, List<Tree>> toMapList(List<Tree> treeList) {
		Map<String,List<Tree>> map = new HashMap<String,List<Tree>>();
		for (Tree tree : treeList) {
			String parentId = tree.getParentId();
			List<Tree> list = map.get(parentId);
			if(list == null){
				list = new ArrayList<Tree>();
			}
			list.add(tree);
			map.put(parentId, list);
		}
		return map;
	}

}