package com.sangbill.leecode.string;

class T1170_numSmallerByFrequency {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] w = new int[words.length];
        int[] cnt = new int[2002];
        int[] sum = new int[2002];
        for (int i = 0; i < words.length; i++) {
            w[i] = f(words[i]);
            cnt[w[i]]++;
        }
        for (int i = cnt.length - 1; i > 0; i--) {
            sum[i - 1] = sum[i] + cnt[i];
        }

        //循环得出比较
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int x = f(queries[i]);
            ans[i] = sum[x];
        }
        return ans;
    }

    public int f(String s) {
        int num = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (min > index) {
                min = index;
                num = 1;
            } else if (min == index) {
                num++;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        T1170_numSmallerByFrequency su = new T1170_numSmallerByFrequency();
        int[] ans = su.numSmallerByFrequency(
                new String[]{"bbb","cc"},
                new String[]{"a","aa","aaa","aaaa"}
        );
        System.out.println(ans);
    }
}