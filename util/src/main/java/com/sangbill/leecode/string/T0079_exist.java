package com.sangbill.leecode.string;

import java.util.Stack;
/**
 * 单词搜索
 * @author Bill
 *
 */
public class T0079_exist {
    public boolean exist(char[][] board, String word) {
        char[] w = word.toCharArray();
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i < board.length;i++){
            char[] r = board[i];
            for(int j = 0;j < r.length;j++){
                boolean b = sdf(stack,w,0,board,i,j);
                if(b){
                    return b;
                }
            }
        }
        return false;
    }

    public boolean sdf(Stack<Integer> stack, char[] w,int wi,char[][] board,int i,int j){
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || stack.contains(500*i+j))
            return false;

        if(w[wi] != board[i][j]){
            return false;
        }

        if(wi == w.length - 1){
            return true;
        }
        stack.add(500*i+j);
        wi++;
        boolean b = sdf(stack,w,wi,board,i-1,j) 
                || sdf(stack,w,wi,board,i,j-1) 
                || sdf(stack,w,wi,board,i+1,j) 
                || sdf(stack,w,wi,board,i,j+1);
        if(b){
            return b;
        }else{
            stack.pop();
            return false;
        }
    }
    
    public static void main(String[] args) {
    	T0079_exist solution = new T0079_exist();
		char[][] board = new char[][]{
			{'A','B','C','E'},
			{'S','F','C','S'},
			{'A','D','E','E'}
		};
		
		System.out.println(solution.exist(board, "ABCCED"));
	}
}