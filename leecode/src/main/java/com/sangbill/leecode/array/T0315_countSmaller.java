package com.sangbill.leecode.array;

import java.util.*;

class T0315_countSmaller {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if(nums.length == 0){
            return list;
        }

        int base = 10000;
        Integer key = 0;

        //统计各个数字出现次数
        int[] cnt = new int[2*base+1];
        TreeSet<Integer> set = new TreeSet<>();
        for(int i = 0;i < nums.length;i++){
            key = nums[i]+base;
            cnt[key]++;
            set.add(key);
        }

        //统计每个节点比自己小的累计数量
        int[] cntSum = new int[2*base+1];
        Integer pre = set.first();
        cntSum[pre] = 0;
        for( Iterator<Integer> it = set.iterator();it.hasNext();){
            key = it.next();
            if(key > pre){
                cntSum[key] = cntSum[pre] + cnt[pre]; //上一个节点累计及上个节点数量
            }
            pre = key;
        }

        //循环数组
        for(int i = 0;i < nums.length;i++){
            key = nums[i]+base;
            list.add(cntSum[key]);
            //更新所有比key大的数据
            SortedSet<Integer> subSet = set.tailSet(key,false);
            for( Iterator<Integer> it = subSet.iterator();it.hasNext();){
                cntSum[it.next()]--;
            }
            cnt[key]--;
            if(cnt[key] == 0){
                set.remove(key);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = new  int[]{5,2,6,1};
        T0315_countSmaller su = new T0315_countSmaller();
        List<Integer> list = su.countSmaller(nums);
        System.out.println(list.size());
    }
}