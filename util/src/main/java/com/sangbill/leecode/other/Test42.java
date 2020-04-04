package com.sangbill.leecode.other;

import java.util.Stack;

class Test42 {
    public static int movingCount(int m, int n, int k) {
        Stack<int[]> s = new Stack<int[]>();
        s.push(new int[]{0,0});
        int[][] visited = new int[m][n];
        int count = 0;
        int x,y;
        while(!s.isEmpty()){
        	int[] point = s.pop();
            x = point[0];
            y = point[1];
            if(visited[x][y] == 0){
                visited[x][y] = 1;
                int sum = cal(x)+cal(y);
                if(sum <= k){
                    count++;
                    if(x+1 < m && visited[x+1][y] == 0){
                        s.push(new int[]{x+1,y});
                    }
                    
                    if(y+1 < n && visited[x][y+1] == 0){
                        s.push(new int[]{x,y+1});
                    }   						
                }
            }
        }
        return count;
    }

    public static int cal(int num){
        int sum = 0;
        while(num > 0){
            sum += num%10;
            num = num/10;
        }
        return sum;
    }
    
    public static void main(String[] args) {
		System.out.println(movingCount(20,15,9));
	}
}