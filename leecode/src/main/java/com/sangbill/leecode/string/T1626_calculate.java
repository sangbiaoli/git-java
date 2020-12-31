package com.sangbill.leecode.string;

class T1626_calculate {
    public int calculate(String s) {
        int i = 0;
        char opt = '+';
        int left = 0, right = 0;
        while (i < s.length()) {
            if (s.charAt(i) != ' ') {
                //计算从i位置开始的数字
                int num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                    ++i;
                };
                switch (opt) {
                    case '+':
                        left += right;
                        right = num;
                        break;
                    case '-':
                        left += right;
                        right = -num;
                        break;
                    case '*':
                        right *= num;
                        break;
                    case '/':
                        right /= num;
                        break;
                }
                if (i < s.length()) {
                    opt = s.charAt(i);
                }
            }
            ++i;
        }
        return left + right;
    }

    public static void main(String[] args) {
        T1626_calculate su = new T1626_calculate();
        System.out.println(su.calculate("0*0+4"));
    }
}