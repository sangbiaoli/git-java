package com.sangbill.leecode.string;

class T1415_getHappyString {
    public String getHappyString(int n, int k) {
        //在第一次选择后，每次都只有两种选择，因此可以算出一共有集中路径
        int bucket = (int) Math.pow(2, n - 1);
        if (3 * bucket < k) {
            return "";
        }
        //共有'a','b','c'为开头的三个桶，'a'的索引为0
        int bucketIndex = k / bucket;
        if(bucket * bucketIndex == k){ //如果刚好整除，则说明不应该落在当前的桶，要回退到上一个桶
            bucketIndex--;
        }
        char firstChar = (bucketIndex == 0) ? 'a' : (bucketIndex == 1) ? 'b' : 'c';
        StringBuilder sb = new StringBuilder().append(firstChar);
        if (n - 1 > 0) {
            //选择桶后，算出剩下的值及二进制串s，并将s补足k-1位（首字母占用了一位）
            String s = toBinary(k - bucketIndex * bucket - 1, n - 1);
            for (int i = 0; i < s.length(); i++) {
                int num = s.charAt(i) - '0';
                char prev = sb.charAt(i);
                if (prev == 'a') {
                    sb.append((num == 0) ? 'b' : 'c');
                } else if (prev == 'b') {
                    sb.append((num == 0) ? 'a' : 'c');
                } else {
                    sb.append((num == 0) ? 'a' : 'b');
                }
            }
        }
        return sb.toString();
    }

    public String toBinary(int num, int digits) {
        String cover = Integer.toBinaryString(1 << digits).substring(1);
        String s = Integer.toBinaryString(num);
        return s.length() < digits ? cover.substring(s.length()) + s : s;
    }

    public static void main(String[] args) {
        T1415_getHappyString su = new T1415_getHappyString();
        String s = su.getHappyString(3, 4);
        System.out.println(s);
    }
}