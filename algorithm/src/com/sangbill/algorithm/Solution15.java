package com.sangbill.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution15 {
	 public List<List<Integer>> threeSum(int[] nums) {
        if(nums == null || nums.length < 3)
            return Collections.emptyList();
        
        List<Integer> postiveList = new ArrayList<>();
        List<Integer> zeroList = new ArrayList<>();
        List<Integer> negtiveList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
			if(nums[i] > 0){
				postiveList.add(nums[i]);
			}else if(nums[i] == 0){
				zeroList.add(nums[i]);
			}else{
				negtiveList.add(nums[i]);
			}
		}
        
        Collections.sort(postiveList);
        Collections.sort(negtiveList);
        Integer[] postives = postiveList.toArray(new Integer[postiveList.size()]);
        Integer[] negtives = negtiveList.toArray(new Integer[negtiveList.size()]);

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        //处理有0参与的情况
        if(zeroList.size() > 0){
        	if(zeroList.size() >= 3){
        		result.add(Arrays.asList(0,0,0));
        	}
        	//正负列表都有数据，各取一个匹对
        	if(postives.length > 0 && negtives.length > 0){
        		for(int i = 0;i < postives.length;i++){
        			//重复的元素不做处理
        			if(i > 0 && postives[i] == postives[i - 1])
        				continue;
        			for(int j = 0;j < negtives.length;j++){
        				//重复的元素不做处理
        				if(j > 0 && negtives[j] == negtives[j - 1])
            				continue;
        				if(postives[i] + negtives[j] == 0){
        	        		result.add(Arrays.asList(postives[i],0,negtives[j]));
        				}
            		}
        		}
        	}
        }
        //处理无0参与的情况：(负二，正一）或(负一，正二）
    	if(postives.length > 0 && negtives.length > 0){
    		//负二，正一
    		for(int i = 0;i < postives.length;i++){
    			for(int j = 0;j < negtives.length;j++){
    				//重复的元素不做处理
    				if(j > 0 && negtives[j] == negtives[j - 1])
        				continue;
    				if(i == 1 && j == 1){
    					System.out.println();
    				}
    				if(j + 1 < negtives.length){
    					for(int k = j+1;k < negtives.length;k++){
    						//重复的元素不做处理
    	    				if(k > j+1 && negtives[k] == negtives[k - 1])
    	        				continue;
            				if(postives[i] + negtives[j] + negtives[k] == 0){
            	        		result.add(Arrays.asList(postives[i] , negtives[j] , negtives[k]));
            				}
            			}
    				}   				
    			}
    		}
    		//负一，正二
    		for(int i = 0;i < negtives.length;i++){
    			for(int j = 0;j < postives.length;j++){
    				//重复的元素不做处理
    				if(j > 0 && postives[j] == postives[j - 1])
        				continue;
    				if(j + 1 < postives.length){
    					for(int k = j+1;k < postives.length;k++){
    						//重复的元素不做处理
    	    				if(k > j+1 && postives[k] == postives[k - 1])
    	        				continue;
            				if(negtives[i] + postives[j] + postives[k] == 0){
            	        		result.add(Arrays.asList(negtives[i] , postives[j] , postives[k]));
            				}
            			}
    				}   				
    			}
    		}
    	}
    	return result;
    }
	 
	public static void main(String[] args) {
		Solution15 solution = new Solution15();
//		int[] nums = {-1, 0, 1, 2, -1, -4,0,0,4,99,-36,-63,36,63,-99};
		int[] nums = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
		List<List<Integer>> list = solution.threeSum(nums );
		for (int i = 0; i < list.size(); i++) {
			StringBuffer sb = new StringBuffer();
			for (Integer num : list.get(i)) {
				sb.append(num+",");
			}
			sb.deleteCharAt(sb.length() - 1);
			System.out.println(sb.toString());
		}
	}
}
