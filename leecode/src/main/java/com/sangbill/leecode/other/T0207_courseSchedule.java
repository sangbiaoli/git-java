package com.sangbill.leecode.other;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class T0207_courseSchedule {
	public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        for(int i = 0; i < prerequisites.length;i++){
            int[] temp = prerequisites[i];
            indegree[temp[1]]++;
        }

        Deque<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0)
                queue.add(i);
        }

        if(queue.isEmpty())
            return false;

        List<Integer> topoRes = new ArrayList<>();
        while(!queue.isEmpty()){
            int cur = queue.poll();
            topoRes.add(cur);
            for(int i = 0; i < prerequisites.length;i++){
                int[] temp = prerequisites[i];
                if(temp[0] == cur){
                    indegree[temp[1]] --;
                    if(indegree[temp[1]] == 0){
                        queue.add(temp[1]);
                    }
                }
            }
        }
        return (topoRes.size() == numCourses);
    }

	public static void main(String[] args) {
		int[][] prerequisites = new  int[][]{
			{0,1},
		};
		System.out.println(canFinish(2,prerequisites ));
	}
	
}
