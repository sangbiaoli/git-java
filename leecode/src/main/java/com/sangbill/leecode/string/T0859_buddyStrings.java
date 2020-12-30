package com.sangbill.leecode.string;

class T0859_buddyStrings {
    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }
        int[] nums = new int[26];
        int start = -1, end = -1, cnt = 0;
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        for (int i = 0; i < a.length; i++) {
            nums[a[i] - 'a']++;
            if (a[i] != b[i]) {
                cnt++;
                if (start == -1) {
                    start = i;
                } else {
                    end = i;
                }
                if (cnt == 3) {
                    return false;
                }else if(cnt == 2 && (a[start] != b[end] || a[end] != b[start])){
                    return false;
                }
            }
        }
        //不同位置数量只有三种情况：0个，1个，2个
        if (cnt == 0) {
            for (int i : nums) {
                if (i >= 2) {
                    return true;
                }
            }
            return false;
        }
        return cnt == 2;
    }

    public static void main(String[] args) {
        T0859_buddyStrings su = new T0859_buddyStrings();
        System.out.println(su.buddyStrings("abab", "abab"));
    }
}