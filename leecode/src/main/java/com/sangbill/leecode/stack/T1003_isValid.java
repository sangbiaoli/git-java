package com.sangbill.leecode.stack;

class T1003_isValid {
    public boolean isValid(String s) {
        StringBuilder sb = new StringBuilder();
        int len;
        for (char c : s.toCharArray()) {
            if (c == 'c') {
                len = sb.length();
                if (len < 2 || !"ab".equals(sb.substring(len - 2, len))) {
                    return false;
                } else {
                    sb.delete(len - 2, len);
                }
            } else {
                sb.append(c);
            }
        }
        return sb.length() == 0;
    }

    public static void main(String[] args) {
        T1003_isValid su = new T1003_isValid();
        System.out.println(su.isValid("aabcbc"));
    }
}