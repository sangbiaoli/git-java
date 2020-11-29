package com.sangbill.leecode.string;


import java.util.ArrayDeque;

/**
 * 检查字符串是否可以通过排序子字符串得到另一个字符串
 */
public class T1585_isTransformable {
    public boolean isTransformable(String s, String t) {
        ArrayDeque<Integer>[] q = new ArrayDeque[10];

        for(int i = 0;i < q.length;i++) {
            q[i] = new ArrayDeque<>();
        }

        for(int i = 0;i < s.length();i++){
            int n = s.charAt(i) - '0';
            q[n].addLast(i);
        }

        for(int i = t.length() - 1;i >= 0 ;i--){
            int n = t.charAt(i) - '0';
            if(q[n].size() == 0){
                return false;
            }
            if(n == (s.charAt(i) - '0')){
                q[n].removeLast();
                continue;
            }else{
                int p = q[n].getLast(); //得到这个数字n的最后一个索引
                for(int j = n+1;j <= 9;j++){
                    if(q[j].size() > 0 && q[j].getLast() > p){  //用比n大的数据得到它们的索引，如果索引更大，则排序无用
                        return false;
                    }
                }
                q[n].removeLast();
            }
        }
        return true;
    }

    public static void main(String[] args) {
        T1585_isTransformable su = new T1585_isTransformable();
        System.out.println(su.isTransformable("84532","34852"));

    }
}