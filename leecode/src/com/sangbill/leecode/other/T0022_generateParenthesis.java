package com.sangbill.leecode.other;

import java.util.ArrayList;
import java.util.List;

public class T0022_generateParenthesis {
	// 做减法

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        // 特判
        if (n == 0) {
            return res;
        }

        // 执行深度优先遍历，搜索可能的结果
        dfs("", n, n, res);
        return res;
    }
    
    private static void dfs(String cur, int left, int right, List<String> res) {
		System.out.println(String.format("cur:%s,left:%s,right:%s", cur,left,right));
		if(left == 0 && right == 0){
			res.add(cur);
			System.out.println();
			return;
		}
		
		if(left > right){
			return;
		}
		
		if(left > 0){
			dfs(cur+"(", left - 1, right, res);
		}
		if(right > 0){
			dfs(cur+")", left, right - 1, res);
		}
		
	}

	public static void main(String[] args) {
		generateParenthesis(2);
	}
	
}
