package com.sangbill.leecode.other;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class T210_courseScheduleII {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        for(int i = 0; i < prerequisites.length;i++){
            int[] temp = prerequisites[i];
            indegree[temp[0]]++;
        }

        Deque<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0)
                queue.add(i);
        }

        if(queue.isEmpty())
            return new int[0];

        List<Integer> topoRes = new ArrayList<>();
        while(!queue.isEmpty()){
            int cur = queue.poll();
            topoRes.add(cur);
            for(int i = 0; i < prerequisites.length;i++){
                int[] temp = prerequisites[i];
                if(temp[1] == cur){
                    indegree[temp[0]] --;
                    if(indegree[temp[0]] == 0){
                        queue.add(temp[0]);
                    }
                }
            }
        }
        if(topoRes.size() < numCourses)
            return new int[0];

        int[] array = topoRes.stream().mapToInt(i->i).toArray();
        return array;
    }
	
}